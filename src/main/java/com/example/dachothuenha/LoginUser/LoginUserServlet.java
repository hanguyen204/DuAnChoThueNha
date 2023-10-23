package com.example.dachothuenha.LoginUser;

import com.mysql.jdbc.Driver;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@WebServlet(value = "/servlet_Login")
public class LoginUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if (isValidInput(username) && isValidInput(password)) {
            if (checkCredentials(username, password)) {
                HttpSession session = request.getSession();
                session.setAttribute("username", username);
                response.sendRedirect("Authentication/newsfeed.jsp");
            } else {
                request.setAttribute("error", "The specified password does not match.");
                request.getRequestDispatcher("Authentication/viewLogin.jsp").forward(request, response);
            }
        } else {
            request.setAttribute("error", "user ");
            request.getRequestDispatcher("Authentication/viewLogin.jsp").forward(request, response);
        }
    }

    private boolean isValidInput(String input) {
        // Sử dụng regex để kiểm tra xem chuỗi không chứa ký tự đặc biệt (*, %, , ')
        String regex = "^[a-zA-Z0-9]*$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        return matcher.matches();
    }

    private boolean checkCredentials(String username, String password) {
        Connection connection = ConnectJDBC.getConnection();
        if (connection == null) {
            return false;
        }

        try {
            String query = "SELECT * FROM UserLogin WHERE username = ? AND password = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

}
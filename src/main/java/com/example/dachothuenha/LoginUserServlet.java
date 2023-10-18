package com.example.dachothuenha;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Login-User", value = "/LoginUser")
public class LoginUserServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // Xác thực đầu vào (không có ký tự đặc biệt bằng biểu thức chính quy)
        if (!isValidInput(username) || !isValidInput(password)) {
            request.setAttribute("errorMessage", "Invalid characters in username or password.");
            request.getRequestDispatcher("login-user.jsp").forward(request, response);
            return;
        }

        // Kiểm tra thông tin đăng nhập (thay thế bằng logic xác thực của bạn)
        if (username.equals("namca") && password.equals("123")) {
            // Redirect to news feed on successful login
            response.sendRedirect("newsfeed.jsp");
        } else {
            // Đăng nhập thất bại, hiển thị thông báo lỗi
            request.setAttribute("errorMessage", "Incorrect username or password.");
            request.getRequestDispatcher("login-user.jsp").forward(request, response);
        }
    }

    private boolean isValidInput(String input) {
        // Regex to check for special characters
        String regex = "^[a-zA-Z0-9]*$";
        return input.matches(regex);
    }
}


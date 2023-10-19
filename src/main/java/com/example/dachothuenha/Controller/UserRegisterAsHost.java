package com.example.dachothuenha.Controller;

import com.example.dachothuenha.Model.User;
import com.example.dachothuenha.Service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "UserRegisterAsHost", value = "/register_Host")
public class UserRegisterAsHost extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String url_image = req.getParameter("url_image");
        String full_name = req.getParameter("full_name");
        String address = req.getParameter("address");
        String phone = req.getParameter("phone");
        String password = req.getParameter("password");
        String confirmPassword = req.getParameter("confirm-password");
        User newUser = new User(username,url_image, full_name, address, phone, password);
        UserService userService = new UserService();
        if (!confirmPassword.equals(password) || userService.checkEmail(username)) {
            req.setAttribute("message","Please Review Your Account And Password!!!");
            req.getRequestDispatcher("registerHost.jsp").forward(req,resp);
        } else {
            try {
                userService.insertUser(newUser);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
            req.getRequestDispatcher("");
        }

    }
}

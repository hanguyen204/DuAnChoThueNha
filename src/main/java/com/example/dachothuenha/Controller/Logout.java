package com.example.dachothuenha.Controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "Logout", value = "/logout")
public class Logout extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        // xóa giá trị của session
        session.removeAttribute("username");
        session.removeAttribute("password");
        // kết thúc phiên làm việc của session
        session.invalidate();
        // chuyển sang một trang xác nhận logout
        req.getRequestDispatcher("Authentication/confirmLogout.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // điền link đăng nhập vào đây
        req.getRequestDispatcher("").forward(req,resp);
    }
}

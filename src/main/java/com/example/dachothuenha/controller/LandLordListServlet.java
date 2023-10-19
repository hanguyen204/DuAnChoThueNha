package com.example.dachothuenha.controller;

import com.example.dachothuenha.model.LandLord;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/landlordlist")
public class LandLordListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int currentPage = 1;
        int recordPerPage = 5;
        if (req.getParameter("page") != null) {
            currentPage = Integer.parseInt(req.getParameter("page"));
        }

        List<LandLord> landLordList = new ArrayList<>();
        int totalRecords = 0;
        int totalPages = 0;

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/HouseRentalProject", "root", "anhnam2005")) {
            String countQuery = "SELECT COUNT(*) AS total FROM Users";
            try (Statement countStmt = connection.createStatement()) {
                ResultSet countResult = countStmt.executeQuery(countQuery);
                if (countResult.next()) {
                    totalRecords = countResult.getInt("total");
                }
            }
            totalPages = (int) Math.ceil((double) totalRecords / recordPerPage);
            int start = (currentPage - 1) * recordPerPage;
            String selectQuery = "SELECT * FROM Users WHERE user_type=\"Land lord\" LIMIT ?, ?";

            try (PreparedStatement preparedStatement = connection.prepareStatement(selectQuery)) {
                preparedStatement.setInt(1, start);
                preparedStatement.setInt(2, recordPerPage);

                ResultSet resultSet = preparedStatement.executeQuery();

                while (resultSet.next()) {
                    int id = resultSet.getInt("user_id");
                    String avatar = resultSet.getString("avatar");
                    String fullName = resultSet.getString("full_name");
                    String phone = resultSet.getString("phone");
                    int revenue = resultSet.getInt("revenue");
                    int numberHouseForRent = resultSet.getInt("number_house_for_rent");
                    String status = resultSet.getString("status");

                    LandLord landLord = new LandLord(id ,avatar, fullName, phone, revenue, numberHouseForRent, status);
                    landLordList.add(landLord);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        req.setAttribute("landLordList", landLordList);
        req.setAttribute("totalPages", totalPages);
        req.setAttribute("currentPage", currentPage);
        req.getRequestDispatcher("landlordlist.jsp").forward(req, resp);
    }
}

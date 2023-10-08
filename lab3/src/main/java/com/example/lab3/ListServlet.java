package com.example.lab3;

import java.io.*;
import java.sql.*;
import java.util.ArrayList;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "listServlet", value = "/list")
public class ListServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            String url = "jdbc:mysql://localhost:3306/world?serverTimezone=UTC";
            String user = "root";
            String password = "password";
            Connection conn = DriverManager.getConnection(url, user, password);

            Statement st = conn.createStatement();

            String query = "SELECT name, code, population FROM Country WHERE Continent = 'Europe'";

            ResultSet rs = st.executeQuery(query);

            ArrayList<CountryBean> list = new ArrayList<>();
            while (rs.next()) {
                CountryBean country = new CountryBean();
                country.setName(rs.getString("name"));
                country.setCode(rs.getString("code"));
                country.setPopulation(rs.getInt("population"));
                list.add(country);
            }

            HttpSession session = request.getSession(true);
            session.setAttribute("list", list);

            response.sendRedirect("countryList.jsp");

            rs.close();
            st.close();
            conn.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Błąd w trakcie obsługi bazy danych.");
        }
    }
}
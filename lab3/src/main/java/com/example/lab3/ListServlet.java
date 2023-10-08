package com.example.lab3;

import java.io.*;
import java.sql.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "listServlet", value = "/list")
public class ListServlet extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            Class.forName("com.mysql.cj.jdbc.Driver");

            String url = "jdbc:mysql://localhost:3306/world?serverTimezone=UTC";
            String user = "root";
            String password = "password";
            Connection conn = DriverManager.getConnection(url, user, password);

            Statement st = conn.createStatement();

            String query = "SELECT name, code, population FROM Country WHERE Continent = 'Europe'";

            ResultSet rs = st.executeQuery(query);

            out.println("<html>");
            out.println("<head>");
            out.println("<title>List of European Countries</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>List of European Countries</h1>");

            while (rs.next()) {
                // Pobierz i wyświetl dane z odpowiednich kolumn
                String name = rs.getString("name");
                String code = rs.getString("code");
                int population = rs.getInt("population");

                out.println("<p>Name: " + name + "</p>");
                out.println("<p>Code: " + code + "</p>");
                out.println("<p>Population: " + population + "</p>");
                out.println("<hr>");
            }

            out.println("</body>");
            out.println("</html>");

            rs.close();
            st.close();
            conn.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Błąd w trakcie obsługi bazy danych.");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }


    public void destroy() {
    }
}
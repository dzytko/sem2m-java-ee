<%@ page import="com.example.lab3.CountryBean" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>List of European Countries</title>
</head>
<body>
<h1>List of European Countries</h1>
<table>
    <tr>
        <th>Code</th>
        <th>Name</th>
        <th>Population</th>
        <th>Details</th>
    </tr>
    <%
        ArrayList<CountryBean> list = (ArrayList<CountryBean>)session.getAttribute("list");
        for (int i = 0; i < list.size(); i++) {
            CountryBean country = list.get(i);
    %>
    <tr>
        <td><%= country.getCode() %></td>
        <td><%= country.getName() %></td>
        <td><%= country.getPopulation() %></td>
        <td><a href="details.jsp?index=<%= i %>">Details</a></td>
    </tr>
    <%
        }
    %>
</table>
</body>
</html>
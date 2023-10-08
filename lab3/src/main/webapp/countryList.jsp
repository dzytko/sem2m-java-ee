<%@ page import="com.example.lab3.CountryBean" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Country List</title>
</head>
<body>
<h1>List of European Countries</h1>
<table>
    <tr>
        <th>Code</th>
        <th>Name</th>
        <th>Population</th>
    </tr>
    <%
        ArrayList<CountryBean> list = (ArrayList<CountryBean>) session.getAttribute("list");
        for (CountryBean country : list) {
    %>
    <tr>
        <td><%= country.getCode() %>
        </td>
        <td><%= country.getName() %>
        </td>
        <td><%= country.getPopulation() %>
        </td>
    </tr>
    <%
        }
    %>
</table>
</body>
</html>

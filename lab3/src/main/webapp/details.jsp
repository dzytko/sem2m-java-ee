<%@ page import="com.example.lab3.CountryBean" %>
<%@ page import="java.util.ArrayList" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Country Details</title>
</head>
<body>
<h1>Country Details</h1>
<%
    ArrayList<CountryBean> list = (ArrayList<CountryBean>)session.getAttribute("list");
    int index = Integer.parseInt(request.getParameter("index"));
    CountryBean country = list.get(index);
%>
<h2>Code: <%= country.getCode() %></h2>
<h2>Name: <%= country.getName() %></h2>
<h2>Population: <%= country.getPopulation() %></h2>
<a href="countryList.jsp">Back to List</a>
</body>
</html>

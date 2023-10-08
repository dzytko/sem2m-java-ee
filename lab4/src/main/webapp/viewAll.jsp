<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Pracownicy</title>
</head>
<body>
<div>
    <h1>Lista pracowników</h1>
    <table border>
        <tr>
            <th>Id</th>
            <th>Nazwisko</th>
            <th>Pensja</th>
            <th>Firma</th>
            <th>Edytuj</th>
            <th>Usuń</th>
        </tr>
        <jsp:useBean id="list" scope="request" type="java.util.List"/>
        <c:forEach var="worker" items="${list}">
            <tr>
                <td> ${worker.id} </td>
                <td> ${worker.lastName} </td>
                <td> ${worker.salary} </td>
                <td> ${worker.companyName} </td>
                <td><a href="edit/${worker.id}"> Edytuj </a></td>
                <td><a href="…"> Usuń </a></td>
            </tr>
        </c:forEach>
    </table>
    <br/>
    <a href="addForm">Dodaj nowego pracownika</a>
</div>
</body>
</html>

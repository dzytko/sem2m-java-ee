<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.text.DateFormat" %>
<%@ page import="java.text.DecimalFormat" %>

<jsp:useBean id="loan" class="com.example.lab2.LoanBean" scope="session" />
<jsp:setProperty name="loan" property="*" />

<%
    DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    Date now = new Date();
    String date = dateFormat.format(now);
    String res = "";

    if (request.getParameter("interestRateForm") != null) {
        DecimalFormat df = new DecimalFormat("#.00");
        res = "Rata kredytu wynosi: " + df.format(loan.getInstallment());
    }
    else {
        res = "Wprowadź dane";
    }
%>

<!DOCTYPE html>
<html>
<head>
    <title>JSP - Calc with bean</title>
</head>
<body>
<p>
    Aktualna data: <%= date %>
</p>
<form method="post">
    <label for="amount">Kwota pożyczki:</label>
    <input type="number" step="0.1" name="amount" id="amount" required><br><br>

    <label for="yearlyInterestRate">Oprocentowanie roczne:</label>
    <input type="number" step="0.1" name="yearlyInterestRate" id="yearlyInterestRate" required><br><br>

    <label for="numberOfInstallments">Liczba rat:</label>
    <input type="number" step="1" name="numberOfInstallments" id="numberOfInstallments" required><br><br>

    <input type="submit" name="interestRateForm" value="Oblicz ratę">
</form>

</br>
<div>
    Wynik: <%= res %>
</div>
</body>
</html>
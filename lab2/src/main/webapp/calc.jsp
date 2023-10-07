<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.text.DateFormat" %>
<%@ page import="java.text.DecimalFormat" %>

<%
    DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    Date now = new Date();
    String date = dateFormat.format(now);
    String res = "";

    if (request.getParameter("interestRateForm") != null) {
        double amount, yearlyRate, numberOfInstallments, monthlyRate, installement;

        try {
            amount = Double.parseDouble(request.getParameter("amount"));
            yearlyRate = Double.parseDouble(request.getParameter("yearlyInterestRate")) / 100;
            numberOfInstallments = Double.parseDouble(request.getParameter("numberOfInstallments"));
            monthlyRate = yearlyRate / 12;

            installement = (amount * monthlyRate) / (1 - Math.pow(1 + monthlyRate, -numberOfInstallments));

            DecimalFormat df = new DecimalFormat("#.00");
            res = "Rata kredytu wynosi: " + df.format(installement);
        } catch (Exception ex) {
            res = "Wprowadzono błędne dane.";
        }
    }
    else {
        res = "Wprowadź dane";
    }
%>

<!DOCTYPE html>
<html>
<head>
    <title>JSP -Calc</title>
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
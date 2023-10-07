<%@page contentType="text/html" pageEncoding="UTF-8" isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - error page</title>
</head>
<body>
<h2>Wprowadzono błędne dane!</h2>
<p>Pojawił się następujący błąd: <%= exception.getMessage() %>. <br /></p>
</body>
</html>
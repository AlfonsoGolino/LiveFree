<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Account</title>
</head>
<body>
<%if(session.getAttribute("tipo").equals("utente")){%>
Account utente
<%}else{%>
Account Autorità
<%} %>
<form action="Logout" method="get">
<input type="submit" value="Logout">
</form>
<a  href="FormModifca.html" title="Modifica Account">
<button type="button">Modifica Account</button>
</a>
</body>
</html>
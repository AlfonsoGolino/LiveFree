<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Modifica Account</title>
</head>
<body>
<%if(session.getAttribute("tipo").equals("utente")){%>
Modifica utente
<%}else{%>
Modifica Autorità
<%} %>
<form action="ModificaAccount" method="get">
<strong>Nome:</strong><input type="text" name="Nome"  value="<%=request.getAttribute("Nome") %>"></br>
<strong>Cognome:</strong> <input type="text" name="Cognome"  value="<%=request.getAttribute("Cognome") %>"></br>
<%if(session.getAttribute("tipo").equals("utente")){%>
<strong>Codice Fiscale: </strong><input type="text" name="CodiceFiscale"  value="<%=request.getAttribute("CodiceFiscale") %>" disabled></br>
<%}else{%>
<strong>Matricola: </strong><input type="text" name="Matricola"  value="<%=request.getAttribute("Matricola") %>" disabled></br>
<%} %>
<strong>Username:</strong> <input type="text" name="user"  value="<%=request.getAttribute("Username") %>"></br>
<strong>Pasword:</strong> <input type="password" name="Pasword"  value="<%=request.getAttribute("Password") %>"></br>
<input type="submit" value="Modifica Account">
</form>
</body>
</html>
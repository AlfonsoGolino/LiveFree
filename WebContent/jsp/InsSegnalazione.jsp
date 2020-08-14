<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%  String nome = request.getParameter("nome");
	String cognome = request.getParameter("cognome");
	String matricola = request.getParameter("matricola");
%>
<form action="../Segnalazione" method="get">
<strong>Nome: </strong><input type="text" name="Nome"  value="<%=nome%>" readonly></br>
<strong>Cogome: </strong><input type="text" name="Cognome"  value="<%=cognome%>" readonly></br>
<strong>Matricola: </strong><input type="text" name="Matricola"  value="<%=matricola%>" readonly></br>
<strong>Indirizzo:</strong> <input type="text" name="Indirizzo"></br>
<strong>Foto:</strong> <input type="text" name="Foto"></br>
</form>
</body>
</html>
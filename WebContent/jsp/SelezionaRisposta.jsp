<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% String indirizzo = request.getParameter("Indirizzo");
String foto = request.getParameter("Foto");
String codiceFiscale = request.getParameter("codiceFiscale");
String id = request.getParameter("ID");
%>

<%=indirizzo%>
<%=foto%>
<%=codiceFiscale%>
Inviare Drone?
<% out.println("<a href='UdateRisposta?risp=no&id="+id+"'><button type='button'>NO</button></a>");
out.println("<a href='UdateRisposta?risp=si&id="+id+"'><button type='button'>SI</button></a>");
%>
</body>
</html>
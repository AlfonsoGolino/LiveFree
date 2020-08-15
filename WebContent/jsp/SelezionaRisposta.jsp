<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% String indirizzo = (String)request.getAttribute("Indirizzo");
String foto = (String)request.getAttribute("Foto");
String codiceFiscale = (String)request.getAttribute("codiceFiscale");
int id = (Integer)request.getAttribute("ID");
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
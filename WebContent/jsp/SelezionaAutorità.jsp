<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import ="java.util.List" import="java.util.Iterator"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Seleziona Autorità</title>
</head>
<body>
<%  
			List<String> listaAutoirtà= (List<String>) request.getAttribute("Lista Autorita");
			Iterator it=listaAutoirtà.iterator();
			while(it.hasNext()){
				String matricola = (String) it.next();
				String nome = (String) it.next();
				String cognome = (String) it.next();
				out.println("<div class='card'> <a href='jsp/InsSegnalazione.jsp?nome="+nome+"&cognome="+cognome+"&matricola="+matricola+"'>nome = "+nome+" cogome = "+cognome+" matricola = "+matricola+"</a></div>");
			}	
%>
</body>
</html>
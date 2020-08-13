<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import ="java.util.List"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Seleziona Autorità</title>
</head>
<body>
<%  
			List<String> listaAutoirtà= (List<String>) request.getAttribute("Lista Autorita");
			for(int i=0; i< listaAutoirtà.size();i++){
				String matricola = listaAutoirtà.get(i);
				out.println("<div class='card'> <a href='ServletFormDomanda?autorita="+matricola+"'> Autorità="+matricola+" ></a></div>");
			}	
%>
</body>
</html>
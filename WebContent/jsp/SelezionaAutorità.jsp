<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import ="java.util.List"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Seleziona Autoritą</title>
</head>
<body>
<%  
			List<String> listaAutoirtą= (List<String>) request.getAttribute("Lista Autorita");
			for(int i=0; i< listaAutoirtą.size();i++){
				String matricola = listaAutoirtą.get(i);
				out.println("<div class='card'> <a href='ServletFormDomanda?autorita="+matricola+"'> Autoritą="+matricola+" ></a></div>");
			}	
%>
</body>
</html>
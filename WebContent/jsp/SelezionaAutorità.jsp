<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import ="java.util.List"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Seleziona Autorit�</title>
</head>
<body>
<%  
			List<String> listaAutoirt�= (List<String>) request.getAttribute("Lista Autorita");
			for(int i=0; i< listaAutoirt�.size();i++){
				String matricola = listaAutoirt�.get(i);
				out.println("<div class='card'> <a href='ServletFormDomanda?autorita="+matricola+"'> Autorit�="+matricola+" ></a></div>");
			}	
%>
</body>
</html>
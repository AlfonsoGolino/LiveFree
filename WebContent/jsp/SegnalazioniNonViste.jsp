<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
   pageEncoding="ISO-8859-1" import ="java.util.List" import="java.util.Iterator"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Segnalazioni non viste</title>
</head>
<body>
<%  if(session.getAttribute("vis").equals("si")){
			List<String> listaSegnalazioni= (List<String>) request.getAttribute("listaSegnalazioni");
			Iterator it=listaSegnalazioni.iterator();
			while(it.hasNext()){
				String CodiceFiscale = (String) it.next();
				String Indirizzo = (String) it.next();
				String id = (String) it.next();
				out.println("<div class='card'><a href='SelezionaRisposta?id="+id+"'> Codice Ficale = "+CodiceFiscale+" Indirizzo = "+Indirizzo+"</a></div>");
			}	
}else{
%>
<div>
non ci sono segnalazioni
</div>
<%} %>
</body>
</html>
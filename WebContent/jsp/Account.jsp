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
<form action="Logout" method="get">
<input type="submit" value="Logout">
</form>
<a  href="FormModifca.html" title="Modifica Account">
<button type="button">Modifica Account</button>
</a>
<a  href="FormSelezionaAutorità.html" title="Inserisci Segnalazione">
<button type="button">Inserisci segnalazione</button>
</a>
<%}else{%>
Account Autorità
<form action="Logout" method="get">
<input type="submit" value="Logout">
</form>
<a  href="FormModifca.html" title="Modifica Account">
<button type="button">Modifica Account</button>
</a>
<a  href="SegnalazioninonViste" title="Segnalazioni non Viste">
<button type="button">Segnalazione non Viste</button>
</a>
<%if(session.getAttribute("vis").equals("si")){ %>
<button onclick="myFunction()">Notifiche</button>
<%}else{%>
<button onclick="myFunction1()">Notifiche</button>
<%}
} %>
<script type="text/javascript">
function myFunction() {
	alert("Ci sono nuove Segnalazioni");
}

function myFunction1() {
	alert("Non ci sono nuove Segnalazioni");
}
</script>
</body>
</html>
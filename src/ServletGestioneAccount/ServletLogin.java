package ServletGestioneAccount;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ClassiComuni.Autorità;
import ClassiComuni.Utente;
import GestioneIterazioneUtenteAutorità.GestioneIterazioneUtenteAutorità;
import GestioneIterazioneUtenteAutorità.ImpGestioneIterazioneUtenteAutorità;
import GestioneUtente.GestioneUtente;
import GestioneUtente.ImpGestioneUtente;



@WebServlet(name="/Login", urlPatterns = {"/Login"})
public class ServletLogin extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
		      throws ServletException, IOException {
		GestioneUtente u = new ImpGestioneUtente();
		 String username = request.getParameter("Username");
		 String pasword = request.getParameter("Pasword");
		 String tipo = request.getParameter("Tipo");
		 HttpSession sessione = request.getSession();
		 sessione.setAttribute("Username", username);  
		 sessione.setAttribute("tipo", tipo);
		 sessione.setAttribute("Pasword", pasword);
		 if (tipo.equals("utente")) {
			 Utente usr = (Utente) u.loginAccount(username, pasword, tipo);
			 request.setAttribute("Nome", usr.getNome());
			 request.setAttribute("Cognome", usr.getCognome());
			 request.setAttribute("Codice Fiscale", usr.getCodiceFiscale());
			 if(usr.getUsername() != null) {
				 RequestDispatcher view = request.getRequestDispatcher("jsp/Account.jsp");
			     view.forward(request, response);
			 }else {
				 RequestDispatcher view = request.getRequestDispatcher("html/Login.html");
			     view.forward(request, response);
			 }
		 }else if(tipo.equals("autorita")) {
			 Autorità a = (Autorità) u.loginAccount(username, pasword, tipo);
			 request.setAttribute("Nome", a.getNome());
			 request.setAttribute("Cognome", a.getCognome());
			 request.setAttribute("Matricola", a.getMatricola());
			 if(a.getUsername() != null) {
				 GestioneIterazioneUtenteAutorità i = new ImpGestioneIterazioneUtenteAutorità();
				 boolean vis = i.SegnalazioneDaVisualizzare(tipo);
				 if (vis == true) {
				   sessione.setAttribute("vis", "si");
				 } else {
				   sessione.setAttribute("vis", "no");
				 }
				 RequestDispatcher view = request.getRequestDispatcher("jsp/Account.jsp");
			     view.forward(request, response);
			 }else {
				 RequestDispatcher view = request.getRequestDispatcher("html/Login.html");
			     view.forward(request, response);
			 }
		 }
	}
	
	 protected void doPost(HttpServletRequest request, HttpServletResponse response) 
		      throws ServletException, IOException {
		 doGet(request, response);
	 }

}

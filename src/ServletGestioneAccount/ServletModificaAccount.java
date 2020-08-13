package ServletGestioneAccount;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import GestioneUtente.GestioneUtente;
import GestioneUtente.ImpGestioneUtente;


@WebServlet(name="/ModificaAccount", urlPatterns = {"/ModificaAccount"})
public class ServletModificaAccount extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1194662384249923108L;
	 protected void doGet(HttpServletRequest request, HttpServletResponse response) 
		      throws ServletException, IOException {
		 HttpSession sessione = request.getSession();
		 	String tipo = (String) sessione.getAttribute("tipo");
		    String nome = request.getParameter("Nome");
		    String cognome = request.getParameter("Cognome");
		    String us = request.getParameter("user");
		    String password = request.getParameter("Pasword");
		    String usr = (String) sessione.getAttribute("Username");
		    if(!us.equals(usr)) {
		    	sessione.setAttribute("Username", us);
		    }
		    GestioneUtente u = new ImpGestioneUtente();
		    if(tipo.equals("utente")) {
		    	String codiceFiscale = request.getParameter("C");
		    	u.modificaAccount(tipo, nome, cognome, codiceFiscale, us, password);
		    	RequestDispatcher view = request.getRequestDispatcher("jsp/Account.jsp");
			     view.forward(request, response);
		    }else {
		    	String matricola = request.getParameter("M");
		    	u.modificaAccount(tipo, nome, cognome,matricola, us, password);
		    	RequestDispatcher view = request.getRequestDispatcher("jsp/Account.jsp");
			     view.forward(request, response);
		    }
		  }
	 protected void doPost(HttpServletRequest request, HttpServletResponse response) 
		      throws ServletException, IOException {
		    doGet(request, response);
		  }
}

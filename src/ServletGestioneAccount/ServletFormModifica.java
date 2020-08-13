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
import GestioneUtente.GestioneUtente;
import GestioneUtente.ImpGestioneUtente;






@WebServlet(name="/FormModifca.html", urlPatterns = {"/FormModifca.html"})
public class ServletFormModifica extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
		      throws ServletException, IOException {
		GestioneUtente u = new ImpGestioneUtente();
	    HttpSession session = request.getSession();
	    String username = (String) session.getAttribute("Username");
	    String tipo = (String) session.getAttribute("tipo");
	    if (tipo.equals("utente")) {
	    	Utente user = (Utente) u.infoAccount(username, tipo);
	    	 request.setAttribute("Nome",user.getNome());
	    	 request.setAttribute("Cognome",user.getCognome());
	    	 request.setAttribute("CodiceFiscale",user.getCodiceFiscale());
	    	 request.setAttribute("Username",user.getUsername());
	    	 request.setAttribute("Password",user.getPasword());
	    	 RequestDispatcher view = request.getRequestDispatcher("jsp/ModificaAccount.jsp");
	         view.forward(request, response);
	    }else {
	    	Autorità a = (Autorità) u.infoAccount(username, tipo);
	   	 	request.setAttribute("Nome",a.getNome());
	   	 	request.setAttribute("Cognome",a.getCognome());
	   	 	request.setAttribute("Matricola",a.getMatricola());
	   	 	request.setAttribute("Username",a.getUsername());
	   	 	request.setAttribute("Password",a.getPasword());
	   	 	RequestDispatcher view = request.getRequestDispatcher("jsp/ModificaAccount.jsp");
	   	 	view.forward(request, response);
	    }
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
		      throws ServletException, IOException {
		    doGet(request, response);
		  }
	
}

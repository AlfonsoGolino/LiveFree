package ServletGestioneAccount;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import GestioneUtente.GestioneUtente;
import GestioneUtente.ImpGestioneUtente;

@WebServlet(name="/FormSelezionaAutorità.html", urlPatterns = {"/FormSelezionaAutorità.html"})
public class FormSelezionaAuotrità extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
		      throws ServletException, IOException {
		GestioneUtente u = new ImpGestioneUtente();
		request.setAttribute("Lista Autorita", u.RecuperaID("Autorità"));
		RequestDispatcher view = request.getRequestDispatcher("jsp/SelezionaAutorità.jsp");
        view.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
		      throws ServletException, IOException {
		    doGet(request, response);
		  }
}

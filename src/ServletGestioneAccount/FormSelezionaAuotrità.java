package ServletGestioneAccount;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import GestioneIterazioneUtenteAutorit�.GestioneIterazioneUtenteAutorit�;
import GestioneIterazioneUtenteAutorit�.ImpGestioneIterazioneUtenteAutorit�;

@WebServlet(name="/FormSelezionaAutorit�.html", urlPatterns = {"/FormSelezionaAutorit�.html"})
public class FormSelezionaAuotrit� extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
		      throws ServletException, IOException {
		GestioneIterazioneUtenteAutorit� i = new ImpGestioneIterazioneUtenteAutorit�();
		request.setAttribute("Lista Autorita", i.RecuperaID("Autorit�"));
		RequestDispatcher view = request.getRequestDispatcher("jsp/SelezionaAutorit�.jsp");
        view.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
		      throws ServletException, IOException {
		    doGet(request, response);
		  }
}

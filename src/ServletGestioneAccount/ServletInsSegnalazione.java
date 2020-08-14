package ServletGestioneAccount;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ClassiComuni.Utente;
import GestioneIterazioneUtenteAutorità.GestioneIterazioneUtenteAutorità;
import GestioneIterazioneUtenteAutorità.ImpGestioneIterazioneUtenteAutorità;
import GestioneUtente.GestioneUtente;
import GestioneUtente.ImpGestioneUtente;

@WebServlet(name="/Segnalazione", urlPatterns = {"/Segnalazione"})
public class ServletInsSegnalazione extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
		      throws ServletException, IOException {
		GestioneUtente u = new ImpGestioneUtente();
		GestioneIterazioneUtenteAutorità i = new ImpGestioneIterazioneUtenteAutorità();
		HttpSession session = request.getSession();
	    String username = (String) session.getAttribute("Username");
		String tipo = (String) session.getAttribute("tipo");
		Utente user = (Utente) u.infoAccount(username, tipo);
		String matricola = request.getParameter("Matricola");
		String indirizzo = request.getParameter("Indirizzo");
	    String foto = request.getParameter("Foto");
		i.InserisciSegnalazione(indirizzo, foto, matricola, user.getCodiceFiscale());
		RequestDispatcher view = request.getRequestDispatcher("jsp/Account.jsp");
	    view.forward(request, response);
	}
	
	 protected void doPost(HttpServletRequest request, HttpServletResponse response) 
		      throws ServletException, IOException {
		    doGet(request, response);
		  }

}

package ServletGestioneAccount;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ClassiComuni.Segnalazione;
import GestioneIterazioneUtenteAutoritÓ.GestioneIterazioneUtenteAutoritÓ;
import GestioneIterazioneUtenteAutoritÓ.ImpGestioneIterazioneUtenteAutoritÓ;

@WebServlet(name="/SelezionaRisposta", urlPatterns = {"/SelezionaRisposta"})
public class ServletSelezionaRisposta extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
		      throws ServletException, IOException {
			String id = request.getParameter("id");
			int ID = Integer.parseInt(id);
			GestioneIterazioneUtenteAutoritÓ i = new ImpGestioneIterazioneUtenteAutoritÓ();
			Segnalazione s = i.getSegnalazione(ID);
			request.setAttribute("Indirizzo", s.getIndirizzo());
			request.setAttribute("Foto", s.getFoto());
			request.setAttribute("codiceFiscale", s.getCodiceFiscale());
			request.setAttribute("ID", s.getIdSegnalazione());
			RequestDispatcher view = request.getRequestDispatcher("jsp/SelezionaRisposta.jsp");
		     view.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
		      throws ServletException, IOException {
		    doGet(request, response);
		  }
}

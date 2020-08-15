package ServletGestioneAccount;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import GestioneIterazioneUtenteAutorità.GestioneIterazioneUtenteAutorità;
import GestioneIterazioneUtenteAutorità.ImpGestioneIterazioneUtenteAutorità;


@WebServlet(name="/SegnalazioninonViste", urlPatterns = {"/SegnalazioninonViste"})
public class ServletSegnlazioniNonViste extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
		      throws ServletException, IOException {
		HttpSession session = request.getSession();
		String tipo = (String) session.getAttribute("tipo");
		GestioneIterazioneUtenteAutorità i = new ImpGestioneIterazioneUtenteAutorità();
		List<String> listaSegnalazioni = i.getSegnalazioniNonViste();
		boolean vis = i.SegnalazioneDaVisualizzare(tipo);
		 if (vis == true) {
		   session.setAttribute("vis", "si");
		 } else {
		   session.setAttribute("vis", "no");
		 }
		    request.setAttribute("listaSegnalazioni", listaSegnalazioni);
		    RequestDispatcher view = request.getRequestDispatcher("jsp/SegnalazioniNonViste.jsp");
		    view.forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
		      throws ServletException, IOException {
		    doGet(request, response);
		  }
}

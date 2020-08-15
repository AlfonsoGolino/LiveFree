package ServletGestioneAccount;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import GestioneIterazioneUtenteAutorità.GestioneIterazioneUtenteAutorità;
import GestioneIterazioneUtenteAutorità.ImpGestioneIterazioneUtenteAutorità;

@WebServlet(name="/UdateRisposta", urlPatterns = {"/UdateRisposta"})
public class ServletUpdateRisposta extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
		      throws ServletException, IOException {
		HttpSession sessione = request.getSession();
	 	String tipo = (String) sessione.getAttribute("tipo");
		String ris= request.getParameter("risp");
		String id = request.getParameter("id");
		int ID = Integer.parseInt(id);
		GestioneIterazioneUtenteAutorità i = new ImpGestioneIterazioneUtenteAutorità();
		if(ris.equals("si")) {
		i.InsRisposta(ID, true);
		}else{
			i.InsRisposta(ID, false);
		}
		 boolean vis = i.SegnalazioneDaVisualizzare(tipo);
		 if (vis == true) {
		   sessione.setAttribute("vis", "si");
		 } else {
		   sessione.setAttribute("vis", "no");
		 }
		 RequestDispatcher view = request.getRequestDispatcher("jsp/Account.jsp");
	     view.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
		      throws ServletException, IOException {
		    doGet(request, response);
		  }
}

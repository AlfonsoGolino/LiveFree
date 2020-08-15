package ServletGestioneAccount;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import GestioneUtente.*;




@WebServlet(name="/Registrazione", urlPatterns = {"/Registrazione"})
public class ServletRegistrazione extends HttpServlet{
	  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
		      throws ServletException, IOException {
		  String tipo = request.getParameter("Tipo");
		  String nome = request.getParameter("Nome");
		  String cognome = request.getParameter("Cognome");
		  String cofi_ma = request.getParameter("co_fi/mat");
		  String username = request.getParameter("Username");
		  String pasword = request.getParameter("Pasword");
		  GestioneUtente u = new ImpGestioneUtente();
		  if(tipo.equals("utente")) {
		  u.registraAccount("utente",nome, cognome, cofi_ma, username, pasword);
		  }else if(tipo.equals("autorita")){
			  u.registraAccount("autorita",nome, cognome, cofi_ma, username, pasword);
		  }
		  RequestDispatcher view = request.getRequestDispatcher("html/Login.html");
		     view.forward(request, response);
	  }
	  
	  protected void doPost(HttpServletRequest request, HttpServletResponse response) 
		      throws ServletException, IOException {
		    doGet(request, response);
		  }
	
}

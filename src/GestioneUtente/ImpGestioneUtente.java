package GestioneUtente;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ClassiComuni.Utente;
import ClassiComuni.Autorità;
import storage.FactoryDao;
import storage.ObjectDao;

public class ImpGestioneUtente implements GestioneUtente{

	@Override
	public Object loginAccount(String username, String password, String tipo) {
		 boolean accesso = false;
		    if (tipo.equals("utente")) {
		      Utente u = new Utente(null, null,null, username, password);
		      FactoryDao fdao = new FactoryDao();
		      ObjectDao o = fdao.getObject("Utente");
		      try {
		        accesso = o.recuperaDati(u);
		      } catch (SQLException e) {
		        e.printStackTrace();
		      }
		      if (accesso == true) {
		        return u;
		      } else {
		        u.setUsername(null); 
		        return u;
		      }
		    } else {
		      Autorità a = new Autorità(null, null, null, username, password);
		      FactoryDao fdao = new FactoryDao();
		      ObjectDao o = fdao.getObject("Autorità");
		      try {
		        accesso = o.recuperaDati(a);
		      } catch (SQLException e) {
		        e.printStackTrace();
		      }
		      if (accesso == true) {
		        return a;
		      } else {
		        a.setUsername(null);
		        return a;
		      }
		    }
	 }

	@Override
	public void registraAccount(String tipo, String Nome, String Cognome, String cofi_ma, 
			  String Username, String Pasword) throws IOException {
		// TODO Auto-generated method stu
		 if(tipo.equals("utente")) {
		Utente s = new Utente(Nome, Cognome, cofi_ma, Username, Pasword);
	      FactoryDao fdao = new FactoryDao();
	      ObjectDao o = fdao.getObject("Utente");
	      try {
	        o.inserisciDati(s);
	      } catch (SQLException e) {
	        e.printStackTrace();
	      }
		 }else {
			 Autorità s = new Autorità(Nome, Cognome, cofi_ma, Username, Pasword);
		      FactoryDao fdao = new FactoryDao();
		      ObjectDao o = fdao.getObject("Autorità");
		      try {
		        o.inserisciDati(s);
		      } catch (SQLException e) {
		        e.printStackTrace();
		      } 
		 }
	}

	@Override
	public void modificaAccount(String tipo, String Nome, String Cognome, String id,
			  String Username, String Pasword) throws IOException {
		if (tipo.equals("utente")) {
			Utente u = new Utente(Nome, Cognome, id, Username, Pasword);
			FactoryDao fdao = new FactoryDao();
		      ObjectDao o = fdao.getObject("Utente");
		      try {
		        o.modificaDati(u);
		      } catch (SQLException e) {
		        e.printStackTrace();
		      }
		}else {
			Autorità a = new Autorità(Nome, Cognome, id, Username, Pasword);
			FactoryDao fdao = new FactoryDao();
		    ObjectDao o = fdao.getObject("Autorità");
		      try {
		        o.modificaDati(a);
		      } catch (SQLException e) {
		        e.printStackTrace();
		      }
		}
	    }
	
	@Override
	  public Object infoAccount(String username, String tipo) {
		    if (tipo.equals("utente")) {
		      Utente u = new Utente(null, null,null, username, null);
		      FactoryDao fdao = new FactoryDao();
		      ObjectDao o = fdao.getObject("Utente");
		      try { 
		        o.recuperaDati(u);
		      } catch (SQLException e) {
		        e.printStackTrace();
		      }
		      return u;
		    } else {
		    	Autorità a = new Autorità(null, null, null, username, null);
			    FactoryDao fdao = new FactoryDao();
			    ObjectDao o = fdao.getObject("Autorità");
		      try {
		        o.recuperaDati(a);
		      } catch (SQLException e) {
		        e.printStackTrace();
		      }
		      return a;
		    }
		  }

	@Override
	public  List<String>  RecuperaID(String tipo) {
		if (tipo.equals("utente")) {
			List<String> listaUtente = new ArrayList<String>();
		      FactoryDao fdao = new FactoryDao();
		      ObjectDao o = fdao.getObject("Utente");
		      try { 
		       ArrayList<Object> listaU =  o.recuperaTutto();
		       for(int i = 0; i < listaU.size(); i++) {
		    	   Utente u = (Utente) listaU.get(i);
		    	   listaUtente.add(u.getCodiceFiscale());
		       }
		      } catch (SQLException e) {
		        e.printStackTrace();
		      }
		      return listaUtente;
		    } else {
		    	List<String> listaAutorita = new ArrayList<String>();
		    	ArrayList<Object> listaA = null;
			    FactoryDao fdao = new FactoryDao();
			    ObjectDao o = fdao.getObject("Autorità");
			    try {
					listaA =  o.recuperaTutto();
				} catch (NumberFormatException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			      for(int i = 0; i < listaA.size(); i++) {
			    	   Autorità a = (Autorità) listaA.get(i);
			    	   listaAutorita.add(a.getMatricola());
			       }
		      return listaAutorita;
		    }
	}
	
	
}

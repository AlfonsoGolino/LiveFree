package GestioneUtente;

import java.io.IOException;
import java.sql.SQLException;

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
		        accesso =(boolean) o.recuperaDati(u);
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
		        accesso =(boolean) o.recuperaDati(a);
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
		 }else if(tipo.equals("autorita")) {
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
}

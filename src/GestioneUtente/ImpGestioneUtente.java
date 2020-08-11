package GestioneUtente;

import java.io.IOException;
import java.sql.SQLException;

import ClassiComuni.Utente;
import ClassiComuni.Autorit�;
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
		      Autorit� a = new Autorit�(null, null, null, username, password);
		      FactoryDao fdao = new FactoryDao();
		      ObjectDao o = fdao.getObject("Autorit�");
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
			 Autorit� s = new Autorit�(Nome, Cognome, cofi_ma, Username, Pasword);
		      FactoryDao fdao = new FactoryDao();
		      ObjectDao o = fdao.getObject("Autorit�");
		      try {
		        o.inserisciDati(s);
		      } catch (SQLException e) {
		        e.printStackTrace();
		      } 
		 }
	}

	@Override
	public void modificaAccount(String Nome, String Cognome, String CodiceFiscale, 
			  String Username, String Pasword) throws IOException {
	    }
}

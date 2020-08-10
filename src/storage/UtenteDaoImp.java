package storage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


import ClassiComuni.Utente;

public class UtenteDaoImp implements ObjectDao {
	  private Connection con;
	  
	  public UtenteDaoImp() {
	    SingletonDataBase db = SingletonDataBase.getInstance();
	    con = db.getConnessione();
	  }

	@Override
	public void inserisciDati(Object o) throws SQLException {
	    Utente u = (Utente) o;

	    PreparedStatement prepared = (PreparedStatement) con.prepareStatement("insert into Utente("
	        + "Nome,Cognome,"
	        + "CodiceFiscale,username,pasword) values (?,?,?,?,?);");
	    prepared.setString(1, u.getNome());
	    prepared.setString(2, u.getCognome());
	    prepared.setString(3, u.getCodiceFiscale());
	    prepared.setString(4, u.getUsername());
	    prepared.setString(5, u.getPasword());
	    prepared.executeUpdate();
	  }

	@Override
	public void modificaDati(Object o) throws SQLException {
		// TODO Auto-generated method stub
		
	}
	  
	  
}

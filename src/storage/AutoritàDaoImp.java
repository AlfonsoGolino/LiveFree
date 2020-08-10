package storage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import ClassiComuni.Autorit‡;

public class Autorit‡DaoImp implements ObjectDao {
	  private Connection con;
	  
	  public Autorit‡DaoImp() {
	    SingletonDataBase db = SingletonDataBase.getInstance();
	    con = db.getConnessione();
	  }

	@Override
	public void inserisciDati(Object o) throws SQLException {
	    Autorit‡ a = (Autorit‡) o;

	    PreparedStatement prepared = (PreparedStatement) con.prepareStatement("insert into Autorit‡("
	        + "Matricola,Nome,"
	        + "Cognome,username,pasword) values (?,?,?,?,?);");
	    prepared.setString(1, a.getMatricola());
	    prepared.setString(2, a.getNome());
	    prepared.setString(3, a.getCognome());
	    prepared.setString(4, a.getUsername());
	    prepared.setString(5, a.getPasword());
	    prepared.executeUpdate();
	  }

	@Override
	public void modificaDati(Object o) throws SQLException {
		// TODO Auto-generated method stub
		
	}
	
}

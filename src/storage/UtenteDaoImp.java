package storage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import java.sql.ResultSet;


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
	    Utente u = (Utente) o;
	    PreparedStatement prepared = (PreparedStatement) con.prepareStatement("update Utente set "
	        + "Nome "
	        + "= ?, Cognome = ?,"
	        + " username = ?, pasword = ? where CodiceFiscale = ?;");
	    prepared.setString(1, u.getNome());
	    prepared.setString(2, u.getCognome());
	    prepared.setString(3, u.getUsername());
	    prepared.setString(4, u.getPasword());
	    prepared.setString(5, u.getCodiceFiscale());
	    prepared.executeUpdate();
	  }
	  
	@Override
	  public boolean recuperaDati(Object o) throws SQLException {
		Utente u = (Utente) o;
		String pass = u.getPasword();
	    
	    PreparedStatement prepared = (PreparedStatement) con.prepareStatement("select * from Utente "
	        + "where username = ?;");
	    prepared.setString(1, u.getUsername());
	    ResultSet result = (ResultSet) prepared.executeQuery();
	    while (result.next()) {
	      u.setNome(result.getString("Nome"));
	      u.setCognome(result.getString("Cognome"));
	      u.setCodiceFiscale(result.getString("CodiceFiscale"));
	      u.setPasword(result.getString("pasword"));
	      if (u.getPasword().equals(pass)) {
	        return true;
	      }
	    }
	    return false;
	  }

	@Override
	public ArrayList<Object> recuperaTutto() throws NumberFormatException, SQLException {
	    ArrayList<Object> listaU = new ArrayList<>(); 
	    
	    Statement query = (Statement) con.createStatement();
	    ResultSet result = (ResultSet) query.executeQuery("select * from Utente;");
	    while (result.next()) {
	      Utente u = new Utente(null, null, null, null, null);
	      u.setNome(result.getString("Nome"));
	      u.setCognome(result.getString("Cognome"));
	      u.setCodiceFiscale(result.getString("CodiceFiscale"));
	      u.setUsername(result.getString("username"));
	      u.setPasword(result.getString("pasword"));
	      listaU.add(u);
	    }
	    return listaU;
	  }
}

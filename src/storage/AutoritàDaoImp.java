package storage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

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

	    PreparedStatement prepared = (PreparedStatement) con.prepareStatement("insert into Autorita("
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
	    Autorit‡ a = (Autorit‡) o;
	    PreparedStatement prepared = (PreparedStatement) con.prepareStatement("update Autorita set "
	        + "Nome "
	        + "= ?, Cognome = ?,"
	        + " username = ?, pasword = ? where Matricola = ?;");
	    prepared.setString(1, a.getNome());
	    prepared.setString(2, a.getCognome());
	    prepared.setString(3, a.getUsername());
	    prepared.setString(4, a.getPasword());
	    prepared.setString(5, a.getMatricola());
	    prepared.executeUpdate();
	  }
	
	@Override
	  public boolean recuperaDati(Object o) throws SQLException {
		Autorit‡ a = (Autorit‡) o;
		String pass = a.getPasword();
	    
		 PreparedStatement prepared = (PreparedStatement) con.prepareStatement("select * from Autorita "
			        + "where username = ?;");
		    prepared.setString(1, a.getUsername());
		    ResultSet result = (ResultSet) prepared.executeQuery();
		    while (result.next()) {
		      a.setNome(result.getString("Nome"));
		      a.setCognome(result.getString("Cognome"));
		      a.setMatricola(result.getString("Matricola"));
		      a.setPasword(result.getString("pasword"));
		      if (a.getPasword().equals(pass)) {
		        return true;
		      }
		    }
		    return false;
		  }


	public ArrayList<Object> recuperaTutto() throws NumberFormatException, SQLException {
	    ArrayList<Object> listaA = new ArrayList<>(); 
	    
	    Statement query = (Statement) con.createStatement();
	    ResultSet result = (ResultSet) query.executeQuery("select * from Autorita;");
	    while (result.next()) {
	      Autorit‡ a = new Autorit‡(null, null, null, null, null);
	      a.setNome(result.getString("Nome"));
	      a.setCognome(result.getString("Cognome"));
	      a.setMatricola(result.getString("Matricola"));
	      a.setUsername(result.getString("username"));
	      a.setPasword(result.getString("pasword"));
	      listaA.add(a);
	    }
	    return listaA;
	  }
}

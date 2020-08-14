package storage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import ClassiComuni.Segnalazione;

public class SegnalazioneDaoImp implements ObjectDao{
	 private Connection con;
	 
	public SegnalazioneDaoImp() {
	    SingletonDataBase db = SingletonDataBase.getInstance();
	    con = db.getConnessione();
	  }
	@Override
	public void inserisciDati(Object o) throws SQLException {
		Segnalazione s = (Segnalazione) o;
		 PreparedStatement prepared = (PreparedStatement) con.prepareStatement("insert into Segnalazione("
			        + "IDSegnalazione,Indirizzo,"
			        + "Foto,matricola,codiceFiscale) values (?,?,?,?,?);");
			    prepared.setInt(1, s.getIdSegnalazione());
			    prepared.setString(2, s.getIndirizzo());
			    prepared.setString(3, s.getFoto());
			    prepared.setString(4, s.getMatricola());
			    prepared.setString(5, s.getCodiceFiscale());
			    prepared.executeUpdate();
	}

	@Override
	public void modificaDati(Object o) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean recuperaDati(Object o) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArrayList<Object> recuperaTutto() throws NumberFormatException, SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}

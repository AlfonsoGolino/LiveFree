package storage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
			        + "Foto,Visualizzato,matricola,codiceFiscale) values (?,?,?,?,?,?);");
			    prepared.setInt(1, s.getIdSegnalazione());
			    prepared.setString(2, s.getIndirizzo());
			    prepared.setString(3, s.getFoto());
			    prepared.setBoolean(4, s.isVisualizzato());
			    prepared.setString(5, s.getMatricola());
			    prepared.setString(6, s.getCodiceFiscale());
			    prepared.executeUpdate();
	}

	@Override
	public void modificaDati(Object o) throws SQLException {
	    Segnalazione s = (Segnalazione) o;
	    PreparedStatement prepared = (PreparedStatement) con.prepareStatement("update Segnalazione set "
		        + "DroneInviato "
		        + "= ?, Visualizzato = ? where IDSegnalazione = ?;");
	    prepared.setBoolean(1, s.isDroneInviato());
	    prepared.setBoolean(2, s.isVisualizzato());
	    prepared.setInt(3, s.getIdSegnalazione());
	    prepared.executeUpdate();
	}

	@Override
	public Object recuperaDati(Object o) throws SQLException {
		Segnalazione s = (Segnalazione) o;
		int id = s.getIdSegnalazione();
		 PreparedStatement prepared = (PreparedStatement) con.prepareStatement("select * from Segnalazione "
			        + "where IDSegnalazione = ?;");
		 prepared.setInt(1, id);
		 ResultSet result = (ResultSet) prepared.executeQuery();
		    while (result.next()) {
		    	s.setIndirizzo(result.getString("Indirizzo"));
		    	s.setFoto(result.getString("Foto"));
		    	s.setCodiceFiscale(result.getString("codiceFiscale"));
		    }
		return s;
	}

	@Override
	public ArrayList<Object> recuperaTutto() throws NumberFormatException, SQLException {
		ArrayList<Object> listaS = new ArrayList<>(); 
	    
	    Statement query = (Statement) con.createStatement();
	    ResultSet result = (ResultSet) query.executeQuery("select * from Segnalazione;");
	    while (result.next()) {
	      Segnalazione s = new Segnalazione(0, null, null, null,false,null);
	      s.setIdSegnalazione(result.getInt("IDSegnalazione"));
	      s.setIndirizzo(result.getString("Indirizzo"));
	      s.setFoto(result.getString("Foto"));
	      s.setVisualizzato(result.getBoolean("Visualizzato"));
	      s.setMatricola(result.getString("matricola"));
	      s.setCodiceFiscale(result.getString("codiceFiscale"));
	      listaS.add(s);
	    }
	    return listaS;
	  }
}

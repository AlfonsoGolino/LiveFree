package storage;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public class SegnalazioneDaoImp implements ObjectDao{
	 private Connection con;
	 
	public SegnalazioneDaoImp() {
	    SingletonDataBase db = SingletonDataBase.getInstance();
	    con = db.getConnessione();
	  }
	@Override
	public void inserisciDati(Object o) throws SQLException {
		// TODO Auto-generated method stub
		
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

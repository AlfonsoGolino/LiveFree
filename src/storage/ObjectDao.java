package storage;

import java.sql.SQLException;
import java.util.ArrayList;

public interface ObjectDao {
  public void inserisciDati(Object o)throws SQLException;
  public void modificaDati(Object o) throws SQLException;
  public Object recuperaDati(Object o) throws SQLException;
	public ArrayList<Object> recuperaTutto() throws NumberFormatException, SQLException;
}

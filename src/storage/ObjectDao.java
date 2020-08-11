package storage;

import java.sql.SQLException;

public interface ObjectDao {
  public void inserisciDati(Object o)throws SQLException;
  public void modificaDati(Object o) throws SQLException;
  public boolean recuperaDati(Object o) throws SQLException;
}

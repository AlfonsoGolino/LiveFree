package storage;

import java.sql.SQLException;
import java.util.ArrayList;

public interface ObjectDao {
  public void inserisciDati(Object o)throws SQLException;
  public void modificaDati(Object o) throws SQLException;
}

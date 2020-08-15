package storage;

import java.sql.Connection;
import java.sql.DriverManager;


public class SingletonDataBase {
	  private static Connection con;
	  private static SingletonDataBase db = new SingletonDataBase();
	    
	  private SingletonDataBase() {
	    con = null;
	    try {
	      Class.forName("com.mysql.jdbc.Driver");
	      String url = "jdbc:mysql://localhost:3306/livefree?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	      String username = "root";
	      String pwd = "";
	      con = (Connection) DriverManager.getConnection(url,username,pwd);
	    } catch (Exception e) {
	      e.printStackTrace();
	    }
	  }
	  
	  public static SingletonDataBase getInstance() {
		    return db;
		  }
	  
	  public Connection getConnessione() {
		    return con;
		  }
}

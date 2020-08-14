package GestioneUtente;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public interface GestioneUtente {
 
  
  public Object loginAccount(String username,String password,String tipo); 
  
  public void registraAccount(String tipo, String Nome, String Cognome, String cofi_ma, 
		  String Username, String Pasword) throws IOException;
  
  public void modificaAccount(String tipo, String Nome, String Cognome, String id,
		  String Username, String Pasword) throws IOException;
  
  public Object infoAccount(String username, String tipo);
 
}

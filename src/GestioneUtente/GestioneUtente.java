package GestioneUtente;

import java.io.IOException;

public interface GestioneUtente {
 
  
  public Object loginAccount(String username,String password,String tipo); 
  
  public void registraAccount(String tipo, String Nome, String Cognome, String cofi_ma, 
		  String Username, String Pasword) throws IOException;
  
  public void modificaAccount(String Nome, String Cognome, 
		  String CodiceFiscale, String Username, String Pasword) throws IOException;
}

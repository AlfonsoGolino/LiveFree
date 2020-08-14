package GestioneIterazioneUtenteAutoritÓ;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ClassiComuni.AutoritÓ;
import ClassiComuni.Utente;
import storage.FactoryDao;
import storage.ObjectDao;

public class ImpGestioneIterazioneUtenteAutoritÓ implements GestioneIterazioneUtenteAutoritÓ{
	@Override
	public  List<String>  RecuperaID(String tipo) {
		if (tipo.equals("utente")) {
			List<String> listaUtente = new ArrayList<String>();
		      FactoryDao fdao = new FactoryDao();
		      ObjectDao o = fdao.getObject("Utente");
		      try { 
		       ArrayList<Object> listaU =  o.recuperaTutto();
		       for(int i = 0; i < listaU.size(); i++) {
		    	   Utente u = (Utente) listaU.get(i);
		    	   listaUtente.add(u.getCodiceFiscale());
		    	   listaUtente.add(u.getNome());
		    	   listaUtente.add(u.getCognome());
		       }
		      } catch (SQLException e) {
		        e.printStackTrace();
		      }
		      return listaUtente;
		    } else {
		    	List<String> listaAutorita = new ArrayList<String>();
		    	ArrayList<Object> listaA = null;
			    FactoryDao fdao = new FactoryDao();
			    ObjectDao o = fdao.getObject("AutoritÓ");
			    try {
					listaA =  o.recuperaTutto();
				} catch (NumberFormatException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			      for(int i = 0; i < listaA.size(); i++) {
			    	   AutoritÓ a = (AutoritÓ) listaA.get(i);
			    	   listaAutorita.add(a.getMatricola());
			    	   listaAutorita.add(a.getNome());
			    	   listaAutorita.add(a.getCognome());
			       }
		      return listaAutorita;
		    }
	}

	@Override
	public void InserisciSegnalazione(String indirizzo, String foto, boolean droneInviato, 
			String matricola, String codiceFiscale) {
		
		
	}
}

package GestioneIterazioneUtenteAutorità;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ClassiComuni.Autorità;
import ClassiComuni.Segnalazione;
import ClassiComuni.Utente;
import storage.FactoryDao;
import storage.ObjectDao;

public class ImpGestioneIterazioneUtenteAutorità implements GestioneIterazioneUtenteAutorità{
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
			    ObjectDao o = fdao.getObject("Autorità");
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
			    	   Autorità a = (Autorità) listaA.get(i);
			    	   listaAutorita.add(a.getMatricola());
			    	   listaAutorita.add(a.getNome());
			    	   listaAutorita.add(a.getCognome());
			       }
		      return listaAutorita;
		    }
	}

	@Override
	public void InserisciSegnalazione(String indirizzo, String foto, 
			String matricola, String codiceFiscale) {
		   int id = (int)(Math.random()*100000);
		   Segnalazione s = new Segnalazione(id, indirizzo, foto, 
				   codiceFiscale, matricola);
		   FactoryDao fd = new FactoryDao();
		   ObjectDao o = fd.getObject("Segnalazione");
		    try {
		        o.inserisciDati(s);
		      } catch (SQLException e) {
		        e.printStackTrace();
		      } 
	}
}

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
				   codiceFiscale,false, matricola);
		   FactoryDao fd = new FactoryDao();
		   ObjectDao o = fd.getObject("Segnalazione");
		    try {
		        o.inserisciDati(s);
		      } catch (SQLException e) {
		        e.printStackTrace();
		      } 
	}

	@Override
	public boolean SegnalazioneDaVisualizzare(String tipo) {
		   FactoryDao fd = new FactoryDao();
		    if (tipo.equals("autorita")) {
		      ObjectDao o = fd.getObject("Segnalazione");
		      ArrayList<Object> listaS = null;
		      try {
		          listaS = o.recuperaTutto();
		        } catch (NumberFormatException e) {
		          e.printStackTrace();
		        } catch (SQLException e) {
		          e.printStackTrace();
		        }
		      for (int i = 0;i < listaS.size();i++) {
		          Segnalazione s = (Segnalazione) listaS.get(i);
		          if (!s.isVisualizzato()) {
		        	  return true;
		          }
		        }
		    }
		return false;
	}

	@Override
	public List<String> getSegnalazioniNonViste() {
		 FactoryDao fd = new FactoryDao();
		ObjectDao o = fd.getObject("Segnalazione");
	      ArrayList<Object> listaS = null;
	      List<String> SegNonViste = new ArrayList<String>();
	      try {
	          listaS = o.recuperaTutto();
	        } catch (NumberFormatException e) {
	          e.printStackTrace();
	        } catch (SQLException e) {
	          e.printStackTrace();
	        }
	      for (int i = 0;i < listaS.size();i++) {
	    	  Segnalazione s = (Segnalazione) listaS.get(i);
	          if (!s.isVisualizzato()) {
	        	  SegNonViste.add(s.getCodiceFiscale());
	        	  SegNonViste.add(s.getIndirizzo());
	        	  SegNonViste.add(String.valueOf(s.getIdSegnalazione()));
	          }
	      }
	      return SegNonViste; 
	}

	@Override
	public Segnalazione getSegnalazione(int id) {
		 FactoryDao fd = new FactoryDao();
		 ObjectDao o = fd.getObject("Segnalazione");
		 Segnalazione s = new Segnalazione(id,null, null,null, false, null);
		 try {
			o.recuperaDati(s);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return s;	
	}

	@Override
	public void InsRisposta(int ID, boolean DroneInviato) {
		Segnalazione s = new Segnalazione(ID,null, null,null, true, null);
		s.setDroneInviato(DroneInviato);
		FactoryDao fdao = new FactoryDao();
	      ObjectDao o = fdao.getObject("Segnalazione");
	      try {
	        o.modificaDati(s);
	      } catch (SQLException e) {
	        e.printStackTrace();
	      }
		
	}
	
}

package GestioneIterazioneUtenteAutorità;

import java.util.List;

import ClassiComuni.Segnalazione;

public interface GestioneIterazioneUtenteAutorità {
	public  List<String>  RecuperaID(String tipo);
	public void InserisciSegnalazione(String indirizzo, String foto, String matricola, 
			String codiceFiscale);
	public boolean SegnalazioneDaVisualizzare(String tipo);
	public List<String> getSegnalazioniNonViste();
	public Segnalazione getSegnalazione(int id);
	public void InsRisposta(int ID, boolean Droneinviato);
}

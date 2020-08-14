package GestioneIterazioneUtenteAutorità;

import java.util.List;

public interface GestioneIterazioneUtenteAutorità {
	public  List<String>  RecuperaID(String tipo);
	public void InserisciSegnalazione(String indirizzo, String foto, boolean droneInviato, 
			String matricola, String codiceFiscale);
}

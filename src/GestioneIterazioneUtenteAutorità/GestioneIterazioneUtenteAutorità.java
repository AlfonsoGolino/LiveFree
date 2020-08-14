package GestioneIterazioneUtenteAutorità;

import java.util.List;

public interface GestioneIterazioneUtenteAutorità {
	public  List<String>  RecuperaID(String tipo);
	public void InserisciSegnalazione(String indirizzo, String foto, String matricola, 
			String codiceFiscale);
}

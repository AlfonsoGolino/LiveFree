package GestioneIterazioneUtenteAutoritÓ;

import java.util.List;

public interface GestioneIterazioneUtenteAutoritÓ {
	public  List<String>  RecuperaID(String tipo);
	public void InserisciSegnalazione(String indirizzo, String foto, boolean droneInviato, 
			String matricola, String codiceFiscale);
}

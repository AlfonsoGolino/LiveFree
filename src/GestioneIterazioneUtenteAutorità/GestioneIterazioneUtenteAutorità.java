package GestioneIterazioneUtenteAutorit�;

import java.util.List;

public interface GestioneIterazioneUtenteAutorit� {
	public  List<String>  RecuperaID(String tipo);
	public void InserisciSegnalazione(String indirizzo, String foto, String matricola, 
			String codiceFiscale);
}

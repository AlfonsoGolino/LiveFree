package ClassiComuni;

public class Segnalazione {
private int idSegnalazione;
private String indirizzo;
private String foto;
private String codiceFiscale;
private String matricola;

	public Segnalazione(int idSegnalazione, String indirizzo, String foto, String codiceFiscale, 
			String matricola) {
		this.idSegnalazione = idSegnalazione;
		this.indirizzo = indirizzo;
		this.foto = foto;
		this.codiceFiscale = codiceFiscale;
		this.matricola = matricola;
	}

	public int getIdSegnalazione() {
		return idSegnalazione;
	}

	public void setIdSegnalazione(int idSegnalazione) {
		this.idSegnalazione = idSegnalazione;
	}

	public String getIndirizzo() {
		return indirizzo;
	}

	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public String getCodiceFiscale() {
		return codiceFiscale;
	}

	public void setCodiceFiscale(String codiceFiscale) {
		this.codiceFiscale = codiceFiscale;
	}

	public String getMatricola() {
		return matricola;
	}

	public void setMatricola(String matricola) {
		this.matricola = matricola;
	}
}

package ClassiComuni;

public class Utente {
	private String Nome;
	private String Cognome;
	private String CodiceFiscale;
	private String Username;
	private String Pasword;
	
	public Utente(String Nome, String Cognome, String CodiceFiscale, String Username, String Pasword) {
		this.Nome = Nome;
		this.Cognome = Cognome;
		this.CodiceFiscale = CodiceFiscale;
		this.Username = Username;
		this.Pasword = Pasword;
	}
	public String getNome() {
		return Nome;
	}
	public void setNome(String nome) {
		Nome = nome;
	}
	public String getCognome() {
		return Cognome;
	}
	public void setCognome(String cognome) {
		Cognome = cognome;
	}
	public String getCodiceFiscale() {
		return CodiceFiscale;
	}
	public void setCodiceFiscale(String codiceFiscale) {
		CodiceFiscale = codiceFiscale;
	}
	public String getUsername() {
		return Username;
	}
	public void setUsername(String username) {
		Username = username;
	}
	public String getPasword() {
		return Pasword;
	}
	public void setPasword(String pasword) {
		Pasword = pasword;
	}
}

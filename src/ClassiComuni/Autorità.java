package ClassiComuni;

public class Autorità {
	private String Nome;
	private String Cognome;
	private String Matricola;
	private String Username;
	private String Pasword;
	
	public Autorità(String Nome, String Cognome, String Matricola, String Username, String Pasword) {
		this.Nome = Nome;
		this.Cognome = Cognome;
		this.Matricola = Matricola;
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
	public String getMatricola() {
		return Matricola;
	}
	public void setMatricola(String matricola) {
		Matricola = matricola;
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

package domain;

public class Utente {
	private String nome;
	private String cognome;
	private String username;
	private String password;


	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	// toString
	@Override
	public String toString() {
		return ("Nome:\t\t" + this.nome + " Cognome:\t\t" + this.cognome + "\nUsername:\t" + this.username
				+ " Password:\t" + this.password);
	}

}

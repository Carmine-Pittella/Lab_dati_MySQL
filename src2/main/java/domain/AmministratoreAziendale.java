package domain;

public class AmministratoreAziendale {

	private int idAmministratoreAziendale;
	private String nome;
	private String cognome;
	private String username;
	private String password;
	private int idAzienda;
	private int idUtente;

	public int getIdAmministratoreAziendale() {
		return idAmministratoreAziendale;
	}

	public void setIdAmministratoreAziendale(int idAmministratoreAziendale) {
		this.idAmministratoreAziendale = idAmministratoreAziendale;
	}

	public int getIdAzienda() {
		return idAzienda;
	}

	public void setIdAzienda(int idAzienda) {
		this.idAzienda = idAzienda;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getIdUtente() {
		return idUtente;
	}

	public void setIdUtente(int idUtente) {
		this.idUtente = idUtente;
	}

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

}

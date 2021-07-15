package entita;

public class Azienda {

	private int idAzienda;
	private String partitaIva;
	private boolean verificata;
	private String nome;
	private String settore;
	private String nomeRappresentante;
	private String cognomeRappresentante;
	private int idAdmin;
	
	
	public String getPartitaIva() {
		return partitaIva;
	}
	public void setPartitaIva(String partitaIva) {
		this.partitaIva = partitaIva;
	}
	public boolean isVerificata() {
		return verificata;
	}
	public void setVerificata(boolean verificata) {
		this.verificata = verificata;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSettore() {
		return settore;
	}
	public void setSettore(String settore) {
		this.settore = settore;
	}
	public String getNomeRappresentante() {
		return nomeRappresentante;
	}
	public void setNomeRappresentante(String nomeRappresentante) {
		this.nomeRappresentante = nomeRappresentante;
	}
	public String getCognomeRappresentante() {
		return cognomeRappresentante;
	}
	public void setCognomeRappresentante(String cognomeRappresentante) {
		this.cognomeRappresentante = cognomeRappresentante;
	}
	public int getIdAdmin() {
		return idAdmin;
	}
	public void setIdAdmin(int idAdmin) {
		this.idAdmin = idAdmin;
	}
	public int getIdAzienda() {
		return idAzienda;
	}
	public void setIdAzienda(int idAzienda) {
		this.idAzienda = idAzienda;
	}
	

}

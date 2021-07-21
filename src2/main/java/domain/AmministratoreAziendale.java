package domain;

public class AmministratoreAziendale extends Utente{

	private Integer idAmministratoreAziendale;
	private Integer idAzienda;
	private Integer idUtente;
	
	// GET E SET
	public Integer getIdAmministratoreAziendale() {
		return idAmministratoreAziendale;
	}
	public void setIdAmministratoreAziendale(Integer idAmministratoreAziendale) {
		this.idAmministratoreAziendale = idAmministratoreAziendale;
	}
	public Integer getIdAzienda() {
		return idAzienda;
	}
	public void setIdAzienda(Integer idAzienda) {
		this.idAzienda = idAzienda;
	}
	public Integer getIdUtente() {
		return idUtente;
	}
	public void setIdUtente(Integer idUtente) {
		this.idUtente = idUtente;
	}

	

}

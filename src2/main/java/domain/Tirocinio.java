package domain;

public class Tirocinio {
	
	private Integer idTirocinio;
	private Integer orarioInizio;
	private Integer orarioFine;
	private int durata;
	private String obiettivi;
	private String attivitaSvolte;
	private String modalita;
	private String facilitazioni;
	private int cfu;
	private boolean esito;
	private Integer idAzienda;
	private Integer idStudente;
	private Integer idTutorAziendale;
	
	// GET E SET
	public Integer getIdTirocinio() {
		return idTirocinio;
	}
	public void setIdTirocinio(Integer idTirocinio) {
		this.idTirocinio = idTirocinio;
	}
	public Integer getOrarioInizio() {
		return orarioInizio;
	}
	public void setOrarioInizio(Integer orarioInizio) {
		this.orarioInizio = orarioInizio;
	}
	public Integer getOrarioFine() {
		return orarioFine;
	}
	public void setOrarioFine(Integer orarioFine) {
		this.orarioFine = orarioFine;
	}
	public int getDurata() {
		return durata;
	}
	public void setDurata(int durata) {
		this.durata = durata;
	}
	public String getObiettivi() {
		return obiettivi;
	}
	public void setObiettivi(String obiettivi) {
		this.obiettivi = obiettivi;
	}
	public String getAttivitaSvolte() {
		return attivitaSvolte;
	}
	public void setAttivitaSvolte(String attivitaSvolte) {
		this.attivitaSvolte = attivitaSvolte;
	}
	public String getModalita() {
		return modalita;
	}
	public void setModalita(String modalita) {
		this.modalita = modalita;
	}
	public String getFacilitazioni() {
		return facilitazioni;
	}
	public void setFacilitazioni(String facilitazioni) {
		this.facilitazioni = facilitazioni;
	}
	public int getCfu() {
		return cfu;
	}
	public void setCfu(int cfu) {
		this.cfu = cfu;
	}
	public boolean isEsito() {
		return esito;
	}
	public void setEsito(boolean esito) {
		this.esito = esito;
	}
	public Integer getIdAzienda() {
		return idAzienda;
	}
	public void setIdAzienda(Integer idAzienda) {
		this.idAzienda = idAzienda;
	}
	public Integer getIdStudente() {
		return idStudente;
	}
	public void setIdStudente(Integer idStudente) {
		this.idStudente = idStudente;
	}
	public Integer getIdTutorAziendale() {
		return idTutorAziendale;
	}
	public void setIdTutorAziendale(Integer idTutorAziendale) {
		this.idTutorAziendale = idTutorAziendale;
	}
	
	
	

}

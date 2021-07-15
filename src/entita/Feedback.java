package entita;

public class Feedback {
	
	private int idFeedback;
	private String dettagli;
	private int rating;
	private int idStudente;
	private int idTirocinio;
	
	
	public String getDettagli() {
		return dettagli;
	}
	public void setDettagli(String dettagli) {
		this.dettagli = dettagli;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public int getIdStudente() {
		return idStudente;
	}
	public void setIdStudente(int idStudente) {
		this.idStudente = idStudente;
	}
	public int getIdTirocinio() {
		return idTirocinio;
	}
	public void setIdTirocinio(int idTirocinio) {
		this.idTirocinio = idTirocinio;
	}
	public int getIdFeedback() {
		return idFeedback;
	}
	public void setIdFeedback(int idFeedback) {
		this.idFeedback = idFeedback;
	}

}

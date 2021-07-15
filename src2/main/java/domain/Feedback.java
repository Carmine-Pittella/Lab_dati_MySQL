package domain;

public class Feedback {

	private Integer idFeedback;
	private String dettagli;
	private int rating;
	private Integer idStudente;
	private Integer idTirocinio;

	// GET E SET
	public Integer getIdFeedback() {
		return idFeedback;
	}

	public void setIdFeedback(Integer idFeedback) {
		this.idFeedback = idFeedback;
	}

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

	public Integer getIdStudente() {
		return idStudente;
	}

	public void setIdStudente(Integer idStudente) {
		this.idStudente = idStudente;
	}

	public Integer getIdTirocinio() {
		return idTirocinio;
	}

	public void setIdTirocinio(Integer idTirocinio) {
		this.idTirocinio = idTirocinio;
	}

}

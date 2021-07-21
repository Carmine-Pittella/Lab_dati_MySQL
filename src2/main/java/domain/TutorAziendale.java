package domain;

public class TutorAziendale extends Utente {
	
	private Integer IdTutorAziendale;
	private Integer idUtente;

	public Integer getIdTutorAziendale() {
		return IdTutorAziendale;
	}

	public void setIdTutorAziendale(Integer idTutorAziendale) {
		IdTutorAziendale = idTutorAziendale;
	}

	public Integer getIdUtente() {
		return idUtente;
	}

	public void setIdUtente(Integer idUtente) {
		this.idUtente = idUtente;
	}

}

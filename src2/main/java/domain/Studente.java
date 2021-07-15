package domain;

public class Studente extends Utente{
	
	private Integer matricola;
	private String corsoDiLaurea;
	private boolean handicap;
	private Integer idAnagrafica;
	private Integer idTutorUni;
	
	
	public int getMatricola() {
		return matricola;
	}
	public void setMatricola(int matricola) {
		this.matricola = matricola;
	}
	public String getCorsoDiLaurea() {
		return corsoDiLaurea;
	}
	public void setCorsoDiLaurea(String corsoDiLaurea) {
		this.corsoDiLaurea = corsoDiLaurea;
	}
	public boolean isHandicap() {
		return handicap;
	}
	public void setHandicap(boolean handicap) {
		this.handicap = handicap;
	}
	public int getIdAnagrafica() {
		return idAnagrafica;
	}
	public void setIdAnagrafica(int idAnagrafica) {
		this.idAnagrafica = idAnagrafica;
	}
	public int getIdTutorUni() {
		return idTutorUni;
	}
	public void setIdTutorUni(int idTutorUni) {
		this.idTutorUni = idTutorUni;
	}
	
	

}

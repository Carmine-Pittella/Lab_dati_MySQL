package domain;

import java.sql.Date;
import java.time.LocalDate;

public class Studente extends Utente{
	
	private Integer IdStudente;
	private Integer matricola;
	private String corsoDiLaurea;
	private boolean handicap;
	private Integer idTutorUni;
	private String codiceFiscale;
	private LocalDate dataNascita;
	private String luogoNascita;
	private String residenza;
	private Integer idUtente;
	
	
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
	
	public int getIdTutorUni() {
		return idTutorUni;
	}
	public void setIdTutorUni(int idTutorUni) {
		this.idTutorUni = idTutorUni;
	}
	public Integer getIdStudente() {
		return IdStudente;
	}
	public void setIdStudente(Integer idStudente) {
		IdStudente = idStudente;
	}
	public String getCodiceFiscale() {
		return codiceFiscale;
	}
	public void setCodiceFiscale(String codiceFiscale) {
		this.codiceFiscale = codiceFiscale;
	}
	
	public String getLuogoNascita() {
		return luogoNascita;
	}
	public void setLuogoNascita(String luogoNascita) {
		this.luogoNascita = luogoNascita;
	}
	public String getResidenza() {
		return residenza;
	}
	public void setResidenza(String residenza) {
		this.residenza = residenza;
	}
	public void setMatricola(Integer matricola) {
		this.matricola = matricola;
	}
	public void setIdTutorUni(Integer idTutorUni) {
		this.idTutorUni = idTutorUni;
	}
	public Date getDataNascita() {
		return java.sql.Date.valueOf(dataNascita);
	}
	public void setDataNascita(LocalDate dataNascita) {
		this.dataNascita = dataNascita;
	}
	public Integer getIdUtente() {
		return idUtente;
	}
	public void setIdUtente(Integer idUtente) {
		this.idUtente = idUtente;
	}
	
	

}

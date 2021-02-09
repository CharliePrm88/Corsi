package dto;

import java.io.Serializable;

public class IstruttoreDto implements Serializable{
	private static final long serialVersionUID = 1L;
	private int matricola;
	private String nome,cognome,codiceFiscale;
	public IstruttoreDto(int matricola, String nome, String cognome, String codiceFiscale) {
		super();
		this.matricola = matricola;
		this.nome = nome;
		this.cognome = cognome;
		this.codiceFiscale = codiceFiscale;
	}
	public int getMatricola() {
		return matricola;
	}
	public void setMatricola(int matricola) {
		this.matricola = matricola;
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
	public String getCodiceFiscale() {
		return codiceFiscale;
	}
	public void setCodiceFiscale(String codiceFiscale) {
		this.codiceFiscale = codiceFiscale;
	}
}

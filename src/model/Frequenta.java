package model;

public class Frequenta {
	private int id,idCorso,idDipendente,idIstruttore;

	public Frequenta(int id, int idCorso, int idDipendente, int idIstruttore) {
		super();
		this.id = id;
		this.idCorso = idCorso;
		this.idDipendente = idDipendente;
		this.idIstruttore = idIstruttore;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdCorso() {
		return idCorso;
	}

	public void setIdCorso(int idCorso) {
		this.idCorso = idCorso;
	}

	public int getIdDipendente() {
		return idDipendente;
	}

	public void setIdDipendente(int idDipendente) {
		this.idDipendente = idDipendente;
	}

	public int getIdIstruttore() {
		return idIstruttore;
	}

	public void setIdIstruttore(int idIstruttore) {
		this.idIstruttore = idIstruttore;
	}

}

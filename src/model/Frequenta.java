package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the frequenta database table.
 * 
 */
@Entity
@NamedQuery(name="Frequenta.findAll", query="SELECT f FROM Frequenta f")
public class Frequenta implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private int idDipendente;

	//bi-directional many-to-one association to Corsi
	@ManyToOne
	@JoinColumn(name="idCorso")
	private Corsi corsi;

	//bi-directional many-to-one association to Istruttore
	@ManyToOne
	@JoinColumn(name="idIstruttore")
	private Istruttore istruttore;

	public Frequenta() {
	}

	public Frequenta(int id, int idDipendente, Corsi corsi, Istruttore istruttore) {
		super();
		this.id = id;
		this.idDipendente = idDipendente;
		this.corsi = corsi;
		this.istruttore = istruttore;
	}



	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdDipendente() {
		return this.idDipendente;
	}

	public void setIdDipendente(int idDipendente) {
		this.idDipendente = idDipendente;
	}

	public Corsi getCorsi() {
		return this.corsi;
	}

	public void setCorsi(Corsi corsi) {
		this.corsi = corsi;
	}

	public Istruttore getIstruttore() {
		return this.istruttore;
	}

	public void setIstruttore(Istruttore istruttore) {
		this.istruttore = istruttore;
	}

}
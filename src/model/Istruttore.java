package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the istruttore database table.
 * 
 */
@Entity
@NamedQuery(name="Istruttore.findAll", query="SELECT i FROM Istruttore i")
public class Istruttore implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int matricola;

	private String codicefiscale;

	private String cognome;

	private String nome;

	//bi-directional many-to-one association to Frequenta
	@OneToMany(mappedBy="istruttore")
	private List<Frequenta> frequentas;

	public Istruttore() {
	}
	
	public Istruttore(int matricola, String nome, String cognome, String codicefiscale) {
		super();
		this.matricola = matricola;
		this.codicefiscale = codicefiscale;
		this.cognome = cognome;
		this.nome = nome;
	}



	public int getMatricola() {
		return this.matricola;
	}

	public void setMatricola(int matricola) {
		this.matricola = matricola;
	}

	public String getCodicefiscale() {
		return this.codicefiscale;
	}

	public void setCodicefiscale(String codicefiscale) {
		this.codicefiscale = codicefiscale;
	}

	public String getCognome() {
		return this.cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Frequenta> getFrequentas() {
		return this.frequentas;
	}

	public void setFrequentas(List<Frequenta> frequentas) {
		this.frequentas = frequentas;
	}

	public Frequenta addFrequenta(Frequenta frequenta) {
		getFrequentas().add(frequenta);
		frequenta.setIstruttore(this);

		return frequenta;
	}

	public Frequenta removeFrequenta(Frequenta frequenta) {
		getFrequentas().remove(frequenta);
		frequenta.setIstruttore(null);

		return frequenta;
	}

}
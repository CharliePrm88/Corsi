package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the corsi database table.
 * 
 */
@Entity
@NamedQuery(name="Corsi.findAll", query="SELECT c FROM Corsi c")
public class Corsi implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	@Temporal(TemporalType.DATE)
	@Column(name="data_fine")
	private Date dataFine;

	@Temporal(TemporalType.DATE)
	@Column(name="data_inizio")
	private Date dataInizio;

	private String nome;

	//bi-directional many-to-one association to Frequenta
	@OneToMany(mappedBy="corsi")
	private List<Frequenta> frequentas;

	public Corsi() {
	}

	public Corsi(int id, String nome, Date dataInizio, Date dataFine) {
		super();
		this.id = id;
		this.dataFine = dataFine;
		this.dataInizio = dataInizio;
		this.nome = nome;
	}



	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDataFine() {
		return this.dataFine;
	}

	public void setDataFine(Date dataFine) {
		this.dataFine = dataFine;
	}

	public Date getDataInizio() {
		return this.dataInizio;
	}

	public void setDataInizio(Date dataInizio) {
		this.dataInizio = dataInizio;
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
		frequenta.setCorsi(this);

		return frequenta;
	}

	public Frequenta removeFrequenta(Frequenta frequenta) {
		getFrequentas().remove(frequenta);
		frequenta.setCorsi(null);

		return frequenta;
	}

}
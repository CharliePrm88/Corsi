package dto;

import java.io.Serializable;
import java.util.Date;

public class CorsiDto implements Serializable {

	private static final long serialVersionUID = 1L;
	private int id;
	private String nome;
	private java.util.Date data_inizio, data_fine;
	public CorsiDto(int id, String nome, Date data_inizio, Date data_fine) {
		super();
		this.id = id;
		this.nome = nome;
		this.data_inizio = data_inizio;
		this.data_fine = data_fine;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public java.util.Date getData_inizio() {
		return data_inizio;
	}
	public void setData_inizio(java.util.Date data_inizio) {
		this.data_inizio = data_inizio;
	}
	public java.util.Date getData_fine() {
		return data_fine;
	}
	public void setData_fine(java.util.Date data_fine) {
		this.data_fine = data_fine;
	}
}

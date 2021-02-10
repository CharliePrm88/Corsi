package model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Corsi{
@Id
private int id;
private String nome;
private java.sql.Date data_inizio, data_fine;
public Corsi(int id, String nome, Date data_inizio, Date data_fine) {
	super();
	this.id = id;
	this.nome = nome;
	this.data_inizio = data_inizio;
	this.data_fine = data_fine;
}

public Corsi() {}
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
public java.sql.Date getData_inizio() {
	return data_inizio;
}
public void setData_inizio(java.sql.Date data_inizio) {
	this.data_inizio = data_inizio;
}
public java.sql.Date getData_fine() {
	return data_fine;
}
public void setData_fine(java.sql.Date data_fine) {
	this.data_fine = data_fine;
}



}

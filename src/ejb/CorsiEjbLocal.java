package ejb;

import java.util.List;

import javax.ejb.Local;

import model.Corsi;

@Local
public interface CorsiEjbLocal {
	public void inserisciCorsi(Corsi c);
	public void aggiornaCorsi(Corsi c);
	public void cancellaCorsi(Corsi c);
	public Corsi ritornaCorsi(int id);
	public List<Corsi> ritornaListaCorsi();

}

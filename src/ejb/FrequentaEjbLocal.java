package ejb;

import java.util.List;

import javax.ejb.Local;

import model.Frequenta;

@Local
public interface FrequentaEjbLocal {
	public void inserisciFrequenta(Frequenta f);
	public void cancellaFrequenta(Frequenta f);
	public void aggiornaFrequenta(Frequenta f);
	public Frequenta ritornaFrequenta(int id);
	public List<Frequenta> ritornaListaFrequenta();
}

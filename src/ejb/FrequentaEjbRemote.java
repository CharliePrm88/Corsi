package ejb;

import java.util.List;

import javax.ejb.Remote;

import model.Frequenta;

@Remote
public interface FrequentaEjbRemote {
	public void inserisciFrequenta(Frequenta f);
	public void cancellaFrequenta(Frequenta f);
	public void aggiornaFrequenta(Frequenta f);
	public Frequenta ritornaFrequenta(int id);
	public List<Frequenta> ritornaListaFrequenta();
}

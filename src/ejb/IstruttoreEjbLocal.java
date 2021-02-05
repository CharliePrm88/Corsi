package ejb;

import java.util.List;

import javax.ejb.Local;

import model.Istruttore;

@Local
public interface IstruttoreEjbLocal {
	
	public void inserisciIstruttore(Istruttore i);
	public void cancellaIstruttore(Istruttore i);
	public void aggiornaIstruttore(Istruttore i);
	public Istruttore ritornaIstruttore(int id);
	public List<Istruttore> ritornaListaIstruttore();

}

package ejb;

import java.util.List;

import javax.ejb.Local;

import dto.IstruttoreDto;


@Local
public interface IstruttoreEjbLocal {
	
	public void inserisciIstruttore(IstruttoreDto i);
	public void cancellaIstruttore(IstruttoreDto i);
	public void aggiornaIstruttore(IstruttoreDto i);
	public IstruttoreDto ritornaIstruttore(int id);
	public List<IstruttoreDto> ritornaListaIstruttore();

}

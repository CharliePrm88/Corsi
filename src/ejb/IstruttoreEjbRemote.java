package ejb;

import java.util.List;

import javax.ejb.Remote;
import dto.IstruttoreDto;

@Remote
public interface IstruttoreEjbRemote {
	public void inserisciIstruttore(IstruttoreDto i);
	public void cancellaIstruttore(IstruttoreDto i);
	public void aggiornaIstruttore(IstruttoreDto i);
	public IstruttoreDto ritornaIstruttore(int id);
	public List<IstruttoreDto> ritornaListaIstruttore();
}

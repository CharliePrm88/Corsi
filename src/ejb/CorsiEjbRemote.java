package ejb;

import java.util.List;

import javax.ejb.Remote;

import dto.CorsiDto;

@Remote
public interface CorsiEjbRemote {
	public void inserisciCorsi(CorsiDto c);
	public void aggiornaCorsi(CorsiDto c);
	public void cancellaCorsi(CorsiDto c);
	public CorsiDto ritornaCorsi(int id);
	public List<CorsiDto> ritornaListaCorsi();
}

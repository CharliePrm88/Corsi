package ejb;

import java.util.List;

import javax.ejb.Local;

import dto.CorsiDto;

@Local
public interface CorsiEjbLocal {
	public void inserisciCorsi(CorsiDto c);
	public void aggiornaCorsi(CorsiDto c);
	public void cancellaCorsi(CorsiDto c);
	public CorsiDto ritornaCorsi(int id);
	public List<CorsiDto> ritornaListaCorsi();

}

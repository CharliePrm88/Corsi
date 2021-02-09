package ejb;

import java.util.List;

import javax.ejb.Remote;

import dto.FrequentaDto;

@Remote
public interface FrequentaEjbRemote {
	public void inserisciFrequenta(FrequentaDto f);
	public void cancellaFrequenta(FrequentaDto f);
	public void aggiornaFrequenta(FrequentaDto f);
	public FrequentaDto ritornaFrequenta(int id);
	public List<FrequentaDto> ritornaListaFrequenta();
}

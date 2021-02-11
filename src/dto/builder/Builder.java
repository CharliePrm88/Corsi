package dto.builder;
import model.Istruttore;
import model.Corsi;
import model.Frequenta;
import dto.CorsiDto;
import dto.FrequentaDto;
import dto.IstruttoreDto;

public class Builder {
	
	public static Istruttore DtoToIstruttore(IstruttoreDto id) {
		Istruttore i = new Istruttore(id.getMatricola(),id.getNome(),id.getCognome(),id.getCodiceFiscale());
		return i;
	}
	
	public static IstruttoreDto IstruttoreToDto(Istruttore i) {
		IstruttoreDto id = new IstruttoreDto(i.getMatricola(),i.getNome(),i.getCognome(), i.getCodicefiscale());
		return id;
	}
	
	public static Corsi DtoToCorsi(CorsiDto cd) {
		Corsi c = new Corsi(cd.getId(),cd.getNome(),cd.getData_inizio(),cd.getData_fine());
		return c;
	}

	public static CorsiDto CorsiToDto(Corsi c) {
		CorsiDto cd = new CorsiDto(c.getId(),c.getNome(),c.getDataInizio(),c.getDataFine());
		return cd;
	}
	
	public static Frequenta DtoToFrequenta(FrequentaDto fd) {
		Corsi c = new Corsi(fd.getId(),null,null,null);
		Istruttore i = new Istruttore(fd.getIdIstruttore(),null,null,null);
		Frequenta f = new Frequenta(fd.getId(),fd.getIdDipendente(),c,i);
		return f;
	}
	public static FrequentaDto FrequentaToDto(Frequenta f) {
		FrequentaDto fd = new FrequentaDto(f.getId(),f.getCorsi().getId(),f.getIdDipendente(),f.getIstruttore().getMatricola());
		return fd;
	}
}

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
		IstruttoreDto id = new IstruttoreDto(i.getMatricola(),i.getNome(),i.getCognome(),i.getCodiceFiscale());
		return id;
	}
	
	public static Corsi DtoToCorsi(CorsiDto cd) {
		Corsi c = new Corsi(cd.getId(),cd.getNome(),cd.getData_inizio(),cd.getData_fine());
		return c;
	}

	public static CorsiDto CorsiToDto(Corsi c) {
		CorsiDto cd = new CorsiDto(c.getId(),c.getNome(),c.getData_inizio(),c.getData_fine());
		return cd;
	}
	
	public static Frequenta DtoToFrequenta(FrequentaDto fd) {
		Frequenta f = new Frequenta(fd.getId(),fd.getIdCorso(),fd.getIdDipendente(),fd.getIdIstruttore());
		return f;
	}
	public static FrequentaDto FrequentaToDto(Frequenta f) {
		FrequentaDto fd = new FrequentaDto(f.getId(),f.getIdCorso(),f.getIdDipendente(),f.getIdIstruttore());
		return fd;
	}
}

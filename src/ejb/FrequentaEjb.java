package ejb;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import dao.FrequentaDao;
import model.Frequenta;
import dto.FrequentaDto;
import dto.builder.Builder;
/**
 * Session Bean implementation class FrequentaEjb
 */
@Stateless
@LocalBean
public class FrequentaEjb implements FrequentaEjbRemote, FrequentaEjbLocal {
FrequentaDao fd = new FrequentaDao();
    /**
     * Default constructor. 
     */
    public FrequentaEjb() {
        // TODO Auto-generated constructor stub
    }

    public void inserisciFrequenta(FrequentaDto f) {
    	Frequenta fdt = Builder.DtoToFrequenta(f);
    	fd.inserisciFrequenta(fdt);
    }
    public void cancellaFrequenta(FrequentaDto f) {
    	Frequenta fdt = Builder.DtoToFrequenta(f);
    	fd.cancellaFrequenta(fdt);
    }
    public void aggiornaFrequenta(FrequentaDto f) {
    	Frequenta fdt = Builder.DtoToFrequenta(f);
    	fd.aggiornaFrequenta(fdt);
    }
    public FrequentaDto ritornaFrequenta(int id) {
    	return Builder.FrequentaToDto(fd.ritornaFrequenta(id));
    }
    public List<FrequentaDto> ritornaListaFrequenta(){
    	List<Frequenta> l1 = fd.ritornaListaFrequenta();
    	List<FrequentaDto> cd = new ArrayList<FrequentaDto>();
    	for(Frequenta l : l1) {
    		cd.add(Builder.FrequentaToDto(l));
    	}
    	return cd;
    }
    
    
}

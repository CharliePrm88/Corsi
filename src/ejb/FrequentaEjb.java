package ejb;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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

     
@PersistenceContext(unitName="Hib4PU")
private EntityManager em;

    public FrequentaEjb() {
        // TODO Auto-generated constructor stub
    }

    public void inserisciFrequenta(FrequentaDto f) {
    	FrequentaDao fd = new FrequentaDao(em);
    	Frequenta fdt = Builder.DtoToFrequenta(f);
    	fd.inserisciFrequenta(fdt);
    }
    public void cancellaFrequenta(FrequentaDto f) {
    	FrequentaDao fd = new FrequentaDao(em);
    	Frequenta fdt = Builder.DtoToFrequenta(f);
    	fd.cancellaFrequenta(fdt);
    }
    public void aggiornaFrequenta(FrequentaDto f) {
    	FrequentaDao fd = new FrequentaDao(em);
    	Frequenta fdt = Builder.DtoToFrequenta(f);
    	fd.aggiornaFrequenta(fdt);
    }
    public FrequentaDto ritornaFrequenta(int id) {
    	FrequentaDao fd = new FrequentaDao(em);
    	return Builder.FrequentaToDto(fd.ritornaFrequenta(id));
    }
    public List<FrequentaDto> ritornaListaFrequenta(){
    	FrequentaDao fd = new FrequentaDao(em);
    	List<Frequenta> l1 = fd.ritornaListaFrequenta();
    	List<FrequentaDto> cd = new ArrayList<FrequentaDto>();
    	for(Frequenta l : l1) {
    		cd.add(Builder.FrequentaToDto(l));
    	}
    	return cd;
    }
    
    
}

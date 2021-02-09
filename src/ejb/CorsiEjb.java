package ejb;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import dao.CorsiDao;
import model.Corsi;
import dto.CorsiDto;
import dto.builder.Builder;
/**
 * Session Bean implementation class CorsiEjb
 */

//	java:jboss/exported/Corsi/IstruttoreEjb!ejb.IstruttoreEjbRemote


@Stateless
@LocalBean
public class CorsiEjb implements CorsiEjbRemote, CorsiEjbLocal {
CorsiDao cd = new CorsiDao();
    /**
     * Default constructor. 
     */
    public CorsiEjb() {
        // TODO Auto-generated constructor stub
    }
    
    public void inserisciCorsi(CorsiDto c) {
    	Corsi c1 = Builder.DtoToCorsi(c);
    	cd.inserisciCorsi(c1);
    }
    
    public void aggiornaCorsi(CorsiDto c) {
    	Corsi c1 = Builder.DtoToCorsi(c);
    	cd.aggiornaCorsi(c1);
    }
    public void cancellaCorsi(CorsiDto c) {
    	Corsi c1 = Builder.DtoToCorsi(c);
    	cd.cancellaCorsi(c1);
    }
    public CorsiDto ritornaCorsi(int id) {
    	Corsi c = cd.ritornaCorsi(id);
    	CorsiDto cd = Builder.CorsiToDto(c);
    	return cd;
    }
    
    public List<CorsiDto> ritornaListaCorsi(){
    	List<Corsi> l1 = cd.ritornaListaCorsi();
    	List<CorsiDto> cd = new ArrayList<CorsiDto>();
    	for(Corsi l : l1) {
    		cd.add(Builder.CorsiToDto(l));
    	}
    	return cd;
    }

}

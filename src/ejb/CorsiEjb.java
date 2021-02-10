package ejb;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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
	
	@PersistenceContext(unitName="Hib4PU")
	private EntityManager em;
    
	/**
     * Default constructor. 
     */
    public CorsiEjb() {
        // TODO Auto-generated constructor stub
    }
    
    public void inserisciCorsi(CorsiDto c) {
    	CorsiDao cd = new CorsiDao(em);
    	Corsi c1 = Builder.DtoToCorsi(c);
    	cd.inserisciCorsi(c1);
    }
    
    public void aggiornaCorsi(CorsiDto c) {
    	CorsiDao cd = new CorsiDao(em);
    	Corsi c1 = Builder.DtoToCorsi(c);
    	cd.aggiornaCorsi(c1);
    }
    public void cancellaCorsi(CorsiDto c) {
    	CorsiDao cd = new CorsiDao(em);
    	Corsi c1 = Builder.DtoToCorsi(c);
    	cd.cancellaCorsi(c1);
    }
    public CorsiDto ritornaCorsi(int id) {
    	CorsiDao cd = new CorsiDao(em);
    	Corsi c = cd.ritornaCorsi(id);
    	CorsiDto cdt = Builder.CorsiToDto(c);
    	return cdt;
    }
    
    public List<CorsiDto> ritornaListaCorsi(){
    	CorsiDao cd = new CorsiDao(em);
    	List<Corsi> l1 = cd.ritornaListaCorsi();
    	List<CorsiDto> cdt = new ArrayList<CorsiDto>();
    	for(Corsi l : l1) {
    		cdt.add(Builder.CorsiToDto(l));
    	}
    	return cdt;
    }

}

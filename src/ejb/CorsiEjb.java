package ejb;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import dao.CorsiDao;
import model.Corsi;
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
    
    public void inserisciCorsi(Corsi c) {
    	cd.inserisciCorsi(c);
    }
    
    public void aggiornaCorsi(Corsi c) {
    	cd.aggiornaCorsi(c);
    }
    public void cancellaCorsi(Corsi c) {
    	cd.cancellaCorsi(c);
    }
    public Corsi ritornaCorsi(int id) {
    	return cd.ritornaCorsi(id);
    }
    
    public List<Corsi> ritornaListaCorsi(){
    	return cd.ritornaListaCorsi();
    }

}

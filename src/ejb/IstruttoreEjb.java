package ejb;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import model.Istruttore;
import dao.IstruttoreDao;
/**
 * Session Bean implementation class IstruttoreEjb
 */
//	java:jboss/exported/Corsi/IstruttoreEjb!ejb.IstruttoreEjbRemote
@Stateless
@LocalBean
public class IstruttoreEjb implements IstruttoreEjbRemote, IstruttoreEjbLocal {
IstruttoreDao iD = new IstruttoreDao();
    /**
     * Default constructor. 
     */
    public IstruttoreEjb() {
        // TODO Auto-generated constructor stub
    }
    
    public void inserisciIstruttore(Istruttore i) {
    	iD.inserisciIstruttore(i);
    }
    
    public void cancellaIstruttore(Istruttore i) {
    	iD.cancellaIstruttore(i);
    }
    public void aggiornaIstruttore(Istruttore i) {
    	iD.aggiornaIstruttore(i);
    }
    public Istruttore ritornaIstruttore(int id) {
    	return iD.ritornaIstruttore(id);    } 
    
    public List<Istruttore> ritornaListaIstruttore(){
    	return iD.ritornaListaIstruttore();
    }

}

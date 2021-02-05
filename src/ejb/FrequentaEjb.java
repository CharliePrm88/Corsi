package ejb;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import dao.FrequentaDao;
import model.Frequenta;
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

    public void inserisciFrequenta(Frequenta f) {
    	fd.inserisciFrequenta(f);
    }
    public void cancellaFrequenta(Frequenta f) {
    	fd.cancellaFrequenta(f);
    }
    public void aggiornaFrequenta(Frequenta f) {
    	fd.aggiornaFrequenta(f);
    }
    public Frequenta ritornaFrequenta(int id) {
    	return fd.ritornaFrequenta(id);
    }
    public List<Frequenta> ritornaListaFrequenta(){
    	return fd.ritornaListaFrequenta();
    }
    
    
}

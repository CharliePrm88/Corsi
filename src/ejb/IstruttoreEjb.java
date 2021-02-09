package ejb;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import model.Istruttore;
import dto.IstruttoreDto;
import dto.builder.Builder;
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
    
    public void inserisciIstruttore(IstruttoreDto i) {
    	Istruttore ist = Builder.DtoToIstruttore(i);
    	iD.inserisciIstruttore(ist);
    }
    
    public void cancellaIstruttore(IstruttoreDto i) {
    	Istruttore ist = Builder.DtoToIstruttore(i);
    	iD.cancellaIstruttore(ist);
    }
    public void aggiornaIstruttore(IstruttoreDto i) {
    	Istruttore ist = Builder.DtoToIstruttore(i);
    	iD.aggiornaIstruttore(ist);
    }
    public IstruttoreDto ritornaIstruttore(int id) {
    	IstruttoreDto ist = Builder.IstruttoreToDto(iD.ritornaIstruttore(id));
    	return ist;
    	} 
    
    public List<IstruttoreDto> ritornaListaIstruttore(){
    	List<Istruttore> l1 = iD.ritornaListaIstruttore();
    	List<IstruttoreDto> cd = new ArrayList<IstruttoreDto>();
    	for(Istruttore l : l1) {
    		cd.add(Builder.IstruttoreToDto(l));
    	}
    	return cd;
    }

}

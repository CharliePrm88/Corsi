package dao;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import model.Frequenta;


//	java:jboss/exported/Corsi/FrequentaEjb!ejb.FrequentaEjbRemote

public class FrequentaDao {
	EntityManager em;
	
	public FrequentaDao(EntityManager em) {
		this.em=em;
	}
	public void inserisciFrequenta(Frequenta f) {
		em.persist(f);
	}
	
	public List<Frequenta> ritornaListaFrequenta() {
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<Frequenta> cq = builder.createQuery(Frequenta.class);
		Root<Frequenta> root = cq.from(Frequenta.class);
		cq.select(root);
		return em.createQuery(cq).getResultList();
	}
	
	public Frequenta ritornaFrequenta(int id) {
		Frequenta res = em.find(Frequenta.class, id);
		return res;
	}

	public void aggiornaFrequenta(Frequenta f) {
		em.merge(f);
	}

	public void cancellaFrequenta(Frequenta f) {
		Frequenta rimuovi = em.getReference(Frequenta.class, f.getId());
		em.remove(rimuovi);
	}
}

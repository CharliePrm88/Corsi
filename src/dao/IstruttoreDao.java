package dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import model.Istruttore;

public class IstruttoreDao {
	EntityManager em;
	public IstruttoreDao(EntityManager em) {
		this.em = em;
	}
	
	public void inserisciIstruttore(Istruttore i) {
		em.persist(i);
	}
	
	public List<Istruttore> ritornaListaIstruttore() {
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<Istruttore> cq = builder.createQuery(Istruttore.class);
		Root<Istruttore> root = cq.from(Istruttore.class);
		cq.select(root);
		return em.createQuery(cq).getResultList();
	}
	
	public Istruttore ritornaIstruttore(int id) {
		Istruttore res = em.find(Istruttore.class, id);
		return res;
	}

	public void aggiornaIstruttore(Istruttore i) {
		em.merge(i);
	}

	public void cancellaIstruttore(Istruttore i) {
		Istruttore rimuovi = em.getReference(Istruttore.class, i.getMatricola());
		em.remove(rimuovi);
		
	}
}

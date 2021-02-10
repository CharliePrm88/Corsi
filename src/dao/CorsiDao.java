package dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import model.Corsi;

public class CorsiDao {
	
	private EntityManager em;
	
	public CorsiDao(EntityManager em) {
		this.em = em;
	}

	public void inserisciCorsi(Corsi c) {
		em.persist(c);
	}
	
	public List<Corsi> ritornaListaCorsi() {
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<Corsi> cq = builder.createQuery(Corsi.class);
		Root<Corsi> root = cq.from(Corsi.class);
		cq.select(root);
		return em.createQuery(cq).getResultList();
	}
	
	public Corsi ritornaCorsi(int id) {
		Corsi res = em.find(Corsi.class, id);
		return res;
	}

	public void aggiornaCorsi(Corsi c) {
		em.merge(c);
	}

	public void cancellaCorsi(Corsi c) {
		Corsi rimuovi = em.getReference(Corsi.class, c.getId());
		em.remove(rimuovi);
	}

}

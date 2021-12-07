package api.dao.implementation;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import api.dao.DiagnosticoDAO;
import entities.Diagnostico;

@Repository
@Transactional
public class DiagnosticoApp implements DiagnosticoDAO {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public void save(Diagnostico entity) {
		em.persist(entity);
	}

	@Override
	public void update(Diagnostico entity) {
		em.merge(entity);
	}
	
}

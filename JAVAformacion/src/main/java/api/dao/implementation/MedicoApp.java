package api.dao.implementation;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import api.dao.MedicoDAO;
import entities.Medico;

@Repository
@Transactional
@SuppressWarnings("unchecked")
public class MedicoApp implements MedicoDAO {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public Optional<Medico> findByID(String id) {
		return em.createQuery("SELECT m FROM MEDICO m WHERE m._usuario = :id").setParameter("id", id).getResultList().stream().findFirst();
	}

	@Override
	public Optional<Medico> findByNC(String id) {
		return em.createQuery("SELECT m FROM MEDICO m WHERE m._numColegiado = :id").setParameter("id", id).getResultList().stream().findFirst();
	}

	@Override
	public List<Medico> findAllByName(String name) {
		return (List<Medico>) em.createQuery("SELECT m FROM MEDICO m WHERE m._nombre || ' ' || m._apellidos LIKE :name").setParameter("name", '%'+name+'%').getResultList();
	}

	@Override
	public List<Medico> findAllByFirstName(String firstname) {
		return (List<Medico>) em.createQuery("SELECT m FROM MEDICO m WHERE m._nombre LIKE :name").setParameter("name", '%'+firstname+'%').getResultList();
	}

	@Override
	public List<Medico> findAllByLastName(String lastname) {
		return (List<Medico>) em.createQuery("SELECT m FROM MEDICO m WHERE m._apellido LIKE :name").setParameter("name", '%'+lastname+'%').getResultList();
	}

	@Override
	public List<Medico> findAll() {
		return (List<Medico>) em.createQuery("SELECT m FROM MEDICO m").getResultList();
	}

	@Override
	public void deleteByID(String id) {
		em.createQuery("DELETE FROM MEDICO m WHERE m._usuario = :id").setParameter("id", id).executeUpdate();
	}

	@Override
	public void deleteAllByID(List<String> ids) {
		em.createQuery("DELETE FROM MEDICO m WHERE m._usuario = :id").setParameter("id", ids).executeUpdate();
	}

	@Override
	public void deleteAllByName(String name) {
		em.createQuery("DELETE FROM MEDICO m WHERE m._nombre || ' ' || m._apellidos LIKE :name").setParameter("name", name).executeUpdate();
	}

	@Override
	public void save(Medico entity) {
		em.persist(entity);
	}

	@Override
	public void saveAll(List<Medico> entities) {
		entities.stream().forEach(m -> em.persist(m));
		
	}

	@Override
	public void update(Medico entity) {
		em.merge(entity);
	}

}

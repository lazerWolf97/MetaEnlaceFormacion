package api.dao.implementation;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import api.dao.PacienteDAO;
import entities.Paciente;

@Repository
@Transactional
@SuppressWarnings("unchecked")
public class PacienteApp implements PacienteDAO {

	@PersistenceContext
	private EntityManager em;

	@Override
	public Optional<Paciente> findByID(String id) {
		return em.createQuery("SELECT p FROM PACIENTE p WHERE p._usuario = :id").setParameter("id", id).getResultList().stream().findFirst();
	}

	@Override
	public Optional<Paciente> findByNSS(String id) {
		return em.createQuery("SELECT p FROM PACIENTE p WHERE p._NSS = :id").setParameter("id", id).getResultList().stream().findFirst();
	}

	@Override
	public List<Paciente> findAllByName(String name) {
		return (List<Paciente>) em.createQuery("SELECT p FROM PACIENTE p WHERE p._nombre || ' ' || p._apellidos LIKE :name").setParameter("name", '%'+name+'%').getResultList();
	}

	@Override
	public List<Paciente> findAllByFirstName(String firstname) {
		return (List<Paciente>) em.createQuery("SELECT p FROM PACIENTE p WHERE p._nombre LIKE :name").setParameter("name", '%'+firstname+'%').getResultList();
	}

	@Override
	public List<Paciente> findAllByLastName(String lastname) {
		return (List<Paciente>) em.createQuery("SELECT p FROM PACIENTE p WHERE p._apellidos LIKE :name").setParameter("name", '%'+lastname+'%').getResultList();
	}

	@Override
	public List<Paciente> findAll() {
		return (List<Paciente>) em.createQuery("FROM PACIENTE", Paciente.class).getResultList();
	}

	@Override
	public void deleteByID(String id) {
		em.createQuery("DELETE FROM PACIENTE p WHERE p._usuario = :id").setParameter("id", id).executeUpdate();
	}

	@Override
	public void deleteAllByID(List<String> ids) {
		em.createQuery("DELETE FROM PACIENTE p WHERE p._usuario = :id").setParameter("id", ids).executeUpdate();
	}

	@Override
	public void deleteAllByName(String name) {
		em.createQuery("DELETE FROM PACIENTE p WHERE p._nombre || ' ' || p._apellidos LIKE :name").setParameter("name", name).executeUpdate();
	}

	@Override
	public void save(Paciente entity) {
		em.persist(entity);
	}

	@Override
	public void saveAll(List<Paciente> entities) {
		for(Paciente p : entities) {
			em.persist(p);
		}
	}
	
	@Override
	public void update(Paciente entity) {
		em.merge(entity);
	}
		

}

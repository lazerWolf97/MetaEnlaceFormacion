package api.dao.implementation;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import api.dao.CitaDAO;
import entities.Cita;
import entities.enums.EstadoCita;

@Repository
@Transactional
@SuppressWarnings("unchecked")
public class CitaApp implements CitaDAO {
	
	@PersistenceContext
	private EntityManager em;
	
	@Override
	public List<Cita> findAll(){
		return em.createQuery("SELECT c FROM CITA c").getResultList();
	}

	@Override
	public List<Cita> findByPaciente(String ID) {
		return em.createQuery("SELECT c FROM CITA c WHERE c._paciente._usuario LIKE :id").setParameter("id", ID).getResultList();
	}

	@Override
	public List<Cita> findByMedico(String ID) {
		return em.createQuery("SELECT c FROM CITA c WHERE c._medico._usuario LIKE :id").setParameter("id", ID).getResultList();
	}

	@Override
	public void clean() {
		em.createQuery("DELETE FROM CITA c WHERE c.estado = :estado").setParameter("estado", EstadoCita.CANCELADA).executeUpdate();
		em.createQuery("DELETE FROM CITA c WHERE c.estado = :estado").setParameter("estado", EstadoCita.SINASISTENCIA).executeUpdate();
		em.createQuery("DELETE FROM CITA c WHERE c.estado = :estado").setParameter("estado", EstadoCita.CUMPLIDA).executeUpdate();
	}

	@Override
	public void save(Cita entity) {
		em.persist(entity);
	}

	@Override
	public void update(Cita entity) {
		em.merge(entity);
	}

}

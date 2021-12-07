package api.dao.implementation;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import api.dao.UsuarioDAO;
import entities.Usuario;

@Repository
@Transactional
@SuppressWarnings("unchecked")
public class UsuarioApp implements UsuarioDAO {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public List<Usuario> findAll() {
		return em.createQuery("FROM USUARIO").getResultList();
	}

	@Override
	public List<Usuario> findByName(String name) {
		return em.createQuery("SELECT u FROM USUARIO u WHERE u._nombre || ' ' || u._apellidos LIKE :name").setParameter("name", '%'+name+'%').getResultList();
	}

	@Override
	public Optional<Usuario> findByID(String ID) {
		return em.createQuery("SELECT u FROM USUARIO u WHERE u._usuario LIKE :id").setParameter("id", ID).getResultStream().findFirst();
	}

	@Override
	public void delete(String ID) {
		em.createQuery("DELETE u FROM USUARIO u WHERE u._usuario LIKE :id").setParameter("id", ID).executeUpdate();
	}

}

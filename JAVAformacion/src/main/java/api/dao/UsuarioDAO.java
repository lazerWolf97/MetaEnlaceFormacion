package api.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;
import entities.Usuario;

@Repository
public interface UsuarioDAO {
	List<Usuario> findAll();
	List<Usuario> findByName(String name);
	Optional<Usuario> findByID(String ID);
	void delete(String ID);
}

package api.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import entities.Medico;

@Repository
public interface MedicoDAO {
	public Optional<Medico> findByID(String id);
	public Optional<Medico> findByNC(String id);
	public List<Medico> findAllByName(String name);
	public List<Medico> findAllByFirstName(String firstname);
	public List<Medico> findAllByLastName(String lastname);
	public List<Medico> findAll();
	public void deleteByID(String id);
	public void deleteAllByID(List<String> ids);
	public void deleteAllByName(String name);
	public void save(Medico entity);
	public void saveAll(List<Medico> entities);
	public void update(Medico entity);
}

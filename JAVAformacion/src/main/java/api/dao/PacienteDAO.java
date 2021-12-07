package api.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import entities.Paciente;

@Repository
public interface PacienteDAO {
	public Optional<Paciente> findByID(String id);
	public Optional<Paciente> findByNSS(String id);
	public List<Paciente> findAllByName(String name);
	public List<Paciente> findAllByFirstName(String firstname);
	public List<Paciente> findAllByLastName(String lastname);
	public List<Paciente> findAll();
	public void deleteByID(String id);
	public void deleteAllByID(List<String> ids);
	public void deleteAllByName(String name);
	public void save(Paciente entity);
	public void saveAll(List<Paciente> entities);
	public void update(Paciente entity);
}

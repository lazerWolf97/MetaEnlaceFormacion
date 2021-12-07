package api.dao;

import java.util.List;

import entities.Cita;

public interface CitaDAO {
	public List<Cita> findAll();
	public List<Cita> findByPaciente(String ID);
	public List<Cita> findByMedico(String ID);
	public void save(Cita entity);
	public void update(Cita entity);
	public void clean();
}

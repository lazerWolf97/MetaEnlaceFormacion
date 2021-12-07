package api.service;

import java.util.List;

import api.dto.CitaGetDTO;
import api.dto.CitaPostDTO;

public interface CitaService {
	public List<CitaGetDTO> findAll();
	public List<CitaGetDTO> findByPaciente(String ID);
	public List<CitaGetDTO> findByMedico(String ID);
	public void save(CitaPostDTO entity);
	public void update(CitaPostDTO entity);
	public void clean();
}

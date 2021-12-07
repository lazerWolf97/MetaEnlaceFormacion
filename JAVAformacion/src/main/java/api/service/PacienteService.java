package api.service;

import java.util.List;

import api.dto.PacienteGetDTO;
import api.dto.PacientePostDTO;

public interface PacienteService {

	public List<PacienteGetDTO> findAll();
	public void addPaciente(PacientePostDTO p);
	public void updatePaciente(PacientePostDTO p);
	public void savePaciente(PacientePostDTO p);
	public PacienteGetDTO findByID(String pacienteID);
	public List<PacienteGetDTO> findByName(String pacienteNAME);
	public void deletePaciente(String pacienteID);
}

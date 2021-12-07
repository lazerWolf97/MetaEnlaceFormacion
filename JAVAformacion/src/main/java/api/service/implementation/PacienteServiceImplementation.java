package api.service.implementation;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import api.dao.PacienteDAO;
import api.dto.PacienteGetDTO;
import api.dto.PacientePostDTO;
import api.dto.mappers.MapStructMapper;
import api.service.PacienteService;
import entities.Paciente;

@Service
public class PacienteServiceImplementation implements PacienteService {

	@Autowired
	private PacienteDAO repository;
	
	@Autowired
	private MapStructMapper mapper;
	
	public List<PacienteGetDTO> findAll(){
		List<Paciente> lp = repository.findAll();
		List<PacienteGetDTO> lpdto = new ArrayList<PacienteGetDTO>();
		lp.stream().forEach(p -> lpdto.add(mapper.getDTO(p)));
		return lpdto;
	}
	
	public void addPaciente(PacientePostDTO p) {
		repository.save(mapper.getPaciente(p));
	}
	
	public void updatePaciente(PacientePostDTO p) {
		repository.update(mapper.getPaciente(p));
	}
	
	public void savePaciente(PacientePostDTO p){
		repository.save(mapper.getPaciente(p));
	}
	
	public PacienteGetDTO findByID(String pacienteID) {
		Optional<Paciente> p = repository.findByID(pacienteID);
		if(!p.isPresent()) {
			throw new RuntimeException("Error: Paciente con ID " + pacienteID + " no encontrado.");
		}
		return mapper.getDTO(p.get());
	}
	
	public List<PacienteGetDTO> findByName(String pacienteNAME) {
		List<Paciente> lp = repository.findAllByName(pacienteNAME);
		List<PacienteGetDTO> lpdto = new ArrayList<PacienteGetDTO>();
		lp.stream().forEach(p -> lpdto.add(mapper.getDTO(p)));
		return lpdto;
	}
	
	public void deletePaciente(String pacienteID) {
		Optional <Paciente> p = repository.findByID(pacienteID);
		if(!p.isPresent()) {
			throw new RuntimeException("Error: Paciente con ID " + pacienteID + " no encontrado.");
		}
		repository.deleteByID(pacienteID);
	}
	
}

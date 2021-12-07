package api.service.implementation;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import api.dao.MedicoDAO;
import api.dto.MedicoGetDTO;
import api.dto.MedicoPostDTO;
import api.dto.mappers.MapStructMapper;
import api.service.MedicoService;
import entities.Medico;

@Service
public class MedicoServiceImplementation implements MedicoService {
	
	@Autowired
	private MedicoDAO repository;
	
	@Autowired
	private MapStructMapper mapper;
	
	public List<MedicoGetDTO> findAll(){
		List<Medico> lm = repository.findAll();
		List<MedicoGetDTO> lmdto = new ArrayList<MedicoGetDTO>();
		lm.stream().forEach(m -> lmdto.add(mapper.getDTO(m)));
		return lmdto;
	}
	
	public void addMedico(MedicoPostDTO m) {
		repository.save(mapper.getMedico(m));
	}
	
	public void updateMedico(MedicoPostDTO m) {
		repository.update(mapper.getMedico(m));
	}
	
	public void saveMedico(MedicoPostDTO m){
		repository.save(mapper.getMedico(m));
	}
	
	public MedicoGetDTO findByID(String medicoID) {
		Optional<Medico> m = repository.findByID(medicoID);
		if(!m.isPresent()) {
			throw new RuntimeException("Error: Paciente con ID " + medicoID + " no encontrado.");
		}
		return mapper.getDTO(m.get());
	}
	
	public List<MedicoGetDTO> findByName(String medicoNAME) {
		List<Medico> lm = repository.findAllByName(medicoNAME);
		List<MedicoGetDTO> lmdto = new ArrayList<MedicoGetDTO>();
		lm.stream().forEach(m -> lmdto.add(mapper.getDTO(m)));
		return lmdto;
	}
	
	public void deleteMedico(String medicoID) {
		Optional <Medico> m = repository.findByID(medicoID);
		if(!m.isPresent()) {
			throw new RuntimeException("Error: Medico con ID " + medicoID + " no encontrado.");
		}
		repository.deleteByID(medicoID);
	}
	
}

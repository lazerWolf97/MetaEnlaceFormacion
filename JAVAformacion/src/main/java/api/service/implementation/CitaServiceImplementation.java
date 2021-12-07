package api.service.implementation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import api.dao.CitaDAO;
import api.dto.CitaGetDTO;
import api.dto.CitaPostDTO;
import api.dto.mappers.MapStructMapper;
import api.service.CitaService;
import entities.Cita;

@Service
public class CitaServiceImplementation implements CitaService {

	@Autowired
	private CitaDAO repository;
	
	@Autowired
	private MapStructMapper mapper;
	
	@Override
	public List<CitaGetDTO> findAll() {
		List<Cita> lc = repository.findAll();
		List<CitaGetDTO> lcDTO = new ArrayList<CitaGetDTO>();
		lc.stream().forEach(c -> lcDTO.add(mapper.getDTO(c)));
		return lcDTO;
	}

	@Override
	public List<CitaGetDTO> findByPaciente(String ID) {
		List<Cita> lc = repository.findByPaciente(ID);
		List<CitaGetDTO> lcDTO = new ArrayList<CitaGetDTO>();
		lc.stream().forEach(c -> lcDTO.add(mapper.getDTO(c)));
		return lcDTO;
	}

	@Override
	public List<CitaGetDTO> findByMedico(String ID) {
		List<Cita> lc = repository.findByMedico(ID);
		List<CitaGetDTO> lcDTO = new ArrayList<CitaGetDTO>();
		lc.stream().forEach(c -> lcDTO.add(mapper.getDTO(c)));
		return lcDTO;
	}

	@Override
	public void clean() {
		repository.clean();
	}

	@Override
	public void save(CitaPostDTO entity) {
		repository.save(mapper.getCita(entity));
	}

	@Override
	public void update(CitaPostDTO entity) {
		repository.update(mapper.getCita(entity));
	}

}

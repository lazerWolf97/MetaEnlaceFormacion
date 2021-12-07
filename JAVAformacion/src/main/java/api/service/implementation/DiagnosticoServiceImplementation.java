package api.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import api.dao.DiagnosticoDAO;
import api.dto.DiagnosticoDTO;
import api.dto.mappers.MapStructMapper;
import api.service.DiagnosticoService;

@Service
public class DiagnosticoServiceImplementation implements DiagnosticoService {

	@Autowired
	DiagnosticoDAO repository;
	
	@Autowired
	MapStructMapper mapper;

	@Override
	public void save(DiagnosticoDTO d) {
		repository.save(mapper.getDiagnostico(d));
	}

	@Override
	public void update(DiagnosticoDTO d) {
		repository.update(mapper.getDiagnostico(d));
	}
	
}

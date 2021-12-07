package api.service.implementation;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import api.dao.implementation.UsuarioApp;
import api.dto.UsuarioGetDTO;
import api.dto.mappers.MapStructMapper;
import api.service.UsuarioService;
import entities.Usuario;

public class UsuarioServiceImplementation implements UsuarioService {

	@Autowired
	private UsuarioApp repository;
	
	@Autowired
	private MapStructMapper mapper;
	
	@Override
	public List<UsuarioGetDTO> findAll(){
		List<Usuario> lu = repository.findAll();
		List<UsuarioGetDTO> ludto = new ArrayList<UsuarioGetDTO>();
		lu.stream().forEach(u -> ludto.add(mapper.getDTO(u)));
		return ludto;
	}
	
	@Override
	public UsuarioGetDTO findByID(String userID) {
		Optional<Usuario> p = repository.findByID(userID);
		if(!p.isPresent()) {
			throw new RuntimeException("Error: Usuario con ID " + userID + " no encontrado.");
		}
		return mapper.getDTO(p.get());
	}
	
	@Override
	public List<UsuarioGetDTO> findByName(String userNAME) {
		List<Usuario> lu = repository.findByName(userNAME);
		List<UsuarioGetDTO> ludto = new ArrayList<UsuarioGetDTO>();
		lu.stream().forEach(u -> ludto.add(mapper.getDTO(u)));
		return ludto;
	}
	
	@Override
	public void delete(String userID) {
		Optional <Usuario> p = repository.findByID(userID);
		if(!p.isPresent()) {
			throw new RuntimeException("Error: Usuario con ID " + userID + " no encontrado.");
		}
		repository.delete(userID);
	}
}

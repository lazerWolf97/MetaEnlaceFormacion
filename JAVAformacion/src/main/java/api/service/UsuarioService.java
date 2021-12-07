package api.service;

import java.util.List;

import api.dto.UsuarioGetDTO;

public interface UsuarioService {
	List<UsuarioGetDTO> findAll();
	public UsuarioGetDTO findByID(String userID);
	public List<UsuarioGetDTO> findByName(String userNAME);
	public void delete(String userID);
}

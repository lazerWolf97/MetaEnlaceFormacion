package api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import api.dto.UsuarioGetDTO;
import api.service.UsuarioService;

@RestController
@RequestMapping("/api")
public class UsuarioController {

	@Autowired
	private UsuarioService service;
	
	@GetMapping("/usuarios")
	public List<UsuarioGetDTO> findAll(){
		return service.findAll();
	}
	
	@GetMapping("/usuarios/id={userID}")
	public UsuarioGetDTO findByID(@PathVariable String userID) {
		return service.findByID(userID);
	}
	
	@GetMapping("/usuarios/name={userNAME}")
	public List<UsuarioGetDTO> findByName(@PathVariable String userNAME) {
		return service.findByName(userNAME);
	}
	
	@DeleteMapping("/usuarios/delete/{userID}")
	public void delete(@PathVariable String userID) {
		service.delete(userID);
	}
}

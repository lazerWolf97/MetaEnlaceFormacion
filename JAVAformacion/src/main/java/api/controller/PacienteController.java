package api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import api.dto.PacienteGetDTO;
import api.dto.PacientePostDTO;
import api.service.PacienteService;

@RestController
@RequestMapping("/api")
public class PacienteController {

	@Autowired
	private PacienteService service;
	
	@GetMapping("/pacientes")
	public List<PacienteGetDTO> findAll(){
		return service.findAll();
	}
	
	@PostMapping("/pacientes/add")
	public void addPaciente(@RequestBody PacientePostDTO p) {
		service.addPaciente(p);
	}
	
	@PatchMapping("/pacientes/update")
	public void updatePaciente(@RequestBody PacientePostDTO p) {
		service.updatePaciente(p);
	}
	
	@PutMapping("/pacientes/save")
	public void savePaciente(PacientePostDTO p){
		service.savePaciente(p);
	}
	
	@GetMapping("/pacientes/id={pacienteID}")
	public PacienteGetDTO findByID(@PathVariable String pacienteID) {
		return service.findByID(pacienteID);
	}
	
	@GetMapping("/pacientes/name={pacienteNAME}")
	public List<PacienteGetDTO> findByName(@PathVariable String pacienteNAME) {
		return service.findByName(pacienteNAME);
	}
	
	@DeleteMapping("/pacientes/delete/{pacienteID}")
	public void deletePaciente(@PathVariable String pacienteID) {
		service.deletePaciente(pacienteID);
	}
	
}

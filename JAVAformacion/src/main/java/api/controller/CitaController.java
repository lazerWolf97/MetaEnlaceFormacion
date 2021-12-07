package api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import api.dto.CitaGetDTO;
import api.dto.CitaPostDTO;
import api.service.CitaService;

@RestController
@RequestMapping("/api")
public class CitaController {

	@Autowired
	private CitaService service;
	
	@GetMapping("/citas")
	public List<CitaGetDTO> findAll(){
		return service.findAll();
	}
	
	@GetMapping("/pacientes/id={pacienteID}/citas")
	public List<CitaGetDTO> findByPaciente(@PathVariable String pacienteID){
		return service.findByPaciente(pacienteID);
	}
	
	@GetMapping("/medicos/id={medicoID}/citas")
	public List<CitaGetDTO> findByMedico(@PathVariable String medicoID){
		return service.findByMedico(medicoID);
	}
	
	@PostMapping("/citas/add")
	public void addCita(@RequestBody CitaPostDTO cita) {
		service.save(cita);
	}
	
	@PatchMapping("/citas/update")
	public void updateCita(@RequestBody CitaPostDTO cita) {
		service.update(cita);
	}
	
	@DeleteMapping("/citas/clean")
	public void clean() {
		service.clean();
	}
	
}

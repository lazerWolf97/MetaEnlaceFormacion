package api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import api.dto.MedicoGetDTO;
import api.dto.MedicoPostDTO;
import api.service.MedicoService;


@RestController
@RequestMapping("/api")
public class MedicoController {

	@Autowired
	private MedicoService service;
	
	@GetMapping("/medicos")
	public List<MedicoGetDTO> findAll(){
		return service.findAll();
	}
	
	@PostMapping("/medicos/add")
	public void addMedico(@RequestBody MedicoPostDTO m) {
		service.addMedico(m);
	}
	
	@PatchMapping("/medicos/update")
	public void updateMedico(@RequestBody MedicoPostDTO m) {
		service.updateMedico(m);
	}
	
	@PutMapping("/medicos/save")
	public void saveMedico(MedicoPostDTO m){
		service.saveMedico(m);
	}
	
	@GetMapping("/medicos/id={medicoID}")
	public MedicoGetDTO findByID(@PathVariable String medicoID) {
		return service.findByID(medicoID);
	}
	
	@GetMapping("/medicos/name={medicoNAME}")
	public List<MedicoGetDTO> findByName(@PathVariable String medicoNAME) {
		return service.findByName(medicoNAME);
	}
	
	@DeleteMapping("/medicos/delete/{medicoID}")
	public void deleteMedico(@PathVariable String medicoID) {
		service.deleteMedico(medicoID);
	}
	
}

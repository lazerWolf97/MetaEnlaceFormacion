package api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import api.dto.DiagnosticoDTO;
import api.service.DiagnosticoService;

@RestController
@RequestMapping("/api/citas")
public class DiagnosticoController {
	
	@Autowired
	private DiagnosticoService service;
	
	@PostMapping("/diagnosticos/save")
	public void addDiagnostico(@RequestBody DiagnosticoDTO d) {
		service.save(d);
	}
	
	@PatchMapping("/diagnosticos/update")
	public void updateDiagnostico(@RequestBody DiagnosticoDTO d) {
		service.update(d);
	}
	
}

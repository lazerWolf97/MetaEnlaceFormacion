package api.service;

import java.util.List;

import api.dto.MedicoGetDTO;
import api.dto.MedicoPostDTO;

public interface MedicoService {
	public List<MedicoGetDTO> findAll();
	public void addMedico(MedicoPostDTO m);
	public void updateMedico(MedicoPostDTO m);
	public void saveMedico(MedicoPostDTO m);
	public MedicoGetDTO findByID(String medicoID);
	public List<MedicoGetDTO> findByName(String medicoNAME);
	public void deleteMedico(String medicoID);
}

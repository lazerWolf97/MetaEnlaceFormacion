package api.dto.mappers;

import org.mapstruct.Mapper;

import api.dto.*;
import entities.*;

@Mapper(componentModel = "spring")
public interface MapStructMapper {
	
	public UsuarioGetDTO getDTO (Usuario u);

	public PacienteGetDTO getDTO (Paciente p);
	public PacientePostDTO getPostDTO (Paciente p);
	public Paciente getPaciente (PacientePostDTO pDTO);
	
	public MedicoGetDTO getDTO (Medico m);
	public MedicoPostDTO getPostDTO (Medico m);
	public Medico getMedico (MedicoPostDTO mDTO);
	
	public CitaGetDTO getDTO (Cita c);
	public Cita getCita (CitaPostDTO cDTO);

	public DiagnosticoDTO getDTO(Diagnostico d);
	public Diagnostico getDiagnostico(DiagnosticoDTO dDTO);
}

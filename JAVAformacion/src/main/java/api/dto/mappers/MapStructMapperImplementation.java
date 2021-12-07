package api.dto.mappers;

import org.springframework.stereotype.Component;

import api.dto.*;
import entities.*;
import entities.enums.EstadoCita;

@Component
public class MapStructMapperImplementation implements MapStructMapper {

	// PACIENTE
	
	@Override
	public PacienteGetDTO getDTO(Paciente p) {
		if(p == null) return null;
		PacienteGetDTO newDTO = new PacienteGetDTO(p.getUsuario(), p.getNombre(),
				p.getApellidos(), p.getNumeroSeguridadSocial(), p.getNumeroTarjeta(),
				p.getNumeroTelefono(), p.getDireccion(), p.getProfesionalesAsociados());
		return newDTO;
	}

	@Override
	public Paciente getPaciente(PacientePostDTO pDTO) {
		if(pDTO == null) return null;
		Paciente newP = new Paciente(pDTO.getNombre(), pDTO.getApellidos(),
				pDTO.getUsuario(), pDTO.getClave(), pDTO.getNSS(),
				pDTO.getNumTarjeta(), pDTO.getTelefono(), pDTO.getDireccion(),
				pDTO.getProfesionalesAsociados());
		return newP;
	}

	@Override
	public PacientePostDTO getPostDTO(Paciente p) {
		if(p == null) return null;
		PacientePostDTO newDTO = new PacientePostDTO(p.getUsuario(), p.getClave(), p.getNombre(),
				p.getApellidos(), p.getNumeroSeguridadSocial(), p.getNumeroTarjeta(),
				p.getNumeroTelefono(), p.getDireccion(), p.getProfesionalesAsociados());
		return newDTO;
	}

	// MEDICO
	
	@Override
	public MedicoGetDTO getDTO(Medico m) {
		if(m == null) return null;
		MedicoGetDTO newDTO = new MedicoGetDTO(m.getUsuario(), m.getNombre(), m.getApellidos(),
				m.getNumeroColegiado(), m.comprobarDisponibilidad());
		return newDTO;
	}
	
	public Medico getMedico(MedicoPostDTO mDTO) {
		if(mDTO == null) return null;
		Medico newm = new Medico(mDTO.getNombre(), mDTO.getApellidos(), mDTO.getUsuario(), 
				mDTO.getClave(), mDTO.getNumColegiado());
		newm.setDisponibilidad(mDTO.isDisponible());
		return newm;
	}

	@Override
	public MedicoPostDTO getPostDTO(Medico m) {
		if(m == null) return null;
		MedicoPostDTO newDTO = new MedicoPostDTO(m.getUsuario(), m.getClave(), m.getNombre(), m.getApellidos(),
				m.getNumeroColegiado(), m.comprobarDisponibilidad());
		return newDTO;
	}

	// USUARIO
	
	@Override
	public UsuarioGetDTO getDTO(Usuario u) {
		if(u == null) return null;
		UsuarioGetDTO newDTO = new UsuarioGetDTO(u.getUsuario(), u.getNombre(), u.getApellidos());
		return newDTO;
	}

	// CITA
	
	@Override
	public CitaGetDTO getDTO(Cita c) {
		if(c == null) return null;
		Paciente p = c.getPaciente();
		Medico m = c.getMedico();
		CitaGetDTO newc = new CitaGetDTO(c.getID(), c.getFechayHora(), c.getMotivoCita(), getDTO(p),
										 getDTO(m), c.getEstado().name(), getDTO(c.getDiagnostico()));
		return newc;
	}
	
	@Override
	public Cita getCita(CitaPostDTO cDTO) {
		if(cDTO == null) return null;
		Cita newc = new Cita(cDTO.getFechaHora(), cDTO.getMotivo(), getPaciente(cDTO.getPaciente()),
							 getMedico(cDTO.getMedico()), getDiagnostico(cDTO.getDiagnostico()),
							 EstadoCita.valueOf(cDTO.getEstado()), cDTO.getID());
		return newc;
	}
	
	// DIAGNOSTICO
	
	@Override
	public DiagnosticoDTO getDTO(Diagnostico d) {
		if(d == null) return null;
		DiagnosticoDTO newd = new DiagnosticoDTO();
		newd.setEnfermedad(d.getEnfermedad());
		newd.setValoracion(d.getValoracion());
		return newd;
	}
	
	@Override
	public Diagnostico getDiagnostico(DiagnosticoDTO dDTO) {
		if(dDTO == null) return null;
		Diagnostico newd = new Diagnostico(dDTO.getValoracion(), dDTO.getEnfermedad());
		return newd;
	}
	
}

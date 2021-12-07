package api.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CitaGetDTO {

	@JsonProperty("id")
	private long ID;
	@JsonProperty("fecha")
	private Date fechaHora;
	@JsonProperty("motivo")
	private String motivo;
	@JsonProperty("paciente")
	private PacienteGetDTO paciente;
	@JsonProperty("medico")
	private MedicoGetDTO medico;
	@JsonProperty("estado")
	private String estado;
	@JsonProperty("diagnostico")
	private DiagnosticoDTO diagnostico;
	
	public CitaGetDTO() {
		ID = 0;
		fechaHora = null;
		motivo = null;
		paciente = null;
		medico = null;
		diagnostico = new DiagnosticoDTO();
	}
	
	public CitaGetDTO(long ID, Date fecha, String motivo, PacienteGetDTO paciente, MedicoGetDTO medico, String estado, DiagnosticoDTO diagnostico) {
		this.ID = ID;
		this.fechaHora = fecha;
		this.motivo = motivo;
		this.paciente = paciente;
		this.medico = medico;
		this.estado = estado;
		this.diagnostico = diagnostico;
	}

	public DiagnosticoDTO getDiagnostico() {
		return diagnostico;
	}

	public void setDiagnostico(DiagnosticoDTO diagnostico) {
		this.diagnostico = diagnostico;
	}

	@JsonProperty("id")
	public long getID() {
		return ID;
	}

	@JsonProperty("id")
	public void setID(long iD) {
		ID = iD;
	}

	public Date getFechaHora() {
		return fechaHora;
	}

	public void setFechaHora(Date fechaHora) {
		this.fechaHora = fechaHora;
	}

	public String getMotivo() {
		return motivo;
	}

	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}

	public PacienteGetDTO getPaciente() {
		return paciente;
	}

	public void setPaciente(PacienteGetDTO paciente) {
		this.paciente = paciente;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public MedicoGetDTO getMedico() {
		return medico;
	}

	public void setMedico(MedicoGetDTO medico) {
		this.medico = medico;
	}
	
}

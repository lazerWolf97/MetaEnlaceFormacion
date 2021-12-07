package api.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CitaPostDTO {

	@JsonProperty("id")
	private long ID;
	@JsonProperty("fecha")
	private Date fechaHora;
	@JsonProperty("motivo")
	private String motivo;
	@JsonProperty("paciente")
	private PacientePostDTO paciente;
	@JsonProperty("medico")
	private MedicoPostDTO medico;
	@JsonProperty("estado")
	private String estado;
	@JsonProperty("diagnostico")
	private DiagnosticoDTO diagnostico;
	
	public CitaPostDTO() {
		ID = 0;
		fechaHora = null;
		motivo = null;
		paciente = null;
		medico = null;
		diagnostico = new DiagnosticoDTO();
	}
	
	public CitaPostDTO(long ID, Date fecha, String motivo, PacientePostDTO paciente, MedicoPostDTO medico, String estado, DiagnosticoDTO diagnostico) {
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

	public PacientePostDTO getPaciente() {
		return paciente;
	}

	public void setPaciente(PacientePostDTO paciente) {
		this.paciente = paciente;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public MedicoPostDTO getMedico() {
		return medico;
	}

	public void setMedico(MedicoPostDTO medico) {
		this.medico = medico;
	}
	
	
}

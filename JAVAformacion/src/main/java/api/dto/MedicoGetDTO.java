package api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MedicoGetDTO extends UsuarioGetDTO {

	@JsonProperty("numColegiado")
	private String _numColegiado;
	@JsonProperty("disponibilidad")
	private boolean _disponibilidad;
	
	public MedicoGetDTO() {
		super();
		_numColegiado = null;
		_disponibilidad = false;
	}
	
	public MedicoGetDTO(String usuario, String nombre, String apellidos, String numColegiado, boolean disponibilidad) {
		super(usuario, nombre, apellidos);
		_numColegiado = numColegiado;
		_disponibilidad = disponibilidad;
	}
	
	@JsonProperty("numColegiado")
	public String getNumColegiado() {
		return _numColegiado;
	}
	
	@JsonProperty("disponibilidad")
	public boolean isDisponible() {
		return _disponibilidad;
	}
	
	@JsonProperty("numColegiado")
	public void setNumColegiado(String numColegiado) {
		_numColegiado = numColegiado;
	}
	
	@JsonProperty("disponibilidad")
	public void setDisponibilidad(boolean disponibilidad) {
		_disponibilidad = disponibilidad;
	}
}

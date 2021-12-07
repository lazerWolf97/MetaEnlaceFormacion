package api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MedicoPostDTO extends UsuarioPostDTO {
	
	@JsonProperty("numColegiado")
	private String _numColegiado;
	@JsonProperty("disponibilidad")
	private boolean _disponibilidad;
	
	public MedicoPostDTO() {
		super();
		_numColegiado = null;
		_disponibilidad = false;
	}
	
	public MedicoPostDTO(String usuario, String clave, String nombre, String apellidos, String numColegiado, boolean disponibilidad) {
		super(usuario, clave, nombre, apellidos);
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

package api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.istack.NotNull;

public class UsuarioGetDTO {
	
	@NotNull
	@JsonProperty("usuario")
	private String _usuario;
	
	@JsonProperty("nombre")
	private String _nombre;
	
	@JsonProperty("apellidos")
	private String _apellidos;
	
	public UsuarioGetDTO() {
		_usuario = null;
		_nombre = null;
		_apellidos = null;
	}
	
	public UsuarioGetDTO(String usuario, String nombre, String apellidos) {
		_usuario = usuario;
		_nombre = nombre;
		_apellidos = apellidos;
	}
	
	@JsonProperty("usuario")
	public String getUsuario() {
		return _usuario;
	}
	
	@JsonProperty("nombre")
	public String getNombre() {
		return _nombre;
	}
	
	@JsonProperty("apellidos")
	public String getApellidos() {
		return _apellidos;
	}
	
	@JsonProperty("usuario")
	public void setUsuario(String u) {
		_usuario = u;
	}
	
	@JsonProperty("nombre")
	public void setNombre(String n) {
		_nombre = n;
	}
	
	@JsonProperty("apellidos")
	public void setApellidos(String a) {
		_apellidos = a;
	}
}

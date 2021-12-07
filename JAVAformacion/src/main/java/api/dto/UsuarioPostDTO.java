package api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.istack.NotNull;

public abstract class UsuarioPostDTO {
	
	@NotNull
	@JsonProperty("usuario")
	private String _usuario;
	
	@NotNull
	@JsonProperty("clave")
	private String _clave;
	
	@JsonProperty("nombre")
	private String _nombre;
	
	@JsonProperty("apellidos")
	private String _apellidos;
	
	public UsuarioPostDTO() {
		_usuario = null;
		_clave = null;
		_nombre = null;
		_apellidos = null;
	}
	
	public UsuarioPostDTO(String usuario, String clave, String nombre, String apellidos) {
		_usuario = usuario;
		_clave = clave;
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
	
	@JsonProperty("clave")
	public String getClave() {
		return _clave;
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
	
	@JsonProperty("clave")
	public void setClave(String c) {
		_clave = c;
	}
	
}
package api.dto;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import entities.Medico;

public class PacientePostDTO extends UsuarioPostDTO {

	@JsonProperty("numeroSeguridadSocial")
	private String numeroSeguridadSocial;
	@JsonProperty("numeroTarjeta")
	private String numeroTarjeta;
	@JsonProperty("numeroTelefono")
	private String numeroTelefono;
	@JsonProperty("direccion")
	private String direccion;
	@JsonProperty("profesionalesAsociados")
	private List<Medico> profesionalesAsociados;
	
	public PacientePostDTO() {
		super();
		numeroSeguridadSocial = null;
		numeroTarjeta = null;
		numeroTelefono = null;
		direccion = null;
		profesionalesAsociados = new ArrayList<Medico>();
	}
	
	public PacientePostDTO(String usuario, String clave, String nombre, String apellidos,
			              String nss, String numTarjeta, String telefono,
			              String direccion, List<Medico> profesionalesA) {
		super(usuario, clave, nombre, apellidos);
		numeroSeguridadSocial = nss;
		numeroTarjeta = numTarjeta;
		numeroTelefono = telefono;
		this.direccion = direccion;
		profesionalesAsociados = profesionalesA;
	}
	
	@JsonProperty("numeroSeguridadSocial")
	public String getNSS() {
		return numeroSeguridadSocial;
	}
	
	@JsonProperty("numeroTarjeta")
	public String getNumTarjeta() {
		return numeroTarjeta;
	}
	
	@JsonProperty("numeroTelefono")
	public String getTelefono() {
		return numeroTelefono;
	}
	
	@JsonProperty("direccion")
	public String getDireccion() {
		return direccion;
	}
	
	@JsonProperty("profesionalesAsociados")
	public List<Medico> getProfesionalesAsociados() {
		return profesionalesAsociados;
	}
	
	@JsonProperty("numeroSeguridadSocial")
	public void setNSS(String NSS) {
		numeroSeguridadSocial = NSS;
	}
	
	@JsonProperty("numeroTarjeta")
	public void setNumTarjeta(String numTarjeta) {
		numeroTarjeta = numTarjeta;
	}
	
	@JsonProperty("numeroTelefono")
	public void setTelefono(String telefono) {
		numeroTelefono = telefono;
	}
	
	@JsonProperty("direccion")
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
	@JsonProperty("profesionalesAsociados")
	public void getProfesionalesAsociados(List<Medico> profesionalesAsociados) {
		this.profesionalesAsociados = profesionalesAsociados;
	}
	
}

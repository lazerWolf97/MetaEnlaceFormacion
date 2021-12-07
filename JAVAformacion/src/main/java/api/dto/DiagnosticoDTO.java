package api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DiagnosticoDTO {

	@JsonProperty("valoracion")
	private String valoracion;
	@JsonProperty("enfermedad")
	private String enfermedad;
	
	public String getValoracion() {
		return valoracion;
	}
	public void setValoracion(String valoracion) {
		this.valoracion = valoracion;
	}
	public String getEnfermedad() {
		return enfermedad;
	}
	public void setEnfermedad(String enfermedad) {
		this.enfermedad = enfermedad;
	}
}

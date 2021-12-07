package entities;

import javax.persistence.*;

@Entity (name = "DIAGNOSTICO")
public class Diagnostico  {

	@Id
	@Column(name="idDiagnostico")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "id_Diagn")
	@SequenceGenerator(name = "id_Diagn", sequenceName = "ID_SEQ")
    private long id;
	
	// ATRIBUTOS DE LA CLASE
	@Column(name="valoracion")
	private String _valoracionEspecialista;
	@Column(name="enfermedad")
	private String _enfermedad;
	
	// ATRIBUTOS - ASOCIACION
	
	// CONSTRUCTORES
	public Diagnostico(String valoracion, String enfermedad) {
		_valoracionEspecialista = valoracion;
		_enfermedad = enfermedad;
	}
	
	protected Diagnostico() {
		
	}
	
	// GETTER
	public String getValoracion() {
		return _valoracionEspecialista;
	}
	
	public String getEnfermedad() {
		return _enfermedad;
	}

	public long getID() {
		return id;
	}
	
}

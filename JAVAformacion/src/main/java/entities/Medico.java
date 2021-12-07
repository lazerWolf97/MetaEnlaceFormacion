package entities;

import java.util.Set;
import java.util.HashSet;
import javax.persistence.*;

@Entity (name = "MEDICO")
public class Medico extends Usuario {
	
	private static final long serialVersionUID = 5967490337554098993L;
	
	// ATRIBUTOS DE LA CLASE
	@Column(name="ncolegiado")
	private String _numColegiado;
	@Column(name="disponibilidad",
			columnDefinition="NUMBER(1)")
	private boolean _disponibilidad;
	
	// ATRIBUTOS - ASOCIACION
	@ManyToMany (mappedBy = "_profesionalesAsociados")
	private Set<Paciente> _pacientesAsociados;
	
	// CONSTRUCTORES
	public Medico(String nombre, String apellidos, String usuario, String clave,
				  String numColegiado) {
		super(nombre, apellidos, usuario, clave);
		_numColegiado = numColegiado;
		_pacientesAsociados = new HashSet<Paciente>();
		_disponibilidad = true;
	}
	
	protected Medico() {
		
	}
	
	// GETTER
	public String getNumeroColegiado() {
		return _numColegiado;
	}
	
	public boolean comprobarDisponibilidad() {
		return _disponibilidad;
	}
	
	public Set<Paciente> getPacientesAsociados(){
		Set<Paciente> bufferedCopy = new HashSet<Paciente>(_pacientesAsociados);
		return bufferedCopy;
	}
	
	// SETTER
	public void setDisponibilidad(boolean disponibilidad) {
		_disponibilidad = disponibilidad;
	}
	
	// METODOS DE LA CLASE
	public void asociarPaciente(Paciente paciente) {
		_pacientesAsociados.add(paciente);
	}
	
	@Override
	public String toString() {
		String a = super.toString();
		a = a + "\nNum. Colegiado: " + _numColegiado;
		return a;
	}
}

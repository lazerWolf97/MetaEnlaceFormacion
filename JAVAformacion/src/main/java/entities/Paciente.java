package entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity (name = "PACIENTE")
public class Paciente extends Usuario {
	
	private static final long serialVersionUID = -270866370577020515L;
	
	// ATRIBUTOS DE LA CLASE
	@Column(name = "nss")
	private String _NSS;
	@Column(name="ntarjeta")
	private String _numTarjeta;
	@Column(name="telefono")
	private String _telefono;
	@Column(name="direccion")
	private String _direccion;
	
	// ATRIBUTOS - ASOCIACION
	@ManyToMany
	@JoinTable(name = "ASOC_MEDICO_PACIENTE",
			   joinColumns = @JoinColumn(name = "paciente_id"), 
			   inverseJoinColumns = @JoinColumn(name = "medico_id"))
	private List<Medico> _profesionalesAsociados;
	
	// CONSTRUCTORES
	public Paciente(String nombre, String apellidos, String usuario, String clave,
					String NSS, String numTarjeta, String telefono, String direccion) {
		super(nombre, apellidos, usuario, clave);
		_NSS = NSS;
		_numTarjeta = numTarjeta;
		_telefono = telefono;
		_direccion = direccion;
		_profesionalesAsociados = new ArrayList<Medico>();
	}
	
	public Paciente(String nombre, String apellidos, String usuario, String clave,
			String NSS, String numTarjeta, String telefono, String direccion, List<Medico> profesionalesAsociados) {
		super(nombre, apellidos, usuario, clave);
		_NSS = NSS;
		_numTarjeta = numTarjeta;
		_telefono = telefono;
		_direccion = direccion;
		_profesionalesAsociados = profesionalesAsociados;
	}
	
	protected Paciente() {
		
	}
	
	// GETTER
	public String getNumeroSeguridadSocial() {
		return _NSS;
	}
	
	public String getNumeroTarjeta() {
		return _numTarjeta;
	}
	
	public String getNumeroTelefono() {
		return _telefono;
	}
	
	public String getDireccion() {
		return _direccion;
	}
	
	public List<Medico> getProfesionalesAsociados() {
		List<Medico> bufferedCopy = new ArrayList<Medico>(_profesionalesAsociados);
		return bufferedCopy;
	}
	
	public void setProfesionalesAsociados(List<Medico> profesionalesAsociados) {
		_profesionalesAsociados = profesionalesAsociados;
	}
	
	
	// METODOS DE LA CLASE
	public void asociarProfesional(Medico profesional) {
		_profesionalesAsociados.add(profesional);
	}
	
	public Cita concertarCita(int dia, int mes, int hora, int min, String motivo) {
		Cita cita = new Cita(dia, mes, hora, min, motivo);
		cita.setMedico(_profesionalesAsociados.stream()
				.filter(p -> p.comprobarDisponibilidad()).findFirst().get());
		cita.setPaciente(this);
		return cita;
	}
	
	@Override
	public String toString() {
		String a = super.toString();
		a = a + "\nNSS: " + _NSS + "\nNum. Tarjeta: " + _numTarjeta + 
				 "\nNum. Telefono: " + _telefono + "\nDirecci�n: " + _direccion;
		return a;
	}
}

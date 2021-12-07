package entities;

import java.util.Date;
import java.util.Calendar;
import javax.persistence.*;
import entities.enums.EstadoCita;

@Entity (name="CITA")
public class Cita {
	
	@Id
	@Column(name="idCita")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "id_Cita")
	@SequenceGenerator(name = "id_Cita", sequenceName = "ID_SEQ")
    private long id;
	
	// ATRIBUTOS DE LA CLASE
	@Column(name="fechaHora")
	@Temporal(TemporalType.DATE)
	private Date _fechaHora;
	@Column(name="motivoCita")
	private String _motivoCita;
	@SuppressWarnings(value = { "unused" })
	private int attribute11;
	
	// ATRIBUTOS - ASOCIACION
	@OneToOne
	@JoinColumn(name="idDiagnostico")
	private Diagnostico _diagnostico;
	@ManyToOne
	@JoinColumn(name="paciente")
	private Paciente _paciente;
	@ManyToOne
	@JoinColumn(name="medico")
	private Medico _medico;
	
	@Enumerated(EnumType.ORDINAL)
	private EstadoCita estado;
	
	// CONSTRUCTORES
	public Cita(int dia, int mes, int hora, int min, String motivo) {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, 2021);
		cal.set(Calendar.MONTH, mes - 1);
		cal.set(Calendar.DAY_OF_MONTH, dia);
		cal.set(Calendar.HOUR_OF_DAY, hora);
		cal.set(Calendar.MINUTE, min);
		_fechaHora = cal.getTime();
		_motivoCita = motivo;
		estado = EstadoCita.CONCERTADA;
	}
	
	public Cita(Date fecha, String motivo, Paciente p, Medico m, Diagnostico d, EstadoCita estado, long ID) {
		_fechaHora = fecha;
		_motivoCita = motivo;
		_paciente = p;
		_medico = m;
		_diagnostico = d;
		this.estado = estado;
		id = ID;
	}
	
	protected Cita() {
		
	}
	
	// GETTER
	public long getID() {
		return id;
	}
	
	public Date getFechayHora() {
		return _fechaHora;
	}
	
	public String getMotivoCita() {
		return _motivoCita;
	}
	
	public Diagnostico getDiagnostico() {
		return _diagnostico;
	}
	
	public Paciente getPaciente() {
		return _paciente;
	}
	
	public Medico getMedico() {
		return _medico;
	}
	
	public EstadoCita getEstado() {
		return estado;
	}
	
	// SETTER
	public void setMedico(Medico m) {
		_medico = m;
	}
	
	public void setPaciente(Paciente p) {
		_paciente = p;
	}
	
	// FUNCIONALIDAD DE LA CLASE
	public void cancelarCita() {
		estado = EstadoCita.CANCELADA;
	}
	
	public void notificarAbsencion() {
		estado = EstadoCita.SINASISTENCIA;
	}
	
	public void avanzar() {
		if(estado == EstadoCita.CONCERTADA) estado = EstadoCita.OCURRIENDO;
		if(estado == EstadoCita.OCURRIENDO) estado = EstadoCita.CUMPLIDA;
		// Usar patron State en caso de querer a�adir funcionalidad
	}
	
	@Override
	public String toString() {
		return "ID: " + id + "\nHorario: " + _fechaHora + "\nPaciente: "
				+ _paciente.getNombre() + ' ' + _paciente.getApellidos() + "\nM�dico: "
				+ _medico.getNombre() + ' ' + _medico.getApellidos() + "\nMotivo: "
				+ _motivoCita;
	}

}

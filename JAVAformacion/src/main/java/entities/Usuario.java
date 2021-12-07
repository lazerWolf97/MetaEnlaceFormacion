package entities;

import java.io.Serializable;

import javax.persistence.*;

@Entity (name="USUARIO")
@Inheritance (strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn (name = "myDType")
public abstract class Usuario implements Serializable {
	
	private static final long serialVersionUID = -6625873904952885840L;
	
	@Column(insertable = false, updatable = false) 
	private String myDType; 
	
	// ATRIBUTOS DE LA CLASE
	@Column(name="nombre")
	private String _nombre;
	@Column(name="apellidos")
	private String _apellidos;
	@Id
	@Column(name="usuario")
	private String _usuario;
	@Column(name="clave")
	private String _clave;
	
	// CONSTRUCTORES
	public Usuario(String nombre, String apellidos, String usuario, String clave){
		_nombre = nombre;
		_apellidos = apellidos;
		_usuario = usuario;
		_clave = clave;
	}
	
	protected Usuario() {
		
	}
	
	// GETTER
	public String getNombre() {
		return _nombre;
	}
	
	public String getApellidos() {
		return _apellidos;
	}
	
	public String getUsuario() {
		return _usuario;
	}
	
	public String getClave() {
		return _clave;
	}
	
	// METODOS DE LA CLASE
	public void cambiarClave(String claveAntigua, String claveNueva, String confirmarClave) {
		if(claveAntigua.equals(_clave)) {
			if(claveNueva.equals(confirmarClave)) {
				_clave = claveNueva;
			}
			// else Mensaje de error: Las claves no coinciden
		}
		// else Mensaje de error: Clave antigua no es correcta
	}
	
	public boolean comprobarClave(String clave) {
		return clave.equals(_clave);
	}
	
	@Override
	public String toString() {
		return "Nombre: " + _nombre + "\nApellidos: " + _apellidos +
				"\nUsuario: " + _usuario + "\nClave: " + _clave;
	}

}

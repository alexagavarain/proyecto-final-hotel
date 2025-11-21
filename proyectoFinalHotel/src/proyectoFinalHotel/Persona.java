package proyectoFinalHotel;

public abstract class Persona {
	
	protected String nombre;
	protected int edad;
	protected String telefono;
	protected String email;
	
	public Persona(String nombre, int edad, String telefono, String email) {
		this.nombre = nombre;
		this.edad = edad;
		this.telefono = telefono;
		this.email = email;		
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String toString() {
		return "Nombre:" + nombre +
				"\nEdad: " + edad +
				"\n Telefono: " + telefono +
				"\n Email: " + email;
	}

}

package proyectoFinalHotel;

/**
 * La clase abstracta Persona crea objetos que contienen las características de una persona necesarias 
 * para interactuar con el sistema.
 * @author Alexa Gavarain
 * @version 1.0
 **/
public abstract class Persona {
	
	protected String nombre;
	protected int edad;
	protected String telefono;
	protected String email;
	
	/**
	 * Constructor que inicializa a la persona y recibe todos los atributos de la clase.
	 * @param nombre Nombre.
	 * @param edad Edad.
	 * @param telefono Número de teléfono.
	 * @param email Correo electrónico.
	 * */
	public Persona(String nombre, int edad, String telefono, String email) {
		this.nombre = nombre;
		this.edad = edad;
		this.telefono = telefono;
		this.email = email;		
	}

	/**
	 * Método para obtener el nombre de la persona.
	 * @return nombre Nombre.
	 * */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Método para asignar el nombre de la persona.
	 * @param nombre Nombre.
	 * **/
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Método para obtener la edad de la persona.
	 * @return edad Edad.
	 * */
	public int getEdad() {
		return edad;
	}
	
	/**
	 * Método para asignar la edad de la persona.
	 * @param edad Edad.
	 * **/
	public void setEdad(int edad) {
		this.edad = edad;
	}

	/**
	 * Método para obtener el número de teléfono de la persona.
	 * @return telefono Número de teléfono.
	 * */
	public String getTelefono() {
		return telefono;
	}

	/**
	 * Método para asignar el número de teléfono de la persona.
	 * @param telefono Número de teléfono.
	 * **/
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	/**
	 * Método para obtener el correo electrónico de la persona.
	 * @return email Correo electrónico.
	 * */
	public String getEmail() {
		return email;
	}

	/**
	 * Método para asignar el correo electrónico de la persona.
	 * @param email Correo electrónico.
	 * **/
	public void setEmail(String email) {
		this.email = email;
	}
	
	/**
	 * Devuelve un String con toda la información de la persona.
	 * @return String Cadena que contiene el nombre, edad, número de teléfono y correo electrónico de la persona.
	 * **/
	@Override
	public String toString() {
		return " Nombre: " + nombre +
				"\n Edad: " + edad +
				"\n Teléfono: " + telefono +
				"\n Email: " + email;
	}

}

package proyectoFinalHotel;

/**
 * La clase Servicio crea un objeto para representar un servicio contratable dentro del hotel.
 * @author Alexa Gavaraib
 * @version 1.0
 * **/
public class Servicio {
	
	private String nombre;
	private double costo;
	private String nombreClave;
	
	/**
	 * Constructor que crea el servicio con su nombre, nombre en clave y costo.
	 * @param nombre Nombre del servicio.
	 * @param nombreClave Nombre acortado para imprimir.
	 * @param costo Costo del servicio.
	 * **/
	public Servicio(String nombre, String nombreClave, double costo) {
		this.nombre = nombre;
		this.nombreClave = nombreClave;
		this.costo = costo;
	}
	
	/**
	 * Método para obtener el nombre en clave del servicio.
	 * @return nombreClave Nombre en clave.
	 * **/
	public String getNombreClave() {
		return nombreClave;
	}

	/**
	 * Método para asignar el nombre en clave del servicio.
	 * @param nombreClave Nombre en clave.
	 * **/
	public void setNombreClave(String nombreClave) {
		this.nombreClave = nombreClave;
	}

	/**
	 * Método para obtener el nombre del servicio.
	 * @return nombre Nombre.
	 * **/
	public String getNombre() {
		return nombre;
	}
	
	/**
	 * Método para asignar el nombre del servicio.
	 * @param nombre Nombre.
	 * **/
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Método para obtener el costo del servicio.
	 * @return costo Costo.
	 * **/
	public double getCosto() {
		return costo;
	}

	/**
	 * Método para asignar el costo del servicio.
	 * @param costo Costo.
	 * **/
	public void setCosto(double costo) {
		this.costo = costo;
	}
	
	/**
	 * Método que devuelve los datos del servicio.
	 * @return String Cadena que contiene el nombre y costo del servicio.
	 * **/
	@Override
	public String toString() {
		return " Nombre: " + nombre + "  |  Costo: $" + costo;
	}

}

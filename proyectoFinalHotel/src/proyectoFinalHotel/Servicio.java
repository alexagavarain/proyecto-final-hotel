package proyectoFinalHotel;

public class Servicio {
	
	private String nombre;
	private double costo;
	private String nombreClave;
	
	public Servicio(String nombre, String nombreClave, double costo) {
		this.nombre = nombre;
		this.nombreClave = nombreClave;
		this.costo = costo;
	}
	
	public String getNombreClave() {
		return nombreClave;
	}

	public void setNombreClave(String nombreClave) {
		this.nombreClave = nombreClave;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getCosto() {
		return costo;
	}

	public void setCosto(double costo) {
		this.costo = costo;
	}
	
	public String toString() {
		return " Nombre: " + nombre + "  |  Costo: $" + costo;
	}

}

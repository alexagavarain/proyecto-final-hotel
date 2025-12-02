package proyectoFinalHotel;

public class Servicio {
	
	protected String nombre;
	protected double costo;
	
	public Servicio(String nombre, double costo) {
		this.nombre = nombre;
		this.costo = costo;
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
		return " Nombre: " + nombre +
				"\n Costo: $" + costo;
	}

}

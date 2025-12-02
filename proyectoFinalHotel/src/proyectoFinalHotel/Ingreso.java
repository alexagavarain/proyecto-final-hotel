package proyectoFinalHotel;

public class Ingreso {
	
	String clave;
	String tipoHabitacion;
	String tipoMembresia;
	double costo;
	double descuento;
			
	public Ingreso(double costo, Huesped huesped, Habitacion habitacion) {
		this.clave = habitacion.getClave();
		this.tipoHabitacion = habitacion.getTipo();
		this.tipoMembresia = huesped.getTipoMembresia();
		this.costo = costo;
		this.descuento = huesped.porcentajeDescuento();
	}
	
	
	public String toString() {
		return " Clave: " + clave + "\n Tipo: " + tipoHabitacion + "\n Membresia: " + tipoMembresia + "\n Descuento: " + descuento + "% \n $$:" + costo;
	}


}

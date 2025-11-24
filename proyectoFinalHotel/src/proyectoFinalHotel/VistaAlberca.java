package proyectoFinalHotel;

public class VistaAlberca extends Habitacion {
	
	private double extra = 0.15;
	
	public VistaAlberca(String clave, int ocupacionMaxima, double precioPorNoche) {
		super(clave, ocupacionMaxima, precioPorNoche);
	}
	
	public double calcularCosto() {
		double costo = super.calcularCosto();
		costo += costo*extra;
		return costo;
	}

}

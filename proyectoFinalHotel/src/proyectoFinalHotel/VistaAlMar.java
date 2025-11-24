package proyectoFinalHotel;

public class VistaAlMar extends Habitacion {
	
	private double extra = 0.20;
	
	public VistaAlMar(String clave, int ocupacionMaxima, double precioPorNoche) {
		super(clave, ocupacionMaxima, precioPorNoche);
	}
	
	public double calcularCosto() {
		double costo = super.calcularCosto();
		costo += costo*extra;
		return costo;
	}

}

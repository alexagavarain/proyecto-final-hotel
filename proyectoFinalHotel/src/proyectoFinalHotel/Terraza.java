package proyectoFinalHotel;

public class Terraza extends Habitacion {
	
	private double extra = 0.1;
	
	public Terraza(String clave, int ocupacionMaxima, double precioPorNoche) {
		super(clave, ocupacionMaxima, precioPorNoche);
	}
	
	public double calcularCosto() {
		double costo = super.calcularCosto();
		costo += costo*extra;
		return costo;
	}

}

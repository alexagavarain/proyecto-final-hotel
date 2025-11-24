package proyectoFinalHotel;

public class JardinPrivado extends Habitacion {
	
	private double extra = 0.15;

	public JardinPrivado(String clave, int ocupacionMaxima, double precioPorNoche) {
		super(clave, ocupacionMaxima, precioPorNoche);
	}
	
	public double calcularCosto() {
		double costo = super.calcularCosto();
		costo += costo*extra;
		return costo;
	}
	
	

}

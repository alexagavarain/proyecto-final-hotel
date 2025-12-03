package proyectoFinalHotel;

public class Terraza extends Habitacion {
	
	private double extraVista = 200;
	
	public Terraza(String clave, int ocupacionMaxima, double precioPorNoche) {
		super("Terraza", clave, ocupacionMaxima, precioPorNoche);
	}
	
	public double getExtraVista() {
		return extraVista;
	}

	public void setExtraVista(double extraVista) {
		this.extraVista = extraVista;
	}

	public double calcularCosto() {
		double costo = super.calcularCosto();
		costo += extraVista;
		return costo;
	}

}

package proyectoFinalHotel;

public class JardinPrivado extends Habitacion {
	
	private double extraAcceso = 350;

	public JardinPrivado(String clave, int ocupacionMaxima, double precioPorNoche) {
		super("Jardín privado", clave, ocupacionMaxima, precioPorNoche);
	}

	public double getExtraAcceso() {
		return extraAcceso;
	}

	public void setExtraAcceso(double extraAcceso) {
		this.extraAcceso = extraAcceso;
	}

	public double calcularCosto() {
		double costo = super.calcularCosto();
		costo += extraAcceso;
		return costo;
	}
	
	

}

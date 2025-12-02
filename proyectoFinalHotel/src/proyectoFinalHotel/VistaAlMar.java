package proyectoFinalHotel;

public class VistaAlMar extends Habitacion {
	
	private double extraVista = 400;
	
	public VistaAlMar(String clave, int ocupacionMaxima, double precioPorNoche) {
		super("Vista al mar", clave, ocupacionMaxima, precioPorNoche);
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

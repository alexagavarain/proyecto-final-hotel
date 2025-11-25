package proyectoFinalHotel;

public class VistaAlberca extends Habitacion {
	
	private double extraVista = 200;
	
	public VistaAlberca(String clave, int ocupacionMaxima, double precioPorNoche) {
		super(clave, ocupacionMaxima, precioPorNoche);
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

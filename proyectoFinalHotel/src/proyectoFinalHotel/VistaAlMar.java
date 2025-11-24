package proyectoFinalHotel;

public class VistaAlMar extends Habitacion {
	
	private double extraVista = 400;
	private boolean palapaReservada;
	
	public VistaAlMar(String clave, int ocupacionMaxima, double precioPorNoche, boolean palapaReservada) {
		super(clave, ocupacionMaxima, precioPorNoche);
		this.palapaReservada = palapaReservada;
	}
	
	public double getExtraVista() {
		return extraVista;
	}

	public void setExtraVista(double extraVista) {
		this.extraVista = extraVista;
	}

	public boolean isPalapaReservada() {
		return palapaReservada;
	}

	public void setPalapaReservada(boolean palapaReservada) {
		this.palapaReservada = palapaReservada;
	}

	public double calcularCosto() {
		double costo = super.calcularCosto();
		costo += extraVista;
		if (palapaReservada) {
			costo += 200;
		}
		return costo;
	}

}

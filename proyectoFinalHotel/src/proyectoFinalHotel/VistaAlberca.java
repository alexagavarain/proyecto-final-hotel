package proyectoFinalHotel;

public class VistaAlberca extends Habitacion {
	
	private double extraVista = 200;
	private boolean camastrosReservados;
	
	public VistaAlberca(String clave, int ocupacionMaxima, double precioPorNoche, boolean camastrosReservados, boolean servicioBar) {
		super(clave, ocupacionMaxima, precioPorNoche);
		this.camastrosReservados = camastrosReservados;
	}
	
	public double getExtraVista() {
		return extraVista;
	}

	public void setExtraVista(double extraVista) {
		this.extraVista = extraVista;
	}

	public boolean isCamastrosReservados() {
		return camastrosReservados;
	}

	public void setCamastrosReservados(boolean camastrosReservados) {
		this.camastrosReservados = camastrosReservados;
	}

	public double calcularCosto() {
		double costo = super.calcularCosto();
		costo += extraVista;
		
		if (camastrosReservados) {
			costo += 100;
		}
		return costo;
	}

}

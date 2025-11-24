package proyectoFinalHotel;

public abstract class Habitacion {
	
	protected String clave;
	protected int ocupacionMaxima;
	protected double precioPorNoche;
	protected boolean reservada;
	protected boolean ocupada;
	protected int cantidadNoches;
	protected Huesped huespedTitular;
	
	public Habitacion(String clave, int ocupacionMaxima, double precioPorNoche) {
		this.clave = clave;
		this.ocupacionMaxima = ocupacionMaxima;
		this.precioPorNoche = precioPorNoche;
		this.reservada = false;
		this.ocupada = false;
		this.huespedTitular = new Huesped(); 
	}
	
	public String getClave() {
		return clave;
	}
	
	public void setClave(String clave) {
		this.clave = clave;
	}
	
	public int getOcupacionMaxima() {
		return ocupacionMaxima;
	}
	
	public void setOcupacionMaxima(int ocupacionMaxima) {
		this.ocupacionMaxima = ocupacionMaxima;
	}
	
	public double getPrecioPorNoche() {
		return precioPorNoche;
	}
	
	public void setPrecioPorNoche(double precioPorNoche) {
		this.precioPorNoche = precioPorNoche;
	}
	
	public boolean isReservada() {
		return reservada;
	}
	
	public void setReservada(boolean reservada) {
		this.reservada = reservada;
	}
	
	public boolean isOcupada() {
		return ocupada;
	}
	
	public void setOcupada(boolean ocupada) {
		this.ocupada = ocupada;
	}
	
	public int getCantidadNoches() {
		return cantidadNoches;
	}
	
	public void setCantidadNoches(int cantidadNoches) {
		this.cantidadNoches = cantidadNoches;
	}
	
	public Huesped getHuespedTitular() {
		return huespedTitular;
	}
	
	public void setHuespedTitular(Huesped huespedTitular) {
		this.huespedTitular = huespedTitular;
	}
	
	public boolean reservar(Huesped huespedTitular, int cantidadHuespedes, int noches) {
		if (!reservada && !ocupada) {
			if (cantidadHuespedes <= ocupacionMaxima) {
				reservada = true;
				cantidadNoches = noches;
				this.huespedTitular = huespedTitular;
				return true;
				
			}
		}
		return false;
	}
	
	public boolean ocupar() {
		if (reservada) {
			ocupada = true;
			return true;
		}
		return false;
	}
	
	public boolean desocupar() {
		if (ocupada) {
			reservada = false;
			ocupada = false;
			return true;
		}
		return false;
	}
	
	public double calcularCosto() {
		return precioPorNoche*cantidadNoches;
	}
	
	public String toString() {
		return " Clave: " + clave +
				"\n Ocupación máxima: " + ocupacionMaxima +
				"\n Precio por noche: $" + precioPorNoche +
				"\n Reservada: " + (reservada ? "Sí" : "No") +
				"\n Ocupada: " + (ocupada ? "Sí" : "No") +
				"\n Cantidad de noches: " + cantidadNoches +
				"\n Huésped titular: " + huespedTitular;
	}
	
	

}

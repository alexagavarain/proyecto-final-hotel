package proyectoFinalHotel;

/**
 * La clase abstracta Habitacion establece los atributos y métodos necesarios para representar 
 * una habitación de hotel.
 * @author Alexa Gavarain
 * @version 1.0
 * **/
public abstract class Habitacion {
	
	protected String tipo;
	protected String clave;
	protected int ocupacionMaxima;
	protected double precioPorNoche;
	
	protected boolean reservada;
	protected boolean ocupada;
	protected int cantidadNoches;
	protected Huesped huespedTitular;
	
	/**
	 * Constructor que crea el objeto Habitación con los atributos que necesitan declararse e inicializa 
	 * el resto de los atributos de la clase con su valor por defecto.
	 * @param tipo Tipo de habitación (con jardín, con terraza, etc.).
	 * @param clave Clave de la habitación.
	 * @param ocupacionMaxima Capacidad máxima de la habitación.
	 * @param precioPorNoche Costo por noche de la habitación.
	 * **/
	public Habitacion(String tipo, String clave, int ocupacionMaxima, double precioPorNoche) {
		this.tipo = tipo;
		this.clave = clave;
		this.ocupacionMaxima = ocupacionMaxima;
		this.precioPorNoche = precioPorNoche;
		this.reservada = false;
		this.ocupada = false;
		this.huespedTitular = null;
	}
	
	/**
	 * Método para obtener el tipo de habitación.
	 * @return tipo Tipo.
	 * **/
	public String getTipo() {
		return tipo;
	}

	/**
	 * Método para asignar el tipo de habitación.
	 * @param tipo Tipo.
	 * **/
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	/**
	 * Método para obtener la clave de la habitación.
	 * @return clave Clave.
	 * **/
	public String getClave() {
		return clave;
	}
	
	/**
	 * Método para asignar la clave de la habitación.
	 * @param clave Clave.
	 * **/
	public void setClave(String clave) {
		this.clave = clave;
	}
	
	/**
	 * Método para obtener la ocupación máxima de la habitación.
	 * @return ocupacionMaxima Ocupación máxima.
	 * **/
	public int getOcupacionMaxima() {
		return ocupacionMaxima;
	}
	
	/**
	 * Método para asignar la ocupación máxima de la habitación.
	 * @param ocupacionMaxima Ocupación máxima.
	 * **/
	public void setOcupacionMaxima(int ocupacionMaxima) {
		this.ocupacionMaxima = ocupacionMaxima;
	}
	
	/**
	 * Método para obtener el precio por noche de la habitación.
	 * @return precioPorNoche Precio por noche.
	 * **/
	public double getPrecioPorNoche() {
		return precioPorNoche;
	}
	
	/**
	 * Método para asignar el precio por noche de la habitación.
	 * @param precioPorNoche Precio por noche.
	 * **/
	public void setPrecioPorNoche(double precioPorNoche) {
		this.precioPorNoche = precioPorNoche;
	}
	
	/**
	 * Método para saber si la habitación está reservada o no.
	 * @return reservada Boolean que muestra si está reservada.
	 * **/
	public boolean isReservada() {
		return reservada;
	}
	
	/**
	 * Método para asignar si la habitación está reservada o no.
	 * @param reservada Boolean que dice si está reservada.
	 * **/
	public void setReservada(boolean reservada) {
		this.reservada = reservada;
	}
	
	/**
	 * Método para saber si la habitación está ocupada o no.
	 * @return ocupada Boolean que muestra si está ocupada.
	 * **/
	public boolean isOcupada() {
		return ocupada;
	}
	
	/**
	 * Método para asignar si la habitación está ocupada o no.
	 * @param ocupada Boolean que dice si está ocupada.
	 * **/
	public void setOcupada(boolean ocupada) {
		this.ocupada = ocupada;
	}
	
	/**
	 * Método para obtener la cantidad de noches por las que se reservará la habitación para el huésped.
	 * @return cantidadNoches Cantidad de noches.
	 * **/
	public int getCantidadNoches() {
		return cantidadNoches;
	}
	
	/**
	 * Método para asignar la cantidad de noches por las que se reservará la habitación para el huésped.
	 * @param cantidadNoches Cantidad de noches.
	 * **/
	public void setCantidadNoches(int cantidadNoches) {
		this.cantidadNoches = cantidadNoches;
	}
	
	/**
	 * Método para obtener al huésped titular de la habitación.
	 * @return huespedTitular Objeto de tipo Huesped titular de la habitación.
	 * **/
	public Huesped getHuespedTitular() {
		return huespedTitular;
	}
	
	/**
	 * Método para asignar al huésped titular de la habitación.
	 * @param huespedTitular Objeto de tipo Huesped titular de la habitación.
	 * **/
	public void setHuespedTitular(Huesped huespedTitular) {
		this.huespedTitular = huespedTitular;
	}
	
	/**
	 * Método para reservar la habitación. Valida que no haya sido reservada u ocupada previamente 
	 * y que la cantidad de huéspedes sea menor o igual a la capacidad de la habitación. 
	 * Guarda en los atributos de Huésped al titular y la cantidad de noches.
	 * @param huespedTitular Huésped que desea reservar la habitación.
	 * @param cantidadHuespedes Cantidad de personas que se van a hospedar.
	 * @param noches Número de noches que durará su estancia.
	 * @return boolean Si se logró hacer la reservación.
	 * **/
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
	
	/**
	 * Método para ocupar la habitación. Valida si ha sido previamente reservada por el mismo huésped.
	 * @param huespedTitular Huésped que desea ocupar la habitación.
	 * @return boolean Si se logró ocupar la habitación.
	 * **/
	public boolean ocupar(Huesped huespedTitular) {
		if (reservada && this.huespedTitular.comparar(huespedTitular)) {
			ocupada = true;
			return true;
		}
		return false;
	}
	
	/**
	 * Método para desocupar la habitación al momento de irse el huésped. Valida que la habitación haya sido
	 * previamente ocupada y que el titular sea el mismo.
	 * @param huespedTitular Huésped que desea desocupar la habitación.
	 * @return boolean Si se logró desocupar la habitación.
	 * **/
	public boolean desocupar(Huesped huespedTitular) {
		if (ocupada && this.huespedTitular.comparar(huespedTitular)) {
			this.reservada = false;
			this.ocupada = false;
	        this.cantidadNoches = 0;
	        this.huespedTitular = null;
	        return true;
		}
		return false;
	}
	
	/**
	 * Método que calcula el costo de la estadía multiplicando el precio por noche por la cantidad de noches reservadas.
	 * @return double Costo total;
	 * **/
	public double calcularCosto() {
		return precioPorNoche*cantidadNoches;
	}
	
	/**
	 * Método que genera una cadena con los datos de la habitación.
	 * @return String Cadena con los valores de clave, tipo, ocupación máxima, precio por noche, estado de reservación,
	 * estado de ocupación, cantidad de noches y huésped titular de la habitación.
	 * **/
	@Override
	public String toString() {
		return " Clave: " + clave +
				"\n Tipo: " + tipo +
				"\n Ocupación máxima: " + ocupacionMaxima +
				"\n Precio por noche: $" + precioPorNoche +
				"\n Reservada: " + (reservada ? "Sí" : "No") +
				"\n Ocupada: " + (ocupada ? "Sí" : "No") +
				"\n Cantidad de noches: " + cantidadNoches +
				"\n Huésped titular: " + (huespedTitular == null ? "Sin titular" : huespedTitular);
	}
	
	

}

package proyectoFinalHotel;

/**
 * La clase JardínPrivado hereda de Habitación para crear un tipo específico de cuarto con acceso a un jardín privado.
 * @author Alexa Gavarain
 * @version 1.0
 * **/
public class JardinPrivado extends Habitacion {
	
	private double extraAcceso = 350;

	/**
	 * Constructor que crea la habitación con jardín y la inicializa con los mismos atributos que el constructor de Habitacion.
	 * @param clave Clave de la habitación.
	 * @param ocupacionMaxima Capacidad máxima de la habitación.
	 * @param precioPorNoche Costo por noche de la habitación.
	 * **/
	public JardinPrivado(String clave, int ocupacionMaxima, double precioPorNoche) {
		super("Jardín privado", clave, ocupacionMaxima, precioPorNoche);
	}

	/**
	 * Método para obtener el costo extra que se le aplica a la habitación por tener acceso al jardín privado.
	 * @return extraAcceso Cantidad extra.
	 * **/
	public double getExtraAcceso() {
		return extraAcceso;
	}

	/**
	 * Método para asignar el costo extra que se le aplica a la habitación por tener acceso al jardín privado.
	 * @param extraAcceso Cantidad extra.
	 * **/
	public void setExtraAcceso(double extraAcceso) {
		this.extraAcceso = extraAcceso;
	}

	/**
	 * Método que sobreescribe al de la clase Habitación para añadir el costo extra del acceso al jardín privado al costo total.
	 * @return costo Costo total por la estancia.
	 * **/
	@Override
	public double calcularCosto() {
		double costo = super.calcularCosto();
		costo += extraAcceso;
		return costo;
	}
	
	

}

package proyectoFinalHotel;

/**
 * La clase VistaAlMar hereda de Habitación para crear un tipo específico de cuarto con vista al mar.
 * @author Alexa Gavarain
 * @version 1.0
 * **/
public class VistaAlMar extends Habitacion {
	
	private double extraVista = 400;
	
	/**
	 * Constructor que crea la habitación con vista al mar y la inicializa con los mismos atributos que el constructor de Habitacion.
	 * @param clave Clave de la habitación.
	 * @param ocupacionMaxima Capacidad máxima de la habitación.
	 * @param precioPorNoche Costo por noche de la habitación.
	 * **/
	public VistaAlMar(String clave, int ocupacionMaxima, double precioPorNoche) {
		super("Vista al mar", clave, ocupacionMaxima, precioPorNoche);
	}
	
	/**
	 * Método para obtener el costo extra que se le aplica a la habitación por tener vista al mar.
	 * @return extraVista Cantidad extra.
	 * **/
	public double getExtraVista() {
		return extraVista;
	}

	/**
	 * Método para asignar el costo extra que se le aplica a la habitación por tener vista al mar.
	 * @param extraVista Cantidad extra.
	 * **/
	public void setExtraVista(double extraVista) {
		this.extraVista = extraVista;
	}

	/**
	 * Método que sobreescribe al de la clase Habitación para añadir el costo extra de la habitación con vista al mar al costo total.
	 * @return costo Costo total por la estancia.
	 * **/
	@Override
	public double calcularCosto() {
		double costo = super.calcularCosto();
		costo += extraVista;
		return costo;
	}

}

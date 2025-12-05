package proyectoFinalHotel;

/**
 * La clase Huesped hereda de la clase Persona para crear un objeto que contenga las características de una persona, 
 * además de recibir características extra que le permitan interactuar como un huésped en el sistema de hotel.
 * @author Alexa Gavarain
 * @version 1.0
 * **/
public class Huesped extends Persona {
	
	private String tipoMembresia;
	private Servicio[] serviciosContratados;
	
	/**
	 * Constructor que inicializa Huesped con todos los atributos de Persona, además de recibir 
	 * y asignar el tipo de membresía e inicializar un arreglo de servicios contratados por el huésped.
	 * @param nombre Nombre.
	 * @param edad Edad.
	 * @param telefono Número de teléfono.
	 * @param email Correo electrónico.
	 * @param tipoMembresia Tipo de membresía del huésped.
	 * **/
	public Huesped(String nombre, int edad, String telefono, String email, String tipoMembresia) {
		super(nombre, edad, telefono, email);
		this.tipoMembresia = tipoMembresia;
		serviciosContratados = new Servicio[100];
	}
	
	/**
	 * Método para obtener el tipo de membresía del huésped.
	 * @return tipoMembresia Tipo de membresía.
	 * **/
	public String getTipoMembresia() {
		return tipoMembresia;
	}

	/**
	 * Método para asignar el tipo de membresía del huésped.
	 * @param tipoMembresia Tipo de membresía.
	 * **/
	public void setTipoMembresia(String tipoMembresia) {
		this.tipoMembresia = tipoMembresia;
	}

	/**
	 * Método para obtener el arreglo de servicios contratados por el huésped.
	 * @return serviciosContratados Arreglo de servicios contratados.
	 * **/
	public Servicio[] getServiciosContratados() {
		return serviciosContratados;
	}

	/**
	 * Método para asignar el arreglo de servicios contratados por el huésped.
	 * @param serviciosContratados Arreglo de servicios contratados.
	 * **/
	public void setServiciosContratados(Servicio[] serviciosContratados) {
		this.serviciosContratados = serviciosContratados;
	}
	
	/**
	 * Método que calcula el porcentaje de descuento que se aplicará al huesped al hacer check-out 
	 * en base a su tipo de membresía.
	 * @return double Porcentaje de descuento.
	 * **/
	public double porcentajeDescuento() {
		if (tipoMembresia.equalsIgnoreCase("VIP")) {
			return 0.15;
		}
		if (tipoMembresia.equalsIgnoreCase("CF")) {
			return 0.1;
		}
		return 0;
	}
	
	/**
	 * Método que permite añadir un objeto de tipo Servicio diferente de null al arreglo de servicios contratados 
	 * por el huésped, y aumenta la cantidad de servicios contratados.
	 * @param servicio Servicio que se contratará.
	 * @return boolean Si se pudo contratar o no.
	 * **/
	public boolean contratarServicio(Servicio servicio) {
		for (int i = 0; i < serviciosContratados.length; i++) {
			if (serviciosContratados[i] == null) {
				serviciosContratados[i] = servicio;
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Método que devuelve la suma de los costos de todos los servicios contratados por el huésped.
	 * @return double Costo total por los servicios.
	 * **/
	public double calcularCostoServicios() {
		double total = 0;
		for (int i = 0; i < serviciosContratados.length; i++) {
			if (serviciosContratados[i] != null) {
				total += serviciosContratados[i].getCosto();
			}
		}
		return total;
	}
	
	/**
	 * Método que permite imprimir la lista de servicios contratados por el huésped.
	 * @return String String que contiene la información de cada servicio.
	 * **/
	public String mostrarServiciosContratados() {
	    String resultado = "";
	    for (int i = 0; i < serviciosContratados.length; i++) {
	        if (serviciosContratados[i] != null) {
	            resultado += serviciosContratados[i].toString() + " | ";
	        }
	    }
	    return resultado;
	}
	
	/**
	 * Método para comparar el nombre, correo electrónico y edad de el huésped con la de otro, 
	 * para determinar si son la misma persona.
	 * @param huespedBuscar Huésped que se quiere comparar.
	 * @return boolean Si son la misma persona o no.
	 * **/
	public boolean comparar(Huesped huespedBuscar) {
		return nombre.equals(huespedBuscar.getNombre()) 
				&& email.equals(huespedBuscar.getEmail()) 
				&& edad == huespedBuscar.getEdad();
	}

	/**
	 * Método que devuelve toda la información del huésped.
	 * @return String Cadena que contiene el nombre, edad, número de teléfono, tipo de membresía 
	 * y la lista de servicios contratados por el huésped.
	 * **/
	@Override
	public String toString() {
		return  "Nombre: " + nombre +
				"\n Edad: " + edad + 
				"\n Teléfono: " + telefono +
				"\n Email: " + email +
				"\n Membresía: " + tipoMembresia + 
				"\n Servicios: " + mostrarServiciosContratados();		
	}
	
}

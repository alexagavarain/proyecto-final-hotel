package proyectoFinalHotel;

/**
 * La clase Hotel representa un hotel real mediante una matriz de objetos de tipo Habitacion. Se encarga de
 * administrar las funciones básicas de un hotel (reservas, registros, ingresos, etc).
 * @author Alexa Gavarain
 * @version 1.0
 * **/
public class Hotel {
	
	private Habitacion[][] habitaciones;
	private Huesped[] registroHuespedes;
	private double ingresosHabitaciones = 0;
	private double ingresosServicios = 0;
	private double ingresosTotales = 0;
		
	/**
	 * Constructor que se encarga de inicializar la matriz de habitaciones y llenarla, 
	 * además de inicializar el arreglo de registro de huéspedes.
	 * **/
	public Hotel() {
		habitaciones = new Habitacion[4][5];
		registroHuespedes = new Huesped[2000];
		habitaciones[0][0] = new VistaAlberca("A1", 10, 3000);
		habitaciones[0][1] = new VistaAlberca("A2", 3, 2000);
		habitaciones[0][2] = new VistaAlberca("A3", 2, 1800);
		habitaciones[0][3] = new VistaAlberca("A4", 5, 2500);
		habitaciones[0][4] = new VistaAlberca("A5", 10, 3000);
		
		habitaciones[1][0] = new JardinPrivado("B1", 10, 2500);
		habitaciones[1][1] = new JardinPrivado("B2", 8, 2300);
		habitaciones[1][2] = new JardinPrivado("B3", 5, 2000);
		habitaciones[1][3] = new JardinPrivado("B4", 2, 1700);
		habitaciones[1][4] = new JardinPrivado("B5", 2, 1700);
		
		habitaciones[2][0] = new VistaAlMar("C1", 2, 2800);
		habitaciones[2][1] = new VistaAlMar("C2", 3, 3000);
		habitaciones[2][2] = new VistaAlMar("C3", 5, 3400);
		habitaciones[2][3] = new VistaAlMar("C4", 8, 3800);
		habitaciones[2][4] = new VistaAlMar("C5", 2, 2800);
		
		habitaciones[3][0] = new Terraza("D1", 2, 1900);
		habitaciones[3][1] = new Terraza("D2", 3, 2100);
		habitaciones[3][2] = new Terraza("D3", 5, 2500);
		habitaciones[3][3] = new Terraza("D4", 8, 3000);
		habitaciones[3][4] = new Terraza("D5", 10, 3400);
	}
	
	/**
	 * Método para obtener la matriz de habitaciones.
	 * @return habitaciones Matriz de habitaciones.
	 * **/
	public Habitacion[][] getHabitaciones() {
	    return habitaciones;
	}
	
	/**
	 * Método para asignar la matriz de habitaciones.
	 * @param habitaciones Matriz de habitaciones.
	 * **/
	public void setHabitaciones(Habitacion[][] habitaciones) {
	    this.habitaciones = habitaciones;
	}

	/**
	 * Método para obtener el arreglo de registro de huéspedes.
	 * @return registroHuespedes Arreglo de registro de huépedes.
	 * **/
	public Huesped[] getRegistroHuespedes() {
		return registroHuespedes; 
	}
	
	/**
	 * Método para asignar el arreglo de registro de huéspedes.
	 * @param registroHuespedes Arreglo de registro de huépedes.
	 * **/
	public void getRegistroHuespedes(Huesped[] registroHuespedes) {
		this.registroHuespedes = registroHuespedes; 
	}

	/**
	 * Método para obtener los ingresos generados por las habitaciones.
	 * @return ingresosHabitaciones Ingresos de las habitaciones.
	 * **/
	public double getIngresosHabitaciones() {
	    return ingresosHabitaciones;
	}
	
	/**
	 * Método para asignar los ingresos generados por las habitaciones.
	 * @param ingresosHabitaciones Ingresos de las habitaciones.
	 * **/
	public void setIngresosHabitaciones(double ingresosHabitaciones) {
		this.ingresosHabitaciones = ingresosHabitaciones;
	}

	/**
	 * Método para obtener los ingresos generados por los servicios.
	 * @return ingresosServicios Ingresos de los servicios.
	 * **/
	public double getIngresosServicios() {
	    return ingresosServicios;
	}
	
	/**
	 * Método para obtener los ingresos generados por los servicios.
	 * @param ingresosServicios Ingresos de los servicios.
	 * **/
	public void setIngresosServicios(double ingresosServicios) {
		this.ingresosServicios = ingresosServicios;
	}

	/**
	 * Método para obtener los ingresos totales generados por el hotel.
	 * @return ingresosTotales Ingresos totales del hotel.
	 * **/
	public double getIngresosTotales() {
		return ingresosTotales;
	}

	/**
	 * Método para asignar los ingresos totales generados por el hotel.
	 * @param ingresosTotales Ingresos totales del hotel.
	 * **/
	public void setIngresosTotales(double ingresosTotales) {
		this.ingresosTotales = ingresosTotales;
	}
	
	/**
	 * Método para imprimir el registro de huéspedes.
	 * **/
	public void verRegistroHuespedes() {
		for (int i = 0; i < registroHuespedes.length; i++) {
			if (registroHuespedes[i] != null) {
				System.out.println(registroHuespedes[i].toString() + "\n");
			}
		}
	}
	
	/**
	 * Método para confirmar que un huésped es el titular de una habitación. 
	 * Recorre las habitaciones del hotel y aplica el método de la clase huésped comparar() para verificar
	 * que el titular y el huésped ingresados sean la misma persona.
	 * @param huesped Huésped que se desea comparar.
	 * @param clave Clave de la habitación.
	 * @return boolean Si el huésped es el titular o no.
 	 * **/
	public boolean confirmarHuesped(Huesped huesped, String clave) {
		Habitacion habitacion = buscarHabitacion(clave);
		if (habitacion != null && habitacion.getHuespedTitular() != null) {
			return habitacion.getHuespedTitular().comparar(huesped);
		}
		return false;
	}
	
	/**
	 * Método que busca una habitación recorriendo el hotel hasta dar con la clave ingresada.
	 * @param clave Clave de la habitación buscada.
	 * @return Habitacion Habitación encontrada.
	 * **/
	public Habitacion buscarHabitacion(String clave) {
		for (int i = 0; i < habitaciones.length; i++) {
			for (int j = 0; j < habitaciones[i].length; j++) {
				if (habitaciones[i][j] != null && habitaciones[i][j].getClave().equalsIgnoreCase(clave)) {
					return habitaciones[i][j];
				}
			}
		}
		return null;
	}
	
	/**
	 * Método que busca un huésped recorriendo las habitaciones hasta encontrar un titular con el mismo nombre.
	 * @param nombre Nombre del huésped buscado.
	 * @return huesped Huésped encontrado.
	 * **/
	public Huesped buscarHuesped(String nombre) {
	    for (int i = 0; i < habitaciones.length; i++) {
	        for (int j = 0; j < habitaciones[i].length; j++) {
	        	if (habitaciones[i][j] != null) {
		            Huesped huesped = habitaciones[i][j].getHuespedTitular();
		            if (huesped != null && huesped.getNombre().equalsIgnoreCase(nombre)) {
							return huesped;
					}
	        	}
	        }
	    } 
	    return null;
	}
	
	/**
	 * Método que se utiliza para buscar a un huésped por nombre en todas las habitaciones y devolver un arreglo con todas las coindicencias.
	 * @param nombre Nombre del huésped buscado
	 * @return huespedesEncontrados Arreglo con todos los huéspedes con el nombre ingresado. 
	 * **/
	public Huesped[] buscadorHuespedes(String nombre) {
		int numHuespedes = 0;
		
		for (int i = 0; i < habitaciones.length; i++) {
			for (int j = 0; j < habitaciones[i].length; j++) {
				if (habitaciones[i][j] != null) {
		            if (habitaciones[i][j].getHuespedTitular() != null && 
		            	habitaciones[i][j].getHuespedTitular().getNombre().equalsIgnoreCase(nombre)) {
		                numHuespedes++;
		            }
				}
			}
		}
		
		Huesped[] huespedesEncontrados = new Huesped[numHuespedes];
		int index = 0;
		
	    for (int i = 0; i < habitaciones.length; i++) {
	        for (int j = 0; j < habitaciones[i].length; j++) {
	        	if (habitaciones[i][j] != null) {
		            Huesped huesped = habitaciones[i][j].getHuespedTitular();
		            if (huesped != null && huesped.getNombre().equalsIgnoreCase(nombre)) {
						huespedesEncontrados[index++] = huesped;
					}
	        	}
	        }
	    } 
	    return huespedesEncontrados;
	}

	/**
	 * Método para reservar una habitación de hotel que valida que la habitación no esté reservada antes de llamar al 
	 * método reservar() de la clase habitación y al método agregarHuesped() para añadirlo al registro.
	 * @param huesped Huésped que desea reservar.
	 * @param clave Clave de la habitación.
	 * @param cantidadHuespedes Cantidad de personas que se van a hospedar.
	 * @param cantidadNoches Cantidad de noches que se van a hospedar.
	 * @return boolean Si se logró reservar.
	 * **/
	public boolean reservarHabitacion(Huesped huesped, String clave, int cantidadHuespedes, int cantidadNoches) {
		Habitacion habitacion = buscarHabitacion(clave);
		
		if (habitacion != null && !habitacion.isReservada()) {
			if (habitacion.reservar(huesped, cantidadHuespedes, cantidadNoches)) {
				agregarHuesped(huesped);
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Método que agrega un huésped al registro de huéspedes al reservar. Valida que el huésped no sea titular
	 * de otra habitación para no añadirlo dos veces.
	 * @param huesped Huésped que se va a agregar.
	 * @return boolean Si se agregó el huesped.
	 * **/
	public boolean agregarHuesped(Huesped huesped) {	
		for (int i = 0; i < registroHuespedes.length; i++) {
			if (registroHuespedes[i] != null && registroHuespedes[i].comparar(huesped)) {
				return true;
			}
		}
		
		for (int i = 0; i < registroHuespedes.length; i++) {
			if (registroHuespedes[i] == null) {
				registroHuespedes[i] = huesped;
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Método para hacer check-in en la habitación mediante método de la clase habitación ocupar(). Valida que la habitación exista y que haya sido reservada previamente.
	 * @param huesped Huésped que desea hacer check-in.
	 * @param clave Clave de la habitación.
	 * @return boolean Si se pudo hacer check-in.
	 * **/
	public boolean checkIn(Huesped huesped, String clave) {
		Habitacion habitacion = buscarHabitacion(clave);

		if (habitacion != null && habitacion.isReservada()) {
			return habitacion.ocupar(huesped);
		}
		return false;
	}
	
	/**
	 * Método para hacer check-out en la habitación. Valida que la habitación exista, que haya sido previamente ocupada y
	 * que el huésped ingresado sea titular. Aplica el método cobrar() y, si regresa true, aplica el método de la clase Habitación 
	 * desocupar() y, finalmente, eliminarHuéspedRegistro() para eliminar al huésped del registro.
	 * @param huesped Huésped que desea hacer check-out.
	 * @param clave Clave de la habitación.
	 * @return boolean Si se pudo hacer check-out.
	 * **/
	public boolean checkOut(Huesped huesped, String clave) {
		Habitacion habitacion = buscarHabitacion(clave);

		if (habitacion != null && habitacion.isOcupada() && confirmarHuesped(huesped, clave)) {
			if(cobrar(huesped, clave) != -1) {	
				boolean desocupado = habitacion.desocupar(huesped);
				if (desocupado) {
					eliminarHuespedRegistro(huesped);
				}
				return desocupado;
			}
		}
		return false;
	}
	
	/**
	 * Método para imprimir la matriz de habitaciones que muestra una X si la habitación no está disponible.
	 * **/
	public void verDisponibilidad() {
		for (int i = 0; i < habitaciones.length; i++) {
			for (int j = 0; j < habitaciones[i].length; j++) {
				System.out.print("[");
				if (habitaciones[i][j].isReservada()) {
					System.out.print("X");
				} else {
					System.out.print(" ");
				}
				System.out.print("]");
			}
			System.out.println("");
		}
	}
	
	/**
	 * Método para calcular el costo total de la estadía, considerando el costo de la habitación, los servicios contratados y los descuentos por membresía.
	 * Además, añade los ingresos el los atributos ingresosHabitaciones, ingresosServicios e ingresosTotales para llevar registro de los ingresos
	 * del hotel.
	 * @param huesped Huésped al que se le va a cobrar.
	 * @param clave Clave de la habitación.
	 * @param total Costo total de la estadía.
	 * **/
	public double cobrar(Huesped huesped, String clave) {
		Habitacion habitacion = buscarHabitacion(clave);

	    if (habitacion == null || !confirmarHuesped(huesped, clave)) {
	        return -1;
	    }

	    double costoHab = habitacion.calcularCosto();
	    double costoServ = huesped.calcularCostoServicios();

	    double total = costoHab + costoServ;
	    total -= (total * huesped.porcentajeDescuento());

	    ingresosHabitaciones += costoHab;
	    ingresosServicios += costoServ;
	    ingresosTotales += total;

	    return total;
	}

	/**
	 * Método para eliminar a un huésped del registro de huéspedes. Valida que ya no exista ninguna habitación a su nombre.
	 * @param huesped Huésped que se va a eliminar.
	 * **/
	public void eliminarHuespedRegistro(Huesped huesped) {
		boolean habitacionASuNombre = false;
		for (int i = 0; i < habitaciones.length; i++) {
			for (int j = 0; j < habitaciones[i].length; j++) {
				if (habitaciones[i][j] != null && habitaciones[i][j].getHuespedTitular() != null
					&& habitaciones[i][j].getHuespedTitular().comparar(huesped)) {
					habitacionASuNombre = true;
					break;
				}
			}
		}
		
		if (!habitacionASuNombre) {
			for (int i = 0; i < registroHuespedes.length; i++) {
				if (registroHuespedes[i] != null && registroHuespedes[i].comparar(huesped)) {
					registroHuespedes[i] = null;
					break;
				}
			}
		}	
	}

}

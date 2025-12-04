package proyectoFinalHotel;

public class Hotel {
	
	private Habitacion[][] habitaciones = new Habitacion[4][5];
	private Huesped[] registroHuespedes = new Huesped[2000];;
	private double ingresosHabitaciones = 0;
	private double ingresosServicios = 0;
	private double ingresosTotales = 0;
	
	//Llenar hotel de habitaciones
	public Hotel() {
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
	
	public Habitacion[][] getHabitaciones() {
	    return habitaciones;
	}

	public Huesped[] getRegistroHuespedes() {
		return registroHuespedes; 
	}

	public double getIngresosHabitaciones() {
	    return ingresosHabitaciones;
	}

	public double getIngresosServicios() {
	    return ingresosServicios;
	}

	public double getIngresosTotales() {
		return ingresosTotales;
	}

	public void setIngresosTotales(double ingresosTotales) {
		this.ingresosTotales = ingresosTotales;
	}
	
	//Imprimir arreglo de registro
	public void verRegistroHuespedes() {
		for (int i = 0; i < registroHuespedes.length; i++) {
			if (registroHuespedes[i] != null) {
				System.out.println(registroHuespedes[i].toString() + "\n");
			}
		}
	}
	
	//Confirma que el huesped si es el titular de la habitacion
	public boolean confirmarHuesped(Huesped huesped, String clave) {
		Habitacion habitacion = buscarHabitacion(clave);
		if (habitacion != null && habitacion.getHuespedTitular() != null) {
			return habitacion.getHuespedTitular().comparar(huesped);
		}
		return false;
	}
	
	//Busca una habitacion por clave en la matriz del hotel
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
	
	//Busca un huesped por nombre y regresa el objeto tipo Huesped
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
	
	//Busca a los huespedes por nombre y regresa un arreglo que contiene todas las coincidencias
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

	public boolean reservarHabitacion(Huesped huesped, String clave, int cantidadHuespedes, int cantidadNoches) {
		Habitacion habitacion = buscarHabitacion(clave);
		
		if (habitacion != null && !habitacion.isReservada()) {
			if (agregarHuesped(huesped) && habitacion.reservar(huesped, cantidadHuespedes, cantidadNoches)) {
				return true;
			}
		}
		return false;
	}
	
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
	
	public boolean checkIn(Huesped huesped, String clave) {
		Habitacion habitacion = buscarHabitacion(clave);

		if (habitacion != null && habitacion.isReservada()) {
			return habitacion.ocupar(huesped);
		}
		return false;
	}
	
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

	public void eliminarHuespedRegistro(Huesped huesped) {
		boolean habitacionASuNombre = false;
		for (int i = 0; i < habitaciones.length; i++) {
			for (int j = 0; j < habitaciones[i].length; j++) {
				if (habitaciones[i][j] != null && habitaciones[i][j] != null
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

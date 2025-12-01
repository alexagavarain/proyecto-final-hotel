package proyectoFinalHotel;

public class Hotel {
	
	private Habitacion[][] habitaciones = new Habitacion[4][5];
	private Huesped[] registroHuespedes = new Huesped[20];;
	private int habitacionesOcupadas;
	
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
	
	public int getHabitacionesOcupadas() {
		return habitacionesOcupadas;
	}

	public void setHabitacionesOcupadas(int habitacionesOcupadas) {
		this.habitacionesOcupadas = habitacionesOcupadas;
	}
	
	public void verRegistroHuespedes() {
		for (int i = 0; i < registroHuespedes.length; i++) {
			if (registroHuespedes[i] != null)
			System.out.println(registroHuespedes[i].toString() + "\n");
		}
	}
	
	public Huesped buscarHuesped(String nombre) {
		for (int i = 0; i < habitaciones.length; i++) {
			for (int j = 0; j < habitaciones[i].length; j++) {
				if (habitaciones[i][j].getHuespedTitular().getNombre().equalsIgnoreCase(nombre)) {
					return habitaciones[i][j].getHuespedTitular();
				}
			}
		}
		return null;
	}
	
	public Habitacion buscarHabitacion(String clave) {
		for (int i = 0; i < habitaciones.length; i++) {
			for (int j = 0; j < habitaciones[i].length; j++) {
				if (habitaciones[i][j].getClave().equalsIgnoreCase(clave)) {
					return habitaciones[i][j];
				}
			}
		}
		return null;
	}

	public boolean reservarHabitacion(Huesped huesped, String clave, int cantidadHuespedes, int cantidadNoches) {
		for (int i = 0; i < habitaciones.length; i++) {
			for (int j = 0; j < habitaciones[i].length; j++) {
				if (habitaciones[i][j].getClave().equals(clave) && !habitaciones[i][j].isReservada()) {
					habitaciones[i][j].reservar(huesped, cantidadHuespedes, cantidadNoches);
					registroHuespedes[habitacionesOcupadas] = huesped;
					habitacionesOcupadas++;
					return true;
				}
			}
		}
		return false;
	}
	
	public boolean checkIn(Huesped huesped, String clave) {
		if (buscarHuesped(huesped.getNombre()) != null) {
			for (int i = 0; i < habitaciones.length; i++) {
				for (int j = 0; j < habitaciones[i].length; j++) {
					if (habitaciones[i][j].getHuespedTitular().getNombre().equals(huesped.getNombre()) && habitaciones[i][j].getClave().equals(clave)) {
						habitaciones[i][j].ocupar();
						return true;
					}
				}
			}
		}	
		return false;
	}
	
	public boolean checkOut(Huesped huesped, String clave) {
		if (buscarHuesped(huesped.getNombre()) != null) {
			for (int i = 0; i < habitaciones.length; i++) {
				for (int j = 0; j < habitaciones[i].length; j++) {
					if (habitaciones[i][j].isOcupada() && habitaciones[i][j].getHuespedTitular().getNombre().equals(huesped.getNombre()) && habitaciones[i][j].getClave().equals(clave)) {
						habitaciones[i][j].desocupar();
						return true;
					}
				}
			}
		}	
		return false;
	}
	
	public void verDisponibilidad() {
		for (int i = 0; i < habitaciones.length; i++) {
			for (int j = 0; j < habitaciones.length; j++) {
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
	
	public double cobrar(String nombre, String clave) {
		Huesped huesped = buscarHuesped(nombre);
		Habitacion habitacion = buscarHabitacion(clave);
		double total = 0;
		if (huesped != null && habitacion.getHuespedTitular().getNombre().equalsIgnoreCase(nombre)) {
			total += habitacion.calcularCosto() + huesped.calcularCostoServicios();
			total -= (total*huesped.porcentajeDescuento());
			return total;
		}
		return 17;
	}
	
	public void verIngresosTotales() {
		double totalTerraza = 0;
		double totalJardinPrivado = 0;
		double totalVistalAlberca = 0;
		double totalVistaAlMar = 0;
		double totalServicios = 0;
		
		for (int i = 0; i < habitaciones.length; i++) {
			for (int j = 0; j < habitaciones[i].length; j++) {
				if (habitaciones[i][j].isReservada()) {
					if (i == 0) {
						totalVistalAlberca += cobrar(habitaciones[i][j].getHuespedTitular().getNombre(), habitaciones[i][i].getClave());
					}
					if (i == 1) {
						totalJardinPrivado += habitaciones[i][j].calcularCosto();
					}
					if (i == 2) {
						totalVistaAlMar += habitaciones[i][j].calcularCosto();
					}
					if (i == 3) {
						totalTerraza += habitaciones[i][j].calcularCosto();
					}
					totalServicios += habitaciones[i][j].getHuespedTitular().calcularCostoServicios();
				}
			}
		}
		System.out.println("HABITACIONES\n Vista alberca: " + totalVistalAlberca +
							"\n Jardin privado: " + totalJardinPrivado +
							"\n Vista al mar: " + totalVistaAlMar +
							"\n Terraza: " + totalTerraza +
							"\n\nSERVICIOS\n " + totalServicios);
	}
	
	public Habitacion[][] getHabitaciones() {
	    return habitaciones;
	}

	public Huesped[] getRegistroHuespedes() {
		return registroHuespedes; 
	}

	

}

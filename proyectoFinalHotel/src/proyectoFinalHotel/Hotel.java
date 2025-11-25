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
			System.out.println(registroHuespedes.toString() + "\n");
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
	

	public boolean reservarHabitacion(Huesped huesped, Habitacion habitacion, int cantidadHuespedes, int cantidadNoches) {
		for (int i = 0; i < habitaciones.length; i++) {
			for (int j = 0; j < habitaciones[i].length; j++) {
				if (!habitaciones[i][j].isReservada()) {
					habitaciones[i][j].reservar(huesped, cantidadHuespedes, cantidadNoches);
					registroHuespedes[habitacionesOcupadas] = huesped;
					habitacionesOcupadas++;
					return true;
				}
			}
		}
		return false;
	}
	
//	public int buscarHabitacion(Habitacion habitacion) {
//		for (int i = 0; i < habitaciones.length; i++) {
//			for (int j = 0; j < habitaciones[i].length; j++) {
//				if (habitaciones[i][j].getClave().equals(habitacion.getClave())) {
//					return i;
//				}
//			}
//		}
//		return -1;
//	}
	
//	public boolean checkIn(Huesped huesped, Habitacion habitacion) {
//		if (buscarHuesped(huesped.getNombre()) != null) {
//			
//			for (int i = 0; i < habitaciones.length; i++) {
//				for (int j = 0; j < habitaciones[i].length; j++) {
//					if (habitaciones[i][j].getClave().equals(habitacion.getClave())) {
//						
//					}
//				}
//			}
//			
//		}
//	}

}

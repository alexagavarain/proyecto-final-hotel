package proyectoFinalHotel;

public class Huesped extends Persona {
	
	private String tipoMembresia;
	private Servicio[] serviciosContratados;
	private int numServicios;
	
	public Huesped(String nombre, int edad, String telefono, String email, String tipoMembresia) {
		super(nombre, edad, telefono, email);
		this.tipoMembresia = tipoMembresia;
		
		serviciosContratados = new Servicio[100];
	}
	
	public String getTipoMembresia() {
		return tipoMembresia;
	}

	public void setTipoMembresia(String tipoMembresia) {
		this.tipoMembresia = tipoMembresia;
	}

	public Servicio[] getServiciosContratados() {
		return serviciosContratados;
	}

	public void setServiciosContratados(Servicio[] serviciosContratados) {
		this.serviciosContratados = serviciosContratados;
	}

	public int getNumServicios() {
		return numServicios;
	}

	public void setNumServicios(int numServicios) {
		this.numServicios = numServicios;
	}
	
	public double porcentajeDescuento() {
		if (tipoMembresia.equalsIgnoreCase("VIP")) {
			return 0.15;
		}
		if (tipoMembresia.equalsIgnoreCase("CF")) {
			return 0.1;
		}
		return 0;
	}
	
	public boolean contratarServicio(Servicio servicio) {
		for (int i = 0; i < serviciosContratados.length; i++) {
			if (serviciosContratados[i] == null) {
				serviciosContratados[i] = servicio;
				numServicios++;
				return true;
			}
		}
		return false;
	}
	
	public double calcularCostoServicios() {
		double total = 0;
		for (int i = 0; i < serviciosContratados.length; i++) {
			if (serviciosContratados[i] != null) {
				total += serviciosContratados[i].getCosto();
			}
		}
		return total;
	}
	
	public String mostrarServiciosContratados() {
	    String resultado = "";

	    for (int i = 0; i < serviciosContratados.length; i++) {
	        if (serviciosContratados[i] != null) {
	            resultado += serviciosContratados[i].toString() + " | ";
	        }
	    }

	    return resultado;
	}
	
	public boolean comparar(Huesped huespedBuscar) {
		return nombre.equals(huespedBuscar.getNombre()) && email.equals(huespedBuscar.getEmail()) && edad == huespedBuscar.getEdad();
	}

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

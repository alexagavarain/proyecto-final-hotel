package proyectoFinalHotel;

public class Huesped extends Persona {
	
	String tipoMembresia;
	Servicio[] serviciosContratados;
	int numServicios;
	
	public Huesped() {
	}
	
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
		if (numServicios < 100) {
			for (int i = 0; i < serviciosContratados.length; i++) {
				if (serviciosContratados[i] == null) {
					serviciosContratados[i] = servicio;
					numServicios++;
					return true;
				}
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
	
	public void mostrarServiciosContratados() {
		for (int i = 0; i < serviciosContratados.length; i++) {
			if (serviciosContratados[i] != null) {
				System.out.println(serviciosContratados[i].toString());
			}
		}
	}
	
	//TODO toString
}

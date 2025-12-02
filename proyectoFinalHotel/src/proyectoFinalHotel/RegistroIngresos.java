package proyectoFinalHotel;

public class RegistroIngresos {
	
	Ingreso[] registro;
	int numeroIngreso = 0;

	
	public RegistroIngresos() {
		registro = new Ingreso[2000];
	}
	
	public void registrarCobro(Ingreso ingreso) {
		registro[numeroIngreso] = ingreso;
		numeroIngreso ++;
	}
	
	public void imprimirRegistro() {
		for (int i = 0; i < registro.length; i++) {
			if (registro[i] != null) {
				System.out.println(registro[i].toString());
			}
		}
	}

	
	

}

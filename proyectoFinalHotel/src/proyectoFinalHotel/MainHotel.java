package proyectoFinalHotel;

public class MainHotel {
	public static void main(String[] args) {
		
		Huesped huesped = new Huesped("Alexa", 19, "612", "gmail", "VIP");
		
		Huesped noHuesped = new Huesped();
		System.out.println(noHuesped);
		
		Habitacion habitacion= new Terraza("D44", 10, 1500);
		System.out.println(habitacion);
		
		System.out.println(habitacion.reservar(huesped, 12, 5));
		System.out.println(habitacion.ocupar());
//		System.out.println(habitacion.desocupar());
		
		System.out.println(habitacion);
		
	}
}

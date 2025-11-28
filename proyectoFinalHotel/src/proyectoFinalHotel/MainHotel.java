package proyectoFinalHotel;

public class MainHotel {
	public static void main(String[] args) {
		
		Huesped huesped = new Huesped("Alexa", 19, "612", "gmail", "VIP");
		Huesped huesped2 = new Huesped("Alexo", 19, "612", "gmail", "VIP");
//		
//		Huesped noHuesped = new Huesped();
//		System.out.println(noHuesped);
//		
		Habitacion habitacion= new Terraza("D44", 10, 1500);
//		System.out.println(habitacion);
//		
//		System.out.println(habitacion.reservar(huesped, 12, 5));
//		System.out.println(habitacion.ocupar());
////		System.out.println(habitacion.desocupar());
//		
//		System.out.println(habitacion);
		
		Hotel hotel = new Hotel();
		
		
		System.out.println(hotel.reservarHabitacion(huesped, "A2", 1, 1));
		System.out.println(hotel.checkIn(huesped, "A2"));
		
		System.out.println(huesped.contratarServicio(new Servicio("Baño", 300)));
		
		System.out.println(hotel.cobrar("Alexa", "A2"));
		hotel.verIngresosTotales();

		
		
	}
}

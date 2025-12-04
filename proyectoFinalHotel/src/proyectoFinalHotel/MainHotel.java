package proyectoFinalHotel;

import java.util.Scanner;

public class MainHotel {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        Hotel miHotel = new Hotel();

        boolean salir = false;

        while(!salir) {
            System.out.println("\n==== MENÚ DEL HOTEL ====");
            System.out.println("1. Ver registro de huéspedes");
            System.out.println("2. Buscar huésped");
            System.out.println("3. Reservar habitación");
            System.out.println("4. Check-in");
            System.out.println("5. Check-out");
            System.out.println("6. Ver disponibilidad");
            System.out.println("7. Ver ingresos totales");
            System.out.println("8. Salir");
            System.out.print("Elige una opción: ");

            int opcion = in.nextInt();
            in.nextLine(); 

            switch(opcion) {

                case 1:
                    miHotel.verRegistroHuespedes();
                    break;

                case 2:
                    System.out.print("Ingresa nombre o email del huésped: ");
                    String dato = in.nextLine();
                    Huesped huespedEncontrado = miHotel.buscarHuesped(dato);
                    if(huespedEncontrado != null)
                        System.out.println("Huesped encontrado:\n" + huespedEncontrado);
                    else
                        System.out.println("No existe un huésped con esos datos.");
                    break;

                case 3:
                    System.out.println("=== Reservar habitación ===");
                    System.out.print("Nombre del huésped: ");
                    String nombre = in.nextLine();

                    System.out.print("Edad: ");
                    int edad = in.nextInt(); 
                    in.nextLine();

                    System.out.print("Teléfono: ");
                    String tel = in.nextLine();

                    System.out.print("Email: ");
                    String email = in.nextLine();
                    
                    System.out.print("Cantidad de personas: ");
                    int cantidadPersonas = in.nextInt(); 
                    in.nextLine();
                    
                    System.out.print("Cantidad de noches: ");
                    int cantidadNoches = in.nextInt(); 
                    in.nextLine();

                    System.out.print("Tipo de membresía (VIP / Cliente frecuente / Ninguna): ");
                    String tipoMembresia = in.nextLine();

                    Huesped nuevoHuesped = new Huesped(nombre, edad, tel, email, tipoMembresia);

                    System.out.println("Ingresa clave de habitación (P1-P4): ");
                    String clave = in.nextLine();

                    Habitacion miHabitacion = miHotel.buscarHabitacion(clave);

                    if(miHabitacion != null) {
                        if(miHotel.reservarHabitacion( nuevoHuesped,clave, cantidadPersonas, cantidadNoches))
                            System.out.println("Habitación reservada con éxito.");
                        else
                            System.out.println("No se pudo reservar.");
                    } else {
                        System.out.println("La habitación no existe.");
                    }
                    break;

                case 4:
                    System.out.println("=== Check-in ===");
                    System.out.print("Email del huésped: ");
                    String emailIngresa = in.nextLine();

                    Huesped llegaHuesped = miHotel.buscarHuesped(emailIngresa);

                    if(llegaHuesped == null) {
                        System.out.println("Huésped no registrado o sin reserva.");
                        break;
                    }

                    System.out.print("Clave de habitación: ");
                    String claveLlega = in.nextLine();

                    Habitacion habitacionLlegada = miHotel.buscarHabitacion(claveLlega);

                    if(miHotel.checkIn(llegaHuesped, claveLlega))
                        System.out.println("Check-in realizado.");
                    else
                        System.out.println("No se pudo realizar check-in.");
                    break;

                case 5:
                    System.out.println("=== Check-out ===");
                    System.out.print("Email del huésped: ");
                    String emailSeVa = in.nextLine();

                    Huesped seVaHuesped = miHotel.buscarHuesped(emailSeVa);

                    if(seVaHuesped == null) {
                        System.out.println("Huésped no registrado.");
                        break;
                    }

                    System.out.print("Clave de habitación: ");
                    String claveSeVa = in.nextLine();

                    Habitacion habOut = miHotel.buscarHabitacion(claveSeVa);

                    if(miHotel.checkOut(seVaHuesped, claveSeVa)) {
                        System.out.println("Check-out correcto.");
                    		System.out.println(miHotel.cobrar(seVaHuesped, claveSeVa));
                    }
                    else {
                        System.out.println("No se pudo realizar check-out.");
                    }
                    break;

                case 6:
                    miHotel.verDisponibilidad();
                    break;

                case 7:
//                	miHotel.verIngresosTotales();
                    break;

                case 8:
                    salir = true;
                    System.out.println("Saliendo del programa...");
                    break;

                default:
                    System.out.println("Opción no válida.");
            }
        }

        in.close();
    }
}

	
	
	


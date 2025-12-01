package proyectoFinalHotel;

import javax.swing.*;
import java.awt.Color;

public class VentanaIngresos  extends JFrame {

    private Hotel hotel;
    private JTextArea area;

    public VentanaIngresos(Hotel hotel) {
    	getContentPane().setBackground(new Color(255, 128, 128));
        this.hotel = hotel;

        setTitle("Ingresos del Hotel");
        setSize(500, 400);
        setLocationRelativeTo(null);
        getContentPane().setLayout(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        area = new JTextArea();
        area.setBackground(new Color(255, 128, 128));
        area.setEditable(false);
        JScrollPane scroll = new JScrollPane(area);
        scroll.setBounds(30, 30, 430, 300);
        getContentPane().add(scroll);

        mostrarIngresos();

        setVisible(true);
    }

    private void mostrarIngresos() {
        double totalHabitaciones = 0;
        double totalServicios = 0;

        Habitacion[][] habs = hotel.getHabitaciones();

        for (int i = 0; i < habs.length; i++) {
            for (int j = 0; j < habs[i].length; j++) {
                Habitacion h = habs[i][j];
                if (h == null) continue;

                // sumar si está reservada u ocupada según prefieras
                if (h.isReservada() || h.isOcupada()) {
                    totalHabitaciones += h.calcularCosto();
                    Huesped hu = h.getHuespedTitular();
                    if (hu != null) {
                        totalServicios += hu.calcularCostoServicios();
                    }
                }
            }
        }

        double totalFinal = totalHabitaciones + totalServicios;

        area.setText("=== INGRESOS DEL HOTEL ===\n\n");
        area.append("Ingresos por habitaciones: $" + totalHabitaciones + "\n");
        area.append("Ingresos por servicios: $" + totalServicios + "\n\n");
        area.append("TOTAL: $" + totalFinal + "\n");
    }
}



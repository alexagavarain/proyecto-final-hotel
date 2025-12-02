package proyectoFinalHotel;

import javax.swing.*;
import java.awt.Color;

public class VentanaIngresos extends JFrame {

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

        double totalHabitaciones = hotel.getIngresosHabitaciones();
        double totalServicios = hotel.getIngresosServicios();
        double totalFinal = hotel.getIngresosTotales();

        area.setText("=== INGRESOS DEL HOTEL ===\n\n");
        area.append("Ingresos por habitaciones: $" + totalHabitaciones + "\n");
        area.append("Ingresos por servicios: $" + totalServicios + "\n\n");
        area.append("INGRESOS TOTALES: $" + totalFinal + "\n");
    }
}




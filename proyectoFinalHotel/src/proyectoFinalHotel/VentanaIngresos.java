package proyectoFinalHotel;

import javax.swing.*;
import java.awt.Color;
import javax.swing.table.DefaultTableModel;

public class VentanaIngresos extends JFrame {

    private Hotel hotel;
    private JTable tabla;
    private DefaultTableModel modelo;

    public VentanaIngresos(Hotel hotel) {
        getContentPane().setBackground(new Color(238, 238, 238));
        this.hotel = hotel;

        setTitle("Ingresos del Hotel");
        setSize(500, 400);
        setLocationRelativeTo(null);
        getContentPane().setLayout(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        String[] columnas = {"Habitaciones", "Servicios", "Total"};

        modelo = new DefaultTableModel(columnas, 0) {
            @Override
            public boolean isCellEditable(int row, int col) {
                return false;
            }
        };

        tabla = new JTable(modelo);
        tabla.setRowHeight(25);

        JScrollPane scroll = new JScrollPane(tabla);
        scroll.setBounds(30, 30, 430, 200);
        getContentPane().add(scroll);

        mostrarIngresos();

        setVisible(true);
    }

    private void mostrarIngresos() {

        double totalHabitaciones = hotel.getIngresosHabitaciones();
        double totalServicios = hotel.getIngresosServicios();
        double totalFinal = hotel.getIngresosTotales();

        Object[] fila = {
                totalHabitaciones,
                totalServicios,
                totalFinal
        };

        modelo.addRow(fila);
    }
}




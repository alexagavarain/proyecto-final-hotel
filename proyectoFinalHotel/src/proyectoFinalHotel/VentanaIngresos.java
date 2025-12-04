package proyectoFinalHotel;

import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.table.DefaultTableModel;

public class VentanaIngresos extends JFrame {

    private Hotel hotel;
    private JTable tabla;
    private DefaultTableModel modelo;

    public VentanaIngresos(Hotel hotel) {
        getContentPane().setBackground(new Color(238, 238, 238));
        this.hotel = hotel;

        setTitle("Ingresos del hotel");
        setSize(500, 400);
        setLocationRelativeTo(null);
        getContentPane().setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        JLabel titulo = new JLabel("Ingresos del hotel", SwingConstants.CENTER);
        titulo.setBackground(new Color(255, 128, 128));
        titulo.setFont(new Font("Monospaced", Font.BOLD, 22));
        titulo.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        getContentPane().add(titulo, BorderLayout.NORTH);

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




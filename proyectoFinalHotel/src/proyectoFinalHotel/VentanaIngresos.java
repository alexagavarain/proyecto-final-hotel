package proyectoFinalHotel;

import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.table.DefaultTableModel;

	/**
	 * La clase VentanaIngresos genera la ventana en la cual se presentan los ingresos obtenidos por el hotel y aparece al momento de utilizar el botón correspondiente en el menú.
	 * @author Erandeni Trujillo.
	 * */

public class VentanaIngresos extends JFrame {

    private Hotel hotel;
    private JTable tabla;
    private DefaultTableModel modelo;

    public VentanaIngresos(Hotel hotel) {
        getContentPane().setBackground(new Color(238, 238, 238));
        this.hotel = hotel;

        /**
         * Se configura la ventana inicial.
         * */
        setTitle("Ingresos del hotel");
        setSize(500, 400);
        setLocationRelativeTo(null);
        getContentPane().setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        
        /**
         * Se agrega el titulo.
         * */
        JLabel titulo = new JLabel("Ingresos del hotel", SwingConstants.CENTER);
        titulo.setBackground(new Color(255, 128, 128));
        titulo.setFont(new Font("Monospaced", Font.BOLD, 22));
        titulo.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        getContentPane().add(titulo, BorderLayout.NORTH);

        
        /**
         * Se crean las columnas de la tabla.
         * */
        String[] columnas = {"Habitaciones", "Servicios", "Total"};

        /**
         * Se crea el modelo de la tabla.
         * */
        modelo = new DefaultTableModel(columnas, 0) {
            @Override
            public boolean isCellEditable(int row, int col) {
                return false;
            }
        };

        /**
         * Se crea la tabla y se agrega al scroll
         * */
        tabla = new JTable(modelo);
        tabla.setRowHeight(25);

        JScrollPane scroll = new JScrollPane(tabla);
        scroll.setBounds(30, 30, 430, 200);
        getContentPane().add(scroll);

        mostrarIngresos();

        setVisible(true);
    }

    private void mostrarIngresos() {
    	

    	/**
    	 * Se crean variables en las cuales se llaman para obtener los distintos ingresos.
    	 * */
        double totalHabitaciones = hotel.getIngresosHabitaciones();
        double totalServicios = hotel.getIngresosServicios();
        double totalFinal = hotel.getIngresosTotales();

        /**
         * Se crea una fila con las variables.
         * */
        Object[] fila = {
                totalHabitaciones,
                totalServicios,
                totalFinal
        };

        /**
         * Se agrega la fila a la tabla.
         * */
        modelo.addRow(fila);
    }
}




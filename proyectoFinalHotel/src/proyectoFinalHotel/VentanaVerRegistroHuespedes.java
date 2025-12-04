package proyectoFinalHotel;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class VentanaVerRegistroHuespedes extends JFrame {

    private Hotel hotel;
    private JTable tabla;

    public VentanaVerRegistroHuespedes(Hotel hotel) {
    	
    	/**
    	 * Se crea la pantalla inicial.
    	 * */
    	getContentPane().setBackground(new Color(238, 238, 238));
        this.hotel = hotel;

        setTitle("Registro de huéspedes");
        setSize(750, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new BorderLayout());


        JLabel titulo = new JLabel("Registro de huéspedes", SwingConstants.CENTER);
        titulo.setBackground(new Color(255, 128, 128));
        titulo.setFont(new Font("Monospaced", Font.BOLD, 22));
        titulo.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        getContentPane().add(titulo, BorderLayout.NORTH);


        /**
         * Se crean las columnas que se van a utilizar.
         * */
        String[] columnas = {"Nombre", "Edad", "Teléfono", "Email", "Membresía", "Servicios"};

        /**
         * Se crea el modelo de la tabla con las columnas y ninguna fila.
         * */
        DefaultTableModel modelo = new DefaultTableModel(columnas, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; 
            }
        };
        
        
        /**
         * Se crea la tabla con el modelo.
         * */
        tabla = new JTable(modelo);
        tabla.setBackground(new Color(255, 255, 255));
        tabla.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        tabla.setRowHeight(25);

        
        /**
         * Se crea el scroll con la tabla.
         * */
        JScrollPane scroll = new JScrollPane(tabla);
        scroll.getViewport().setBackground(new Color(240, 240, 240));  
        scroll.setBackground(new Color(255, 128, 128));

        getContentPane().add(scroll, BorderLayout.CENTER);

        /**
         * Se la agregan los datos.
         * */
        cargarDatos();
    }

    private void cargarDatos() {
    	
    	/**
    	 * Se crea una table default.
    	 * */
        DefaultTableModel model = (DefaultTableModel) tabla.getModel();
        model.setRowCount(0);

        /**
         * Se crea un arreglo de huespedes llamando a la funcion que nos devuelve los huespedes.
         * */
        Huesped[] registro = hotel.getRegistroHuespedes();

        /**
         * Por cada huesped en nuestro arreglo, si el huésped es diferente a null, se obtienen los servicios que contrató,
         * se crea la fila de todos los datos del huésped y se agrega al modelo.
         * */
        for (Huesped h : registro) {
            if (h != null) {


                StringBuilder servicios = new StringBuilder();
                for (Servicio s : h.getServiciosContratados()) {
                    if (s != null) {
                        servicios.append(s.getNombreClave()).append(", ");
                    }
                }
                if (servicios.length() > 0) {
                    servicios.setLength(servicios.length() - 2); 
                }

                Object[] fila = {
                        h.getNombre(),
                        h.getEdad(),
                        h.getTelefono(),
                        h.getEmail(),
                        h.getTipoMembresia(),
                        servicios.toString()
                };

                model.addRow(fila);
            }
        }
    }
}



package proyectoFinalHotel;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.Font;
import java.awt.event.*;
import java.awt.Color;

	/**
	 * La clase VentanaBuscarHuesped se encarga de crear la ventana que se abre al momento de utilizar el botón de buscar huésped que se encuentra en el menú.
	 * @author Erandeni Trujillo.
	 * */

public class VentanaBuscarHuesped extends JFrame {

    private Hotel hotel;
    private JTextField campoNombre;

    private JTable tabla;
    private DefaultTableModel modelo;

    public VentanaBuscarHuesped(Hotel hotel) {
    	
    	/**
    	 * Se crea la pantalla inicial
    	 * */
    	getContentPane().setBackground(new Color(238, 238, 238));
        this.hotel = hotel;

        setTitle("Buscar huésped");
        setSize(500, 413);
        setLocationRelativeTo(null);
        getContentPane().setLayout(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JLabel lblNombre = new JLabel("Nombre del huésped:");
        lblNombre.setBounds(40, 30, 200, 25);
        getContentPane().add(lblNombre);

        campoNombre = new JTextField();
        campoNombre.setBounds(180, 30, 250, 25);
        getContentPane().add(campoNombre);

        JButton btnBuscar = new JButton("Buscar");
        btnBuscar.setBounds(180, 70, 100, 30);
        getContentPane().add(btnBuscar);

        
        /**
         * Se crean las columnas de la tabla.
         * */
        String[] columnas = {"Nombre", "Edad", "Teléfono", "Email", "Membresía", "Servicios"};

        
        /**
         * Se crea el modelo de la tabla.
         * */
        modelo = new DefaultTableModel(columnas, 0) {
	        @Override
	        public boolean isCellEditable(int row, int col) {
	        	return false;
	        }
        };

        /* *
         * Se crea la tabla con el modelo anterior.
         * */
        
    	tabla = new JTable(modelo);
    	tabla.setRowHeight(25);
    	tabla.setFont(new Font("Segoe UI", Font.PLAIN, 14));

    	/**
    	 * Se crea un scroll con la tabla.
    	 * */
    	JScrollPane scroll = new JScrollPane(tabla);
    	scroll.setBounds(40, 120, 400, 200);
    	getContentPane().add(scroll);

    	/**
    	 * Le agrega la acción de buscarHuesped() cuando se acciona.
    	 * */
    	btnBuscar.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	            buscarHuesped();
	        }
    	});

        setVisible(true);
    }
    
   
    private void buscarHuesped() {
    	/**
    	 * Se crea una variable con el nombre ingresado.
    	 * */
        String nombreBuscado = campoNombre.getText();

        
        /**
         * Si el nombre está vacio manda un mensaje.
         * */
        if (nombreBuscado.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ingrese un nombre");
            return;
        }
        
        
        modelo.setRowCount(0);

        /**
         * Se crea un arreglo de tipo huesped en el cual se agrega el huesped con la variable creada anteriormente.
         * */
        Huesped[] buscador = hotel.buscadorHuespedes(nombreBuscado);
        
        /**
         * Si el arreglo mide 0 es porque no hay huesped.
         * */
        if (buscador.length == 0) {
            JOptionPane.showMessageDialog(null, "Huésped no encontrado");
            dispose();
            return;
        }

        /**
         * Recorre todos los huespedes de nuestro arreglo y si es diferente a null obtiene los servicios que se contrataron,
         * crea una fila nueva con los datos del huesped y la agrega a la tabla.
         * */
        for (Huesped h : buscador) {
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

                modelo.addRow(fila);
            }
        }

    }
}

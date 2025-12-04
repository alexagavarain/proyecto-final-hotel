package proyectoFinalHotel;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.Font;
import java.awt.event.*;
import java.awt.Color;

public class VentanaBuscarHuesped extends JFrame {

    private Hotel hotel;
    private JTextField campoNombre;
//    private JTextArea areaResultado;
    private JTable tabla;
    private DefaultTableModel modelo;

    public VentanaBuscarHuesped(Hotel hotel) {
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

        String[] columnas = {"Nombre", "Edad", "Teléfono", "Email", "Membresía", "Servicios"};

        modelo = new DefaultTableModel(columnas, 0) {
	        @Override
	        public boolean isCellEditable(int row, int col) {
	        	return false;
	        }
        };

    	tabla = new JTable(modelo);
    	tabla.setRowHeight(25);
    	tabla.setFont(new Font("Segoe UI", Font.PLAIN, 14));

    	JScrollPane scroll = new JScrollPane(tabla);
    	scroll.setBounds(40, 120, 400, 200);
    	getContentPane().add(scroll);

    	btnBuscar.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	            buscarHuesped();
	        }
    	});

        setVisible(true);
    }
    
    //TODO imprimir el arreglo del metodo buscadorHuespedes() en vez de buscarHuesped()
    private void buscarHuesped() {
        String nombreBuscado = campoNombre.getText();

        if (nombreBuscado.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ingrese un nombre");
            return;
        }
        
        modelo.setRowCount(0);

        Huesped[] buscador = hotel.buscadorHuespedes(nombreBuscado);
        
        if (buscador.length == 0) {
            JOptionPane.showMessageDialog(null, "Huésped no encontrado");
            dispose();
            return;
        }

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

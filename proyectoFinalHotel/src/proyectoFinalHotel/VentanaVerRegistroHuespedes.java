package proyectoFinalHotel;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class VentanaVerRegistroHuespedes extends JFrame {

    private Hotel hotel;
    private JTable tabla;

    public VentanaVerRegistroHuespedes(Hotel hotel) {
    	getContentPane().setBackground(new Color(255, 128, 128));
        this.hotel = hotel;

        setTitle("Registro de Huéspedes");
        setSize(750, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new BorderLayout());


        JLabel titulo = new JLabel("Registro de Huéspedes", SwingConstants.CENTER);
        titulo.setBackground(new Color(255, 128, 128));
        titulo.setFont(new Font("Segoe UI", Font.BOLD, 22));
        titulo.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        getContentPane().add(titulo, BorderLayout.NORTH);


        String[] columnas = {"Nombre", "Edad", "Teléfono", "Email", "Membresía", "Servicios contratados"};

        DefaultTableModel modelo = new DefaultTableModel(columnas, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; 
            }
        };

        tabla = new JTable(modelo);
        tabla.setBackground(new Color(255, 128, 128));
        tabla.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        tabla.setRowHeight(25);

        JScrollPane scroll = new JScrollPane(tabla);
        scroll.getViewport().setBackground(new Color(240, 240, 240));  
        scroll.setBackground(new Color(255, 128, 128));

        getContentPane().add(scroll, BorderLayout.CENTER);

        cargarDatos();
    }

    private void cargarDatos() {
        DefaultTableModel model = (DefaultTableModel) tabla.getModel();
        model.setRowCount(0);

        Huesped[] registro = hotel.getRegistroHuespedes();

        for (Huesped h : registro) {
            if (h != null) {


                StringBuilder servicios = new StringBuilder();
                for (Servicio s : h.getServiciosContratados()) {
                    if (s != null) {
                        servicios.append(s.getNombre()).append(", ");
                    }
                }
                if (servicios.length() > 0)
                    servicios.setLength(servicios.length() - 2); 

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



package proyectoFinalHotel;

import javax.swing.*;
import java.awt.event.*;
import java.awt.Color;

public class VentanaBuscarHuesped extends JFrame {

    private Hotel hotel;
    private JTextField campoNombre;
    private JTextArea areaResultado;

    public VentanaBuscarHuesped(Hotel hotel) {
    	getContentPane().setBackground(new Color(255, 128, 128));
        this.hotel = hotel;

        setTitle("Buscar Huésped");
        setSize(561, 413);
        setLocationRelativeTo(null);
        getContentPane().setLayout(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JLabel lblNombre = new JLabel("Nombre del huésped:");
        lblNombre.setBounds(40, 30, 200, 25);
        getContentPane().add(lblNombre);

        campoNombre = new JTextField();
        campoNombre.setBounds(180, 30, 200, 25);
        getContentPane().add(campoNombre);

        JButton btnBuscar = new JButton("Buscar");
        btnBuscar.setBounds(180, 70, 100, 30);
        getContentPane().add(btnBuscar);

        areaResultado = new JTextArea();
        areaResultado.setTabSize(10);
        areaResultado.setBackground(new Color(255, 128, 128));
        JScrollPane scroll = new JScrollPane(areaResultado);
        scroll.setBounds(40, 120, 400, 200);
        getContentPane().add(scroll);
        scroll.getViewport().setBackground(new Color(240, 240, 240)); 
        scroll.setBackground(new Color(255, 128, 128));


        btnBuscar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                buscarHuesped();
            }
        });

        setVisible(true);
    }

    private void buscarHuesped() {
        String nombreBuscado = campoNombre.getText().trim();

        if (nombreBuscado.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Escribe un nombre.");
            return;
        }

        Habitacion[][] habs = hotel.getHabitaciones();
        boolean encontrado = false;

        areaResultado.setText("");

        for (int i = 0; i < habs.length; i++) {
            for (int j = 0; j < habs[i].length; j++) {
                Habitacion h = habs[i][j];
                if (h == null) continue;
                Huesped hu = h.getHuespedTitular();
                if (hu == null) continue;
                if (hu.getNombre() == null) continue;

                if (hu.getNombre().equalsIgnoreCase(nombreBuscado)) {
                    encontrado = true;
                    areaResultado.append("Huésped encontrado:\n\n");
                    areaResultado.append(hu.toString() + "\n\n");
                    areaResultado.append("Habitación: " + h.getClave() + "\n");
                    areaResultado.append("Costo total habitación: $" + h.calcularCosto() + "\n");
                    areaResultado.append("Costo servicios: $" + hu.calcularCostoServicios() + "\n");
                    areaResultado.append("------------------------------------------\n");
                }
            }
        }

        if (!encontrado) {
            areaResultado.setText("No se encontró un huésped con ese nombre.");
        }
    }
}


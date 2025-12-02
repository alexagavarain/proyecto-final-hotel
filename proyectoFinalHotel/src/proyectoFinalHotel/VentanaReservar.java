package proyectoFinalHotel;

import javax.swing.*;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.awt.event.ActionEvent;

public class VentanaReservar extends JFrame {

    public VentanaReservar(Hotel hotel, Habitacion hab) {
        getContentPane().setBackground(new Color(255, 128, 128));
        setTitle("Reservar Habitación");
        setSize(409, 558);
        setLocationRelativeTo(null);
        getContentPane().setLayout(null);

        JLabel lblNombre = new JLabel("Nombre:");
        lblNombre.setBounds(54, 20, 120, 20);
        getContentPane().add(lblNombre);

        JTextField txtNombre = new JTextField();
        txtNombre.setBounds(184, 20, 150, 20);
        getContentPane().add(txtNombre);

        JLabel lblEdad = new JLabel("Edad:");
        lblEdad.setBounds(54, 60, 120, 20);
        getContentPane().add(lblEdad);

        JTextField txtEdad = new JTextField();
        txtEdad.setBounds(184, 60, 150, 20);
        getContentPane().add(txtEdad);

        JLabel lblTel = new JLabel("Teléfono:");
        lblTel.setBounds(54, 100, 120, 20);
        getContentPane().add(lblTel);

        JTextField txtTel = new JTextField();
        txtTel.setBounds(184, 100, 150, 20);
        getContentPane().add(txtTel);

        JLabel lblEmail = new JLabel("Email:");
        lblEmail.setBounds(54, 131, 120, 20);
        getContentPane().add(lblEmail);

        JTextField txtEmail = new JTextField();
        txtEmail.setBounds(127, 131, 207, 20);
        getContentPane().add(txtEmail);

        JLabel lblMem = new JLabel("Membresía (CF / VIP):");
        lblMem.setBounds(49, 180, 150, 20);
        getContentPane().add(lblMem);

        JTextField txtMem = new JTextField();
        txtMem.setBounds(224, 180, 110, 20);
        getContentPane().add(txtMem);

        JLabel lblClave = new JLabel("Clave hab:");
        lblClave.setBounds(49, 220, 120, 20);
        getContentPane().add(lblClave);

        JTextField txtClave = new JTextField();
        txtClave.setBounds(184, 220, 150, 20);

        txtClave.setText(hab.getClave());
        txtClave.setEnabled(false);
        getContentPane().add(txtClave);

        JLabel lblCant = new JLabel("Cantidad huéspedes:");
        lblCant.setBounds(49, 251, 150, 20);
        getContentPane().add(lblCant);

        JTextField txtCant = new JTextField();
        txtCant.setBounds(224, 251, 110, 20);
        getContentPane().add(txtCant);

        JLabel lblNoches = new JLabel("Noches:");
        lblNoches.setBounds(54, 282, 120, 20);
        getContentPane().add(lblNoches);

        JTextField txtNoches = new JTextField();
        txtNoches.setBounds(184, 282, 150, 20);
        getContentPane().add(txtNoches);

        JButton btnReservar = new JButton("Reservar");
        btnReservar.setBounds(128, 446, 120, 30);
        getContentPane().add(btnReservar);
        
        JLabel lblNewLabel = new JLabel("Servicio extra:");
        lblNewLabel.setBounds(158, 313, 110, 14);
        getContentPane().add(lblNewLabel);
        
        JButton btnALaHabitacion = new JButton("A la habitacion");
        btnALaHabitacion.setBounds(48, 348, 110, 23);
        getContentPane().add(btnALaHabitacion);
        
        JButton btnLavanderia = new JButton("Lavanderia");
        btnLavanderia.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	}
        });
        btnLavanderia.setBounds(224, 348, 110, 23);
        getContentPane().add(btnLavanderia);
        
        JButton btnSpa = new JButton("Spa");
        btnSpa.setBounds(48, 384, 110, 23);
        getContentPane().add(btnSpa);
        
        JButton btnTour = new JButton("Tour");
        btnTour.setBounds(224, 384, 110, 23);
        getContentPane().add(btnTour);

        HashMap<JButton, Servicio> mapaServicios = new HashMap<>();
        ArrayList<Servicio> serviciosSeleccionados = new ArrayList<>();

        Servicio sHab = new ServicioALaHabitacion();
        Servicio sLav = new ServicioLavanderia();
        Servicio sSpa = new ServicioSpa();
        Servicio sTour = new ServicioTour();

        mapaServicios.put(btnALaHabitacion, sHab);
        mapaServicios.put(btnLavanderia, sLav);
        mapaServicios.put(btnSpa, sSpa);
        mapaServicios.put(btnTour, sTour);

        for (JButton b : mapaServicios.keySet()) {
            b.setBackground(Color.LIGHT_GRAY);
            b.setOpaque(true);
            b.setBorderPainted(false);
        }

        for (JButton btnServ : mapaServicios.keySet()) {

            btnServ.addActionListener(e -> {

                Servicio s = mapaServicios.get(btnServ);

                if (serviciosSeleccionados.contains(s)) {
                    serviciosSeleccionados.remove(s);
                    btnServ.setBackground(Color.LIGHT_GRAY);
                } else {
                    serviciosSeleccionados.add(s);
                    btnServ.setBackground(new Color(60, 170, 60)); 
                }
            });
        }

        
        
        
        btnReservar.addActionListener(e -> {
            try {

                Huesped h = new Huesped(
                        txtNombre.getText(),
                        Integer.parseInt(txtEdad.getText()),
                        txtTel.getText(),
                        txtEmail.getText(),
                        txtMem.getText()
                );

                for (Servicio s : serviciosSeleccionados) {
                    h.contratarServicio(s);
                }

                boolean ok = hotel.reservarHabitacion(
                        h,
                        hab.getClave(),
                        Integer.parseInt(txtCant.getText()),
                        Integer.parseInt(txtNoches.getText())
                );

                if (ok) {
                    double costoServicios = h.calcularCostoServicios();
                    JOptionPane.showMessageDialog(null, 
                        "Reservación realizada\n" +
                        "Servicios extra: $" + costoServicios
                    );
                } else {
                    JOptionPane.showMessageDialog(null, "No se pudo reservar");
                }

                dispose();

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Datos inválidos");
            }
        });
 

        setVisible(true);
    }
}



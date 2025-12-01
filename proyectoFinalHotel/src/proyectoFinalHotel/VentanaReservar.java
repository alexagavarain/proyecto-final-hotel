package proyectoFinalHotel;

import javax.swing.*;
import java.awt.Color;

public class VentanaReservar extends JFrame {

    public VentanaReservar(Hotel hotel) {
    	getContentPane().setBackground(new Color(255, 128, 128));
        setTitle("Reservar Habitación");
        setSize(350, 430);
        setLocationRelativeTo(null);
        getContentPane().setLayout(null);

        JLabel lblNombre = new JLabel("Nombre:");
        lblNombre.setBounds(20, 20, 120, 20);
        getContentPane().add(lblNombre);

        JTextField txtNombre = new JTextField();
        txtNombre.setBounds(140, 20, 150, 20);
        getContentPane().add(txtNombre);

        JLabel lblEdad = new JLabel("Edad:");
        lblEdad.setBounds(20, 60, 120, 20);
        getContentPane().add(lblEdad);

        JTextField txtEdad = new JTextField();
        txtEdad.setBounds(140, 60, 150, 20);
        getContentPane().add(txtEdad);

        JLabel lblTel = new JLabel("Teléfono:");
        lblTel.setBounds(20, 100, 120, 20);
        getContentPane().add(lblTel);

        JTextField txtTel = new JTextField();
        txtTel.setBounds(140, 100, 150, 20);
        getContentPane().add(txtTel);

        JLabel lblEmail = new JLabel("Email:");
        lblEmail.setBounds(20, 140, 120, 20);
        getContentPane().add(lblEmail);

        JTextField txtEmail = new JTextField();
        txtEmail.setBounds(83, 140, 207, 20);
        getContentPane().add(txtEmail);

        JLabel lblMem = new JLabel("Membresía (CF / VIP):");
        lblMem.setBounds(20, 180, 150, 20);
        getContentPane().add(lblMem);

        JTextField txtMem = new JTextField();
        txtMem.setBounds(180, 180, 110, 20);
        getContentPane().add(txtMem);

        JLabel lblClave = new JLabel("Clave hab:");
        lblClave.setBounds(20, 220, 120, 20);
        getContentPane().add(lblClave);

        JTextField txtClave = new JTextField();
        txtClave.setBounds(140, 220, 150, 20);
        getContentPane().add(txtClave);

        JLabel lblCant = new JLabel("Cantidad huéspedes:");
        lblCant.setBounds(20, 260, 150, 20);
        getContentPane().add(lblCant);

        JTextField txtCant = new JTextField();
        txtCant.setBounds(180, 260, 110, 20);
        getContentPane().add(txtCant);

        JLabel lblNoches = new JLabel("Noches:");
        lblNoches.setBounds(20, 300, 120, 20);
        getContentPane().add(lblNoches);

        JTextField txtNoches = new JTextField();
        txtNoches.setBounds(140, 300, 150, 20);
        getContentPane().add(txtNoches);

        JButton btn = new JButton("Reservar");
        btn.setBounds(110, 340, 120, 30);
        getContentPane().add(btn);

        btn.addActionListener(e -> {
            try {
                Huesped h = new Huesped(
                        txtNombre.getText(),
                        Integer.parseInt(txtEdad.getText()),
                        txtTel.getText(),
                        txtEmail.getText(),
                        txtMem.getText()
                );

                boolean ok = hotel.reservarHabitacion(
                        h,
                        txtClave.getText(),
                        Integer.parseInt(txtCant.getText()),
                        Integer.parseInt(txtNoches.getText())
                );

                if (ok)
                    JOptionPane.showMessageDialog(null, "Reservación realizada");
                else
                    JOptionPane.showMessageDialog(null, "No se pudo reservar");
                dispose();

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Datos inválidos");
            }
        });

        setVisible(true);
    }
}


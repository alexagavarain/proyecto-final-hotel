package proyectoFinalHotel;

import javax.swing.*;
import java.awt.Color;

public class VentanaCheckOut extends JFrame {

    public VentanaCheckOut(Hotel hotel) {
    	getContentPane().setBackground(new Color(238, 238, 238));
        setTitle("Check-Out");
        setSize(300, 200);
        setLocationRelativeTo(null);
        getContentPane().setLayout(null);

        JLabel lblNombre = new JLabel("Nombre:");
        lblNombre.setBounds(20, 20, 100, 20);
        getContentPane().add(lblNombre);

        JTextField txtNombre = new JTextField();
        txtNombre.setBounds(120, 20, 130, 20);
        getContentPane().add(txtNombre);

        JLabel lblClave = new JLabel("Clave:");
        lblClave.setBounds(20, 60, 100, 20);
        getContentPane().add(lblClave);

        JTextField txtClave = new JTextField();
        txtClave.setBounds(120, 60, 130, 20);
        getContentPane().add(txtClave);

        JButton btn = new JButton("Check-Out");
        btn.setBounds(80, 110, 120, 30);
        getContentPane().add(btn);

        btn.addActionListener(e -> {
            Huesped h = hotel.buscarHuesped(txtNombre.getText());
            
            if (h == null) {
            	JOptionPane.showMessageDialog(null, "Huésped no encontrado");
            	dispose();
            	return;
            }
            
            String clave = txtClave.getText();
    		double cantidadCobrar = hotel.cobrar(h, clave);
            
    		if (hotel.checkOut(h, clave)) {
                JOptionPane.showMessageDialog(null, "Check-out realizado\n" + "Cantidad a cobrar: $" + cantidadCobrar);
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo hacer check-out");
            }
            dispose();
        });

        setVisible(true);
    }
}


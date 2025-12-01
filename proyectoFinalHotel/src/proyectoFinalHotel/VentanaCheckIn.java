package proyectoFinalHotel;

import javax.swing.*;

public class VentanaCheckIn extends JFrame {

    public VentanaCheckIn(Hotel hotel) {
        setTitle("Check-In");
        setSize(300, 200);
        setLocationRelativeTo(null);
        setLayout(null);

        JLabel lblNombre = new JLabel("Nombre:");
        lblNombre.setBounds(20, 20, 100, 20);
        add(lblNombre);

        JTextField txtNombre = new JTextField();
        txtNombre.setBounds(120, 20, 130, 20);
        add(txtNombre);

        JLabel lblClave = new JLabel("Clave hab:");
        lblClave.setBounds(20, 60, 100, 20);
        add(lblClave);

        JTextField txtClave = new JTextField();
        txtClave.setBounds(120, 60, 130, 20);
        add(txtClave);

        JButton btn = new JButton("Check-In");
        btn.setBounds(80, 110, 120, 30);
        add(btn);

        btn.addActionListener(e -> {
            Huesped h = hotel.buscarHuesped(txtNombre.getText());
            if (h != null && hotel.checkIn(h, txtClave.getText())) {
                JOptionPane.showMessageDialog(null, "Check-in realizado");
            } else {
                JOptionPane.showMessageDialog(null, "Error en check-in");
            }
            dispose();
        });

        setVisible(true);
    }
}

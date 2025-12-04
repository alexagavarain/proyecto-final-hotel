package proyectoFinalHotel;

import javax.swing.*;

public class VentanaCheckIn extends JFrame {

    public VentanaCheckIn(Hotel hotel) {
        setTitle("Check-In");
        setSize(300, 200);
        setLocationRelativeTo(null);
        setLayout(null);

        /**
         * Se crean los botones y los labels que se verán en pantalla.
         * */
        JLabel lblNombre = new JLabel("Nombre:");
        lblNombre.setBounds(20, 20, 100, 20);
        add(lblNombre);

        JTextField txtNombre = new JTextField();
        txtNombre.setBounds(120, 20, 130, 20);
        add(txtNombre);

        JLabel lblClave = new JLabel("Clave:");
        lblClave.setBounds(20, 60, 100, 20);
        add(lblClave);

        JTextField txtClave = new JTextField();
        txtClave.setBounds(120, 60, 130, 20);
        add(txtClave);

        JButton btn = new JButton("Check-In");
        btn.setBounds(80, 110, 120, 30);
        add(btn);

        /**
         * Se le agrega la acción al boton de check in
         * */
        btn.addActionListener(e -> {
        	
        	/**
        	 * Se crea un huesped con que se busca en el hotel.
        	 * */
            Huesped h = hotel.buscarHuesped(txtNombre.getText());
            
            /**
             * Si el huesped es diferente a null y el check in regresa un true sale un mensaje de que se realizó.
             * */
            if (h != null && hotel.checkIn(h, txtClave.getText())) {
                JOptionPane.showMessageDialog(null, "Check-in realizado");
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo hacer check-in");
            }
            dispose();
        });

        setVisible(true);
    }
}

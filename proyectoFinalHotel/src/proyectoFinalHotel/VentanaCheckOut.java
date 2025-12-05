package proyectoFinalHotel;

import javax.swing.*;
import java.awt.Color;


	/**
	 * La clase VentanaCheckOut se encarga de crear la ventana en la cual el usuario hace check out mediante el botón con el mismo nombre que se encuentra en el menú.
	 * @author Erandeni Trujillo.
	 * */
public class VentanaCheckOut extends JFrame {

    public VentanaCheckOut(Hotel hotel) {
    	getContentPane().setBackground(new Color(238, 238, 238));
        setTitle("Check-Out");
        setSize(300, 200);
        setLocationRelativeTo(null);
        getContentPane().setLayout(null);

        
        /**
         * Se crean los labels y botones que van a aparecer en la ventana.
         * */
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

        
        /**
         * Se agrega una accion al botón.
         * */
        btn.addActionListener(e -> {
        	/**
        	 * Se crea el huésped llamando a confirmarHuespedNombre() con el nombre dado.
        	 * */
            Huesped h = hotel.confirmarHuespedNombre(txtNombre.getText(), txtClave.getText());
            
            /**
             * Si el huésped es null se manda mensaje de que no se encontró.
             * */
            if (h == null) {
            	JOptionPane.showMessageDialog(null, "Huésped no encontrado");
            	return;
            }
            
            /**
             * Se crea una variable con la clave que dio el huésped, luego otra para sacar el monto que se va a cobrar.
             * */
            String clave = txtClave.getText();
	            
    		/**
    		 * Si el check out devuelve un true, manda un mensaje de que se pudo realizar y la cantidad que se cobró.
    		 * */
    		if (hotel.checkOut(h, clave)) {
    			double cantidadCobrar = hotel.getUltimoCobro();
                JOptionPane.showMessageDialog(null, "Check-out realizado\n" + "Cantidad a cobrar: $" + cantidadCobrar);
                dispose();
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo hacer check-out");
            }
        });
        
	    setVisible(true);
    }
}


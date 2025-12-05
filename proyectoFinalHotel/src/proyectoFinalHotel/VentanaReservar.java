package proyectoFinalHotel;

import javax.swing.*;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.awt.event.ActionEvent;

/**
 * La clase VentanaReservar se encarga de crear la ventana en la cual el usuario ingresa los datos para hacer su reservación.
 * @author Erandeni Trujillo.
 * */

public class VentanaReservar extends JFrame {

    public VentanaReservar(Hotel hotel, Habitacion hab) {
        getContentPane().setBackground(new Color(238, 238, 238));
        setTitle("Reservar habitación");
        setSize(409, 558);
        setLocationRelativeTo(null);
        getContentPane().setLayout(null);

        JLabel lblNombre = new JLabel("Nombre:");
        lblNombre.setBounds(49, 20, 120, 20);
        getContentPane().add(lblNombre);

        JTextField txtNombre = new JTextField();
        txtNombre.setBounds(127, 20, 207, 20);
        getContentPane().add(txtNombre);

        JLabel lblEdad = new JLabel("Edad:");
        lblEdad.setBounds(49, 60, 120, 20);
        getContentPane().add(lblEdad);

        JTextField txtEdad = new JTextField();
        txtEdad.setBounds(224, 60, 110, 20);
        getContentPane().add(txtEdad);

        JLabel lblTel = new JLabel("Teléfono:");
        lblTel.setBounds(49, 100, 120, 20);
        getContentPane().add(lblTel);

        JTextField txtTel = new JTextField();
        txtTel.setBounds(127, 100, 207, 20);
        getContentPane().add(txtTel);

        JLabel lblEmail = new JLabel("Email:");
        lblEmail.setBounds(49, 140, 120, 20);
        getContentPane().add(lblEmail);

        JTextField txtEmail = new JTextField();
        txtEmail.setBounds(127, 140, 207, 20);
        getContentPane().add(txtEmail);

        JLabel lblMem = new JLabel("Membresía (CF / VIP / N):");
        lblMem.setBounds(49, 180, 150, 20);
        getContentPane().add(lblMem);

        JTextField txtMem = new JTextField();
        txtMem.setBounds(224, 180, 110, 20);
        getContentPane().add(txtMem);

        JLabel lblClave = new JLabel("Clave:");
        lblClave.setBounds(49, 220, 120, 20);
        getContentPane().add(lblClave);

        JTextField txtClave = new JTextField();
        txtClave.setBounds(224, 220, 110, 20);

        txtClave.setText(hab.getClave());
        txtClave.setEnabled(false);
        getContentPane().add(txtClave);

        JLabel lblCant = new JLabel("No. huéspedes:");
        lblCant.setBounds(49, 251, 150, 20);
        getContentPane().add(lblCant);

        JTextField txtCant = new JTextField();
        txtCant.setBounds(224, 251, 110, 20);
        getContentPane().add(txtCant);

        JLabel lblNoches = new JLabel("No. noches:");
        lblNoches.setBounds(49, 282, 120, 20);
        getContentPane().add(lblNoches);

        JTextField txtNoches = new JTextField();
        txtNoches.setBounds(224, 282, 110, 20);
        getContentPane().add(txtNoches);

        JButton btnReservar = new JButton("Reservar");
        btnReservar.setBounds(128, 446, 120, 30);
        getContentPane().add(btnReservar);
        
        JLabel lblServicioExtra = new JLabel("Servicio extra:");
        lblServicioExtra.setBounds(158, 313, 110, 14);
        getContentPane().add(lblServicioExtra);
        
        JButton btnALaHabitacion = new JButton("A la habitacion");
        btnALaHabitacion.setBounds(48, 348, 130, 23);
        getContentPane().add(btnALaHabitacion);
        
        JButton btnLavanderia = new JButton("Lavanderia");
        btnLavanderia.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	}
        });
        btnLavanderia.setBounds(224, 348, 130, 23);
        getContentPane().add(btnLavanderia);
        
        JButton btnSpa = new JButton("Spa");
        btnSpa.setBounds(48, 384, 130, 23);
        getContentPane().add(btnSpa);
        
        JButton btnTour = new JButton("Tour");
        btnTour.setBounds(224, 384, 130, 23);
        getContentPane().add(btnTour);

        
        /**
         * Creamos un hashmap con todos los servicios y una lista con los servicios que va a seleccionar el cliente.
         * */
        HashMap<JButton, Servicio> mapaServicios = new HashMap<>();
        ArrayList<Servicio> serviciosSeleccionados = new ArrayList<>();
        
        

        /**
         * Creamos los servicios, cada uno con su nombre, código y precio.
         * */
        Servicio sHab = new Servicio("Servicio a la habitación", "SH", 300);
        Servicio sLav = new Servicio("Lavandería", "L", 700);
        Servicio sSpa = new Servicio("Spa", "SP", 500);
        Servicio sTour = new Servicio("Tour", "T", 900);

        
        /**
         * A cada boton se le relaciona un servicio.
         * */
        mapaServicios.put(btnALaHabitacion, sHab);
        mapaServicios.put(btnLavanderia, sLav);
        mapaServicios.put(btnSpa, sSpa);
        mapaServicios.put(btnTour, sTour);

        
        
        /**
         * Recorremos los botones y los ponemos en gris.
         * */
        for (JButton botones : mapaServicios.keySet()) {
            botones.setBackground(Color.LIGHT_GRAY);
            botones.setOpaque(true);
        }
        
        
        /**
         * Se le asigna una acción a cada boton, si ya estaba seleccionado se le elimina y se vuelve gris, si no se asigna y se pone verde.
         * */
        for (JButton btnServ : mapaServicios.keySet()) {

            btnServ.addActionListener(e -> {

                Servicio misServicios = mapaServicios.get(btnServ);

                if (serviciosSeleccionados.contains(misServicios)) {
                    serviciosSeleccionados.remove(misServicios);
                    btnServ.setBackground(Color.LIGHT_GRAY);
                } else {
                    serviciosSeleccionados.add(misServicios);
                    btnServ.setBackground(new Color(60, 170, 60)); 
                }
            });
        }

        
        
        /**
         * Se le asigna la acción al botón de reservar.
         * */
        
        btnReservar.addActionListener(e -> {
            try {
            	/**
            	 * Crea un objeto huésped con los datos que ingresó el usuario.
            	 * */
                Huesped miHuesped = new Huesped(
                        txtNombre.getText(),
                        Integer.parseInt(txtEdad.getText()),
                        txtTel.getText(),
                        txtEmail.getText(),
                        txtMem.getText()
                );
                /**
                 * Se recorren los servicios seleccionados por el usuario y se agregan al huesped.
                 * */
                for (Servicio s : serviciosSeleccionados) {
                    miHuesped.contratarServicio(s);
                }
                
                /**
                 * Creamos una variable que devuelva el booleano para saber si se pudo o no reservar la habitación.
                 * */
                boolean reservado = hotel.reservarHabitacion(
                        miHuesped,
                        hab.getClave(),
                        Integer.parseInt(txtCant.getText()),
                        Integer.parseInt(txtNoches.getText())
                );

                /**
                 * Si reservado es true se calculan los costos de los servicios y se presenta el mensaje, si es false se presenta un mensaje de que no se pudo reservar.
                 * */
                if (reservado) {
                    double costoServicios = miHuesped.calcularCostoServicios();
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



package proyectoFinalHotel;

import javax.swing.*;
import java.awt.*;

public class VentanaVerDisponibilidad extends JFrame {

    private Hotel hotel;

    public VentanaVerDisponibilidad(Hotel hotel) {
        getContentPane().setBackground(new Color(238, 238, 238));
        this.hotel = hotel;

        setTitle("Mapa de disponibilidad de habitaciones");
        setSize(1023, 864);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new BorderLayout());

        JLabel titulo = new JLabel("Mapa de disponibilidad de habitaciones", SwingConstants.CENTER);
        titulo.setFont(new Font("Monospaced", Font.BOLD, 25));
        titulo.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        getContentPane().add(titulo, BorderLayout.NORTH);

        JPanel panelGrid = new JPanel();
        panelGrid.setBackground(new Color(238, 238, 238));
        panelGrid.setLayout(new GridLayout(4, 5, 10, 10));
        panelGrid.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        getContentPane().add(panelGrid, BorderLayout.CENTER);

        Habitacion[][] habs = hotel.getHabitaciones();

        for (int i = 0; i < habs.length; i++) {
            for (int j = 0; j < habs[i].length; j++) {

                Habitacion h = habs[i][j];

                JPanel tarjeta = new JPanel();
                tarjeta.setLayout(new BoxLayout(tarjeta, BoxLayout.Y_AXIS));
                tarjeta.setBackground(Color.WHITE);
                tarjeta.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1, true));

                JLabel lblClave = new JLabel(h.getClave());
                lblClave.setFont(new Font("Segoe UI", Font.BOLD, 16));
                lblClave.setAlignmentX(Component.CENTER_ALIGNMENT);

                JLabel lblTipo = new JLabel(h.getTipo());
                lblTipo.setFont(new Font("Segoe UI", Font.PLAIN, 14));
                lblTipo.setAlignmentX(Component.CENTER_ALIGNMENT);

                JLabel lblEstado = new JLabel(h.isReservada() ? "RESERVADA" : "DISPONIBLE");
                lblEstado.setFont(new Font("Segoe UI", Font.BOLD, 14));
                lblEstado.setAlignmentX(Component.CENTER_ALIGNMENT);
                lblEstado.setForeground(Color.WHITE);

                JPanel panelEstado = new JPanel();
                panelEstado.setMaximumSize(new Dimension(120, 30));
                panelEstado.setBackground(h.isReservada() ? new Color(200, 50, 50) : new Color(60, 170, 60));
                panelEstado.add(lblEstado);

                tarjeta.add(Box.createVerticalStrut(20));
                tarjeta.add(lblClave);
                tarjeta.add(Box.createVerticalStrut(5));
                tarjeta.add(lblTipo);
                tarjeta.add(Box.createVerticalStrut(10));
                tarjeta.add(panelEstado);

                if (!h.isReservada()) {
                    JButton btnReservar = new JButton("Reservar");
                    btnReservar.setAlignmentX(Component.CENTER_ALIGNMENT);
                    btnReservar.setBackground(new Color(100, 100, 100));
                    btnReservar.setForeground(Color.WHITE);

                    btnReservar.addActionListener(e -> {
                        new VentanaReservar(hotel, h);
                        dispose();
                    });

                    tarjeta.add(Box.createVerticalStrut(10));
                    tarjeta.add(btnReservar);
                }

                panelGrid.add(tarjeta);
            }
        }

        setVisible(true);
    }
}





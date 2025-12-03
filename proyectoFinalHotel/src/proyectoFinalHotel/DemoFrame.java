package proyectoFinalHotel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class DemoFrame extends JFrame {

    private Hotel hotel = new Hotel();

    public DemoFrame() {
    	getContentPane().setBackground(new Color(238, 238, 238));
        setTitle("Sistema de gestión de hotel");
        setSize(721, 505);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        
        JButton btnCheckIn = new JButton("Check-In");
        btnCheckIn.setFont(new Font("Monospaced", Font.BOLD, 15));
        btnCheckIn.setBounds(54, 230, 261, 49);
        JButton btnCheckOut = new JButton("Check-Out");
        btnCheckOut.setFont(new Font("Monospaced", Font.BOLD, 15));
        btnCheckOut.setBounds(393, 230, 256, 49);
        JButton btnDisponibilidad = new JButton("Disponibilidad");
        btnDisponibilidad.setFont(new Font("Monospaced", Font.BOLD, 15));
        btnDisponibilidad.setBounds(59, 290, 256, 49);
        
        JButton btnRegistro = new JButton("Registro de huéspedes");
        btnRegistro.setFont(new Font("Monospaced", Font.BOLD, 15));
        btnRegistro.setBounds(59, 358, 256, 49);
        getContentPane().setLayout(null);

        
        getContentPane().add(btnCheckIn);
        getContentPane().add(btnCheckOut);
        getContentPane().add(btnDisponibilidad);
        getContentPane().add(btnRegistro);
        
        JButton btnBuscarHuesped = new JButton("Buscar huésped");
        btnBuscarHuesped.setFont(new Font("Monospaced", Font.BOLD, 15));
        btnBuscarHuesped.setBounds(393, 290, 261, 49);
        getContentPane().add(btnBuscarHuesped);
        
        JButton btnVerIngresos = new JButton("Ingresos");
        btnVerIngresos.setFont(new Font("Monospaced", Font.BOLD, 15));
        btnVerIngresos.setBounds(393, 358, 261, 49);
        getContentPane().add(btnVerIngresos);
        
        JLabel lblNewLabel = new JLabel("Hotel Descanso");
        lblNewLabel.setFont(new Font("Monospaced", Font.BOLD, 37));
        lblNewLabel.setBounds(210, 68, 323, 79);
        getContentPane().add(lblNewLabel);
        JLabel lblNewLabel2 = new JLabel("Sistema de gestión");
        lblNewLabel2.setFont(new Font("Monospaced", Font.PLAIN, 25));
        lblNewLabel2.setBounds(230,120, 323, 79);
        getContentPane().add(lblNewLabel2);

        // Abrir ventanas
        btnCheckIn.addActionListener(e -> new VentanaCheckIn(hotel));
        btnCheckOut.addActionListener(e -> new VentanaCheckOut(hotel));
        btnDisponibilidad.addActionListener(e -> new VentanaVerDisponibilidad(hotel));
        btnBuscarHuesped.addActionListener(e -> new VentanaBuscarHuesped(hotel));
        btnVerIngresos.addActionListener(e -> new VentanaIngresos(hotel));
        btnRegistro.addActionListener(e -> {
            VentanaVerRegistroHuespedes vr = new VentanaVerRegistroHuespedes(hotel);
            vr.setVisible(true);
        });
        
        

        setVisible(true);
    }
    

    public static void main(String[] args) {
        new DemoFrame();
    }
}

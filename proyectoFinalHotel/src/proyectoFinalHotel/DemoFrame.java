package proyectoFinalHotel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class DemoFrame extends JFrame {

    private Hotel hotel = new Hotel();

    public DemoFrame() {
    	getContentPane().setBackground(new Color(255, 128, 128));
        setTitle("Sistema de Hotel");
        setSize(721, 505);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        
        JButton btnCheckIn = new JButton("Check-In");
        btnCheckIn.setBounds(54, 230, 261, 49);
        JButton btnCheckOut = new JButton("Check-Out");
        btnCheckOut.setBounds(393, 230, 256, 49);
        JButton btnDisponibilidad = new JButton("Ver disponibilidad");
        btnDisponibilidad.setBounds(59, 290, 256, 49);
        
        JButton btnRegistro = new JButton("Ver registro de huéspedes");
        btnRegistro.setBounds(59, 358, 256, 49);
        getContentPane().setLayout(null);

        
        getContentPane().add(btnCheckIn);
        getContentPane().add(btnCheckOut);
        getContentPane().add(btnDisponibilidad);
        getContentPane().add(btnRegistro);
        
        JButton btnBuscarHuesped = new JButton("Buscar huesped");
        btnBuscarHuesped.setBounds(393, 290, 261, 49);
        getContentPane().add(btnBuscarHuesped);
        
        JButton btnVerIngresos = new JButton("Ver ingresos");
        btnVerIngresos.setBounds(393, 358, 261, 49);
        getContentPane().add(btnVerIngresos);
        
        JLabel lblNewLabel = new JLabel("Sistema de hotel");
        lblNewLabel.setFont(new Font("Tw Cen MT Condensed", Font.BOLD | Font.ITALIC, 50));
        lblNewLabel.setBounds(216, 68, 323, 79);
        getContentPane().add(lblNewLabel);

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

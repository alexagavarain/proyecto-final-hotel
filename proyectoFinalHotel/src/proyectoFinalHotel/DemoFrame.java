package proyectoFinalHotel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class DemoFrame extends JFrame {

    private Hotel hotel = new Hotel();

    /**
     * Con este método creamos la ventana que vamos a utilizar como menú.
     * */
    
    
    public DemoFrame() {
    	
    	getContentPane().setBackground(new Color(238, 238, 238));
        setTitle("Sistema de gestión de hotel");
        setSize(721, 505);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        /**
         * Esto se encarga de la creación de los botones que se encuentran en el menú principal.
         * */
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
        
        JButton btnBuscarHuesped = new JButton("Buscar huésped");
        btnBuscarHuesped.setFont(new Font("Monospaced", Font.BOLD, 15));
        btnBuscarHuesped.setBounds(393, 290, 261, 49);
        
        JButton btnVerIngresos = new JButton("Ingresos");
        btnVerIngresos.setFont(new Font("Monospaced", Font.BOLD, 15));
        btnVerIngresos.setBounds(393, 358, 261, 49);
        JLabel lblTitulo = new JLabel("Hotel Descanso");
        lblTitulo.setFont(new Font("Monospaced", Font.BOLD, 37));
        lblTitulo.setBounds(210, 68, 323, 79);
        
        JLabel lblTituloDos = new JLabel("Sistema de gestión");
        lblTituloDos.setFont(new Font("Monospaced", Font.PLAIN, 25));
        lblTituloDos.setBounds(230,120, 323, 79);

       /**
        * El método getContentPane se encarga de llamar al panel que con el add se agregan los botones.
        * */
        getContentPane().add(btnCheckIn);
        getContentPane().add(btnCheckOut);
        getContentPane().add(btnDisponibilidad);
        getContentPane().add(btnRegistro);
        getContentPane().add(btnBuscarHuesped);
        getContentPane().add(btnVerIngresos);
        getContentPane().add(lblTitulo);
        getContentPane().add(lblTituloDos);

        /**
         * Aquí a cada botón se le agrega la acción para que abra su respectiva ventana.
         * */
        btnCheckIn.addActionListener(e -> new VentanaCheckIn(hotel));
        btnCheckOut.addActionListener(e -> new VentanaCheckOut(hotel));
        btnDisponibilidad.addActionListener(e -> new VentanaVerDisponibilidad(hotel));
        btnBuscarHuesped.addActionListener(e -> new VentanaBuscarHuesped(hotel));
        btnVerIngresos.addActionListener(e -> new VentanaIngresos(hotel));
        btnRegistro.addActionListener(e -> {
            VentanaVerRegistroHuespedes vr = new VentanaVerRegistroHuespedes(hotel);
            vr.setVisible(true);
        });
        
        /**
         * Hacemos que nuestra ventana sea visible.
         * */

        setVisible(true);
    }
    
    /**
     * Creamos nuestro método main en el cual mandamos llamar nuestro método anterior que es el menú.
     * */
    public static void main(String[] args) {
        new DemoFrame();
    }
}

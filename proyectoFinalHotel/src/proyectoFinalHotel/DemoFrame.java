package proyectoFinalHotel;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;

public class DemoFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DemoFrame frame = new DemoFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public DemoFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 730, 556);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel Titulo = new JLabel("Hotel \"El buen descanso\"");
		Titulo.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 17));
		Titulo.setBounds(293, 58, 152, 12);
		contentPane.add(Titulo);
		
		JButton verRegistro = new JButton("Ver registro huéspedes");
		verRegistro.setBounds(105, 280, 152, 41);
		contentPane.add(verRegistro);
		
		JButton buscarHuesped = new JButton("Buscar huésped");
		buscarHuesped.setBounds(105, 331, 152, 41);
		contentPane.add(buscarHuesped);
		
		JButton reservarHabitacion = new JButton("Reservar habitacion");
		reservarHabitacion.setBounds(105, 382, 152, 41);
		contentPane.add(reservarHabitacion);
		
		JButton checkIn = new JButton("Check in");
		checkIn.setBounds(105, 433, 152, 41);
		contentPane.add(checkIn);
		
		JButton checkOut = new JButton("Check out");
		checkOut.setBounds(441, 280, 152, 41);
		contentPane.add(checkOut);
		
		JButton verDisponibilidad = new JButton("Ver disponibilidad");
		verDisponibilidad.setBounds(441, 331, 152, 41);
		contentPane.add(verDisponibilidad);
		
		JButton verIngresos = new JButton("Ver ingresos");
		verIngresos.setBounds(441, 382, 152, 41);
		contentPane.add(verIngresos);
		
		JButton buscarHuesped_3 = new JButton("Buscar huésped");
		buscarHuesped_3.setBounds(441, 433, 152, 41);
		contentPane.add(buscarHuesped_3);

	}
}

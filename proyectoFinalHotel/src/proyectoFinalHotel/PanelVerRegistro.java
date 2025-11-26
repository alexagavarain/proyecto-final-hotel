package proyectoFinalHotel;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.JLabel;
import java.awt.Font;

public class PanelVerRegistro extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable tablaRegistros;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PanelVerRegistro frame = new PanelVerRegistro();
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
	public PanelVerRegistro() {
		setTitle("Ver registro de huéspedes");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 787, 562);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel tituloRegistro = new JLabel("Registro");
		tituloRegistro.setFont(new Font("Tahoma", Font.BOLD, 37));
		tituloRegistro.setBounds(314, 31, 177, 58);
		contentPane.add(tituloRegistro);
		
		tablaRegistros = new JTable();
		tablaRegistros.setBounds(113, 146, 187, 191);
		contentPane.add(tablaRegistros);

	}
}

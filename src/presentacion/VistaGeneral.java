package presentacion;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class VistaGeneral extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPrincipal frame = new VentanaPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
	/**
	 * Este atributo establece la comunicación con el controlador correspondiente.
	 */
	private ControladorVistaGeneral control;
	
	/**
	 * Este atributo establece la comunicación con el modelo.
	 */
	private Modelo model;
	
	public void capturaEventos() {
		
	}
	
	
	public ControladorVistaGeneral getControl() {
		return control;
	}


	


	/**
	 * Create the frame.
	 */
	public VistaGeneral(ControlVistaGeneral control, Modelo model) {
		this.control = control;
		this.model = model;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
	}

}

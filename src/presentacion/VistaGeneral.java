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
					Modelo modelo1 = new Modelo();
					VistaGeneral frame = new VistaGeneral(modelo1);
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
	private ControlVistaGeneral control;
	
	/**
	 * Este atributo establece la comunicación con el modelo.
	 */
	private Modelo modelo;
	
	public void capturaEventos() {
		
	}
	
	
	public ControlVistaGeneral getControl() {
		if(control == null){
            control = new ControlVistaGeneral(this);
        }
        return control;
	}


	
	/**
	 * Create the frame.
	 */
	public VistaGeneral(Modelo model) {		
		this.modelo = model;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
	}


	public Modelo getModelo() {		
		return this.modelo;
	}

}

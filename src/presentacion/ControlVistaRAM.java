package presentacion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class ControlVistaRAM implements ActionListener, ComponentListener, ChangeListener {

	private final VistaRAM ventanaRAM;
	private final Modelo modelo;

	public ControlVistaRAM(VistaRAM ventana) {
		this.ventanaRAM = ventana;
		this.modelo = ventanaRAM.getModelo();
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() instanceof JButton) {
			JButton boton = (JButton) arg0.getSource();
			if (boton == ventanaRAM.getBtnAceptar()) {
				// getModelo().cargarRAM();
			} else if (boton == ventanaRAM.getBtnBorrar()) {
				// getModelo().borrarRAM();
			} else if (boton == ventanaRAM.getBtnCargar()) {				
				Object[] possibilities = {"1 - Profesor Serrano", "2 - Profesor Oswaldo"};  
		        Integer i = (Integer) JOptionPane.showOptionDialog(null,   
		                null,  "ShowInputDialog",   
		                JOptionPane.PLAIN_MESSAGE, 1,  null, possibilities, 0);
		        System.out.println("sdsadasdasd:"+i);
		        if (i==0) {
		        	getModelo().cargarProgramaDefecto(1);	
		        }else {
		        	getModelo().cargarProgramaDefecto(2);
		        }
				
			} else {
				//matriz botones
			}
		} else {
		}

	}

	@Override
	public void stateChanged(ChangeEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void componentHidden(ComponentEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void componentMoved(ComponentEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void componentResized(ComponentEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void componentShown(ComponentEvent arg0) {
		// TODO Auto-generated method stub

	}

	public Modelo getModelo() {
		return modelo;
	}
}

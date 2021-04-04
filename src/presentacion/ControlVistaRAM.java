package presentacion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControlVistaRAM implements ActionListener{
	
	private final VistaRAM ventanaRAM;
    private final Modelo modelo;
    
	public ControlVistaRAM(VistaRAM ventana) {
        this.ventanaRAM = ventana;
        this.modelo = ventanaRAM.getModelo();
    }

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}

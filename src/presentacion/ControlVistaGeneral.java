package presentacion;

public class ControlVistaGeneral {
    
	private final VistaGeneral ventanaGeneral;
    private final Modelo modelo;

	public ControlVistaGeneral(VistaGeneral ventana) {
		this.ventanaGeneral = ventana;
		modelo = ventana.getModelo();
	}
}

package presentacion;

import logica.Microprocesador;

public class Modelo implements Runnable {

	// Atributos
	private boolean animando;
	private Microprocesador sistema;
	private VistaGeneral ventanaGeneral;
	private VistaRAM ventanaRAM;
	private Thread hiloDibujo;

	// Métodos ocultación de información

	public Microprocesador getSistema() {
		if (sistema == null) {
			//sistema = new Microprocesador();
		}
		return sistema;
	}

	public VistaGeneral getVentanaGeneral() {
		if (ventanaGeneral == null) {
			// ventanaGeneral = new VistaGeneral(this);
		}
		return ventanaGeneral;
	}

	// Métodos Punto de vista funcional
	void crearNuevoTablero() {
		if (!isAnimando()) {
			sistema = null; // Liberar memoria para este objeto
			System.gc(); // Invocar al recolector de basura sin espera
			animando = false;
		}
	}

	public void iniciar() {
		crearNuevoTablero();
		// getVentanaPrincipal().setSize(800, 600);
		// getVentanaGeneral().setVisible(true);
	}

	public void iniciarAnimacion() {
		// setVelocidad(110 - getVentanaGeneral().getSliVelocidad().getValue());
		// getVentanaGeneral().getBtnIniciar().setEnabled(false);
		// getVentanaGeneral().getBtnDetener().setEnabled(true);
		hiloDibujo = new Thread(this);
		hiloDibujo.start();
	}

	public void detenerAnimacion() {
		// getVentanaGeneral().getBtnIniciar().setEnabled(true);
		// getVentanaGeneral().getBtnDetener().setEnabled(false);
		animando = false;
		hiloDibujo = null;
		System.gc();
	}

	// Métodos correspondientes a la lógica de presentación
	private void animar() throws Exception {
		animando = true;
	}

	public boolean isAnimando() {
		return animando;
	}

	/**
	 * Pausa el hilo
	 * @param tiempo milisegundos 
	 * */
	public void esperar(int tiempo) {
		try {
			Thread.sleep(tiempo);
		} catch (InterruptedException ex) {
		}
	}

	@Override
	public void run() {
		try {
			animar();
		} catch (Exception ex) {
			// mensaje de error
		}
		// getVentanaGeneral().getBtnIniciar().setEnabled(true);
		// getVentanaGeneral().getBtnDetener().setEnabled(false);

	}

	/**
	 * Establece la velocidad del sistema
	 * @param i constante 
	 * */
	public void setVelocidad(int i) {
		// getSistema().setVelocidad(i);
	}
	
	public void restablecerComponentes() {

	}

	/**
	 * Controla la velocidad de la animacion con el slider de la vista general
	 * */
	public void controlarVelocidad() {
		//setVelocidad(110 - getVentanaGeneral().getSliVelocidad().getValue());
	}
}
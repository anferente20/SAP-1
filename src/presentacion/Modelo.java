package presentacion;

import logica.Microprocesador;

public class Modelo implements Runnable {

	// Atributos
	private boolean animando;
	private Microprocesador sistema;
	private VistaGeneral ventanaGeneral;
	private VistaRAM ventanaRAM;
	private Thread hiloDibujo;

	// M�todos ocultaci�n de informaci�n

	public Microprocesador getSistema() {
		if (sistema == null) {
			sistema = new Microprocesador();
		}
		return sistema;
	}

	public VistaGeneral getVentanaGeneral() {
		if (ventanaGeneral == null) {
			ventanaGeneral = new VistaGeneral(this);
		}
		return ventanaGeneral;
	}

	// M�todos Punto de vista funcional
	void crearNuevoTablero() {
		if (!isAnimando()) {
			sistema = null; // Liberar memoria para este objeto
			System.gc(); // Invocar al recolector de basura sin espera
			animando = false;
		}
	}

	public void iniciar() {
		crearNuevoTablero();
		getVentanaGeneral().setVisible(true);
	}

	public void iniciarAnimacion() {
		setVelocidad(110 - getVentanaGeneral().getSlider().getValue());
		System.out.println(110 - getVentanaGeneral().getSlider().getValue());
		getVentanaGeneral().getBtnPlay().setEnabled(false);
		getVentanaGeneral().getBtnPausar().setEnabled(true);
		hiloDibujo = new Thread(this);
		hiloDibujo.start();
	}

	public void detenerAnimacion() {
		getVentanaGeneral().getBtnPlay().setEnabled(true);
		getVentanaGeneral().getBtnPausar().setEnabled(false);
		animando = false;
		hiloDibujo = null;
		System.gc();
	}

	// Metodos correspondientes a la logica de presentacion
	private void animar() throws Exception {
		animando = true;
		String palabra = "";
		getSistema();
		cargarProgramaDefecto(1);
					
		while (!palabra.equals("HLT")) {
			palabra = ciclo();
		}
		

	}

	public boolean isAnimando() {
		return animando;
	}

	/**
	 * Pausa el hilo
	 * 
	 * @param tiempo milisegundos
	 */
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
		getVentanaGeneral().getBtnPlay().setEnabled(true);
		getVentanaGeneral().getBtnPausar().setEnabled(false);

	}

	/**
	 * Establece la velocidad del sistema
	 * 
	 * @param i constante
	 */
	public void setVelocidad(int i) {
		getSistema().setVelocidad(i);
	}

	public void restablecerComponentes() {
		getVentanaGeneral().getBtnPlay().setEnabled(true);
		getVentanaGeneral().getBtnPausar().setEnabled(false);
		getVentanaGeneral().getSlider().setMinimum(10);
		getVentanaGeneral().getSlider().setMaximum(100);

		getVentanaGeneral().getLblPC().setText("0 0 0 0");
		getVentanaGeneral().getLblMAR().setText("0 0 0 0");
		getVentanaGeneral().getBtnRAM().setText("0 0 0 0 0 0 0 0");
		getVentanaGeneral().getLblRI().setText("0 0 0 0 0 0 0 0");
		getVentanaGeneral().getLblCS().setText("");
		getVentanaGeneral().getLblAcumulador().setText("0 0 0 0 0 0 0 0");
		getVentanaGeneral().getLblALU().setText("");
		getVentanaGeneral().getLblRegistroB().setText("0 0 0 0 0 0 0 0");
		getVentanaGeneral().getLblOUT().setText("");
	}

	public int getVelocidad() {
		return this.getSistema().getVelocidad();
	}
	/**
	 * Controla la velocidad de la animacion con el slider de la vista general
	 */
	public void controlarVelocidad() {
		setVelocidad(110 - getVentanaGeneral().getSlider().getValue());
	}

	public void cargarProgramaDefecto(int programa) {
		this.sistema.cargarPrograma(programa);
	}

	public String ciclo() {
		// asigna la instruccion al mar
		sistema.setInstruccionMAR(sistema.getInstruccionPC());
		this.esperar(this.getVelocidad());
		sistema.aumentarPC();
		this.esperar(this.getVelocidad());
		// Busca la posición en la ram
		int[] instruccion = sistema.buscarInstruccioRAM(sistema.getMar().getDatos());
		this.esperar(this.getVelocidad());
		// Asigna la instruccion a IR
		String palabra = sistema.traducir(sistema.toDecimal(sistema.usarRI(instruccion, 1), 0, 3));
		this.esperar(this.getVelocidad());
		int[] datoRegistro = sistema.usarRI(instruccion, 2);
		this.esperar(this.getVelocidad());
		switch (palabra) {
		case "LDA":
			// Asigna la instruccion al MAR
			sistema.setInstruccionMAR(datoRegistro);
			this.esperar(this.getVelocidad());
			// Busca la posición en la ram
			instruccion = sistema.buscarInstruccioRAM(sistema.getMar().getDatos());
			this.esperar(this.getVelocidad());
			sistema.asignarAcumuladorA(instruccion);
			this.esperar(this.getVelocidad());
			break;
		case "ADD":
			sistema.setInstruccionMAR(datoRegistro);
			this.esperar(this.getVelocidad());
			// Busca la posición en la ram
			instruccion = sistema.buscarInstruccioRAM(sistema.getMar().getDatos());
			this.esperar(this.getVelocidad());
			sistema.asignarRegistroB(instruccion);
			this.esperar(this.getVelocidad());
			int suma = sistema.sumarDecimal(sistema.valorDecimalAcumulador(), sistema.valorDecimalRegistro());
			this.esperar(this.getVelocidad());
			sistema.asignarAcumuladorA(sistema.toBinario(suma, 8));
			this.esperar(this.getVelocidad());
			break;
		case "SUB":
			sistema.setInstruccionMAR(datoRegistro);
			this.esperar(this.getVelocidad());
			// Busca la posición en la ram
			instruccion = sistema.buscarInstruccioRAM(sistema.getMar().getDatos());
			this.esperar(this.getVelocidad());
			sistema.asignarRegistroB(instruccion);
			this.esperar(this.getVelocidad());
			int resta = sistema.restarDecimal(sistema.valorDecimalAcumulador(), sistema.valorDecimalRegistro());
			this.esperar(this.getVelocidad());
			sistema.asignarAcumuladorA(sistema.toBinario(resta, 8));
			this.esperar(this.getVelocidad());
			break;
		case "STA":
			sistema.setInstruccionMAR(datoRegistro);
			// Se busca la posicion para guardar en la ram
			int posicion = sistema.toDecimal(datoRegistro, 0, datoRegistro.length - 1);
			sistema.setRegistroRAM(posicion, sistema.obtenerValorAcumulador());
			break;
		case "LDI":
			// Asigna la instruccion al MAR
			sistema.setInstruccionMAR(datoRegistro);
			this.esperar(this.getVelocidad());
			sistema.asignarAcumuladorA(datoRegistro);
			this.esperar(this.getVelocidad());
			break;
		case "JMP":
			sistema.asignarPC(datoRegistro);
			this.esperar(this.getVelocidad());
			break;
		case "JC":
			if (sistema.valorDecimalAcumulador() >= 0) {
				sistema.asignarPC(datoRegistro);
				this.esperar(this.getVelocidad());
			}
			break;
		case "JZ":
			if (sistema.valorDecimalAcumulador() == 0) {
				sistema.asignarPC(datoRegistro);
				this.esperar(this.getVelocidad());
			}
			break;
		case "HLT":
			break;
		case "OUT":
			sistema.setOut(sistema.valorDecimalAcumulador());
			this.esperar(this.getVelocidad());
			System.out.println("El resultado es: " + sistema.valorDecimalAcumulador());
			break;
		}
		System.out.println("----------------------------------------------------------------------");
		return palabra;
	}

	void modificarRAM() {		
		VistaRAM ventanaRAM;
		ventanaRAM = new VistaRAM(this);		
		ventanaRAM.setVisible(true);
	}
}
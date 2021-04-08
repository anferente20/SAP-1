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
			// ventanaGeneral = new VistaGeneral(this);
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

	// M�todos correspondientes a la l�gica de presentaci�n
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
	public void cargarProgramaDefecto(int programa) {
		this.sistema.cargarPrograma(programa);
	}
	
	public String ciclo() {
		//asigna la instruccion al mar
		sistema.setInstruccionMAR(sistema.getInstruccionPC());
		sistema.aumentarPC();
		//Busca la posición en la ram
		int[] instruccion = sistema.buscarInstruccioRAM(sistema.getMar().getDatos());
		//Asigna la instruccion a IR
		String palabra = sistema.traducir(sistema.toDecimal(sistema.usarRI(instruccion,1), 0, 3));
		int[] datoRegistro = sistema.usarRI(instruccion,2);
		System.out.println(palabra);
		switch(palabra) {
			case "LDA":
				//Asigna la instruccion al MAR
				sistema.setInstruccionMAR(datoRegistro);
				//Busca la posición en la ram
				instruccion = sistema.buscarInstruccioRAM(sistema.getMar().getDatos());	
				sistema.asignarAcumuladorA(instruccion);
				break;
			case "ADD":
				sistema.setInstruccionMAR(datoRegistro);
				//Busca la posición en la ram
				instruccion = sistema.buscarInstruccioRAM(sistema.getMar().getDatos());	
				sistema.asignarRegistroB(instruccion);
				int suma = sistema.sumarDecimal(sistema.valorDecimalAcumulador(),sistema.valorDecimalRegistro());
				System.out.println(suma);				
				sistema.asignarAcumuladorA(sistema.toBinario(suma, 8));					
				break;
			case "SUB":
				sistema.setInstruccionMAR(datoRegistro);
				//Busca la posición en la ram
				instruccion = sistema.buscarInstruccioRAM(sistema.getMar().getDatos());	
				sistema.asignarRegistroB(instruccion);
				int resta = sistema.restarDecimal(sistema.valorDecimalAcumulador(),sistema.valorDecimalRegistro());				
				sistema.asignarAcumuladorA(sistema.toBinario(resta, 8));									
				break;
			case "STA":
				sistema.setInstruccionMAR(datoRegistro);
				//Se busca la posicion para guardar en la ram
				int posicion = sistema.toDecimal(datoRegistro, 0, datoRegistro.length-1);
				sistema.setRegistroRAM(posicion, sistema.obtenerValorAcumulador());
				break;
			case "LDI":
				//Asigna la instruccion al MAR
				sistema.setInstruccionMAR(datoRegistro);	
				sistema.asignarAcumuladorA(datoRegistro);
				break;
			case "JMP":
				sistema.asignarPC(datoRegistro);
				break;
			case "JC":
				if(sistema.valorDecimalAcumulador()>=0) {
					sistema.asignarPC(datoRegistro);
				}
				break;
			case "JZ":
				if(sistema.valorDecimalAcumulador()==0) {
					sistema.asignarPC(datoRegistro);
				}
				break;
			case "HLT":
				break;
			case "OUT":
				System.out.println("El resultado es: "+sistema.valorDecimalAcumulador());
				break;
		}
		System.out.println("----------------------------------------------------------------------");
		return palabra;
	}
}
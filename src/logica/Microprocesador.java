package logica;

public class Microprocesador {

	/**
	 * Este atributo representa al Registro de Instruccion del SAP
	 */
	private Registro registroInstruccion;

	/**
	 * Este atributo representa al Program Counter del SAP
	 */
	private PC programCounter;

	/**
	 * Este atributo representa a la RAM del SAP
	 */
	private RAM ram;

	/**
	 * Este atributo representa al MAR del SAP
	 */
	private Registro mar;

	/**
	 * Este atributo representa al Acumulador A del SAP
	 */

	private Registro acumuladorA;

	/**
	 * Este atributo representa al ALU del SAP
	 */
	private ALU alu;

	/**
	 * Este atributo representa al Registro B del SAP
	 */
	private Registro registroB;

	/**
	 * Este atributo representa al Control de Secuencia del SAP
	 */
	private ControlSecuencia cs;

	/**
	 * Este atributo representa el display led que se actualiza
	 */
	private int out;
	
	private int velocidad;

	public Microprocesador() {
		super();
		this.registroInstruccion = new Registro(8);
		this.programCounter = new PC(4);
		this.ram = new RAM(16, 8);
		this.mar = new Registro(4);
		this.acumuladorA = new Registro(8);
		this.alu = new ALU();
		this.registroB = new Registro(8);
		this.cs = new ControlSecuencia();
		this.out = 0;
	}
	
	/**
	 * Permite convertir un decimal en un arreglo de enteros {1,0} en representacion
	 * binaria
	 * 
	 * @param valor numero decimal
	 * @param tamano tama�o del arreglo resultante
	 * @return rta representacion binaria en arreglo
	 */
	public int[] toBinario(int valor, int tamano) {
		int[] binario = new int[tamano];
		String bin = "";
		for (int i = 0; i < tamano; i++) {
			binario[i] = 0;
		}
		if (tamano == 8 && valor < 0) {
			bin = Integer.toBinaryString(Math.abs(valor));
			String[] arrayBin = bin.split("");
			int contador = 0;			
			for (int i = tamano - arrayBin.length; i < tamano; i++) {
				binario[i] = Integer.valueOf(arrayBin[contador]);
				contador++;
			}
			binario[0] =1;
		} else {
			bin = Integer.toBinaryString(Math.abs(valor));
			String[] arrayBin = bin.split("");
			int contador = 0;
			for (int i = tamano - arrayBin.length; i < tamano; i++) {
				binario[i] = Integer.valueOf(arrayBin[contador]);
				contador++;
			}
		}

		return binario;
	}
	
	/**
	 * Permite convertir un arreglo de enteros {1,0} en su representacion decimal
	 * 
	 * @param datos  arreglo de datos binarios
	 * @param inicio posicion inicial del arreglo
	 * @param fin    posicion final del arreglo
	 * @return rta representacion decimal
	 */
	public int toDecimal(int[] datos, int inicio, int fin) {
		String resultado = "";
		if (fin > datos.length) {
			fin = datos.length;
		}				
		if(datos.length == 8 && datos[0] == 1) {
			datos[0] = 0;
			for (int i = inicio; i <= fin; i++) {
				resultado += datos[i];
			}
			return -Integer.parseInt(resultado, 2);			
		}else {
			for (int i = inicio; i <= fin; i++) {
				resultado += datos[i];
			}
			return Integer.parseInt(resultado, 2);
		}
		
	}
	
	public void setOut(int out) {
		this.out = out;
	}

	/**
	 * Este método permite cargar un programa en la RAM
	 */
	public void cargarPrograma(int programa) {
		this.ram.cargarProgramaDefecto(programa);
		this.cs.cargarVersion(programa);
	}

	/**
	 * Este método permite restaurar la memoria RAM y eliminar cualquier programa
	 * cargado
	 */
	public void restaurar() {

	}

	/**
	 * Este método obtiene la instrucción a ejecutar del programCounter
	 * 
	 * @return arreglo que indica la instrucción a ejecutar.
	 */
	public int[] getInstruccionPC() {
		return this.programCounter.getInstruccion();
	}

	/**
	 * Este método permite asignarle una instruccion al registro MAR
	 * 
	 * @param instruccion Instruccion a registrar
	 */
	public void setInstruccionMAR(int[] instruccion) {
		this.mar.setDatos(instruccion);
	}

	/**
	 * Este método permite aumentar el contador del Program Counter
	 */
	public void aumentarPC() {
		this.programCounter.aumentar();
	}

	/**
	 * Este método busca una instrucción específica en la RAM y devuelve la
	 * instrucción específicada
	 * 
	 * @param ubicacion ubicacion a buscar la instruccion
	 * @return instrucción almacenada en la RAM
	 */
	public int[] buscarInstruccioRAM(int[] ubicacion) {
		return this.ram.buscarInstruccion(ubicacion);
	}

	/**
	 * la unidad de control recibe la instruccion encontrada en la RAM
	 * posteriormente
	 * 
	 * @param datos arreglo de datos binarios
	 * @return rta instruccion y dato
	 */
	public int[] extraerSeccion(int[] datos, int pos) {
		int[] rta = new int[4];
		if (pos == 1) {
			for (int i = 0; i < 4; i++) {
				rta[i] = datos[i];
			}
		} else {
			int contador = 0;
			for (int i = 4; i < 8; i++) {
				rta[contador] = datos[i];
				contador++;
			}
		}
		return rta;
	}
	
	// otros metodos de acceso a funciones de los componentes
	public void printRAM() {
		this.ram.mostrarDatos();
	}

	public int sumarDecimal(int acumulador, int registroB) {
		return this.alu.sumar(acumulador, registroB);
	}

	public int restarDecimal(int acumulador, int registroB) {
		return this.alu.restar(acumulador, registroB);
	}

	public int valorDecimalAcumulador() {
		return toDecimal(this.acumuladorA.getDatos(), 0, this.acumuladorA.getNumBits() - 1);
	}

	public int valorDecimalRegistro() {
		return toDecimal(this.registroB.getDatos(), 0, this.registroB.getNumBits() - 1);
	}

	public void asignarAcumuladorA(int[] numero) {
		this.acumuladorA.setDatos(numero);
	}
	
	public void asignarRegistroI(int[] numero) {
		this.registroInstruccion.setDatos(numero);
	}

	public void asignarPC(int[] posicion) {
		this.programCounter.setDatos(posicion);
	}

	public int[] obtenerValorAcumulador() {
		return this.acumuladorA.getDatos();
	}

	public void asignarRegistroB(int[] numero) {
		this.registroB.setDatos(numero);
	}

	public int[] obtenerValorRegistroB() {
		return this.registroB.getDatos();
	}

	public String traducir(int instruccion) {
		return this.cs.traducir(instruccion);
	}

	public void setRegistroRAM(int posicion, int[] instruccion) {
		this.ram.setRegistro(posicion, instruccion);
	}

	
	// Metodos que permiten obtener el estado de cada componente
	public Registro getRegistroInstruccion() {
		return registroInstruccion;
	}

	public PC getProgramCounter() {
		return programCounter;
	}

	public RAM getRam() {
		return ram;
	}

	public Registro getMar() {
		return mar;
	}

	public Registro getAcumuladorA() {
		return acumuladorA;
	}

	public ALU getAlu() {
		return alu;
	}

	public Registro getRegistroB() {
		return registroB;
	}

	public ControlSecuencia getCs() {
		return cs;
	}

	public int getOut() {
		return out;
	}

	public void setVelocidad(int velocidad) {
		this.velocidad = velocidad;	
	}
	
	public int getVelocidad() {
		return this.velocidad;	
	}

}

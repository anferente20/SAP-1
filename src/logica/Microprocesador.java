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

	public Microprocesador() {
		super();
		this.registroInstruccion = new Registro(8);
		this.programCounter = new PC(0);
		this.ram = new RAM(16);
		this.mar = new Registro(4);
		this.acumuladorA = new Registro(8);
		this.alu = new ALU();
		this.registroB = new Registro(8);
		this.cs = new ControlSecuencia();
	}

	/**
	 * Este método permite cargar un programa en la RAM
	 */
	public void cargarPrograma() {

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
		this.aumentarPC();
	}

	/**
	 * Este método permite aumentar el contador del Program Counter
	 */
	private void aumentarPC() {
		this.programCounter.aumentar();
	}

	/**
	 * Este método busca una instrucción específica en la RAM y devuelve la
	 * instrucción específicada
	 * 
	 * @param ubicacion ubicacion a buscar la instruccion
	 * @return instrucción almacenada en la RAM
	 */
	public int buscarInstruccioRAM(int[] ubicacion) {
		return this.ram.buscarInstruccion(ubicacion);
	}

	/**
	 * la unidad de control recibe la instruccion encontrada en la RAM
	 * posteriormente
	 * 
	 * @param datos arreglo de datos binarios
	 * @return rta instruccion y dato
	 */
	public int[] usarRI(int[] datos) {		
		int[] rta = new int [2];
		this.registroInstruccion.setDatos(datos);
		// se debe obtener la instruccion a realizar en la unidad de control
		String numero = "";
		for (int i = 0; i < 4; i++) {
			numero += datos[i];
		}
		rta[0] = Integer.parseInt(numero, 2);
		numero = "";
		// se debe identificar el dato que acompa�a la instruccion
		for (int i = 4; i < datos.length; i++) {
			numero += datos[i];
		}		
		rta[1] = Integer.parseInt(numero, 2);
		return rta;
	}

}

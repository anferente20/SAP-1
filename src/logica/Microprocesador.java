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
		this.out = 0;
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
		// se modifican los datos en RI
		this.registroInstruccion.setDatos(datos);
		// se debe obtener la instruccion a realizar en la unidad de control		
		rta[0] = toDecimal(datos,0,3);		
		// se debe identificar el dato que acompa�a la instruccion		
		rta[1] = toDecimal(datos,4,datos.length);
		return rta;
	}
	
	/**
	 * Permite convertir un arreglo de enteros {1,0}
	 * en su representacion decimal
	 * @param datos arreglo de datos binarios
	 * @param inicio posicion inicial del arreglo
	 * @param fin posicion final del arreglo
	 * @return rta representacion decimal
	 */
	public int toDecimal(int[] datos, int inicio, int fin) {
		String resultado = "";
		if (fin>datos.length) {
			fin = datos.length;			
		}		
		for (int i = inicio; i <= fin; i++) {
			resultado += datos[i];
		}		
		return Integer.parseInt(resultado, 2);
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
}

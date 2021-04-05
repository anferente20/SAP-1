package logica;

public class Microprocesador {
	
	/**
	 * Este atributo representa al Registro de Instrucciones del SAP
	 */
	private Registro registroInstrucciones;
	
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

	
	
	public Microprocesador(Registro registroInstrucciones, PC programCounter, RAM ram, Registro mar,
			Registro acumuladorA, ALU alu, Registro registroB, ControlSecuencia cs) {
		super();
		this.registroInstrucciones = registroInstrucciones;
		this.programCounter = programCounter;
		this.ram = ram;
		this.mar = mar;
		this.acumuladorA = acumuladorA;
		this.alu = alu;
		this.registroB = registroB;
		this.cs = cs;
	}
	
	/**
	 * Este método permite cargar un programa en la RAM
	 */
	public void cargarPrograma() {
		
	}
	
	/**
	 * Este método permite restaurar la memoria RAM y eliminar cualquier programa cargado
	 */
	public void restaurar() {
		
	}
	
	

	public Registro getRegistroInstrucciones() {
		return registroInstrucciones;
	}

	public void setRegistroInstrucciones(Registro registroInstrucciones) {
		this.registroInstrucciones = registroInstrucciones;
	}

	public PC getProgramCounter() {
		return programCounter;
	}

	public void setProgramCounter(PC programCounter) {
		this.programCounter = programCounter;
	}

	public RAM getRam() {
		return ram;
	}

	public void setRam(RAM ram) {
		this.ram = ram;
	}

	public Registro getMar() {
		return mar;
	}

	public void setMar(Registro mar) {
		this.mar = mar;
	}

	public Registro getAcumuladorA() {
		return acumuladorA;
	}

	public void setAcumuladorA(Registro acumuladorA) {
		this.acumuladorA = acumuladorA;
	}

	public ALU getAlu() {
		return alu;
	}

	public void setAlu(ALU alu) {
		this.alu = alu;
	}

	public Registro getRegistroB() {
		return registroB;
	}

	public void setRegistroB(Registro registroB) {
		this.registroB = registroB;
	}

	public ControlSecuencia getCs() {
		return cs;
	}

	public void setCs(ControlSecuencia cs) {
		this.cs = cs;
	}
	
	/**
	 * Este método obtiene la instrucción a ejecutar del programCounter
	 * @return arreglo que indica la instrucción a ejecutar.
	 */
	public int[] getInstruccionPC() {
		return this.programCounter.getInstruccion();
	}
	
	/**
	 * Este método permite asignarle una instruccion al registro MAR
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
	 * Este método busca una instrucción específica en la RAM y devuelve la instrucción específicada
	 * @param ubicacion ubicacion a buscar la instruccion
	 * @return instrucción almacenada en la RAM
	 */
	public int buscarInstruccioRAM(int[] ubicacion) {
		return this.ram.buscarInstruccion(ubicacion);
	}
	
}

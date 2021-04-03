package logica;

public class RAM {

	/**
	 * Este atributo determina el tamaño de la memoria RAM
	 */
	private int tamMemoria;
	
	/**
	 * Este arreglo de enteros almacena el entero correspondiente de cada una de las instrucciones y datos almacenados
	 */
	private int[] datos; 
	
	public RAM(int tamMemoria) {
		this.tamMemoria = tamMemoria;
		this.datos = new int[tamMemoria];
	}
	
	/**
	 * Este método permite obtener la instrucción en una posición específica de la RAM
	 * @param posicion posición de la instruccion
	 * @return Entero correspondiente a la instrucción solicitada
	 */
	public int getInstruccion(int posicion) {
		return this.datos[posicion];
	}
}

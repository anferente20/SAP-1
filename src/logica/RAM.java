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
		for(int i = 0; i<tamMemoria;i++) {
			this.datos[i] = 0;
		}
	}
	
	/**
	 * Este método permite obtener la instrucción en una posición específica de la RAM
	 * @param posicion posición de la instruccion
	 * @return Entero correspondiente a la instrucción solicitada
	 */
	private int getInstruccion(int posicion) {
		return this.datos[posicion];
	}
	
	public int buscarInstruccion(int[] ubicacion) {
		int valor = 0;
		for(int i =0;i<ubicacion.length;i++) {
			valor += ubicacion[i]*Math.pow(2, 3-i);
		}
		return (int)getInstruccion(valor);
	}
}

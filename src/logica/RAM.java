package logica;

public class RAM {

	/**
	 * Este atributo determina el tamaño de la memoria RAM
	 */
	private int tamMemoria;
	
	/**
	 * Este arreglo de enteros almacena el entero correspondiente de cada una de las instrucciones y datos almacenados
	 */
	private int[][] datos; 
	
	public RAM(int tamMemoria, int numBits) {
		this.tamMemoria = tamMemoria;
		this.datos = new int[tamMemoria][numBits];
		for(int i = 0; i<tamMemoria;i++) {
			for(int j=0;j<numBits;j++) {
				this.datos[i][j] = 0;
			}
		}
	}
	
	/**
	 * Este método permite obtener la instrucción en una posición específica de la RAM
	 * @param posicion posición de la instruccion
	 * @return Entero correspondiente a la instrucción solicitada
	 */
	private int[] getInstruccion(int posicion) {
		return this.datos[posicion];
	}
	
	public int[] buscarInstruccion(int[] ubicacion) {
		int valor = 0;
		for(int i =0;i<ubicacion.length;i++) {
			valor += ubicacion[i]*Math.pow(2, 3-i);
		}
		return getInstruccion(valor);
	}
	
	public void cargarProgramaDefecto(int programa) {
		if(programa == 1) {
			this.datos[0][4] = 1; this.datos[2][3] = 1; this.datos[3][4] = 1; this.datos[5][0] = 1; this.datos[10][3] = 1;
			this.datos[0][7] = 1; this.datos[2][4] = 1; this.datos[3][5] = 1; this.datos[5][1] = 1; this.datos[10][5] = 1;
			this.datos[1][3] = 1; this.datos[2][6] = 1; this.datos[4][0] = 1; this.datos[5][2] = 1; this.datos[11][3] = 1;
			this.datos[1][4] = 1; this.datos[2][7] = 1; this.datos[4][1] = 1; this.datos[5][3] = 1; this.datos[11][4] = 1;
			this.datos[1][6] = 1; this.datos[3][2] = 1; this.datos[4][2] = 1; this.datos[9][3] = 1; this.datos[12][2] = 1;
		}else {
			this.datos[0][3] = 1; this.datos[0][4] = 1; this.datos[0][5] = 1; this.datos[0][6] = 1; this.datos[1][2] = 1;
			this.datos[1][3] = 1; this.datos[1][4] = 1; this.datos[1][5] = 1; this.datos[2][1] = 1; this.datos[2][2] = 1;
			this.datos[2][3] = 1; this.datos[2][5] = 1; this.datos[2][6] = 1; this.datos[3][3] = 1; this.datos[3][4] = 1;
			this.datos[3][5] = 1; this.datos[3][7] = 1; this.datos[4][0] = 1; this.datos[4][1] = 1; this.datos[4][2] = 1;
			this.datos[5][0] = 1; this.datos[5][1] = 1; this.datos[5][2] = 1; this.datos[5][3] = 1; this.datos[6][1] = 1;
			this.datos[6][4] = 1; this.datos[6][5] = 1; this.datos[6][6] = 1; this.datos[7][3] = 1; this.datos[7][4] = 1;
			this.datos[7][5] = 1; this.datos[7][7] = 1; this.datos[8][2] = 1; this.datos[8][4] = 1; this.datos[8][5] = 1;
			this.datos[8][7] = 1; this.datos[8][6] = 1; this.datos[9][1] = 1; this.datos[9][4] = 1; this.datos[9][5] = 1;
			this.datos[9][7] = 1; this.datos[10][1] = 1; this.datos[10][2] = 1; this.datos[12][7] = 1; this.datos[14][5] = 1;
			this.datos[14][7] = 1; this.datos[15][6] = 1; this.datos[15][7] = 1; 
		}
	}
	
	public void setRegistro(int posicion, int[] instruccion) {
		for(int i=0;i<instruccion.length;i++) {
			this.datos[posicion][i] = instruccion[i];
		}
	}
	public void mostrarDatos() {
		for(int i = 0;i<tamMemoria;i++) {
			for(int j=0;j<8;j++) {
				System.out.print(this.datos[i][j]);
			}
			System.out.println();
		}
	}
}

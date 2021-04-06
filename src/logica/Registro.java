package logica;

public class Registro {
	
	/**
	 * Este atributo indica el número de bits con los que se contaran en el registro.
	 */
	private int numBits;
	
	/**
	 * Este arreglo contiene la informacion proveniente de la RAM
	 */
	private int[] datos;
			
	public Registro(int numBits) {
		this.numBits = numBits;
		this.datos = new int[numBits];
		for(int i=0;i<numBits;i++) {
			this.datos[i] = 0;
		}
	}

	public int getNumBits() {
		return numBits;
	}

	public void setNumBits(int numBits) {
		this.numBits = numBits;
	}

	public int[] getDatos() {
		return datos;
	}

	public void setDatos(int[] datos) {
		this.datos = datos;
	}
	
	public void mostrarDatos() {
		for(int i=0;i<this.numBits;i++) {
			System.out.print(this.datos[i]);
		}
	}
	
}

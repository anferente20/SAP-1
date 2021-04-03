package logica;

public class Registro {
	
	/**
	 * Este atributo indica el número de bits con los que se contaran en los registro.
	 */
	private int numBits;
	
	/**
	 * Este arreglo contendrá la información a ser procesada en la RAM
	 */
	private int[] datos;
			
	public Registro(int numBits) {
		this.numBits = numBits;
		this.datos = new int[numBits];
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
	
	
	
}

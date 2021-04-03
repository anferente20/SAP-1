package logica;

public class PC extends Registro{
	public PC(int numBits) {
		super(numBits);
		this.CE = false;
	}

	/**
	 * Este atributo representa el contador
	 */
	private boolean CE;

	public boolean isCE() {
		return CE;
	}

	public void setCE(boolean cE) {
		CE = cE;
	}
	
//	
	
	
}

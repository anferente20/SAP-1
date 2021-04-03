package logica;

public class ControlSecuencia {
	
	//A continuación se enuncian las interpretaciones de todas las operaciones con las que cuenta el SAP
	private static int LDA = 0;
	private static int ADD = 1;
	private static int SUB = 2;
	private static int STA = 3;
	private static int LDI = 4;
	private static int JMP = 5;
	private static int JC = 6;
	private static int JZ = 7;
	private static int OUT = 8;
	private static int HLT = 9;

	/**
	 * Este método permite traducir la instrucción de su componente númerico a la palabra en
	 * lenguaje natural que se mostrará en el LED
	 * @param instruccion entero a traducir
	 * @return String que corresponde a la palabra indicada
	 */
	public String traducir(int instruccion) {
		return "";
	}
}

package logica;

public class ControlSecuencia {

	/**
	 * Permite traducir la instruccion con representacion decimal
	 * a la palabra en lenguaje natural
	 * 
	 * @param instruccion entero a traducir
	 * @return String que corresponde a la palabra indicada
	 */
	public String traducir(int instruccion) {
		String respuesta = "";
		switch (instruccion) {
		case 1:
			respuesta = "LDA";
			break;
		case 2:
			respuesta = "ADD";
			break;
		case 3:
			respuesta = "SUB";
			break;
		case 4:
			respuesta = "STA";
			break;
		case 5:
			respuesta = "LDI";
			break;
		case 6:
			respuesta = "JMP";
			break;
		case 7:
			respuesta = "JC";
			break;
		case 8:
			respuesta = "JZ";
			break;
		case 14:
			respuesta = "OUT";
			break;		
		case 15:
			respuesta = "HLT";
			break;
		
		}
		return respuesta;
	}
	
	/**
	 * Permite traducir la instruccion en lenguaje natural
	 * a su representacion decimal
	 * 
	 * @param palabra indicada a traducir
	 * @return int representacion decimal
	 */
	public int traducir(String instruccion) {
		int respuesta = 0;
		switch (instruccion) {		
		case "LDA":
			respuesta = 0;
			break;
		case "ADD":
			respuesta = 1;
			break;
		case "SUB":
			respuesta = 2;
			break;
		case "STA":
			respuesta = 3;
			break;
		case "LDI":
			respuesta = 4;
			break;
		case "JMP":
			respuesta = 5;
			break;
		case "JC":
			respuesta = 6;
			break;
		case "JZ":
			respuesta = 7;
			break;
		case "OUT":
			respuesta = 8;
			break;		
		case "HLT":
			respuesta = 9;
			break;
		default:
			respuesta = 0;
			break;
		}
		return respuesta;
	}
}
	package logica;

public class ALU {

	/**
	 * Este método permite sumar los números del acumulador y el registro B, devolviendo su resultado
	 * @param acumulador Valor almacenado en el acumulador
	 * @param registroB Valor almacenado en el registro B
	 * @return el entero resultante de la suma
	 */
	public int sumar(int acumulador, int registroB) {
		int resultadosuma = 0;
		if (acumulador>=0 && registroB>=0) {
			
			resultadosuma= acumulador + registroB; 
		}
		else {
			if (acumulador<0 && registroB<0) {
				resultadosuma= (~acumulador + 1) + (~registroB + 1);	
			}
			else {
				if(acumulador<0 && registroB>=0){
					resultadosuma= (~acumulador + 1) + registroB;	
				}
				else {
					if(acumulador>=0 && registroB<0) {
						resultadosuma= acumulador + (~registroB + 1);
					}
				}
			}
		}	
		return resultadosuma;
	}
	
	/**
	 * Este método permite restar los números del acumulador y el registro B, devolviendo su resultado
	 * @param acumulador Valor almacenado en el acumulador
	 * @param registroB Valor almacenado en el registro B
	 * @return el entero resultante de la resta
	 */
	public int restar(int acumulador, int registroB) {
		
		int resultadoresta = 0;
		
		resultadoresta= acumulador + (~registroB + 1);
		
		
		return resultadoresta;
	}
}

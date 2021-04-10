package presentacion;

public class Prueba {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Modelo model = new Modelo();
		String palabra = "";
		model.getSistema();
		model.cargarProgramaDefecto(1);
		model.iniciarAnimacion();
		/*
		while(!palabra.equals("HLT")){			
			palabra = model.ciclo();
		}
		*/
	}

}

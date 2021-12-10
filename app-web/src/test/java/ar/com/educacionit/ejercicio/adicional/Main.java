package ar.com.educacionit.ejercicio.adicional;

public class Main {

	public static void main(String[] args) {
		//crear los valores
		Avion a = new Avion("474",10);
		Ovni o = new Ovni("N/I", "circular");
		
		//crear un vector de voladores
		Volador[] voladores = new Volador[] {a,o};
		
		//recorrer el vector
		for(Volador unVolador : voladores) {
			
			//verificar si cumplian el contrato
			if(unVolador.getClass().isAssignableFrom(Aterrizable.class)) {
				
				//me aseguro que unVolador tiene el metodo 
				Aterrizable atr = (Aterrizable)unVolador;
				Resultado res = atr.aterrizar();//->resultado
				
				//evaluar que paso OK|Error
				if(res.isExitoso()) {
					System.out.println("Todo ok!");
				}else {
					System.out.println("Algo salio mal, enviando ayuda!");
				}
			}			
		}
				
	}
}

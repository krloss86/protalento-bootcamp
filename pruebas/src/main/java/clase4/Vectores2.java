package clase4;

import java.util.Arrays;

public class Vectores2 {

	public static void main(String[] args) {
		
		String[] nombres = new String[] {"luz","josé","edwin","carlos","herana","samir","elsa"};//X
	
		//determinar la cantidad de nombres que inican con e
		
		//creamos el vector con dicho tamaño
		
		int cantidad = 0;
		for(String nombre : nombres) {
			if(nombre.startsWith("e")) {
				cantidad ++;
			}
		}
		
		//creo el vector nuevo con el tamaño correcto		
		String[] nombresConE = new String[cantidad];
		
		int pos = 0;
		
		for(String nombre : nombres) {
			if(nombre.startsWith("e")) {
				nombresConE[pos] = nombre;
				pos++;
			}
		}
		
		System.out.println(Arrays.toString(nombresConE));
	}
}

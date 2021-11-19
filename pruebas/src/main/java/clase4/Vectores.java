package clase4;

import java.util.Arrays;

public class Vectores {

	public static void main(String[] args) {
		
		String[] nombres = new String[] {"luz","josé","edwin","carlos","herana","samir","elsa"};//X
		String[] nombresConE = new String[nombres.length]; 
		
		int j = 0;
		
		for(int i=0; i < nombres.length; i++ ) {//0
			String nombre = nombres[i]; 			
			
			if(nombre.startsWith("e")) {
				nombresConE[j] = nombre;
				j++;
			}
		}
		
		System.out.println(Arrays.toString(nombresConE));
//		con un for recorriendo el vector y un if para comparar si esta null o no
		for(String nombre : nombresConE) {
			if(nombre != null) {
				System.out.println(nombre);
			}
		}
	}

}

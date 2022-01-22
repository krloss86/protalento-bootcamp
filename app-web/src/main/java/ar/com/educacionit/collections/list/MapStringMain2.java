package ar.com.educacionit.collections.list;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MapStringMain2 {

	public static void main(String[] args) {
		
		Map<String, Integer> mapa = new HashMap<>();

		Scanner teclado = new Scanner(System.in);
		System.out.println(mapa);
		
		String nombre = "";
		do {
			System.out.println("ingrese nombre");
			nombre = teclado.next();
			
			if(!"FIN".equals(nombre)) {
				if(mapa.containsKey(nombre)) {
					Integer value = mapa.get(nombre);
					value++;
					mapa.put(nombre, value);
				}else {
					mapa.put(nombre, 1);
				}
			}
		}while(!nombre.equalsIgnoreCase("FIN"));
		System.out.println(mapa);

		System.out.println("NOMBRE A ELIMINAR");
		nombre = teclado.next();
		
		if(mapa.containsKey(nombre)) {
			mapa.remove(nombre);
		}else {
			System.out.println("no existe " + nombre + " en el mapa");
		}
		
		System.out.println(mapa);
	}

}

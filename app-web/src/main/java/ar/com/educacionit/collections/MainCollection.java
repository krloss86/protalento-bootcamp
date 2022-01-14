package ar.com.educacionit.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class MainCollection {

	public static void main(String[] args) {
		
		//creo
		Collection<String> nombres = new ArrayList<>();  
		
		//agregar
		nombres.add(new String("edwin"));
		nombres.add(new String("camilo"));
		nombres.add(new String("juan"));
		
		//obtener
		Iterator<String> itNombres = nombres.iterator();
		while(itNombres.hasNext()) {
			String dato = itNombres.next();
			System.out.println("Dato: " + dato);
		}
		
		//eliminar DA ERROR java.util.ConcurrentModificationException
		/*for(String nombre : nombres) {
			nombres.remove(nombre);
		}*/
		
		//buscar sin alterar el tamaño de la coleccion 
		for(String nombre : nombres) {
			if(nombre.equalsIgnoreCase("juan")  ) {
				nombre = new String("jose");
			}
		}
		
		System.out.println(nombres);
		
		itNombres = nombres.iterator();
		while(itNombres.hasNext()) {
			String nombre = itNombres.next();
			if(nombre.equalsIgnoreCase("juan")  ) {
				nombre = new String("jose");
			}
		}
		
		//eliminar con Iterator
		itNombres = nombres.iterator();
		while(itNombres.hasNext()) {
			itNombres.next();
			itNombres.remove();
		}
		
	}
}

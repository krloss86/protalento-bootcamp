package ar.com.educacionit.collections;

import java.util.ArrayList;
import java.util.List;

public class MainCollection3 {

	public static void main(String[] args) {
		
		//creo
		List<String> nombres = new ArrayList<>();  
		
		//agregar
		nombres.add(new String("edwin"));
		nombres.add(new String("camilo"));
		nombres.add(new String("juan"));
		nombres.add(new String("juan"));
		
		List<String> apellidos = new ArrayList<>();
		apellidos.add("perez");
		apellidos.add("lopez");
		apellidos.add("juarez");
		
		//Lista de lista
		List<List<String>> nombresList = new ArrayList<>();
		nombresList.add(nombres);
		nombresList.add(apellidos);
		
		//recorrer
		System.out.println(nombresList);
		for(List<String> nl : nombresList ) {
			for(String aux : nl) {
				System.out.println(aux);
			}
		}
	
		
	}
}

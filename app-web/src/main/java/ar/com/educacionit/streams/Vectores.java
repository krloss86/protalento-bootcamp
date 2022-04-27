package ar.com.educacionit.streams;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Vectores {

	public static void main(String[] args) {
		Collection<Integer> edades = new ArrayList<>();

		edades.add(10);
		edades.add(30);
		edades.add(50);		
		edades.add(5);
		
		//filtrar los elementos >=30
		List<Integer> filtrados = new ArrayList<>();
		for(Integer aux : edades) {
			if(aux >=30) {
				filtrados.add(aux);
			}
		}
		
		if(!filtrados.isEmpty()) {
			System.out.println("Hay elementos >=30" + filtrados);
		}else {
			System.out.println("NO Hay elementos >=30");
		}
	}

}

package ar.com.educacionit.collections.list;

import java.util.List;

public class BuscadorListMain {

	public static void main(String[] args) {
		String clave  = "iron man";

		Buscador b = new Buscador(clave);
		
		b.buscar();
		
		List<String> resultados = b.getResultados();
		
		for(String art : resultados ) {
			System.out.println(art);
		}
	}

}

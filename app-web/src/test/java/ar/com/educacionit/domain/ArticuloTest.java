package ar.com.educacionit.domain;

import java.util.Date;

public class ArticuloTest {

	public static void main(String[] args) {
		//assert
		Articulos miArticulo = new Articulos("titulo1", new Date(), "0001", 2500.0D, 5L, 1L, 1L);
		
		//f3
		//alt <-
		//alt ->
		String titulo = miArticulo.getTitulo(true);
		
		boolean iguales = titulo.equals("TITULO1");
		
		if(iguales) {
			System.out.println("ok");
		}else {
			System.out.println("fail");
		}
	}
}

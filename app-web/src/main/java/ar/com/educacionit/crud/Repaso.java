package ar.com.educacionit.crud;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Repaso {

	public static void main(String[] args) {

/*
	SI	-Base de datos,, driver , en especifico conexión base de datos a Java
		-Colecciones y excepciones 
		-Ciclos y Arrays 
		-Interfaces, instancias en interfaz genérica y prueba de escritorio 
		-Clases abstractas 
		-toString 
		-Herencia 
	SI	-Manejo de GIT y repositorios
		- reflexion
		-Interfaces, instancias en interfaz genérica y prueba de escritorio 
		-Clases abstractas 
		-toString

*/
	
		Scanner teclado = new Scanner(System.in);
		int continuar;
		
		do {
			int opcion;
			do {
				Menu.mostar();	
				opcion = teclado.nextInt();
			}while(opcion < 0 || opcion > 4);
			
			try {
				Ejecutable ej = CreadorDeEjecutables.obtenerEjecutable(opcion);
				
				ILectora lector = new LectorPorConsole(teclado);				
				Data data = lector.leerDatos();
				
				//1 > id,titulo
				//2 > id
				//3 > titulo
				//4 > id
				Long id;
				String titulo;				
				//Data data = new Data();
				if(opcion == 1) {					
					id = teclado.nextLong();
					titulo = teclado.next();
					data.setId(id);
					data.setTitulo(titulo);
				}else if(opcion == 2) {
					id = teclado.nextLong();
					data.setId(id);
				}else if(opcion == 3) {
					titulo = teclado.next();
					data.setTitulo(titulo);
				} else {
					id = teclado.nextLong();
					data.setId(id);
				}
				
				ej.ejectuar(data);
			}catch (Exception e) {
				System.err.println(e.getMessage());
			}
			
			Menu.mostarContinuar();
			continuar = teclado.nextInt();
		}while(continuar == 1);
		
		teclado.close();			
		System.out.println("FIN");
		
	}

}

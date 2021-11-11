package pruebas;

import java.util.Scanner;

public class Ejercicio2 {

	public static void main(String[] args) {

		Scanner teclado = new Scanner(System.in);

		//ahora puedo leer datos desde el taclado
		//f5,f6,f7,f8
		System.out.println("Ingrese el valor de a:");
		int a = teclado.nextInt();//leer un dato entero
		//f6
		System.out.println("Ingrese el valor de b:");
		int b = teclado.nextInt();
		//f6
		int suma = a + b;
		//f6
		System.out.println("la suma es=" + suma);
		
		//cierro el teclado f8
		teclado.close();
	}

}

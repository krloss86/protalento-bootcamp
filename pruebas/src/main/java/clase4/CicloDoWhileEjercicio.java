package clase4;

import java.util.Scanner;

public class CicloDoWhileEjercicio {

	public static void main(String[] args) {
		
		// leer un valor numerico
		// > 0 && <=10
		// acumular la suma de dichos valores
		// MOSTRAR EL VALOR ACUMULADO

		Scanner teclado = new Scanner(System.in);
		int valor;//30
		int suma = 0;
		do {
			System.out.println("Ingrese valor:");
			valor = teclado.nextInt();//20
			
			//logica
			suma += valor;//10 + 20
			
			//??
			// 20>0 && 20<=10 => NO
		}while(valor >0 && valor <= 10);
		
		//AFUERA!!
		System.out.println("SUMA:"+suma);
	}

}

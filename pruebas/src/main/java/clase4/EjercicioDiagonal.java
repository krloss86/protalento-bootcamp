package clase4;

import java.util.Scanner;

public class EjercicioDiagonal {

	public static void main(String[] args) {
		
		Scanner teclado = new Scanner(System.in);
		
		System.out.println("ingrese cantidad de filas");
		int cantFilas = teclado.nextInt();
		
		System.out.println("ingrese cantidad de columnas");
		int cantColumnas = teclado.nextInt();
		
		if(cantFilas == cantColumnas) {
			
			Integer[][] matriz= new Integer[cantFilas][cantColumnas];
			
			System.out.println("Ingrese valores:");
			
			for(int f=0; f<cantFilas; f++) {
				for(int c =0; c<cantColumnas; c++) {
					System.out.println("ingrese (" + f  +","+ c+")");
					int aux = teclado.nextInt();
					matriz[f][c] = aux;
				}
			}
			
			boolean todosUno = true;
			for(int f=0; f<cantFilas; f++) {
				for(int c =0; c<cantColumnas; c++) {
					if(f == c) {
						if(matriz[f][c] != 1) {
							todosUno = false;
							break;
						}
					}
				}
			}
			
			if(todosUno == true) {
				System.out.println("matriz con diagonal en 1");
			}else {
				System.out.println("matriz sin diagonal en 1");
			}
		}
		teclado.close();
	}

}

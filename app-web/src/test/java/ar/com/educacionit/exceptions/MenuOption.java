package ar.com.educacionit.exceptions;

import java.util.Scanner;

public class MenuOption {

	public static Integer getMenu() /*throws InvalidMenuException*/ {
		
		Scanner teclado = new Scanner(System.in);
		
		System.out.println("Ingrese menu:");
		System.out.println("1: alta"
				+ "2:baja"
				+ "3:modificacion");
		
		Integer op = teclado.nextInt();
		try {
			if(op != 1 && op != 2 && op !=3) {
				throw new InvalidMenuException(op + "No es valido");
			}
		}finally {
			teclado.close();
		}
		return op;
	}
}

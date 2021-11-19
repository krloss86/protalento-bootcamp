package clase4;

import java.util.Arrays;

public class Cuentas {

	public static void main(String[] args) {
		
		//viene dede afuerta
		String[] archivo = new String[]{
				"1000;juan lopez;1500;ca",
				"2000;jose guzman;115000;ca",
				"3000;juan martinez;-1000;cc",
				"4000;matias perez;100000;cc",
				"5000;elsa moyano;21000;cc"};
		
		//obtener las cuentas con saldo negativo con apyn
		//obtener la cuentas con saldo > 100000 con apyn
		
		Object[][] saldosNegativo = new Object[archivo.length][4];
		Object[][] saldosMayor100 = new Object[archivo.length][4];
		
		for(int i=0;i< archivo.length;i++ ) {
			String registro = archivo[i];
			
			String[] cuenta = registro.split(";");
			Integer numCuenta = Integer.parseInt(cuenta[0]);
			String apyn = cuenta[1];
			Double saldo = Double.parseDouble(cuenta[2]);
			String tipo = cuenta[3];
			
			if(saldo < 0) {
				saldosNegativo[i][0] = saldo;
				saldosNegativo[i][1] = apyn;
				saldosNegativo[i][2] = numCuenta;
				saldosNegativo[i][3] = tipo;
			}
			if(saldo >= 100000) {
				saldosMayor100[i][0] = saldo;
				saldosMayor100[i][1] = apyn;
				saldosMayor100[i][2] = numCuenta;
				saldosMayor100[i][3] = tipo;
			}
		}
		
		System.out.println("Saldos negativos");
		for(int f=0;f<saldosNegativo.length;f++) {
			for(int c=0;c<saldosNegativo[f].length;c++) {
				if(saldosNegativo[f][c] != null) {
					System.out.println(saldosNegativo[f][c]);
				}
			}
			System.out.println("-----------");
		}
		System.out.println("*************************************");
		System.out.println("Saldos Mayores o iguales a 100000");
		for(int f=0;f<saldosMayor100.length;f++) {
			for(int c=0;c<saldosMayor100[f].length;c++) {
				if(saldosMayor100[f][c] != null) {
					System.out.println(saldosMayor100[f][c]);
				}
			}
			System.out.println("-----------");
		}
	}

}

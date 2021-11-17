package clase4;

import java.util.Scanner;

public class CicloForEjercicio {

	public static void main(String[] args) {
		
		// solicitar al usuario la cantidad de registros
		// cargar en un vector de enteros los datos ingresados por el usuario
		// contar la cantidad de numero pares
		// contar la cantidad de numero impares
		// sumar los numero pares
		// sumar los numero impares
		// promedio de los valores ingresados
		int cantidadRegistros;
		int[] vector;//definir
		int cantPares = 0;
		int cantImpares = 0;
		int sumaPares = 0;
		int sumaImpares = 0;
		double promedio;
		
		//0 definir el tamaño del vector
		//1 carga de datos
		//2 procesamiento
		
		Scanner teclado = new Scanner(System.in);
		do {//alt+arriba|abajo
			System.out.println("Ingrese la cantidad de registros a procesar: > 0");
			cantidadRegistros = teclado.nextInt();// -1
		}while(cantidadRegistros <= 0);  
		
		vector = new int[cantidadRegistros];
		//4: 0,1,2,3
		//carga de datos
		for(int i=0; i < cantidadRegistros ; i++) {
			System.out.println("Ingrese un dato:");
			int datoleido = teclado.nextInt();
			vector[i] = datoleido;  
		}
		
		//procesamiento
		//for/while/dowhile/foreach ??
		for(int dato : vector) { 
			
			if(dato % 2 == 0) {//es par?  2
				cantPares++;//cantidad   1
				sumaPares += dato;//suma  2
			}else {
				cantImpares++;
				sumaImpares += dato;
			}
		}
		//ctrl+shit+i
		promedio = (double)(sumaImpares + sumaPares) / (cantImpares + cantPares);
		
		System.out.println(java.util.Arrays.toString(vector));
		
		// mostrar los datos calculados
		System.out.println("Cantidad de registros:"+ cantidadRegistros);
		System.out.println("Cantidad de pares:"+ cantPares);
		System.out.println("Cantidad de impares:"+ cantImpares);
		System.out.println("Suma de pares:"+ sumaPares);
		System.out.println("Suma de impares:"+ sumaImpares);
		System.out.println("Promedio:"+ promedio);
		
		teclado.close();
	}

}

package clase4;

public class Arrays {

	public static void main(String[] args) {
		
		//crear vector
		int[] edades = new int[2]; //un vector de 2 posiciones 0,1
		
		// [0,0,0]
		//  0 1 2
		//carga
		edades[0] = 5;
		edades[1] = 10;
		// edades[2] = 15; NO VA
		
		//atributo length

		int tamanio = edades.length; //tamaño del vector
		
		//acceder al último elemento
		int edad = edades[tamanio -1 ];
		
		// edades[0];
		
		// edades[2];// bien??
	}

}

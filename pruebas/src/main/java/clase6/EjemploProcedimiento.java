package clase6;

public class EjemploProcedimiento {

	public static void main(String[] args) {
		
		//invocar el procedimiento
		saludar("¿cómo estás?");
		
		responder("bien, gracias!");
		
		//calcular la suma de dos variables
		int a = 10;
		int b = 20;
		//int c = a + b;
		//asignar el valor de retorno de la funcion a una variable tipo int
		int c = sumar(a,b);
		
	}

	static int sumar(int a,int b) {
		/*int res = a + b;
		return res;*/
		
		return a + b;
	}
	
	static void responder(String saludo) {
		System.out.println(saludo);		
	}

	//un procedimiento
	static void saludar(String saludo) {
		System.out.println("Hola: " + saludo);
	}
}

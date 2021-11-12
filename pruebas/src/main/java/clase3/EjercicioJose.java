package clase3;

public class EjercicioJose {

	public static void main(String[] args) {
		//determinar dado 3 numero, cual es el mayor

		// necesito 3 
		// if
		// mostrar
		
		int n1 = 24;
		int n2 = 23;
		int n3 = 25;
		//mayor estricto
		int mayor= n1;
		if (mayor <= n2) {
			mayor = n2;
			if (mayor <= n3) {
				mayor = n3;
			}
		}

		System.out.println(mayor);
	}

}

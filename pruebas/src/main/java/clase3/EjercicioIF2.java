package clase3;

public class EjercicioIF2 {

	public static void main(String[] args) {
		//determinar dado 3 numero, cual es el mayor

		// necesito 3 
		// if
		// mostrar
		
		int n1 = 17;
		int n2 = 18;
		int n3 = 18;
		
		//mayor estricto
		if(n1 > n2 && n1 > n3) {
			System.out.println(n1);
		}
		if(n2 > n1 && n2 > n3) {
			System.out.println(n2);
		}
		if(n3 > n1 && n3 > n2) {
			System.out.println(n3);
		}
		
		// n1 y n2 < n3
		// n1 y n3 < n2
		// n2 y n3 < n1
		if(n1 == n2 && n1 > n3) {
			System.out.println(n1);
		}
		if(n1 == n3 && n1 > n2) {
			System.out.println(n1);
		}
		if(n2 == n3 && n2 > n1) {
			System.out.println(n2);
		}
		
		// n1 == n2 == n3
		if(n1 == n2 && n2 == n3 ) {
			System.out.println("iguales");
		}
	}

}

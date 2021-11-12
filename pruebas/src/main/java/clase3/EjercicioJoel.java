package clase3;

public class EjercicioJoel {

	public static void main(String[] args) {
		//determinar dado 3 numero, cual es el mayor

		// necesito 3 
		// if
		// mostrar
		
		int n1 = 20;
		int n2 = 20;
		int n3 = 20;
		
		//mayor estricto
		if(n1 >= n2 && n1 > n3) {
			System.out.println(n1);
		}else if(n2 >= n1 && n2 > n3) {
			System.out.println(n2);			
		} else if(n3 >= n1 && n3 > n2){
			System.out.println(n3);			
		} else if(n1 == n2 && n1 == n3) {			
			System.out.println("iguales");
		}
	}

}

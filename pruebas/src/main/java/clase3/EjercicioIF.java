package clase3;

public class EjercicioIF {

	public static void main(String[] args) {
		//determinar dado 3 numero, cual es el mayor

		// necesito 3 
		// if
		// mostrar
		
		double a,b,c;
		a = 15;
		b = 20;
		c = 20;
		
		//a > b  y a > c caso1
		//b > a y b > c  caso2
		//c > a y c > b
		// a == b Y a == c
		
		if(a > b && a > c ) {
			System.out.println(a + "es mayor");
		}
		if(b > a && b > c) {
			System.out.println(b + "es mayor");
		}
		if(c > a && c > b) {
			System.out.println(c + "es mayor");
		}
		if(a == b && a == c) {
			System.out.println(a+","+b+","+c + " son iguales");
		}
	}

}

package clase6;

public class Calculadora {

	double sumar(double a, double b) {
		return a + b;
	}
	
	double restar(double a, double b) {
		return a - b;
	}
	
	double multiplicar(double a, double b) {
		return a * b;
	}
	
	/**
	 * pre: b != 0
	 * post: a / b
	 * @param a
	 * @param b
	 * @return
	 */
	double dividir(double a, double b) {
		if(b != 0) {
			return a / b;
		}else {
			System.out.println("No se puede dividir entre cero");
			return 0;
		}
	}
}

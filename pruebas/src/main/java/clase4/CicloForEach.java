package clase4;

public class CicloForEach {

	public static void main(String[] args) {
		
		String[] nombres = new String[] {"Edwin", "Juan","Ricardo","Anyalith"};//length = 4, 0,1,2,3

		// tipo de datos nombre_variable: vector 
		for(String nombre : nombres ) {
			System.out.println("nombre:" + nombre);
		}
	}

}

package pruebas;

public class Operadores {

	public static void main(String[] args) {
		// +
		//variables
		int edad = 10;
		int edad2 = 20;
		
		//quiero sumar las dos edades
		int res = edad+edad2; 
		
		//ahora quiero mostrar el contenido de res
		System.out.println("la suma de edad + edad2 es=" + res );		
		System.out.println(res);
		System.out.println("----------------------------------");
		
		double alto = 175.5; //defecto de los numero con decimales
		
		//para los float 
		float ancho = 205.7F;
		System.out.println("----------------------------------");
		
		
		//obtener el resultado de una division
		//alto/ancho > siempre es con decimales
		//float < double
		//quedar con el floatante que esta dentro del double
		float resDiv = (float)alto/ancho; 
		
		byte valor = 127; // > -128 a + 127
		
		// division /
		float div0 = (float)alto / 0;
		
		System.out.println("div 0="+div0);
		
		System.out.println("fin");
		
		int a = 10;
		int b = 5;
		// D |_d_
		// 0%  2 /
		
		//mod %
		int mod = a % b;
		System.out.println(a +"%" + b + "="+mod);
		System.out.println(a +"/" + b + "="+ a/b );
		
		System.out.println("----------------------------------");
		
		double multi = alto * ancho;
		System.out.println("*" + multi);
		
		// relacionales
		// > < >= <= != TODOS > boolean
							//175.5  != 205.5
		boolean resAltoAncho =  alto != ancho; //true
		System.out.println(alto + " != " + ancho + " = " + resAltoAncho);
		
		// logicos
		// && AND y > las dos deben ser true
		// || inclusivo OR 
		// ! NOT
		// xor exclusivo XOR
		
		// dia sea martes cond1
		// horario 19:30 cond2
		// comienza el curso cond1 y cond2
		
		boolean esMartes = true;
		boolean horario19 = false;
		boolean curso = esMartes && horario19;
		System.out.println("el valor de verdad de " + esMartes +" && " + horario19 +"="+ curso);
		
		int edadAdulto = 18;
		boolean tieneCarnet = true;
		String nombre = "jose";
		float altura = 0.75F;
		char letra = 'M';
		
		//puedo conducir si es mayor Y tiene carnet
		boolean puedeConducir = (edadAdulto >= 18) && tieneCarnet && (nombre == "jose") || (altura > 1.0) && (letra != 'G');
		System.out.println("Puede conducir=" + puedeConducir);
		
		boolean aux = true; // 10 > 01010
		boolean baux = false;// 30 > 11110
		//------------------     10100 > 20   
		boolean resAux = aux ^ baux;
		
				
		System.out.println("XOR resAux="+resAux);
	}

}

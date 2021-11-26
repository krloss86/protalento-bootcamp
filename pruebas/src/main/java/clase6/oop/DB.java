package clase6.oop;

public class DB {

	//no tiene atributos
	
	//no tiene constructor
	
	//solo tiene un metodo
	Articulo[] consultar(String claveConsultada) {
		//simular datos 
		
		Articulo res1 = new Articulo("Figura De Marvel Avengers Titan Hero Series Blast Gear- War", 35940, "http://imagen.jpg", true, 10, true);
		Articulo res2 = new Articulo("Figura De Accion De Marvel Avengers 6 Pulgadas Surtidas", 34930, "http://otraimagen.jpg", false, 2, false);
		
		//??
		//int[]
		Articulo[] resultados = new Articulo[] {res1, res2};//length 2, 0 y 1
		return resultados;
	}
	
	
}

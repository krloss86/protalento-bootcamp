package ar.com.educacionit.ejercicio.adicional;

public class Avion extends Volador implements Aterrizable{

	//atributos propios
	private int asientos;
	
	public Avion(String nombre, int asientos) {		
		super(nombre);
		this.asientos = asientos;
	}

	public Resultado aterrizar() {
		return null;
	}

	public int getAsientos() {
		return asientos;
	}
	
}

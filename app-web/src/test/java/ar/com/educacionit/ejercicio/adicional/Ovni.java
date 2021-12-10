package ar.com.educacionit.ejercicio.adicional;

public class Ovni extends Volador {

	private String forma;
	
	public Ovni(String nombre, String forma) {
		super(nombre);
		this.forma = forma;
	}

	public String getForma() {
		return forma;
	}

	public void setForma(String forma) {
		this.forma = forma;
	}

	
}

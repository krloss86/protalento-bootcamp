package ar.com.educacionit.ejercicio.adicional;

public abstract class Volador {

	//atributos comunes
	protected String nombre; // por ser protected los hijos lo pueden heredar como private
	
	public Volador(String nombre) {
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "Volador [nombre=" + nombre + "]";
	}
	
}

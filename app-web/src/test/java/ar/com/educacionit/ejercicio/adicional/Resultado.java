package ar.com.educacionit.ejercicio.adicional;

public class Resultado {

	private boolean exitoso;
	
	private String descripcion;
	
	
	public Resultado() {
		super();
	}

	public Resultado(boolean exitoso, String descripcion) {
		super();
		this.exitoso = exitoso;
		this.descripcion = descripcion;
	}

	public boolean isExitoso() {
		return exitoso;
	}

	public void setExitoso(boolean exitoso) {
		this.exitoso = exitoso;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	
}

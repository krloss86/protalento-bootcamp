package ar.com.educacionit.collections.list;

import java.util.ArrayList;
import java.util.List;

public class Buscador {

	private String clave;
	private List<String> resultados;

	public Buscador(String clave) {
		this.clave = clave;
		this.resultados = new ArrayList<>();
	}

	public void buscar() {
		List<String> resul = new ArrayList<>();
		resul.add("resultado 1 "+ this.clave);
		resul.add("resultado 2 "+ this.clave);
		resul.add("resultado 3 "+ this.clave);
		
		this.resultados = resul;
	}

	public List<String> getResultados() {
		return this.resultados;
	}
}

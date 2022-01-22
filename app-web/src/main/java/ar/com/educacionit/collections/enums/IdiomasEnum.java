package ar.com.educacionit.collections.enums;

import ar.com.educacionit.collections.list.Chino;
import ar.com.educacionit.collections.list.Espanol;
import ar.com.educacionit.collections.list.IIdioma;
import ar.com.educacionit.collections.list.Ingles;

public enum IdiomasEnum {
	ES(new Espanol()), ING(new Ingles()), CHI(new Chino());

	private IIdioma idioma;

	private IdiomasEnum(IIdioma idioma) {
		this.idioma = idioma;
	}

	public IIdioma getIdioma() {
		return this.idioma;
	}
}
package ar.com.educacionit.crud;

import java.util.Scanner;

public class LectorPorConsole implements ILectora {

	private Scanner teclado;
	private Integer opcion;
	
	public LectorPorConsole(Scanner teclado,Integer opcion) {
		this.teclado = teclado;
		this.opcion = opcion;
	}
	
	public LectorPorConsole(Scanner teclado) {
		this.teclado = teclado;
	}

	@Override
	public Data leerDatos() {
		// TODO Auto-generated method stub
		return null;
	}

}

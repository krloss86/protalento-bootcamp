package ar.com.educacionit.crud;

public class Modificar implements Ejecutable {

	@Override
	public void ejectuar() {
		System.out.println("Ejecutando modificar...");
	}

	@Override
	public void ejectuar(Data data) {
		System.out.println("Ejecutando modificar: " + data);		
		//y aca invocar a los metodo internos
	}
}

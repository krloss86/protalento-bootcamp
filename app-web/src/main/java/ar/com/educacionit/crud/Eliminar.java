package ar.com.educacionit.crud;

public class Eliminar implements Ejecutable {

	@Override
	public void ejectuar() {
		//ctrl+d
		System.out.println("Ejecutando eliminar...");
	}

	@Override
	public void ejectuar(Data data) {
		System.out.println("Ejecutando eliminar: " + data);		
		//y aca invocar a los metodo internos
	}

}

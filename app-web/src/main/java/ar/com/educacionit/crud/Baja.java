package ar.com.educacionit.crud;

public class Baja implements Ejecutable {

	@Override
	public void ejectuar() {
		System.out.println("Ejecutando baja...");
	}

	@Override
	public void ejectuar(Data data) {
		System.out.println("Ejecutando baja: " + data);		
		//y aca invocar a los metodo internos
	}

}

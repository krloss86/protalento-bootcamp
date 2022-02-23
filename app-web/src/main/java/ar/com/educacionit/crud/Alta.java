package ar.com.educacionit.crud;

public class Alta implements Ejecutable {

	@Override
	public void ejectuar() {
		System.out.println("Ejecutando alta...");
		
		//y aca invocar a los metodo internos
	}

	@Override
	public void ejectuar(Data data) {
		
		System.out.println("Ejecutando alta: " + data);
		
		//y aca invocar a los metodo internos
	}
	
	public void crear() {
		System.out.println("metodo crear clase alta");
	}
}

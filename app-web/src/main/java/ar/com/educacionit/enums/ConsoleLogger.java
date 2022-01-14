package ar.com.educacionit.enums;

public class ConsoleLogger implements ILogger {

	@Override
	public void loguear() {
		System.out.println("Logueando en consola");
	}

}

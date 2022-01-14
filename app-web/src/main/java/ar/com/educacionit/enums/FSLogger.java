package ar.com.educacionit.enums;

public class FSLogger implements ILogger {

	@Override
	public void loguear() {
		System.out.println("Logueando en file system");
	}

}

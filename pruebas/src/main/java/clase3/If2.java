package clase3;

import java.util.Scanner;

public class If2 {

	public static void main(String[] args) {

		// ingrese contraseña y usuario
		// si contraseña = "1234" y usuario = admin => "ok"
		// de lo contrario "fail"
		
		String usuario;
		String contrasenia;
		
		usuario = "jose";
		contrasenia = "12345";
		
		//primer forma
		if(usuario == "admin" && contrasenia == "1234") {
			System.out.println("ok");
		}else {
			System.err.println("fail");
		}
		
		//forma anidada
		if(usuario == "admin") {
			if(contrasenia == "1234") {
				System.out.println("ok");
			}else {
				System.err.println("fail");
			}
		}else {
			System.err.println("fail");
		}
	}

}

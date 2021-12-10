package ar.com.educacionit.domain;

import ar.com.educacionit.dao.impl.SocioDaoImpl;

public class SociosTest {

	public static void main(String[] args) {
		//alguien cargo los datos desde teclado
		String nombre = "JUAN";
		String apellido = "PEREZ";
		String dni = "123456789";
		String email = "unmail@mail.com";
		String direccion  = "calle 13";
		Long pais = 1l;//1=ARG/2=COL/3=BRA ETC ETC
		
		SocioDaoImpl socioImpl = new SocioDaoImpl();
		
		Socios socio = socioImpl.create(new Socios(nombre, apellido, email, direccion, pais));
		
		System.out.println("se ha creado el socios id:" + socio.getId());
		
		Socios otroSocio = socioImpl.findById(5l);
		
		if(otroSocio != null) {			
			System.out.println("se ha creado el socios id:" + otroSocio.getId());
		}else {
			System.out.println("se ha encotrado al socios:" + otroSocio);
		}
		
		//usar el findAll()???
	}
}

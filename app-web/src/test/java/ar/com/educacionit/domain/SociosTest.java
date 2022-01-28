package ar.com.educacionit.domain;

import ar.com.educacionit.services.CategoriaService;
import ar.com.educacionit.services.SociosService;
import ar.com.educacionit.services.exceptions.ServiceException;
import ar.com.educacionit.services.impl.CategoriaServiceImpl;
import ar.com.educacionit.services.impl.SociosServiceImpl;

public class SociosTest {

	public static void main(String[] args) throws ServiceException {
		//alguien cargo los datos desde teclado
		String nombre = "JUAN";
		String apellido = "PEREZ";
		String dni = "123456789";
		String email = "unmail6@mail.com";
		String direccion  = "calle 13";
		Long pais = 1l;//1=ARG/2=COL/3=BRA ETC ETC
		
		SociosService service = new SociosServiceImpl();		
		Socios socio = new Socios(nombre, apellido, email, direccion, pais);		
		service.save(socio);//ctrl+t
		
		socio.setApellido("nuevo apellido");
		socio.setNombre("nuevo nombre");
		
		service.update(socio);
		/*
		CategoriaService cservice = new CategoriaServiceImpl();		
		Categorias categorias = new Categorias("televisore", "abc0",1l);		
		cservice.save(categorias);
		
		categorias.setCodigo("0004");
		categorias.setDescripcion("descripcion nueva");
		cservice.update(categorias);
		*/
	}
}

package ar.com.educacionit.domain;

import ar.com.educacionit.services.CategoriaService;
import ar.com.educacionit.services.SociosService;
import ar.com.educacionit.services.exceptions.ServiceException;
import ar.com.educacionit.services.impl.CategoriaServiceImpl;
import ar.com.educacionit.services.impl.SociosServiceImpl;

public class SociosDaoTest {

	public static void main(String[] args) {
		
		SociosService service = new SociosServiceImpl();
		Socios socios = null;
		try {
			socios = service.getOne(null);
		} catch (ServiceException se) {
			String msjDeService = se.getMessage();
			System.err.println(msjDeService);
			
			//quiero la causa que origino se
			Throwable cause = se.getCause();
			String msjCause = cause.getMessage();
			System.err.println(msjCause);
		}
		
		//socios va a tener todos los atributos NULOS por
		//el momento
		System.out.println(socios);
		
		CategoriaService cservice = new CategoriaServiceImpl();
		Categorias categoria = null;
		try {
			categoria = cservice.getOne(2l);
		} catch (ServiceException e) {
			e.printStackTrace();
		}
		System.out.println(categoria);
	}
}

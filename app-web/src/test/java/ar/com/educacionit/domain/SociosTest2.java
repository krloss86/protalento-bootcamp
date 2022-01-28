package ar.com.educacionit.domain;

import ar.com.educacionit.services.SociosService;
import ar.com.educacionit.services.exceptions.ServiceException;
import ar.com.educacionit.services.impl.SociosServiceImpl;

public class SociosTest2 {

	public static void main(String[] args) throws ServiceException {
		
		SociosService service = new SociosServiceImpl();		
		Socios socio = service.getOne(5L);//ctrl+t
		
		socio.setApellido("nuevo apellido");
		socio.setNombre("nuevo nombre");
		socio.setEmail("unmailunmailunmailunmailunmailunmailunmailunmailunmailunmailunmailunmail@mail.com");
		
		service.update(socio);
	}
}

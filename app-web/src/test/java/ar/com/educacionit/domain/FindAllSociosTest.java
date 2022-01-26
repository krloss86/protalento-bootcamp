package ar.com.educacionit.domain;

import java.util.List;

import ar.com.educacionit.dao.exceptions.GenericException;
import ar.com.educacionit.dao.impl.SocioDaoImpl;

public class FindAllSociosTest {

	public static void main(String[] args) throws GenericException {
		
		//creo la implementacion que me permite acceder a la db (CRUDl)
		SocioDaoImpl socioImpl = new SocioDaoImpl();
		
		List<Socios> vectorDeSociso = socioImpl.findAll();
		
		for(Socios socio : vectorDeSociso) {
			System.out.println(socio);
		}
	}
}

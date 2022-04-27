package ar.com.educacionit.streams;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import ar.com.educacionit.domain.Articulos;
import ar.com.educacionit.services.exceptions.ServiceException;
import ar.com.educacionit.services.impl.ArticulosServicesImpl;

public class Maps {

	public static void main(String[] args) throws ServiceException {
		
		//convertir edades de Integer a String
		Collection<Articulos> list = new ArticulosServicesImpl().findAll();
		
		//ctrl+shit+t
		Long total = list.stream()
			.filter(x -> x.getPrecio() >= 1500) 
			.peek(x -> System.out.println(x))
			.count();
		System.out.println(total);
	}

}

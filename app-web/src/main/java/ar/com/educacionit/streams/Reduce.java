package ar.com.educacionit.streams;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import ar.com.educacionit.domain.Articulos;
import ar.com.educacionit.services.exceptions.ServiceException;
import ar.com.educacionit.services.impl.ArticulosServicesImpl;

public class Reduce {

	public static void main(String[] args) throws ServiceException {
		
		//convertir edades de Integer a String
		Collection<Articulos> list = new ArticulosServicesImpl().findAll();
		
		Double total = list.stream()
			.map(x -> x.getPrecio())
			.reduce(0d, (x,y) -> x+y);
		
		System.out.println("total:"+total);
	}

}

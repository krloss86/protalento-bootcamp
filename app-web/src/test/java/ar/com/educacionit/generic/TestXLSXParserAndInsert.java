package ar.com.educacionit.generic;

import java.util.Collection;

import ar.com.educacionit.domain.Articulos;
import ar.com.educacionit.services.ArticulosServices;
import ar.com.educacionit.services.exceptions.ServiceException;
import ar.com.educacionit.services.impl.ArticulosServicesImpl;

public class TestXLSXParserAndInsert {

	public static void main(String[] args) throws ParseException {
		
		String path = "./src/test/java/ar/com/educacionit/generic/articulos.xlsx";		
		IParser<Collection<Articulos>> xlsxParser = new XLSXFileParser(path); 
		Collection<Articulos> articulos = xlsxParser.parse();			
		
		//1 - creo el service asociado a articulos
		ArticulosServices as = new ArticulosServicesImpl();
		
		for(Articulos unArticulo : articulos) {
			//2 - ejecuto el metodo save
			try {
				as.save(unArticulo);
			} catch (ServiceException e) {
				e.printStackTrace();
			}
		}
	}

}

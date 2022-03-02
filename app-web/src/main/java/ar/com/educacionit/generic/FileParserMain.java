package ar.com.educacionit.generic;

import java.util.Collection;

import ar.com.educacionit.domain.Articulos;

public class FileParserMain {

	public static void main(String[] args) {

		String path = "C:\\desarrollo\\articulos.csv";
		
		IParser<Collection<Articulos>> parser = new CSVFileParser(path);
		
		int cantidadRegistro = 0;
		Double precioTotal = 0d;
		try {
			Collection<Articulos> articulos = parser.parse();
			cantidadRegistro = articulos.size();
			
			for(Articulos articulo : articulos) {
				System.out.println(articulo);
				precioTotal = precioTotal + articulo.getPrecio();
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
		System.out.println("Cantidad procesados:" + cantidadRegistro);
		System.out.println("Precio Total:" + precioTotal);
	}

}

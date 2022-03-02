package ar.com.educacionit.generic;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

import ar.com.educacionit.domain.Articulos;

public class CSVFileParser extends BaseFile implements IParser<Collection<Articulos>>{
	
	public CSVFileParser(String path) {
		super(path);
	}

	//implementar el metodo generico, PERO, dandole un tipo concreto 
	public Collection<Articulos> parse() throws ParseException{
		
		//lista vacia de articulos
		Collection<Articulos> articulos = new ArrayList<>();
		
		//ACA VA LA LOGICA DE LECTURA DEL FILE 
		File file = new File(super.getFilePath());
		
		//verifico si existe el file
		if(!file.exists()) {
			//negocio
			throw new ParseException("No existe el archivo:" + super.getFilePath());
		}
		
		//leo archivo
		try (FileReader fileReader = new FileReader(file);) {
			try(BufferedReader br = new BufferedReader(fileReader);) {
				//leer la primer línea y la descarto porque tiene los título
				String lineaLeida = br.readLine();
				//id;titulo;precio;
				
				//vuelvo a leer para tomar los "registros"
				lineaLeida = br.readLine();
				
				while(lineaLeida != null) {
					//1;monitor;25000 lo separo por; obtengo un String[]
					//logica de parseo
					
					String[] datos = lineaLeida.split(";"); 
					String id = datos[0];// => id
					String titulo = datos[1];// => titulo
					String precio = datos[2];// => precio
					
					//creo el articulo
					Articulos unArticulo = new Articulos(Long.parseLong(id), titulo, Double.parseDouble(precio));
					
					articulos.add(unArticulo);
					
					lineaLeida = br.readLine();
				}
			}
		} catch (IOException e) {
			throw new ParseException(e.getMessage(),e);
		}
		
		return articulos;
	}
}

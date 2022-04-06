package ar.com.educacionit.generic;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.servlet.http.Part;

import ar.com.educacionit.domain.Articulos;

public class CSVFileParser extends BaseFile implements IParser<Collection<Articulos>>{
	
	public CSVFileParser(Part filePart) {
		super(filePart);
	}
	
	public CSVFileParser(String path) {
		super(path);
	}

	//implementar el metodo generico, PERO, dandole un tipo concreto 
	public Collection<Articulos> parseV2() throws ParseException{
		
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
	
	public Collection<Articulos> parse() throws ParseException, IOException {
		
		InputStream is = null;
		FileReader fileReader = null;
		BufferedReader br = null;
		
		try {
			//detectar si tiene path como String o Part
			if(this.filePart != null) {
				is = filePart.getInputStream();
				br = new BufferedReader(new InputStreamReader(is));
			}else {
				File file = new File(super.getFilePath());
				if(!file.exists()) {
					throw new ParseException("No existe el archivo:" + super.getFilePath());
				}			
				fileReader = new FileReader(file);
				br = new BufferedReader(fileReader);
			}				
		}finally {
			if(br != null) {
				br.close();
			}
		}
		
		//lista vacia de articulos
		return this.buildArchivos(br);
	}

	private Collection<Articulos> buildArchivos(BufferedReader br) throws IOException {
		Collection<Articulos> articulos = new ArrayList<Articulos>();

		String lineaLeida = br.readLine();
		
		//vuelvo a leer para tomar los "registros"
		lineaLeida = br.readLine();
		
		Date fechaCrecion = new Date();
		while(lineaLeida != null) {
			
			String[] datos = lineaLeida.split(";"); 
			String titulo = datos[0];// => titulo
			String codigo = datos[1];// => titulo
			String precio = datos[2];// => precio
			String stock = datos[3];// => precio
			String categoria = datos[4];// => precio
			String marca = datos[5];// => precio
		
			//validador!!
			//Validador.getValidar(Enum.paraArticulo).validate(datos);
						
			Articulos unArticulo = new Articulos(
				titulo,fechaCrecion,codigo,Double.parseDouble(precio),Long.parseLong(stock),Long.parseLong(marca), Long.parseLong(categoria)
			);
			
			articulos.add(unArticulo);
			lineaLeida = br.readLine();
		}
				
		return articulos;
	}
}

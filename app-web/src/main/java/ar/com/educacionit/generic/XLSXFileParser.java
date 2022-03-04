package ar.com.educacionit.generic;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import ar.com.educacionit.domain.Articulos;

public class XLSXFileParser extends BaseFile implements IParser<Collection<Articulos>> {

	public XLSXFileParser(String path) {
		super(path);
	}

	//implementar el metodo generico, PERO, dandole un tipo concreto 
	public Collection<Articulos> parse() throws ParseException {
		
		//libreria poi de apache
		
		//leer un binario
		File xlsxFile = new File(super.getFilePath());
		
		Collection<Articulos> articulos = new ArrayList<Articulos>();
		
		//clases propias de la libreria
		try(
				InputStream xlsxInputStream = new FileInputStream(xlsxFile);
				Workbook workbook = new XSSFWorkbook(xlsxInputStream)
			) {
			
			Sheet hojas = workbook.getSheetAt(0);
			
			//collection
			Iterator<Row> filasDeLaHoja0 = hojas.iterator();
			
			boolean primerFila = true;
			//TITULO	CODIGO	PRECIO	STOCK	MARCASID	CATEGORIASID
			
			while(filasDeLaHoja0.hasNext()) {
				Row filaActual = filasDeLaHoja0.next();
				if(primerFila) {
					primerFila = false;
					continue;
				}
				
				//MONITOR	MONI000	24500	2	1	1
				Iterator<Cell> celdas = filaActual.iterator();
				
				//Articulo
				
				Articulos articulo = new Articulos();
				
				while(celdas.hasNext()) {
					fromCellToArticulos(celdas, articulo);
				}
				
				articulos.add(articulo);
 			}
		}catch (IOException fnfe) {
			throw new ParseException("No se ha podido parsear el archivo: " + getFilePath(),fnfe);
		}
		
		return articulos;
	}

	protected void fromCellToArticulos(Iterator<Cell> celdas, Articulos articulo) {
		Cell celdaActual = celdas.next();
		String valor;
		switch (celdaActual.getColumnIndex()) {//0 -> titulo ->setTitulo(valor)
			case 0:
				valor = celdaActual.getStringCellValue();//valor de la celda actual  -> MONITOR
				articulo.setTitulo(valor);
				break;	
			case 1:
				valor = celdaActual.getStringCellValue();//valor de la celda actual  -> MONI000
				articulo.setCodigo(valor);
				break;
			case 2:
				Double valorD = celdaActual.getNumericCellValue();//valor de la celda actual  -> MONI000
				articulo.setPrecio(valorD);
				break;
			case 3:
				Double stock = (Double)celdaActual.getNumericCellValue();//valor de la celda actual  -> 2
				articulo.setStock(stock.longValue());
				break;
			case 4:
				Double marcasId = (Double)celdaActual.getNumericCellValue();//valor de la celda actual  -> 1
				articulo.setMarcaId(marcasId.longValue());
				break;
			case 5:
				Double categoriasId = (Double)celdaActual.getNumericCellValue();//valor de la celda actual  -> 1
				articulo.setCategoriaId(categoriasId.longValue());
				break;
			default:
				break;
		}
		articulo.setFechaCreacion(new Date());
	}
}

package ar.com.educacionit.servlet;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ar.com.educacionit.domain.Articulos;
import ar.com.educacionit.web.enums.ViewKeysEnum;

@WebServlet("/controllers/GenerarArchivoErrorSevlet")
public class GenerarArchivoErrorSevlet  extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//tomar los datos de la session
		Collection<Articulos> articulosPreview = (Collection<Articulos>)req.getSession().getAttribute(ViewKeysEnum.ARTICULOS_FAILS.getParam());

		//validaciones
		
		String fileName = "listado-productos-error";
		
		String format = req.getParameter(ViewKeysEnum.FORMATO.getParam());
		
		//c:/desarrolo/educacionit/bootcamp/
		String path = File.separator + "desarrollo" + File.separator + fileName + "." + format;
		
		File outputFile = new File(path);
		
		if(!outputFile.exists()) {
			Files.createFile(outputFile.toPath());			
		}
		
		FileWriter fr = new FileWriter(outputFile);
		
		for(Articulos art : articulosPreview) {
			String lineFromArticulo = this.lineFromArticulo(art);			
			fr.write(lineFromArticulo);
		}
		
		super.doGet(req, resp);
	}

	private String lineFromArticulo(Articulos aux) {
		StringBuffer linea = new StringBuffer();
		linea.append(aux.getCodigo()).append(";");
		linea.append(aux.getTitulo()).append(";");
		linea.append(aux.getPrecio()).append(";");
		return linea.toString(); 
	}
}

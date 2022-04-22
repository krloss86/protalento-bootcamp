package ar.com.educacionit.servlet;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ar.com.educacionit.domain.Articulos;
import ar.com.educacionit.web.enums.ViewEnums;
import ar.com.educacionit.web.enums.ViewKeysEnum;

@WebServlet("/controllers/GenerarArchivoErrorSevlet")
public class GenerarArchivoErrorSevlet  extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//req.getHeaderNames().asIterator()
		//tomar los datos de la session
		Collection<Articulos> articulosPreview = (Collection<Articulos>)req.getSession().getAttribute(ViewKeysEnum.ARTICULOS_FAILS.getParam());

		if(articulosPreview != null && !articulosPreview.isEmpty()) {
		
			//validaciones
			
			String fileName = "listado-productos-error";
			
			String format = req.getParameter(ViewKeysEnum.FORMATO.getParam());
			
			//aca pueden implementar conversion generica  
			
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
			fr.close();
			
			//logica para descargar el archivo y que en navegador
			//entienda que es un file
			descargar(fileName, format, outputFile, resp);
		}
		
		req.setAttribute(ViewKeysEnum.ERROR_GENERAL.getParam(), "Sin datos...");
		getServletContext().getRequestDispatcher(ViewEnums.RESULTADO_PREVIEW.getParam()).forward(req, resp);
	}

	private void descargar(String fileName, String format, File outputFile, HttpServletResponse resp) throws IOException{
		
		resp.setContentType("text/csv");
		
		String finalName = fileName + "."+format;
		
		resp.setHeader("Content-Disposition", "attachment; filename=\""+finalName + "\"");
		
		try {
			OutputStream out = resp.getOutputStream();
			byte[] bytes = Files.readAllBytes(outputFile.toPath());
			out.write(bytes);
			out.flush();
			out.close();
		}catch(Exception e) {
			resp.getWriter().print("No se ha podido generar el archivo: " + finalName);
		}
	}

	private String lineFromArticulo(Articulos aux) {
		StringBuffer linea = new StringBuffer();
		linea.append(aux.getCodigo()).append(";");
		linea.append(aux.getTitulo()).append(";");
		linea.append(aux.getPrecio()).append(";");
		linea.append("\n");
		return linea.toString(); 
	}
}

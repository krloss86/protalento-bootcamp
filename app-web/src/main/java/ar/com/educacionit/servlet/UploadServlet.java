package ar.com.educacionit.servlet;

import java.io.IOException;
import java.nio.file.Paths;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import ar.com.educacionit.domain.Articulos;
import ar.com.educacionit.generic.CSVFileParser;
import ar.com.educacionit.generic.IParser;
import ar.com.educacionit.generic.XLSXFileParser;
import ar.com.educacionit.web.enums.ViewKeysEnum;

@WebServlet("/UploadServlet")
public class UploadServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		Part filePart = req.getPart(ViewKeysEnum.UPLOAD_FILE.getParam());
		
		if(filePart.getSize() > 0) {
			
			String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();
			
			String ext = this.getExt(fileName);
			
			IParser<Articulos> parser;
			switch (ext) {
			case "csv":
				parser = new CSVFileParser(ext);
				break;
			case "xls":
				parser = new XLSXFileParser(ext);
				break;				
			default:
				parser = null;
				break;
			}
			
			if(parser == null) {
				req.setAttribute(ViewKeysEnum.ERROR_GENERAL.getParam(), "Formato no soportado");
				//...
			}
		}
	}

	private String getExt(String fileName) {
		String[] names = fileName.split(".");		
		return names[1];
	}
}

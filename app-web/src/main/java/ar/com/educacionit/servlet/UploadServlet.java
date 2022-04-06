package ar.com.educacionit.servlet;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import ar.com.educacionit.domain.Articulos;
import ar.com.educacionit.generic.CSVFileParser;
import ar.com.educacionit.generic.IParser;
import ar.com.educacionit.generic.ParseException;
import ar.com.educacionit.generic.XLSXFileParser;
import ar.com.educacionit.web.enums.ViewEnums;
import ar.com.educacionit.web.enums.ViewKeysEnum;

@WebServlet("/controllers/UploadServlet")
@MultipartConfig
public class UploadServlet extends BaseServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		Part filePart = req.getPart(ViewKeysEnum.UPLOAD_FILE.getParam());
		
		ViewEnums target = ViewEnums.UPLOAD_PREVIEW;
		
		if(filePart.getSize() > 0) {
			
			String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();
			
			String ext = this.getExt(fileName);
			
			IParser<Collection<Articulos>> parser;
			switch (ext) {
			case "csv":
				parser = new CSVFileParser(filePart);
				break;
			case "xls":
				parser = new XLSXFileParser(ext);
				break;				
			default:
				parser = null;
				break;
			}
			
			if(parser != null) {
				try {
					Collection<Articulos> articulos = parser.parse();
					super.addAttribute(req, ViewKeysEnum.UPLOAD_PREVIEW_KEY, articulos);
				} catch (ParseException e) {
					super.addAttribute(req, ViewKeysEnum.ERROR_GENERAL, e.getMessage());
					target = ViewEnums.UPLOAD;
				}
			}else {
				target = ViewEnums.UPLOAD;
				super.addAttribute(req, ViewKeysEnum.ERROR_GENERAL, "Formato no soportado");
			}
			
			super.redirect(target, req,resp);
		}
	}

	private String getExt(String fileName) {
		String[] names = fileName.split("\\.");		
		return names[1];
	}
}

package ar.com.educacionit.servlet.rest;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import ar.com.educacionit.domain.Articulos;
import ar.com.educacionit.services.ArticulosServices;
import ar.com.educacionit.services.exceptions.ServiceException;
import ar.com.educacionit.services.impl.ArticulosServicesImpl;
import ar.com.educacionit.web.enums.ViewKeysEnum;

@WebServlet("/rest/ProductoRest")
public class ProductoRest extends HttpServlet{

	private ArticulosServices service = new ArticulosServicesImpl();
	private ObjectMapper objectMapper = new ObjectMapper();
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//tomar id que viene por req
		String id = req.getParameter(ViewKeysEnum.ID_PRODUCTO.getParam());
		
		try {
			Articulos articulo = this.service.getOne(Long.parseLong(id));
			String json = objectMapper.writeValueAsString(articulo);
			
			//escribo en el response el objeto
			resp.getWriter().print(json);
			
		} catch (ServiceException e) {
			//tph: manejar el error y crear un json <algo>
			e.printStackTrace();
		}
	}
	
}

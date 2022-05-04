package ar.com.educacionit.servlet.rest;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import ar.com.educacionit.domain.Articulos;
import ar.com.educacionit.domain.Categorias;
import ar.com.educacionit.domain.Marcas;
import ar.com.educacionit.services.ArticulosServices;
import ar.com.educacionit.services.CategoriaService;
import ar.com.educacionit.services.MarcasService;
import ar.com.educacionit.services.exceptions.ServiceException;
import ar.com.educacionit.services.impl.ArticulosServicesImpl;
import ar.com.educacionit.services.impl.CategoriaServiceImpl;
import ar.com.educacionit.services.impl.MarcasServiceImpl;
import ar.com.educacionit.web.enums.ViewKeysEnum;

@WebServlet("/rest/ProductoRest")
public class ProductoRest extends HttpServlet{

	private ArticulosServices service = new ArticulosServicesImpl();
	private CategoriaService catServices = new CategoriaServiceImpl();
	private MarcasService marcaService = new MarcasServiceImpl();
	
	private ObjectMapper objectMapper = new ObjectMapper();
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//tomar id que viene por req
		String id = req.getParameter(ViewKeysEnum.ID_PRODUCTO.getParam());
		
		try {
			Articulos articulo = this.service.getOne(Long.parseLong(id));
			//String json = objectMapper.writeValueAsString(articulo);
			
			//obtener la lista de categorias
			List<Marcas> marcas = this.marcaService.findAll();

			//obtener la lista de marcas
			List<Categorias> categorias = this.catServices.findAll();
			/*
			{
				articulo: {
					id: ,
					etc: 
				},
				marcas: [
			         {
			        	 id,
			        	 descripcion
			         }
				],
				categorias:[
		            {
			        	 id,
			        	 descripcion
		            }
	            ]
			}
			*/
			Map<String,Object> jsonObject = new HashMap<>();
			jsonObject.put("articulo", articulo);
			jsonObject.put("marcas", marcas);
			jsonObject.put("categorias", categorias);
			
			String json = objectMapper.writeValueAsString(jsonObject);
			
			//escribo en el response el objeto
			resp.getWriter().print(json);
			
		} catch (ServiceException e) {
			//tph: manejar el error y crear un json <algo>
			e.printStackTrace();
		}
	}
	
}

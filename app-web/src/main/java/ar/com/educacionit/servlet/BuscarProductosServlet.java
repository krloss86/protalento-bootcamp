package ar.com.educacionit.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ar.com.educacionit.domain.Articulos;
import ar.com.educacionit.services.ArticulosServices;
import ar.com.educacionit.services.exceptions.ServiceException;
import ar.com.educacionit.services.impl.ArticulosServicesImpl;
import ar.com.educacionit.web.enums.ViewEnums;
import ar.com.educacionit.web.enums.ViewKeysEnum;

@WebServlet("/controllers/BuscarProductosServlet")
public class BuscarProductosServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
//		String limit = req.getParameter("limit");//10|20|30|40
//		String offset = req.getParameter("offset");//0|1
				
		String claveBusqueda = req.getParameter(ViewKeysEnum.CLAVE_BUSQUEDA.getParam());
		
		if(claveBusqueda == null) {
			claveBusqueda = "";
		}
		
		ArticulosServices service = new ArticulosServicesImpl();
		
		try {
			/*List<Articulos> listado = service.findAll();
			 
			for(Iterator<Articulos> itArticulos = listado.iterator();itArticulos.hasNext();) {
				if(!itArticulos.next().getTitulo().contains(claveBusqueda)) {
					itArticulos.remove();
				}
			}*/
			List<Articulos> listado = service.findAllBy(claveBusqueda);
			
			//calculo el total
			Double total = listado.stream()
				.map(x -> x.getPrecio())
				.reduce(0d,(x,y) -> x+y);
			req.getSession().setAttribute(ViewKeysEnum.LISTADO.getParam(), listado);
			req.getSession().setAttribute(ViewKeysEnum.TOTAL.getParam(), total);
			
			getServletContext().getRequestDispatcher(ViewEnums.LISTADO_GENERAL.getParam()).forward(req, resp);
		} catch (ServiceException e) {
			List<Articulos> listado = new ArrayList<>();
			req.setAttribute("LISTADO", listado);
			getServletContext().getRequestDispatcher("/listado.jsp").forward(req, resp);
		}
	}
}

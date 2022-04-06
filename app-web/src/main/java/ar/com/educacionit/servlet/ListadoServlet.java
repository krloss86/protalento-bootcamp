package ar.com.educacionit.servlet;

import java.io.IOException;
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

/**
 * los servlet no tienen el metodo main, porque no son de tipo
 * consola, sino web
 *
 */
@WebServlet("/controllers/ListadoServlet")
public class ListadoServlet extends HttpServlet {

	@Override	
	protected void doPost(HttpServletRequest entrada, HttpServletResponse salida) throws ServletException, IOException {
		System.out.println("llegue al servlet /listado que escucha y atiende por POST");
		salida.getWriter().print("hola frontend, soy el backend y atendi tu solictud POR POST");
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//que hago acá: instancio ArticuloService 
		
		ArticulosServices articuloService = new ArticulosServicesImpl();
		
		try {
			List<Articulos> articulos = articuloService.findAll();
			
			//guardar el listado en un lugar llamado "request"
			
			request.setAttribute("LISTADO", articulos);
			
			//AHORA "anda" a la otra pagina y pasale la lista de artiuclos
			
			getServletContext().getRequestDispatcher("/listado.jsp").forward(request, response);
		} catch (ServiceException e) {
			e.printStackTrace();
		}
	}
}

package ar.com.educacionit.servlet;

import java.io.IOException;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ar.com.educacionit.domain.Articulos;
import ar.com.educacionit.services.ArticulosServices;
import ar.com.educacionit.services.exceptions.ServiceException;
import ar.com.educacionit.services.impl.ArticulosServicesImpl;
import ar.com.educacionit.web.enums.ViewEnums;
import ar.com.educacionit.web.enums.ViewKeysEnum;

@WebServlet("/controllers/EditarProductoServlet")
public class EditarProductoServlet extends BaseServlet {

	private ArticulosServices service = new ArticulosServicesImpl();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String id = req.getParameter(ViewKeysEnum.ID_PRODUCTO.getParam());
		
		//datos a actualizar
		String titulo = req.getParameter("titulo");
		String precio = req.getParameter("precio");
		String marca = req.getParameter("marcas");
		String categoria = req.getParameter("categorias");
		
		Collection<Articulos> artInSession = (Collection<Articulos>)req.getSession().getAttribute(ViewKeysEnum.LISTADO.getParam());
		ViewEnums target = ViewEnums.LISTADO_GENERAL;
		try {
			//nuevo articulo actualizado
			Articulos art = this.service.getOne(Long.parseLong(id));
			
			art.setTitulo(titulo);
			art.setPrecio(Double.parseDouble(precio));
			art.setCategoriasId(Long.parseLong(categoria));
			art.setMarcasId(Long.parseLong(marca));
			
			this.service.update(art);
			
			//viejo articulo en sesion
			artInSession = artInSession.stream()
					.filter(x -> !x.getId().equals(art.getId()))
					.collect(Collectors.toList());
			artInSession.add(art);
		} catch (ServiceException e) {
			super.addAttribute(req, ViewKeysEnum.ERROR_GENERAL, e.getMessage());
		} finally {
			addAttribute(req.getSession(), ViewKeysEnum.LISTADO, artInSession);
			Double total = artInSession.stream()
					.map(x -> x.getPrecio())
					.reduce(0d,(x,y) -> x+y);
			addAttribute(req.getSession(),ViewKeysEnum.TOTAL, total);
		}
		super.redirect(target, req, resp);
	}
}

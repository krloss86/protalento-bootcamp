package ar.com.educacionit.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ar.com.educacionit.domain.Articulos;
import ar.com.educacionit.services.ArticulosServices;
import ar.com.educacionit.services.exceptions.ServiceException;
import ar.com.educacionit.services.impl.ArticulosServicesImpl;
import ar.com.educacionit.web.enums.Enumerable;
import ar.com.educacionit.web.enums.ViewEnums;
import ar.com.educacionit.web.enums.ViewKeysEnum;

@WebServlet("/controllers/CargarProductosServlet")
public class CargarProductosServlet extends BaseServlet {

	@Override
	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//1 -toma los datos de session (que esta dentro del req) 
		Collection<Articulos> articulosPreview = (Collection<Articulos>)req.getSession().getAttribute(ViewKeysEnum.UPLOAD_PREVIEW_KEY.getParam());
		
		//validaciones
		// IValidator validator = ValidatorBuilder.getValidator(ValidatorEnum.CHEQUES);
		// validator.validate(articulos);
		if(articulosPreview == null || articulosPreview.isEmpty()) {
			req.setAttribute(ViewKeysEnum.ERROR_GENERAL.getParam(), "No hay datos a procesar");
			redirect(ViewEnums.UPLOAD_PREVIEW, req, resp);
		}
		
		ArticulosServices service = new ArticulosServicesImpl();
		
		List<Articulos> oks = new ArrayList<>();
		List<Articulos> fails = new ArrayList<>();
		
		//persistir los datos en la db por medio del servicio ArticulosService
		//recorro la lista e inserto de a uno
		for(Articulos art : articulosPreview) {
			try {
				service.save(art);				
				oks.add(art);
			}catch(ServiceException se) {
				fails.add(art);
			}
		}
		
		//una vez procesado todos los articulos, limpio la session
		req.getSession().removeAttribute(ViewKeysEnum.UPLOAD_PREVIEW_KEY.getParam());
		
		//GUARDO LAS LISTAS EN REQUEST/SESSION
//		req.getSession().setAttribute(Enumerable.ENUMPARAM, ViewKeysEnum.ARTICULOS_FAILS);
		
		addAttribute(req.getSession(), ViewKeysEnum.ARTICULOS_FAILS, fails);
		addAttribute(req, ViewKeysEnum.ARTICULOS_OKS, oks);
		
		//redirect
		redirect(ViewEnums.RESULTADO_PREVIEW, req, resp);
	}
}

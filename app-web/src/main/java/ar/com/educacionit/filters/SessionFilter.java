package ar.com.educacionit.filters;

import java.io.IOException;

import ar.com.educacionit.domain.Users;
import ar.com.educacionit.web.enums.ViewKeysEnum;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

//@WebFilter(filterName = "/SessionFilter", urlPatterns = "/controllers/*")
public class SessionFilter implements Filter{

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		//1 - obtener usuario de la sesion
		
		//2 - url "donde vamos" (/controller/AlgunServlet")
		HttpServletRequest req = (HttpServletRequest)request;
		
//		String url = req.getRequestURI();//http://localhost:8080/app-web/
		
//		String contextPath = req.getContextPath();
//		
//		//3 - definir rutas o url al las cuales no se aplican este filtro
//		List<String> validatePath = Arrays.asList(
//			contextPath + "/controllers/"
//		);
//		
//		boolean mustValidate = false;
//		for(String path : validatePath) {
//			if(url.contains(path)) {
//				mustValidate = true;
//				break;
//			}
//		}
		
		HttpSession session = req.getSession(false);
				
//		if(mustValidate) {
			if(session == null) {
				req.setAttribute(ViewKeysEnum.ERROR_GENERAL.getParam(), "Debe loguearse");
				req.getRequestDispatcher("/login.jsp").forward(request, response);
			}else {
				Users loggedUser =(Users)req.getSession().getAttribute(ViewKeysEnum.USER.getParam());
				
				if(loggedUser != null) {
					//dejo que acceda al /controller/AlgunServlet solicitado
					chain.doFilter(request, response);
				}else {
					req.setAttribute(ViewKeysEnum.ERROR_GENERAL.getParam(), "Debe loguearse");
					req.getRequestDispatcher("/login.jsp").forward(request, response);
				}
			}
//		}else {
//			chain.doFilter(request, response);
//		}
		//4 - logica 
	}

}

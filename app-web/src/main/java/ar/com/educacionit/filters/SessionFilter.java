package ar.com.educacionit.filters;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import ar.com.educacionit.domain.Users;
import ar.com.educacionit.web.enums.ViewKeysEnum;

@WebFilter(filterName = "/SessionFilter", urlPatterns = "/controllers/*")
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

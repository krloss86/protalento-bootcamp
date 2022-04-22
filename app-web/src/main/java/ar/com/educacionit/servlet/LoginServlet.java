package ar.com.educacionit.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import ar.com.educacionit.domain.Users;
import ar.com.educacionit.services.LoginService;
import ar.com.educacionit.services.exceptions.ServiceException;
import ar.com.educacionit.services.impl.LoginServiceImpl;
import ar.com.educacionit.web.enums.ViewEnums;
import ar.com.educacionit.web.enums.ViewKeysEnum;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet{

	private ObjectMapper objectMapper = new ObjectMapper();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//viene el json desde ls jsp
		String data = req.getParameter("data");
		
		LoginDTO loginDTO = objectMapper.readValue(data, LoginDTO.class);
		
		ViewEnums target = ViewEnums.LOGIN_SUCCESS;
		
		//validaciones (mejorar sacando a un metodo a parte)
		if(isValid(loginDTO.getUsername(), loginDTO.getPassword())) {
		
			//LOGIN SERVICE
			LoginService ls = new LoginServiceImpl();
			
			Users user;
			
			try {
				user = ls.getUserByUserNameAndPassword(loginDTO.getUsername(), loginDTO.getPassword());
			
				if(user == null) {
					//guardar en el request
					req.setAttribute(ViewKeysEnum.ERROR_GENERAL.getParam(), ViewKeysEnum.USUARIO_PASSWORD_INVALIDO.getParam());
					target = ViewEnums.LOGIN;				
				}else {
					//session
					req.getSession().setAttribute(ViewKeysEnum.USER.getParam(), user);
				}
			} catch (ServiceException e) {			
				//crear una tabla de mapeo de errores clave - valor
				req.setAttribute(ViewKeysEnum.ERROR_GENERAL.getParam(), e.getMessage());
				target = ViewEnums.LOGIN;//ctrl+shit+i
			}
		}else {
			//guardar en el request
			req.setAttribute(ViewKeysEnum.ERROR_GENERAL.getParam(), ViewKeysEnum.USUARIO_PASSWORD_INVALIDO.getParam());
			target  = ViewEnums.LOGIN;
		}
		
		// ir a target
		getServletContext().getRequestDispatcher(target.getView()).forward(req, resp);
	}

	protected boolean isValid(String usernameFromHtml, String passwordFromHtml) {
		return (usernameFromHtml !=null && !usernameFromHtml.isBlank()) 
				&&
				(passwordFromHtml !=null && !passwordFromHtml.isBlank());
	}
}

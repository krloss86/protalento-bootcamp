package ar.com.educacionit.servlet;

import java.io.IOException;

import ar.com.educacionit.web.enums.ViewKeysEnum;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/LogoutServlet")
public class LogoutServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//limpiar datos de session
		req.getSession().removeAttribute(ViewKeysEnum.USER.getParam());
		req.getSession().invalidate();
		
		//redirect a /
		resp.sendRedirect(getServletContext().getContextPath());
	}
}

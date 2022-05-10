package ar.com.educacionit.servlet;

import java.io.IOException;

import ar.com.educacionit.web.enums.Enumerable;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class BaseServlet extends HttpServlet {

	protected void addAttribute(HttpServletRequest req, Enumerable key, Object value) {
		req.setAttribute(key.getParam(), value);
	}
	
	protected void addAttribute(HttpSession session, Enumerable key, Object value) {
		session.setAttribute(key.getParam(), value);
	}

	public void redirect(Enumerable target, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher(target.getParam()).forward(req, resp);		
	}

}

package ar.com.educacionit.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ar.com.educacionit.web.enums.Enumerable;

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

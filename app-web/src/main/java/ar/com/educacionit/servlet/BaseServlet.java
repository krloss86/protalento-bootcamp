package ar.com.educacionit.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ar.com.educacionit.web.enums.ViewEnums;
import ar.com.educacionit.web.enums.ViewKeysEnum;

public class BaseServlet extends HttpServlet {

	protected void addAttribute(HttpServletRequest req, ViewKeysEnum key, Object value) {
		req.setAttribute(key.getParam(), value);
	}

	public void redirect(ViewEnums target, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher(target.getView()).forward(req, resp);		
	}

}

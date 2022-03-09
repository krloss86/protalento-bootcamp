package ar.com.educacionit.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * los servlet no tienen el metodo main, porque no son de tipo
 * consola, sino web
 *
 */
@WebServlet("/listado")
public class ListadoServlet extends HttpServlet {

	@Override	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("llegue al servlet /listado que escucha y atiende por POST");
		resp.getWriter().print("hola frontend, soy el backend y atendi tu solictud POR POST");
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.getWriter().print("hola frontend, soy el backend y atendi tu solictud POR get");
	}
}

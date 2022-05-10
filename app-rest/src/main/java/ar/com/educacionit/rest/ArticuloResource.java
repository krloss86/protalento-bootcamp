package ar.com.educacionit.rest;

import java.util.Collection;

import ar.com.educacionit.domain.Articulos;
import ar.com.educacionit.services.ArticulosServices;
import ar.com.educacionit.services.exceptions.ServiceException;
import ar.com.educacionit.services.impl.ArticulosServicesImpl;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;


@Path("productos")
public class ArticuloResource {
	//jersey
	
	/*
	 * retorna json
	*/
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response findAll() {
		ArticulosServices articuloService = new ArticulosServicesImpl();
		try {
			Collection<Articulos> articulos = articuloService.findAll();
			return Response.ok(articulos).build();
		} catch (ServiceException e) {
			return Response.status(Status.INTERNAL_SERVER_ERROR).build();
		}
	}
}

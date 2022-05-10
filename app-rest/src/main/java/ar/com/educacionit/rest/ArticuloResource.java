package ar.com.educacionit.rest;

//import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

//import ar.com.educacionit.domain.Articulos;
//import ar.com.educacionit.services.ArticulosServices;
//import ar.com.educacionit.services.exceptions.ServiceException;
//import ar.com.educacionit.services.impl.ArticulosServicesImpl;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
//import jakarta.ws.rs.core.Response.Status;


@Path("productos")
public class ArticuloResource {
	//jersey
	
	/*
	 * retorna json
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response findAll() {
		ArticulosServices articuloService = new ArticulosServicesImpl();
		try {
			Collection<Articulos> articulos = articuloService.findAll();
			return Response.ok(articulos).build();
			//por medio de jackson se convierte a json 
		} catch (ServiceException e) {
			return Response.status(Status.INTERNAL_SERVER_ERROR).build();
		}
	}
	*/
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response find() {
		//ArticulosServices articuloService = new ArticulosServicesImpl();
		Map<String,String> datos = new HashMap<>();
		datos.put("clave1", "valor1");
		datos.put("clave2", "valor2");
		return Response.ok(datos).build();
	}
}

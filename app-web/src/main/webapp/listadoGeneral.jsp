<!DOCTYPE html>
<%@page import="ar.com.educacionit.web.enums.ViewKeysEnum"%>
<%@page import="java.util.Collection"%>
<%@page import="ar.com.educacionit.domain.Articulos"%>
<html lang="es">
<head>
	<jsp:include page="styles.jsp"/>
</head>
<body>
	<%--incluyo la seccion navbar --%>
	<jsp:include page="navbar.jsp"/>
	<main>
		<%-- seccion para visualizar errores --%>
		<jsp:include page="mensajeria.jsp"/>
		<%-- seccion ppal --%>
		<section class="container-fluid">
			<div class="row">
				<div class="col-sm-12 col-md-4 col-lg-3">
					<form>
					  <div class="mb-3">
					    <label for="exampleInputEmail1" class="form-label">Email address</label>
					    <input type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp">
					  </div>
					  <div class="mb-3">
					    <label for="exampleInputPassword1" class="form-label">Password</label>
					    <input type="password" class="form-control" id="exampleInputPassword1">
					  </div>
					  <button type="submit" class="btn btn-primary">Filtrar</button>
					</form>
				</div>
				<div class="col">
					<h2>Listado de articulos</h2>
					<table class="table">
					 	<thead>
					    <tr>
					      <th scope="col">#</th>
					      <th scope="col">Título</th>
					      <th scope="col">Código</th>
					      <th scope="col">Precio</th>
					      <th scope="col">Stock</th>
					      <th scope="col">Id Marca</th>
					      <th scope="col">Id Categoria</th>
					      <th scope="col"></th>
					    </tr>
					  </thead>
					  <tbody>
					  	<% Collection<Articulos> articulos = (Collection<Articulos>)session.getAttribute(ViewKeysEnum.LISTADO.getParam());%>
						<% for(Articulos aux: articulos){%>
						    <tr>
						      <td scope="row"><%=aux.getTitulo() %>&nbsp;</td>
						      <td><%=aux.getTitulo() %></td>
						      <td><%=aux.getCodigo() %></td>
						      <td><%=aux.getPrecio() %></td>
						      <td><%=aux.getStock() %></td>
						      <td><%=aux.getMarcasId() %></td>
						      <td><%=aux.getCategoriasId() %></td>
						      <td>
						      	<!-- Button trigger modal -->
								<button type="button" class="btn btn-danger" data-bs-toggle="modal" data-bs-target="#modalEliminar"
									onclick="guardarId(<%=aux.getId()%>)">
								  Eliminar
								</button>
								<a class="btn btn-primary" role="button">Editar</a>
						      </td>
						    </tr>
					   	<%} %>				    
					  </tbody>
					  <tfoot>
					  	<tr>
					  		<td colspan="3">
					  			Total:
					  		</td>
					  		<td colspan="4">
					  			<%=session.getAttribute(ViewKeysEnum.TOTAL.getParam()).toString() %>
					  		</td>
					  	</tr>
					  </tfoot>
					</table>
				</div>
			</div>		
		</section>
		<!-- Modal -->
		<div class="modal fade" id="modalEliminar" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
		  <div class="modal-dialog">
		    <div class="modal-content">
		      <div class="modal-header">
		        <h5 class="modal-title" id="exampleModalLabel">Eliminar Articulo</h5>
		        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
		      </div>
		      <div class="modal-body">
		        ¿Desea eliminar el articulo?
		      </div>
		      <div class="modal-footer">
		      	<form id="eliminarForm" action="<%=request.getContextPath()%>/controllers/EliminarProductoServlet">
		      		<input name="id" type="hidden" id="idProductoEliminar">
			        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cerrar</button>
			        <button type="submit" class="btn btn-primary">Confirmar</button>
		        </form>
		      </div>
		    </div>
		  </div>
		</div>
	</main>
	<jsp:include page="scripts.jsp"/>
	<script type="text/javascript" src="<%=request.getContextPath()%>/js/listado-general.js"></script>
</body>
</html>
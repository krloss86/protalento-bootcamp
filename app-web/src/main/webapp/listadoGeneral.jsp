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
						    </tr>
					   	<%} %>				    
					  </tbody>
					</table>
				</div>
			</div>		
		</section>
	</main>
	<jsp:include page="scripts.jsp"/>
</body>
</html>
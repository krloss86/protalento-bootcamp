<!DOCTYPE html>
<%@page import="ar.com.educacionit.web.enums.ViewKeysEnum"%>
<%@page import="java.util.Collection"%>
<%@page import="ar.com.educacionit.domain.Articulos"%>
<html lang="es">
<head>
	<jsp:include page="styles.jsp"/>
	<script type="text/javascript">
		async function editar(id) {
			const options = {
			  keyboard: false
			};
			
			//simulo que tengo el json de http://sito.com.ar/api/v1/articulo?id=1
			/*
			const articuloJson = {
			 id:id,
			 titulo:"titulo1",
			 fechaCreacion: new Date(),
			 codigo: 'tit000',
			 precio: 1500,
			 marca: {
				id:1,
				marca: 'nike'
			 }
			};
			*/
			//hace la peticion asincrona (ajax) 
			let articuloJson = await axios.get(`<%=request.getContextPath()%>/rest/ProductoRest?id=${id}`);

			articuloJson = articuloJson.data;
			
			const articulo = articuloJson.articulo;
			
			//tomo el input con id='id' y actualizo su valor con articuloJson.id
			document.getElementById('idArticulo').value = articulo.id;
			document.getElementById('id').innerHTML = articulo.id;
			document.getElementById('titulo').value = articulo.titulo;
			document.getElementById('precio').value = articulo.precio;
			
			const categorias = articuloJson.categorias;
			llenarSelect('categorias',categorias, articulo.categoria.id);
						
			const marcas = articuloJson.marcas;
			llenarSelect('marcas',marcas,articulo.marca.id);
			
			const myModal = new bootstrap.Modal(document.getElementById('modalActualizarArticulo'), options)
			myModal.show();
			//usar libreria de axios para pedir informacion al servidor
			
			// voy a obtener el json que retorna
			
			//actualizar el form que está en el modal
			
			//tomando los atributos del json y 
		}
		
		function llenarSelect(id,lista,idSelected) {
			//tomar el select por su id
			const select = document.getElementById(id);
			const currentList = select.getElementsByTagName('option');
			if(currentList.length > 0) {
				for(const opcion of currentList) {
					opcion.selected = +opcion.value === idSelected;
				}
				return;
			}
			//<option selected>Open this select menu</option>
			for(const obj of lista) {
				const opcion = document.createElement('option');
				opcion.value = obj.id;
				opcion.text = obj.descripcion;				
				opcion.selected = obj.id === idSelected;
				select.appendChild(opcion);
			}
		}
	</script>
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
								<a class="btn btn-primary" 
									role="button"
									onclick="editar(<%=aux.getId()%>)" 
									>Editar
								</a>
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
		
		<!-- Modal para actualizar articulo-->
		<div class="modal fade" id="modalActualizarArticulo" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
		  <div class="modal-dialog">
	      	<form id="eliminarForm" action="<%=request.getContextPath()%>/controllers/EditarProductoServlet" method="POST">
			    <div class="modal-content">
			      <div class="modal-header">
			        <h5 class="modal-title" id="exampleModalLabel">Actualizar Articulo</h5>
			        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
			      </div>
			      <div class="modal-body">
	    				<div class="mb-3">
					    <label for="id" 
					    	class="form-label">ID</label>
					    <%--
					    <input type="text"
					    	name="id" 
					    	class="form-control" 
				    		id="id" 
				    		disabled="disabled"
				    		aria-describedby="emailHelp">
				    	--%>
				    	<input name="id" id="idArticulo" type="hidden">
				    	<span id="id"></span>
					  </div>
					  <div class="mb-3">
					    <label for="titulo" 
					    	class="form-label">Título</label>
					    <input type="text" 
					    	name="titulo" 
					    	class="form-control" 
				    		id="titulo" 
				    		aria-describedby="emailHelp">
					  </div>
					  <div class="mb-3">
					    <label for="precio" 
					    	class="form-label">Precio</label>
					    <input type="number" 
					    	name="precio" 
					    	class="form-control" 
					    	id="precio">
					  </div>
					  <div class="mb-3">
						<!-- MARCAS -->
						<label for="marcas" 
					    	class="form-label">Marca</label>
						<select id="marcas" 
							class="form-select"
							name="marcas" 
							aria-label="">						  
						</select>
					  </div>
					  <!-- CATEGORIAS -->
					  <div class="mb-3">
						<!-- MARCAS -->
						<label for="categorias" 
					    	class="form-label">Categorias</label>
						<select id="categorias" 
							class="form-select"
							name="categorias" 
							aria-label="">						  
						</select>
					  </div>
	<!-- 				<button type="submit" class="btn btn-primary">Actualizar</button> -->
			      </div>
			      <div class="modal-footer">
		      		<button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cerrar</button>
			        <button type="submit" class="btn btn-primary">Confirmar</button>
			      </div>
			    </div>
			</form>
		  </div>
		</div>
	</main>
	<jsp:include page="scripts.jsp"/>
	<script type="text/javascript" src="<%=request.getContextPath()%>/js/listado-general.js"></script>
	<script src="https://unpkg.com/axios/dist/axios.min.js"></script></body>
</html>
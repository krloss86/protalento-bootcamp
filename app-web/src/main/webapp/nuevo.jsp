<!DOCTYPE html>
<%@page import="ar.com.educacionit.domain.Categorias"%>
<%@page import="java.util.Collection"%>
<%@page import="ar.com.educacionit.domain.Marcas"%>
<%@page import="ar.com.educacionit.web.enums.ViewKeysEnum"%>
<html lang="es">
<head>
	<jsp:include page="styles.jsp"/>
</head>
<body>
	<jsp:include page="navbar.jsp"/>
	<main>
		<jsp:include page="mensajeria.jsp"/>
		<section class="container">
			<div class="row d-flex justify-content-center">
				<h1>Nuevo Producto</h1>				
						<form class="row g-3 needs-validation" novalidate action="<%=request.getContextPath()%>/controllers/NuevoProductoServlet" method="POST">
						  <div class="mb-3">
						    <label for="titulo" 
						    	class="form-label">Título</label>
						    <input type="text" 
						    	name="titulo" 
						    	class="form-control" 
					    		id="titulo" 
					    		aria-describedby="emailHelp"
					    		required
					    		maxlength="100">
						  </div>
						  <div class="mb-3">
						    <label for="codigo" 
						    	class="form-label">Código</label>
						    <input type="text" 
						    	name="codigo" 
						    	class="form-control" 
					    		id="codigo" 
					    		aria-describedby="emailHelp"
					    		required
					    		maxlength="10">
						  </div>
						  <div class="mb-3">
						    <label for="stock" 
						    	class="form-label">Stock</label>
						    <input type="number" 
						    	name="stock" 
						    	class="form-control" 
					    		id="stock" 
					    		aria-describedby="stock"
					    		required
					    		min="0"
					    		max="999999">
						  </div>
						  <div class="mb-3">
						    <label for="precio" 
						    	class="form-label">Precio</label>
						    <input type="number" 
						    	name="precio" 
						    	class="form-control" 
						    	id="precio"
						    	required
						    	min="0"
						    	max="9999999">
						  </div>
						  <div class="mb-3">
							<!-- MARCAS -->
							<label for="marcas" 
						    	class="form-label">Marca</label>
							<select id="marcas" 
								class="form-select"
								name="marcas" 
								aria-label=""
								required>
								<%
									for(Marcas marca : (Collection<Marcas>)session.getAttribute(ViewKeysEnum.MARCAS.getParam())) {
								%>
									<option value="<%=marca.getId()%>"><%=marca.getDescripcion() %></option>
								<%
									}
								%>
							</select>
						  </div>
						  <!-- CATEGORIAS -->
						  <div class="mb-3">
							<label for="categorias" 
						    	class="form-label">Categorias</label>
							<select id="categorias" 
								class="form-select"
								name="categorias" 
								aria-label=""
								required>
								<%
									for(Categorias categoria : (Collection<Categorias>)session.getAttribute(ViewKeysEnum.CATEGORIAS.getParam())) {
								%>
									<option value="<%=categoria.getId()%>"><%=categoria.getDescripcion() %></option>
								<%
									}
								%>						  
							</select>
						  </div>
						  <div class="col-12">
    							<button class="btn btn-primary" type="submit">Submit form</button>
 							</div>
					</form>		
				</div>					
		</section>
	</main>
	<jsp:include page="scripts.jsp"/>
	<script type="text/javascript">
	// Example starter JavaScript for disabling form submissions if there are invalid fields
	(function () {
	  'use strict'

	  // Fetch all the forms we want to apply custom Bootstrap validation styles to
	  var forms = document.querySelectorAll('.needs-validation')

	  // Loop over them and prevent submission
	  Array.prototype.slice.call(forms)
	    .forEach(function (form) {
	      form.addEventListener('submit', function (event) {
	        if (!form.checkValidity()) {
	          event.preventDefault()
	          event.stopPropagation()
	        }

	        form.classList.add('was-validated')
	      }, false)
	    })
	})()
	</script>
</body>
</html>
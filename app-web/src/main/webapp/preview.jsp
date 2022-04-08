<!DOCTYPE html>
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
				<h1>Preview de Archivos a procesar</h1>				
				<jsp:include page="./components/tablaArticulosPreview.jsp"/>
				<div class="row">
					<div class="col-12">
						<a class="btn btn-primary" href="<%=request.getContextPath()%>/controllers/CargarProductosServlet" role="button">Guardar</a>
					</div>
				</div>				
			</div>
		</section>
	</main>
	<jsp:include page="scripts.jsp"/>
</body>
</html>
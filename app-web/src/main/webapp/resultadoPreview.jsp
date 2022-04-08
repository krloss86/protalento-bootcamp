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
				<div class="col">
					<jsp:include page="./components/tablaArticulosPreviewResultados.jsp"/>
				</div>
			</div>
		</section>
	</main>
	<jsp:include page="scripts.jsp"/>
</body>
</html>
<%@page isELIgnored="false" %>
<%@page import="ar.com.educacionit.web.enums.ViewKeysEnum"%>
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
				<h1>Cargar Archivo</h1>
				<div class="col-6">
					<form action="${pageContext.request.contextPath}/controllers/UploadServlet" method="post" enctype="multipart/form-data"> 
						<div class="mb-3">
						  <label for="formFile" class="form-label">Cargar Archivo</label>
						  <input class="form-control" name="<%=ViewKeysEnum.UPLOAD_FILE.getParam()%>" type="file" id="formFile">
						</div>
						<button type="submit" class="btn btn-primary">Cargar Archivo</button>
					</form>
				</div>
			</div>
		</section>
	</main>
	<jsp:include page="scripts.jsp"/>
</body>
</html>
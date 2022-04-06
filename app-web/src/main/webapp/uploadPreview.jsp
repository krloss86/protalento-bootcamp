<%@page import="ar.com.educacionit.domain.Articulos"%>
<%@page import="java.util.Collection"%>
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
				<h1>Preview de Archivos a procesar</h1>
				<%
					Collection<Articulos> articulos = (Collection<Articulos>)request.getAttribute(ViewKeysEnum.UPLOAD_PREVIEW_KEY.getParam());
					out.print(articulos);
				%>
			</div>
		</section>
	</main>
	<jsp:include page="scripts.jsp"/>
</body>
</html>
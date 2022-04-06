<%@page isELIgnored="false" %>
<%@page import="ar.com.educacionit.web.enums.ViewKeysEnum"%>
<%@page import="ar.com.educacionit.domain.Users"%>
<%@page import="ar.com.educacionit.web.enums.ViewKeysEnum"%>
<%
	//objetos implicitos que tiene las jsp
 	Users user = (Users)session.getAttribute(ViewKeysEnum.USER.getParam());
%>
<!DOCTYPE html>
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
			<div class="row d-flex justify-content-center">
				<div class="col-6">
					<h1>Username: <%=user.getUsername()%> </h1>
					<h2>Nombre: <%=user.getSocio().getNombre()%> </h2>
					<h3>Apellido: <%=user.getSocio().getApellido()%> </h3>
					
					<a href="<%=request.getContextPath()%>/controllers/BuscarProductosServlet">Ver Listado</a>
				</div>
			</div>
		</section>
	</main>
	<jsp:include page="scripts.jsp"/>
</body>
</html>
<%@page isELIgnored="false" %>
<%@page import="ar.com.educacionit.web.enums.ViewKeysEnum"%>
<!-- HTML5 -->
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
					<form action="${pageContext.request.contextPath}/LoginServlet" method="POST">
					  <div class="mb-3">
					    <label for="exampleInputEmail1" class="form-label">Username</label>
					    <input type="text" name="<%=ViewKeysEnum.USERNAME.getParam()%>" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp">
					  </div>
					  <div class="mb-3">
					    <label for="exampleInputPassword1" class="form-label">Password</label>
					    <input type="password" name="<%=ViewKeysEnum.PASSWORD.getParam()%>" class="form-control" id="exampleInputPassword1">
					  </div>
					  <button type="submit" class="btn btn-primary">Login</button>
					</form>
				</div>
			</div>
		</section>
	</main>
	<jsp:include page="scripts.jsp"/>
</body>
</html>
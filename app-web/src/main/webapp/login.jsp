<%@page isELIgnored="false" %>
<%@page import="ar.com.educacionit.web.enums.ViewKeysEnum"%>
<!-- HTML5 -->
<!DOCTYPE html>
<html lang="es">
<head>
	<jsp:include page="styles.jsp"/>
	<script>
		function sendForm() {
			//obtiene el primer formulario del html
			const form = document.forms[0];	
			
			const loginObjet = {					
				username: document.getElementById('exampleInputEmail1').value,	
				password: document.getElementById('exampleInputPassword1').value
			}

			document.getElementById('data').value = JSON.stringify(loginObjet);
			
			form.submit();
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
			<div class="row d-flex justify-content-center">
				<div class="col-6">
					<form action="${pageContext.request.contextPath}/LoginServlet" method="POST">
					  <input type="hidden" id="data" name="data"/>
					  <div class="mb-3">
					    <label for="exampleInputEmail1" class="form-label">Username</label>
					    <input type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp">
					  </div>
					  <div class="mb-3">
					    <label for="exampleInputPassword1" class="form-label">Password</label>
					    <input type="password" class="form-control" id="exampleInputPassword1">
					  </div>
					  <button type="button" class="btn btn-primary" onclick="sendForm()">Login</button>
					</form>
				</div>
			</div>
		</section>
	</main>
	<jsp:include page="scripts.jsp"/>
</body>
</html>
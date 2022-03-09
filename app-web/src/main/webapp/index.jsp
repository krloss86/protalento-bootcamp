<html>
	<head>
		<title>Clase36 - Inicio java web</title>
	</head>
	<body>
		<h1>Clase36</h1>
		<h2>Subtitulo</h2>
		<ul>
			<li>1</li>
			<li>2</li>
			<li>3</li>
			<li>4</li>
		</ul>
		<% // scriplet
			// es codigo java que se compila
			// y se muestra como html
			for(int i=0; i< 4; i++) {
				out.print("i vale: " +i + "<br>");
			}
		%>
		
		<!-- crepo un formulario -->
		<form action="<%=request.getContextPath()%>/listado"
		 	method="POST">
			<!-- con un boton dentro -->
			<input type="submit" value="Pedir Listado"/>
		</form>
		
		<!-- crepo un formulario -->
		<form action="<%=request.getContextPath()%>/listado"
		 	method="GET">
			<!-- con un boton dentro -->
			<input type="submit" value="Pedir Listado"/>
		</form>
	</body>
</html>
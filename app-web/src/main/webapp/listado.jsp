<%@page import="ar.com.educacionit.domain.Articulos"%>
<%@page import="java.util.List"%>

<html>
	
	<head>
	
	</head>
	
	<body>
		<!-- 
			quiero capturar el listado que envio el servlet bajo el nombre
			LISTADO
		-->
		<% //SCRIPTLET > ESCRIBIR CODIGO JAVA
			// dentro de las jsp tengo un "objeto implicito" llamado request
 			
			//primero 
			Object listadoObject = request.getAttribute("LISTADO");
		
			//puedo castear de Object a List<Articulos>
			List<Articulos> listado = (List<Articulos>)listadoObject;
		%>
		
		<%
			//recorrer el listado e ir dibujando el codigo en un parrafo html 
			for(Articulos art : listado) {
		%>
			<!-- puedo poner html puro y usar el objeto art --> 
			<p><%=art.getCodigo()%></p>
		<%
			}
		%>
	</body>
</html>
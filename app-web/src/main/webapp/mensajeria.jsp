<%@page import="ar.com.educacionit.web.enums.ViewKeysEnum"%>
<%
  	//si existe alguien CualuierServlet
 	String error = (String)request.getAttribute(ViewKeysEnum.ERROR_GENERAL.getParam());
	String exito = (String)request.getAttribute(ViewKeysEnum.EXITO.getParam());
%>

<%
	if(error != null) {
%>
	<div class="alert alert-danger" role="alert">
	 	<%=error%>
	</div>
<%
	}
%>

<%
	if(exito!= null) {
%>
	<div class="alert alert-success" role="alert">
	 	<%=exito%>
	</div>
<%
	}
%>
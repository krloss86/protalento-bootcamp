<%@page import="ar.com.educacionit.web.enums.Enumerable"%>
<%@page import="java.util.ArrayList"%>
<%@page import="ar.com.educacionit.web.enums.ViewKeysEnum"%>
<%@page import="ar.com.educacionit.domain.Articulos"%>
<%@page import="java.util.Collection"%>
<%
	Enumerable _enum = (Enumerable)session.getAttribute(Enumerable.ENUMPARAM);
	Collection<Articulos> articulos = (Collection<Articulos>)session.getAttribute(_enum.getParam());
	if(articulos == null) {
		articulos = new ArrayList<>();
	}
%>
<table class="table">
 	<thead>
    <tr>
      <th scope="col">#</th>
      <th scope="col">Título</th>
      <th scope="col">Código</th>
      <th scope="col">Precio</th>
      <th scope="col">Stock</th>
      <th scope="col">Id Marca</th>
      <th scope="col">Id Categoria</th>
    </tr>
  </thead>
  <tbody>
	<% for(Articulos aux: articulos){%>
	    <tr>
	      <th scope="row"><%=aux.getTitulo() %></th>
	      <td><%=aux.getTitulo() %></td>
	      <td><%=aux.getCodigo() %></td>
	      <td><%=aux.getPrecio() %></td>
	      <td><%=aux.getStock() %></td>
	      <td><%=aux.getMarcasId() %></td>
	      <td><%=aux.getCategoriasId() %></td>
	    </tr>
   	<%} %>				    
  </tbody>
</table>
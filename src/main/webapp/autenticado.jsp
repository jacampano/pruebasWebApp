<%@ page import="java.lang.*" %>
<%@ page session="true" %>
<%
  Boolean autenticado = (Boolean) session.getAttribute("autenticado");
  if (autenticado != null && autenticado) {
%>
    <h2 id="paginaAutenticado">Autenticado</h2>
    <!-- Contenido adicional para usuarios autenticados -->
<%
  } else {
    response.sendRedirect("no-autenticado.jsp");
  }
%>
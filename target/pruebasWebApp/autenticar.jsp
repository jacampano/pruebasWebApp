<%@ page import="java.lang.*" %>
<%@ page session="true" %>
<%
  String nombre = request.getParameter("nombre");
  String contrasena = request.getParameter("contrasena");

  if ("usuario".equals(nombre) && "password".equals(contrasena)) {
    session.setAttribute("autenticado", true);
    response.sendRedirect("autenticado.jsp");
  } else {
    response.sendRedirect("no-autenticado.jsp");
  }
%>
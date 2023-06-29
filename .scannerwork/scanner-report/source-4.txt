<%@ page import="java.lang.*,java.util.Map"%>
<%@ page session="true" %>
<html>
<body>
<h2>Aplicacion pruebas Despliegue Contenedores</h2>
<%
    String var1 = System.getenv("CONFIGMAP");
    String var2 = System.getenv("SECRET");
    
    session = request.getSession(true);

%>
<h3>Formulario autenticar</h3>
<form method="post" action="autenticar.jsp" style="text-align: left;">
  <div style="align-items: left;">
  <label for="nombre">User:</label>
  <input type="text" name="nombre" id="nombre" required><br>
  <label for="contrasena">Pass:</label>
  <input type="password" name="contrasena" id="contrasena" required><br>
  <input type="submit" value="Autenticar" id="autenticar">
  </div>
</form>

<p>Lectura variable entorno via configmap:   <b><%=var1%> </b></p>
<p>Lectura variable entorno via secrets:   <b><%=var2%> </b></p>
</br>
</br>
<h3>Listado de todas las variables de entorno </h3>
<%
Map<String, String> env = System.getenv();
for (String envName : env.keySet()) {
    String valor = env.get(envName);
    session.setAttribute(envName, valor);
    String valorPropiedadSesion = (String) session.getAttribute(envName);
    
%>
<p> <%=envName%> = <%=valorPropiedadSesion%> </p>
<%
}
%>


</body>
</html>

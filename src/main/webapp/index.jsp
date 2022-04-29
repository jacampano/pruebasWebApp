<%@ page import="java.lang.*,java.util.Map"%>
<html>
<body>
<h2>Aplicacion pruebas Despliegue Contenedores</h2>
<%
    String var1 = System.getenv("CONFIGMAP");
    String var2 = System.getenv("SECRET");
%>
<p>Lectura variable entorno via configmap:   <b><%=var1%> </b></p>
<p>Lectura variable entorno via secrets:   <b><%=var2%> </b></p>
</br>
</br>
<h3>Listado de todas las variables de entorno </h3>
<%
Map<String, String> env = System.getenv();
for (String envName : env.keySet()) {
    String valor = env.get(envName);
%>
<p> <%=envName%> = <%=valor%> </p>
<%
}
%>


</body>
</html>

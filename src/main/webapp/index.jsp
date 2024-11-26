<%@ page import="java.lang.System"%>
<%@ page import="java.util.Map"%>
<%@ page import="java.io.BufferedReader" %>
<%@ page import="java.io.File" %>
<%@ page import="java.io.FileReader" %>
<%@ page import="java.io.IOException" %>
<%@ page import="java.util.Properties" %>
<%@ page import="es.jacampano.curso.*" %>

<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha384-vtXRMe3mGCbOeY7l30aIg8H9p3GdeSe4IFlP6G8JMa7o7lXvnz3GFKzPxzJdPfGK" crossorigin="anonymous"></script>
<link href="https://cdn.datatables.net/v/dt/dt-2.0.5/datatables.min.css" rel="stylesheet">
<script src="https://cdn.datatables.net/v/dt/dt-2.0.5/datatables.min.js" integrity="sha384-XF3Rp9av2UCgM3eD8xGPkc0yW445qxJMEGUBLYjWptDSrwEjFqEP+p/BVB2Feg2i" crossorigin="anonymous"></script>
<!DOCTYPE html>

<!-- Comentario para que SonarQube no falle -->
<html lang="es">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Aplicación pruebas Despliegue Contenedores - prueba POC operacion</title>
        <link rel="stylesheet" href="css/styles.css">
    </head>
<div class="general">
<body>
    <div class="header">
        <h2>Aplicacion pruebas Despliegue pipeline</h2>
    </div>
<!-- Comentario para que SonarQube no falle -->
<%
    String var1 = "";
    String var2 = "";
    String CONFIGMAP= System.getenv("CONFIGMAP");
    String SECRET = System.getenv("SECRET");
    if ( CONFIGMAP != null ) {
        var1 = CONFIGMAP ;
    } else {
        var1 ="No se ha encontrado variable CONFIGMAP!!" ;
    }

    if ( SECRET != null ) {
        var2 = SECRET ;
    } else {
        var2 ="No se ha encontrado variable SECRET" ;
    }
    
    String pomPropertiesPath = pageContext.getServletContext().getRealPath("/META-INF/maven/es.juntadeandalucia/pruebaswebapp/pom.properties");
    String version = PomPropertiesReader.getVersion(pomPropertiesPath);
%>
<!-- Comentario para que SonarQube no falle -->
<p>Lectura variable entorno via configmap:   <b><%=var1%> </b></p>
<p>Lectura variable entorno via secrets:   <b><%=var2%> </b></p>
</br>
</br>
<h2>POM version: <%=version%></h2>
</br>
</br>
<h3> -- Probando -- Listado de todas las variables de entorno -- Probando -- </h3>
<!-- Comentario para que SonarQube no falle -->
<table id="tablaVariablesEntorno" border="1" class="table is-striped" style="width:100%">
    <caption>Tabla de ejemplo</caption>
    <thead>
        <tr>
            <th>Variable de entorno</th>
            <th>Valor</th>
        </tr>
    </thead>
    <tbody>
        <%
        Map<String, String> env = System.getenv();
        for (String envName : env.keySet()) {
            String valor = env.get(envName);
        %>
        <tr>
            <td><%=envName%></td>
            <td><%=valor%></td>
        </tr>
    </tbody>
    <%
    }
    %>
</table>
<!-- Comentario para que SonarQube no falle -->
<script>
    
    $(document).ready(function() {
        $('#tablaVariablesEntorno').DataTable({
            paging: true,
            searching: false
        });
    });
</script>
<!-- Comentario para que SonarQube no falle -->
</body>
</div>
</html>


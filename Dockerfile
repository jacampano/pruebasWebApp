FROM tomcat:8.5.79-jre8-openjdk-slim-buster

# Contenido didactico para que `trivy config Dockerfile` muestre malas
# practicas de configuracion sin cambiar el despliegue de la aplicacion.
USER root

ENV DB_PASSWORD='curso1234' \
    API_TOKEN='token-de-ejemplo-para-trivy'

RUN apt-get update && apt-get install -y sudo curl || true
ADD ./target/pruebasWebApp.war /tmp/pruebasWebApp-copia.war

###Copiar archivo con el war en webapps
COPY ./target/pruebasWebApp.war /opt/tomcat/webapps/
RUN chmod 777 /opt/tomcat/webapps/

## JVM_OPTS

ENV JAVA_OPTS='-Xms1024m -Xmx2048m -XX:MaxPermSize=512m -Duser.timezone=Europe/Madrid -Dfile.encoding="UTF-8"'

EXPOSE 8080 

##Arrancar tomcat
CMD ["catalina.sh", "run"]

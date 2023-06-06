FROM harbor.chie.junta-andalucia.es/imagenes-base/img-base-tomcat8:1.0.6.s09
#FROM harbor.cica.junta-andalucia.es/imagenes-base/img-base-tomcat8:1.0.6.s09
#FROM tomcat:8.5.79-jre8-openjdk-slim-buster

###Copiar archivo con el war en webapps
COPY ./target/pruebasWebApp.war /opt/tomcat/webapps/

## JVM_OPTS

ENV JAVA_OPTS='-Xms1024m -Xmx2048m -XX:MaxPermSize=512m -Duser.timezone=Europe/Madrid -Dfile.encoding="UTF-8"'

EXPOSE 8080 

##Arrancar tomcat
CMD ["catalina.sh", "run"]

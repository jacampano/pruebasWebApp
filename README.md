# PruebasWebApp

_Aplicacion Java mavenizada de pruebas para cursos de Jenkins y SonarQube._

## Objetivo didactico

Este proyecto contiene una aplicacion web sencilla y varias clases Java de ejemplo. La logica nueva simula un carrito de la compra y esta preparada para explicar en clase:

* Code smells habituales: constantes magicas, comparacion de `String` con `==`, bloques complejos, `System.out`, variables sin uso y comentarios heredados.
* Bugs potenciales: acceso a metodos sobre valores que pueden ser `null`.
* Security hotspots: credenciales simuladas en codigo.
* Duplicidades: `calcularPrecioClienteOro` y `calcularPrecioClientePlatino` contienen bloques casi identicos.
* Cobertura de tests: JaCoCo genera `target/site/jacoco/jacoco.xml` para SonarQube.

Para ejecutar los unitarios y generar cobertura:

```
mvn clean test
```

La prueba Selenium queda marcada con `@Ignore` porque depende del entorno de laboratorio `lab.zalenium` y `lab.tomcat`.

## Comenzando 🚀


Mira **Deployment** para conocer como desplegar el proyecto.


### Pre-requisitos 📋

_Que cosas necesitas para instalar el software y como instalarlas_

```
Da un ejemplo
```

### Instalación 🔧

_Una serie de ejemplos paso a paso que te dice lo que debes ejecutar para tener un entorno de desarrollo ejecutandose_

_Dí cómo será ese paso_

```
Da un ejemplo
```

_Y repite_

```
hasta finalizar
```

_Finaliza con un ejemplo de cómo obtener datos del sistema o como usarlos para una pequeña demo_

## Ejecutando las pruebas ⚙️

_Explica como ejecutar las pruebas automatizadas para este sistema_

### Analice las pruebas end-to-end 🔩

_Explica que verifican estas pruebas y por qué_

```
Da un ejemplo
```

### Y las pruebas de estilo de codificación ⌨️

_Explica que verifican estas pruebas y por qué_

```
Da un ejemplo
```

## Despliegue 📦

_Agrega notas adicionales sobre como hacer deploy_

## Construido con 🛠️

_Menciona las herramientas que utilizaste para crear tu proyecto_

* [Dropwizard](http://www.dropwizard.io/1.0.2/docs/) - El framework web usado
* [Maven](https://maven.apache.org/) - Manejador de dependencias
* [ROME](https://rometools.github.io/rome/) - Usado para generar RSS

## Contribuyendo 🖇️

Por favor lee el [CONTRIBUTING.md](https://gist.github.com/villanuevand/xxxxxx) para detalles de nuestro código de conducta, y el proceso para enviarnos pull requests.

## Wiki 📖

Puedes encontrar mucho más de cómo utilizar este proyecto en nuestra [Wiki](https://github.com/tu/proyecto/wiki)

## Versionado 📌

Usamos [SemVer](http://semver.org/) para el versionado. Para todas las versiones disponibles, revisa las etiquetas

## Autores ✒️



* **Juan Antonio Campano** - 


También puedes mirar la lista de todos los [contribuyentes](https://github.com/your/project/contributors) quíenes han participado en este proyecto. 

## Licencia 📄




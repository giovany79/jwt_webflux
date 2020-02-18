# JWT con Webflux
Proyecto que se encarga de generar un token de sesión JWT y validarlo luego para acceder a recursos de un API

# Fundamentos de JWT
https://github.com/giovany79/jwt_webflux/wiki/Json-Web-Token---JWT

# Técnologías

## JDK 11
Versión de Java 11 para desarrollo de aplicaciones en lenguaje de programación Java https://www.oracle.com/technetwork/java/javase/downloads/jdk11-downloads-5066655.html

## Spring-boot 2.0
Componente que permite crear aplicaciones autocontenidas y las cuales se ejecutan en su mismo proceso
https://spring.io/projects/spring-boot

## Spring Webflux
Framework de spring que implementa el modelo reactivo para la creación de servicios rest. https://docs.spring.io/spring/docs/current/spring-framework-reference/web-reactive.html

## Spring security
Es un framework que permite personalizar la autenticación y el control de acceso. Se enfoca en proporcionar autenticación y autorización a aplicaciones Java.
https://spring.io/projects/spring-security

## Gradle
Gradle permite automatizar la administración de dependencias, automatizar pruebas unitarias y de acceptación y generar artefactos desplegables.
https://gradle.org/

## Lombok
Libreria que permite automatizar mediante anotaciones la escritura de getters, setters y constructores en tiempo de compilación https://projectlombok.org/

## io.jsonwebtoken.jjwt
Librería que ayuda a crear y verificar JSON Web Tokens (JWTs) basado en las especificaciones JWT, JWS, JWE, JWK y JWA
https://github.com/jwtk/jjwt#jws-create

# Requisitos

1. Tener instalado JDK 11

2. Tener instalado IDE (Intellij, Eclipse, Netbeans, etc)

# Ejercicio
Se requiere generar un token de sesión JWT luego de una autenticación exitosa con usuario y password. Este token de sesión se debe enviar en la cabecera autorization para consumir operaciones del API

# Solución
Se crea un microservicio que expone una operación para autenticación mediante un método post enviandole el usuario y el password en formato json. Como respuesta genera un bearer token JWT. Este token se debe enviar como cabecera autorization en la petición de resourse/user para autorizar la ejecución de la operación

# Estructura de la solución

## Paquete config
Este paquete contiene las clases para la administración de los Json Web Token y administración de la seguridad

### AuthenticationManager
Clase que implementa ReactiveAuthenticationManager  para validar el token.

### JwtUtil
Clase que tiene los métodos que genera y valida el token

### UserService
Clase de servicio para validar que el usuario exista

### WebSecurityConfig
Clase que permite configurar todas las necesidades de seguridad. Controla que operación requiere autenticación previa

### PBKDF2PasswordEncoder
Clase que implementa PBKDF2PasswordEncoder para personalizar el encoding del password. Requiere la configuración del secreto en el application.yaml

### CORSFilter
(Cross Origin Resource Sharing) Filtro para manejar los CORS.

## Paquete model
Tiene las clases entidad que representan los request y los responses

### JwtRequest
Entidad para el request del JWT donde se envía usuario y password

### JwtResponse
Entidad para el response donde devuelve el JWT

### Message
Entidad para el mensaje de respuesta una vez el JWT es validado

### User
Entidad que representa al usuario y si estado

## Paquete controler
Tiene los controladores para el servicio de autenticación como el de solicitud del mensaje

### AuthenticationController
Controlador que se encarga de resolver la autenticación y devolver  el token JWT

### Controller
Controlador que se encarga de resolver la petición validando previamente el token

## resources - application.yaml
Propiedades requeridas por la aplicación

- **springbootwebfluxjjwt.password.encoder.secret:** Secreto usado para cifrar la clave
- **springbootwebfluxjjwt.password.encoder.iteration:** Es el número de veces que el password es cifrado durante la derivacion de la llave simetrica. 
- **springbootwebfluxjjwt.password.encoder.iteration.keylength:** La longitud de la llave a ser entregada

- **springbootwebfluxjjwt.jjwt.secret:** Secreto usado para firmar el JWT
- **springbootwebfluxjjwt.jjwt.expiration:** Tiempo de expiración del JWT

## Como probar el servicio

1. Ingresar con usuario y clave invalido
- Se aprecia que se devuelve un status code 401 Unauthorized
![](https://github.com/giovany79/images/blob/master/jwtwrongpassword.png)


2. Ingresar con usuario y clave correcta
- Devuelve un status code 200
- Devuelve en el body el token JWT
![](https://github.com/giovany79/images/blob/master/jwtpasswordOK.png)

3. Consumir el servicio sin autenticación previa (Sin Bearer token)
- Devuelve un status code 401 Unauthorized
![](https://github.com/giovany79/images/blob/master/jwtwithoutBearer.png)

4. Consumir el servicio enviando el Bearer token
- Se aprecia que se devuelve el recurso correctamente
https://github.com/giovany79/images/blob/master/JwtWithBearer.png

## Referencias
https://medium.com/@ard333/authentication-and-authorization-using-jwt-on-spring-webflux-29b81f813e78

# JWT con Webflux
Proyecto que se encarga de generar un token de sesión JWT y validarlo luego para acceder a recursos de un API

# Técnologías

## JDK 11

## Springboot 2.0

## Webflux

## Spring security

## Gradle

## Lombok

## io.jsonwebtoken.jjwt

# Requisitos

1. Tener instalado JDK 11

2. Tener instalado IDE (Intellij, Eclipse, Netbeans, etc)

# Ejercicio
Se requiere generar un token de sesión JWT luego de una autenticación exitosa con usuario y password. Este token de sesión se debe enviar en la cabecera autorization para consumir operaciones del API

# Solución
Se crea un microservicio que expone una operación para autenticación mediante un método post enviandole el usuario y el password en formato json. Como respuesta genera un bearer token JWT. Este token se debe enviar como cabecera autorization en la petición de resourse/user para autorizar la ejecución de la operación

# Estructura de la solución

## Paquete config

## Paquete model

## Paquete controler

## resources - application.yaml


## Referencias
https://medium.com/@ard333/authentication-and-authorization-using-jwt-on-spring-webflux-29b81f813e78

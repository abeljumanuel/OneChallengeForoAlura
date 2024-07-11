<div align="center">
  <h1 align="center">
    API de Foro Alura
    <br>
    <br>
    <img src="https://app.aluracursos.com/assets/images/logos/logo-aluraespanhol.svg" alt="Logo Foro Alura" width="200" align=auto/>
  </h1>
</div>

![Estado del Proyecto](https://img.shields.io/badge/ESTADO-EN%20DESARROLLO-green)

API REST para el foro de Alura, permitiendo la gestión de tópicos y cursos.

## 🔧 Funcionalidades del proyecto

- `Funcionalidad 1`: CRUD completo de tópicos del foro.
- `Funcionalidad 2`: Listado paginado de tópicos.
- `Funcionalidad 3`: Búsqueda de tópicos por año.
- `Funcionalidad 4`: Autenticación y autorización mediante JWT.

## Cómo usar la API
![Demo de uso de la API](img/demo-api-uso.gif)

### Pre-requisitos 📋
- Java 17
- PostgreSQL
- Maven

## 📁 Acceso al proyecto
Puedes clonar el proyecto usando el siguiente comando:

## 🛠️ Abre y ejecuta el proyecto

1. Configura la base de datos PostgreSQL en `application.properties`.
2. Ejecuta `mvn clean install` para instalar las dependencias.
3. Inicia la aplicación con `mvn spring-boot:run`.

## Construido con 🛠️

- [Java 17](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html)
- [Spring Boot](https://spring.io/projects/spring-boot)
- [Spring Security](https://spring.io/projects/spring-security)
- [PostgreSQL](https://www.postgresql.org/)
- [JWT](https://jwt.io/)

## Endpoints principales

### Tópicos

- `GET /topicos`: Lista todos los tópicos activos (paginado).
- `GET /topicos/especial?anio={año}`: Lista tópicos creados en un año específico.
- `POST /topicos`: Crea un nuevo tópico.
- `PUT /topicos`: Actualiza un tópico existente.
- `DELETE /topicos/{id}`: Elimina lógicamente un tópico.
- `GET /topicos/{id}`: Obtiene detalles de un tópico específico.

## Seguridad

La API utiliza Spring Security y JWT para la autenticación y autorización. Asegúrate de incluir el token JWT en el header de tus peticiones para acceder a los endpoints protegidos.

## Contribuyendo 🖇️

Las contribuciones son lo que hacen a la comunidad de código abierto un lugar increíble para aprender, inspirar y crear. Cualquier contribución que hagas será **muy apreciada**.

1. Haz un Fork del proyecto
2. Crea tu rama de característica (`git checkout -b feature/AmazingFeature`)
3. Haz commit de tus cambios (`git commit -m 'Add some AmazingFeature'`)
4. Haz Push a la rama (`git push origin feature/AmazingFeature`)
5. Abre un Pull Request

## Autor ✒️

* **Juan Manuel Rojas Gonzalez** - *Trabajo Inicial Primera Api Spring Boot y Documentación* - [Abeljumanuel](https://github.com/Abeljumanuel)

## Expresiones de Gratitud 🎁

* Comenta a otros sobre este proyecto 📢
* Invita una cerveza 🍺 o un café ☕ a alguien del equipo.
* Da las gracias públicamente 🤓.

---
⌨️ con ❤️ por [Abeljumanuel](https://github.com/Abeljumanuel) 😊
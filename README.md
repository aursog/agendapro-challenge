# AgendaPro - Java Backend Technical Test

Resolución de test para posición de Java Backend Senior. 

## Descripción

Esta API está diseñada para crear y consultar sobre un listado de productos, los cuales serán almacenados en una base de datos 
PostgreSQL.

Para eso se implementó un mecanismo de autenticación y uso de recursos a través de JWT para proporcionar seguridad de datos restringidos.

Se agrega como parte de la documentación, el acceso a plataforma Swagger/OpenApi3 para acceder a los recursos del sistema y poder probar.

## Features

- Crear un usuario de acuerdo con la siguiente estructura:

```json
{
    "name": <String>,
    "email": <String>,
    "password": <String>,
    "phones": [
        {
            "number": <String>,
            "citycode": <String>,
            "countrycode": <String>
        }
    ]
}
```
- La constraseña deberá seguir las siguientes restricciones.
  - Largo entre 8 y 20 caracteres.
  - A lo menos una mayúscula.
  - A lo menos un número.
  - A lo menos un caracter especial (ej: @, #, $, %, ^, &, +, =)
- Almacenamiento en base de datos PostgreSQL
- End-point sin requerir autenticación o un JWT: 
    - Crear un nuevo usuario y creación del respectivo JWT.
    - Login de un usuario existente.
    - Ping (```http://localhost:8080/ping```)
    - Actuator (```http://localhost:8080/actuator```)
- End-point con JWT requerido:
  - Listar todos los usuarios registrados en la base de datos
  - Obtener a un usuario específico vía UUID.
  - Listado de todas las categorias y unidades.
  - Listado de una categoría específica o una unidad específica (vía UUID).
  - Creación de categorías y unidades.
  - Listado de todos los productos registrados.
  - Obtención de un producto específico vía UUID.
  - Creación de un producto.
  - Eliminación de un producto
  - Actualización de un producto.


## Tecnologías usadas

- Java 17 (developed with 17.0.6-zulu)
- Spring Boot 3.3.0
- Gradle 8.8
- Flyway
- io.jsonwebtoken for JWT token creation
- Spring Security
- Api Docs (swagger)

Other libraries:

- Faker 1.0.2
- Lombok

## Instalación

Para instalar y ejecutar el proyecto se requiere lo siguiente:

1. Clonar este repositorio en tu máquina local

```bash
git clone git@github.com:aursog/agendapro-challenge.git
```

2. Navegar al directorio del proyecto.

```bash
cd agendapro-challenge
```

3. Si no tienes instalado **java** puedes instalarlo a través de _sdkman_

```bash
# To install sdkman
curl -s "https://get.sdkman.io" | bash

# To install java version
sdk install java 17.0.6-zulu
```

4. Ejecutar el siguiente comando para hacer **build** el proyecto:

```bash
./gradlew build
```

5. Una vez que el **build** ha ejecutado correctamente, correr el siguiente comando para ejecutar la aplicación:

```bash
./gradlew bootRun
```

Esto correrá la aplicación en el puerto **8080** y la aplicación quedará lista para ejecutar.

## Ejecución de test y test report

Para ejecutar los test unitarios, deberán ejecutar los siguientes comandos:

```bash
./gradlew test jacocoTestReport
```

Con este comando la aplicación correrá todos los test definidos y generará el test report y cobertura de test.

Para propositos de pruebas se han excluidos los siguientes paquetes:

```gradle
fileTree(dir: it,
        exclude: ["**/clients/*",
                "**/model/*",
                "**/dto/*",
                "**/repositories/*",
                "**/exceptions/*",
                "**/controller/*",
                "**/config/*"
        ]
)
```

La **task** ejecutará _jacoco_ para construir el reporte **html** que se puede encontrar en: **build/reports/test/index.html**

## Cómo usar

Para usar esta aplicación, lo más fácil es a través de los end-point de swagger:

```bash
http://localhost:8080/swagger-ui/index.html
```

Acá se podrá encontrar los diferentes end-points, incluidos la generación de end-point con uso de token. 

Acá esta la lista de end-point, objetivos y respuesta esperada (todos los end-point se ejecutan sobre: http://localhost:8080/):

| End-point        | Description                                                                                                                                                                    | Expected Response                                                                                                        |
|------------------|--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|--------------------------------------------------------------------------------------------------------------------------|
| /ping            | GET Ping controller                                                                                                                                                            | pong! (```String```)                                                                                                     |
| /auth/signin     | POST User creation and token generation. To create a new user, you need to send the information according to the defined object in the body of the request                     | JSON Object (uuid, createdAt, updatedAt, lastLogin, token, isActive)                                                     |
| /auth/login      | POST end-point to login in the system with the user credentials sended in the body request (email, password)                                                                   | JSON Object (uuid, createdAt, updatedAt, lastLogin, token, isActive)                                                     |
| /user            | GET List all the users in the database                                                                                                                                         | JSON Object (List<JsonObject(uuid, email, name, phones)>)                                                                |
| /user/{uuid}     | GET end-point to get information about an specific user defined by his UUID                                                                                                    | JSON Object (uuid, email, name, phones)                                                                                  |
| /category        | GET List all the categories registered on the database                                                                                                                         | List<JSON Object> (List<JsonObject(uuid, description)> )                                                                 |
| /category/{uuid} | GET a single category registered on the database                                                                                                                               | JSON Object (uuid, description)                                                                                          |
| /category        | POST create a new category on the system. Body request (JsonObject(description))                                                                                               | JSON Object (uuid, description)                                                                                          |
| /unidad          | GET List all the unidad registered on the database                                                                                                                             | List<JSON Object> (List<JsonObject(uuid, description)>)                                                                  |
| /unidad/{uuid}   | GET a single unidad on the database                                                                                                                                            | JSON Object (uuid, description)                                                                                          |
| /unidad          | POST create a new unidad on the system. Body request (JsonObject(description))                                                                                                 | JSON Object (uuid, description)                                                                                          |
| /producto        | GET List of all product recorded on the system                                                                                                                                 | List<JSON Object> (List<JsonObject(uuid, sku, descripcion, category, version, unidad, loteable, imagenUrl, comentario)>) |
| /producto/{uuid} | GET a single producto recorded on the system                                                                                                                                   | JSON Object (uuid, sku, descripcion, category, version, unidad, loteable, imagenUrl, comentario)                         |
| /producto        | POST create a new producto on the system. Body request (JsonObject(sku, descripcion, category<String>, version, unidad<String>, loteable, imagenUrl, comentario))              | JSON Object (uuid, sku, descripcion, category, version, unidad, loteable, imagenUrl, comentario)                         |
| /producto/{uuid} | PATCH Edit a single producto recorded on the database. Body request (JsonObject(sku, descripcion, category<String>, version, unidad<String>, loteable, imagenUrl, comentario)) | JSON Object (uuid, sku, descripcion, category, version, unidad, loteable, imagenUrl, comentario)                         |
| /producto/{uuid} | DELETE Delete a single producto recorded on the database.                                                                                                                      | success ```String```                                                                                                        | 
| /actuator/*      | GET actuator information: health, info, etc. This end-point is used to retrieve information about the application                                                              | JSON Object                                                                                                              |

Changelog

Changelog from git meeting

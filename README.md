# Java Backend Technical Test

This test is designed to assess your knowledge and skills in backend development.

## Description

The API is designed create and consulting users in a H2 in-memory database, with all the security aspects related. This API is 
build as a RESTFul API with JWT. 

## Features

- Create a user according to defined structure in document

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

- Data storage in a in-memory H2 database.
- End-points for the following features:
    - Create or **signin** a new user gettin the corresponding jwt.
    - Login an existing user.
    - Get an specific user through the UUID.
    - Get all the users registered in the database.
- Requires authentication via a JWT token to access the endpoints.

## Technologies used

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

## Instalation

To install and run this project do you need to do this:

1. Clone this repository to your local machine

```bash
git clone git@github.com:aursog/agendapro-challenge.git
```

2. Navigate to the project directory

```bash
cd agendapro-challenge
```

3. If you don't have installed java, you can install through _sdkman_

```bash
# To install sdkman
curl -s "https://get.sdkman.io" | bash

# To install java version
sdk install java 17.0.6-zulu
```

4. Run the following command to build the project:

```bash
./gradlew build
```

5. Once the build is successful, run the following command to start the application:

```bash
./gradlew bootRun
```

This will start the application on port **8080** and the application is ready to use

## Run test and coverage report

For execute the unit test, you need to run the following command:

```bash
./gradlew test jacocoTestReport
```

With this command the application run all the test defined on the code and generate the test report and the coverage.

For test propose I exclude the following packages:

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

The task execute jacoco to build a html report find in: **build/reports/test/index.html**

## How to use

For use this application, the easiest way to test is through the swagger end-point:

```bash
http://localhost:8080/swagger-ui/index.html
```

Here you can found the different end-points, included the generation token end-point, the salut controller and the rest of the end-points

Here is a list of end-points, goals and expected response (all the end-points run over http://localhost:8080/):

| End-point     | Description                                                                                                                                                | Expected Response                                                    |
|---------------|------------------------------------------------------------------------------------------------------------------------------------------------------------|----------------------------------------------------------------------|
| /ping         | GET Ping controller                                                                                                                                        | pong!                                                                |
| /auth/signin  | POST User creation and token generation. To create a new user, you need to send the information according to the defined object in the body of the request | JSON Object (uuid, createdAt, updatedAt, lastLogin, token, isActive) |
| /auth/login   | POST end-point to login in the system with the user credentials sended in the body request (email, password)                                               | JSON Object (uuid, createdAt, updatedAt, lastLogin, token, isActive) |
| /user         | GET List all the users in the database                                                                                                                     | JSON Object (List<JsonObject(uuid, email, name, phones)>)            |
| /user/${uuid} | GET end-point to get information about an specific user defined by his UUID                                                                                 | JSON Object (uuid, email, name, phones)                              |
| /actuator/*   | GET actuator information: health, info, etc. This end-point is used to retrieve information about the application                                          | JSON Object                                                          |

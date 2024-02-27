# YesteryearYonder

Yesteryear Yonder is a time travel management platform that seamlessly integrates different design patterns to build a robust and scalable system while maintaining modularity, separation of concerns, and reusability. The project is built using Java and Spring Boot, and also uses a PostgreSQL database to store the data and Docker to containerize the application. The project is built using the following design patterns: Strategy, Facade, and Decorator. In addition, Spring Boot handles both dependency injection and the Singleton pattern, as each Bean is a Singleton by default.

## Authors

- Juan Manuel Negro
- Princess Dela Paz

## Requirements

- Java 17 or above
- Maven
- Docker

## Execution

- To run the database, make sure you also have `Docker` installed.
- You can either use the `start_server.sh` script or manually start it with the following steps:
  - Build the project with `mvn clean package -DskipTests`.
  - Move the build project with `cp target/yesteryearyonder-0.0.1-SNAPSHOT.jar src/main/docker`.
  - Remove previous docker images with `docker rmi docker-spring-boot-postgres:latest`.
  - Start the server with `docker compose -f src/main/docker/docker-compose.yml up`.
  - To see the available endpoints and their usages, Swagger UI is set up at the `/swagger-ui/index.html` endpoint. For example, `http://localhost:8080/swagger-ui/index.html`.

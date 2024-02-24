#!/bin/bash

# Compile the server
./mvnw clean package -DskipTests
cp target/yesteryearyonder-0.0.1-SNAPSHOT.jar src/main/docker

# Build the docker image
cd src/main/docker
docker compose down
docker rmi docker-spring-boot-postgres:latest
docker compose up

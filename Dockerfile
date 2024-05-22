# Build stage
FROM gradle:7.5-jdk17 as build
WORKDIR /ApiRest-Spring-MySql-Docker
COPY . .
RUN gradle clean build -x test

# Run stage
FROM openjdk:17-jdk-slim
WORKDIR /ApiRest-Spring-MySql-Docker
COPY --from=build /ApiRest-Spring-MySql-Docker/build/libs/ApiRest.jar ApiRest.jar
EXPOSE 8080

ENTRYPOINT ["java", "-jar", "ApiRest.jar"]

LABEL authors="jpguevara"


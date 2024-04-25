# Stage 1: Build Spring Boot application
FROM maven:3.8.4-openjdk-17-slim AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests

# Stage 2: Create final image with PostgreSQL and Spring Boot application
FROM postgres:latest AS postgres
ENV POSTGRES_DB=webzy
ENV POSTGRES_USER=postgres
ENV POSTGRES_PASSWORD=root

FROM eclipse-temurin AS final
WORKDIR /app
COPY --from=build /app/target/*.jar testapp.jar
EXPOSE 2018
ENTRYPOINT ["java", "-jar", "testapp.jar"]

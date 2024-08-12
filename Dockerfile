
FROM eclipse-temurin:17.0.8.1_1-jdk-focal
WORKDIR /app

COPY target/gest-project-backend-0.0.1-SNAPSHOT.jar gest.jar
EXPOSE 8080

ENTRYPOINT ["java", "-jar", "gest.jar"]

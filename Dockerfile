FROM openjdk:22-ea-17-jdk-slim-bullseye

ARG JAR_FILE=target/*.jar

COPY ./target/task-management-system-0.0.1-SNAPSHOT.jar app.jar

ENTRYPOINT ["java", "-jar", "/app.jar"]
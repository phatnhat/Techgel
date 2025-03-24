FROM openjdk:17-jdk-alpine
WORKDIR /app
COPY target/techgel.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
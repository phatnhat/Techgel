# ----------- STAGE 1: Build the Spring Boot app -------------
FROM maven:3.9.4-eclipse-temurin-17 AS builder

# Set working directory
WORKDIR /app

# Copy project files
COPY . .

# Build the application
RUN mvn clean package -DskipTests


# ----------- STAGE 2: Run the built JAR ---------------------
FROM eclipse-temurin:17-jdk-alpine

# Set working directory
WORKDIR /app

# Copy the JAR from the build stage
COPY --from=builder /app/target/*.jar app.jar

# Expose port (optional for local use; Render auto-binds via PORT)
EXPOSE 8080

# Use dynamic port assignment from Render
ENV PORT=8080
ENTRYPOINT ["sh", "-c", "java -jar app.jar --server.port=${PORT}"]

# Step 1: Use an official Java runtime as a base image
FROM eclipse-temurin:17-jdk-alpine

# Step 2: Set the internal directory inside the container
WORKDIR /app

# Step 3: Copy your compiled Spring Boot JAR into the container
COPY build/libs/*SNAPSHOT.jar app.jar

# Step 4: Open port 8080 inside the container network
EXPOSE 8080

# Step 5: The exact command to start your Spring Boot app
ENTRYPOINT ["java", "-jar", "app.jar"]

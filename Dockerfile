# Use an official Java 17 runtime as the base image
FROM eclipse-temurin:17-jdk-jammy

# Set working directory inside the container
WORKDIR /app

# Copy Maven wrapper and pom.xml
COPY mvnw pom.xml ./
COPY .mvn .mvn

# Copy source code
COPY src src

# Make the Maven wrapper executable
RUN chmod +x mvnw

# Build the project
RUN ./mvnw clean package -DskipTests

# Expose the port your Spring Boot app will run on
EXPOSE 8080

# Set environment variable for dynamic port (Render sets PORT automatically)
ENV SERVER_PORT=${PORT:-8080}

# Run the app
CMD ["java", "-jar", "target/demo-0.0.1-SNAPSHOT.jar"]
# Use OpenJDK 17 slim
FROM openjdk:23-jdk-slim

# Set working directory
WORKDIR /app

# Copy the built JAR file
COPY target/EurekaServer-0.0.1-SNAPSHOT.jar /app/app.jar

# Expose Eureka Server port
EXPOSE 8761

# Run the Eureka server
ENTRYPOINT ["java", "-jar", "/app/app.jar"]

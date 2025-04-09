# Use OpenJDK 23 slim as the base image
FROM openjdk:23-jdk-slim
# Install git and wget
RUN apt-get update && apt-get install -y git curl && rm -rf /var/lib/apt/lists/*
# Set working directory
WORKDIR /app
# Copy the built JAR file
COPY target/ConfigServer-0.0.1-SNAPSHOT.jar /app/app.jar
# Expose the Config Server port
EXPOSE 8888

# Run the Config Server
ENTRYPOINT ["java", "-jar", "/app/app.jar"]
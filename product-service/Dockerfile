# Use OpenJDK 23 slim
FROM openjdk:23-jdk-slim

# Set working directory
WORKDIR /app

# Copy the built JAR file
COPY target/product-service-0.0.1-SNAPSHOT.jar /app/app.jar

# Expose the API Gateway port
EXPOSE 8082

# Run the API Gateway
ENTRYPOINT ["java", "-jar", "/app/app.jar"]

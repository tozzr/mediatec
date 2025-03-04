# Use OpenJDK as base image
FROM openjdk:17-jdk

# Set working directory
WORKDIR /app

# Copy built application
COPY target/*.jar app.jar

# Expose port
EXPOSE 8080

# Run application
ENTRYPOINT ["java", "-jar", "app.jar"]

# Use the Eclipse Temurin JDK 21 image as the base image
FROM eclipse-temurin:21-jre

# Set the maintainer label
LABEL maintainer="nonokub.671@gmail.com"

# Set the working directory inside the container
WORKDIR /app

# Copy the JAR file into the container
COPY target/search-service.jar /app/search-service.jar

# Copy the application.properties file into the container
COPY src/main/resources/application.properties /app/config/application.properties

# Expose the application's port
EXPOSE 8081

# Set the default command to run the application
ENTRYPOINT ["java", "-jar", "/app/search-service.jar", "--spring.config.location=file:/app/config/application.properties"]

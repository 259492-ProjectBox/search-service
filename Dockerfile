# Use the Eclipse Temurin JDK 21 image as the base image
FROM eclipse-temurin:21-jdk

# Set the maintainer label
LABEL maintainer="nonokub.671@gmail.com"

# Set the working directory inside the container
WORKDIR /app

# Create the /app/config directory
RUN mkdir -p /app/config

# Copy the JAR file into the container
COPY target/search-service.jar /app/search-service.jar

# Copy the application-prod.properties file into the container
COPY src/main/resources/application-prod.properties /app/config/application-prod.properties

# Expose the application's port
EXPOSE 8081

# Set the default command to run the application
ENTRYPOINT ["java", "-jar", "/app/search-service.jar", "--spring.config.location=/app/config/application-prod.properties"]

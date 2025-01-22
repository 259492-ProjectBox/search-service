# Build stage
FROM maven:3.9-eclipse-temurin-21 AS build

# Set the working directory for the build
WORKDIR /app

# Copy pom.xml and source code
COPY pom.xml /app/
COPY src /app/src/

# Run Maven to build the JAR file
RUN mvn clean package -DskipTests

# Production stage
FROM eclipse-temurin:21-jdk AS production


# Set the maintainer label
LABEL maintainer="nonokub.671@gmail.com"


# Set the working directory for the runtime
WORKDIR /app

# Create the /app/config directory
RUN mkdir -p /app/config

# Copy the JAR file from the build stage
COPY --from=build /app/target/search-service.jar /app/search-service.jar

# Copy the application-prod.properties file
COPY src/main/resources/application-prod.properties /app/config/application-prod.properties

# Expose the application's port
EXPOSE 8081

# Set the default command to run the application
ENTRYPOINT ["java", "-jar", "/app/search-service.jar", "--spring.config.location=/app/config/application-prod.properties"]

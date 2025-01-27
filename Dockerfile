# Build Stage
FROM maven:3.9-eclipse-temurin-21 AS build

# Set the working directory for the build
WORKDIR /app

# Copy Maven configuration and source code
COPY pom.xml /app/
COPY src /app/src/

# Run Maven to build the JAR file
# RUN mvn clean package -DskipTests

# Run Maven to build the JAR file, completely skipping tests and test compilation
RUN mvn clean package -Dmaven.test.skip=true

# Production Stage
FROM eclipse-temurin:21-jdk AS production

# Set the maintainer label
LABEL maintainer="nonokub.671@gmail.com"

# Set the working directory for the runtime
WORKDIR /app

# Create a directory for configuration files
RUN mkdir -p /app/config

# Copy the compiled JAR file from the build stage
COPY --from=build /app/target/search-service.jar /app/search-service.jar

# Copy production configuration file
COPY src/main/resources/application-prod.properties /app/config/application-prod.properties

# Expose the application's port
EXPOSE 8081

# Default command to run the application
ENTRYPOINT ["java", "-jar", "/app/search-service.jar", "--spring.config.location=/app/config/application-prod.properties"]

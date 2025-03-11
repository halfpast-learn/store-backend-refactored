FROM gradle:8.6-jdk21 AS build
WORKDIR /app

# Copy gradle configuration
COPY settings.gradle .
COPY gradle ./gradle
COPY gradlew .

# Copy common module
COPY common/ ./common/

# Copy project files
COPY opinionservice/build.gradle ./opinionservice/
COPY opinionservice/src ./opinionservice/src/

# Build the application
RUN gradle opinionservice:bootJar --no-daemon

# Runtime stage
FROM eclipse-temurin:21-jdk
WORKDIR /app

# Copy the built jar file
COPY --from=build /app/opinionservice/build/libs/*.jar app.jar

# Set environment variables
ENV SPRING_DATASOURCE_URL=jdbc:postgresql://postgres-opinion:5432/opinion_db
ENV SPRING_DATASOURCE_USERNAME=postgres
ENV SPRING_DATASOURCE_PASSWORD=admin

EXPOSE 8082
ENTRYPOINT ["java", "-jar", "app.jar"] 
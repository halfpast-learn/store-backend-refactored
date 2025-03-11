FROM gradle:8.6-jdk21 AS build
WORKDIR /app

# Copy gradle configuration
COPY settings.gradle .
COPY gradle ./gradle
COPY gradlew .

# Copy common module
COPY common/ ./common/

# Copy project files
COPY tagservice/build.gradle ./tagservice/
COPY tagservice/src ./tagservice/src/

# Build the application
RUN gradle tagservice:bootJar --no-daemon

# Runtime stage
FROM eclipse-temurin:21-jdk
WORKDIR /app

# Copy the built jar file
COPY --from=build /app/tagservice/build/libs/*.jar app.jar

# Set environment variables
ENV SPRING_DATASOURCE_URL=jdbc:postgresql://postgres-tag:5432/tag_db
ENV SPRING_DATASOURCE_USERNAME=postgres
ENV SPRING_DATASOURCE_PASSWORD=admin

EXPOSE 8085
ENTRYPOINT ["java", "-jar", "app.jar"] 
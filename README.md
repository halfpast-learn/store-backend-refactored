# 🛍️ Store Backend Microservices

A robust e-commerce backend built with Spring Boot microservices, providing a complete solution for managing products, orders, and user preferences.

## 🛠️ Technical Stack

- **Framework**: Spring Boot
- **Database**: PostgreSQL
- **Security**: Spring Security
- **API**: RESTful
- **Build Tool**: Gradle
- **Documentation**: SpringDoc/OpenAPI
- **Containerization**: Docker & Docker Compose

## 🚀 Features

### User Management Service
- User authentication and registration
- Secure password encryption
- User profile management
- Order history tracking

### Item Service
- Complete CRUD operations for products
- Integration with tag system
- Product filtering by tags
- Detailed product information management

### Tag Service
- Dynamic product categorization
- Tag management (CRUD operations)
- Item-tag relationship handling
- Tag-based item filtering

### Order Service
- Order creation and tracking
- Order status management
- Order history retrieval

### Preference Service
- User preference management
- Tag-based preference system
- Role-based configurations

## 🏗️ Architecture

The application follows a microservices architecture with:
- Independent services for specific business domains
- RESTful communication between services
- Clean separation of concerns
- DTO pattern for data transfer
- Repository pattern for data access
- Mapper implementations for entity-DTO conversion

## 🔌 Services

### User Management Service
- User authentication and account management
- Password encryption and validation
- User profile operations

### Item Service
- Product management
- Integration with tag system
- Product search and filtering

### Tag Service
- Tag management
- Product categorization
- Tag-based filtering

### Order Service
- Order processing
- Order status tracking
- Order history

### Preference Service
- User preferences
- Role-based configurations
- Tag associations

## 🔒 Security Features

- Password encryption using Spring Security
- Entity-level validation
- Exception handling
- Transactional operations

## 🚀 Getting Started

You can run this application using Docker (recommended) or directly with Gradle. Choose the approach that best fits your needs.

### Prerequisites

- Docker & Docker Compose (for containerized approach)
- Java 21 or higher (for Gradle approach)
- Gradle (for Gradle approach)
- PostgreSQL (for Gradle approach)

### Option 1: Running with Docker (Recommended)

The easiest way to run the complete application with all services:

1. Clone the repository
   ```bash
   git clone <repository-url>
   cd store-backend-java
   ```

2. Start all services:
   ```bash
   docker-compose up -d
   ```
   This builds and starts all microservices with their dedicated databases.

3. Access services at their respective ports (8080-8086)

To stop all services:
```bash
docker-compose down
```

### Option 2: Running with Gradle

1. Clone the repository
   ```bash
   git clone <repository-url>
   cd store-backend-java
   ```

2. Configure separate databases for each service (e.g., item_db, image_db, etc.)

3. Build the services:
   ```bash
   ./gradlew build
   ```

4. Run each service:
   ```bash
   ./gradlew :<service-name>:bootRun
   ```

## 📦 Service Configuration

### Docker Setup
When using Docker, the configuration is handled through environment variables in docker-compose.yml and .env file. Each service has its own dedicated PostgreSQL database with unique ports (5432-5438).

### Gradle Setup
Each service has its own configuration properties in `application.properties/yaml` including database connections, server ports, and service-specific settings.

## 📝 API Documentation

Each service exposes its own REST API endpoints. Access the OpenAPI documentation at:
```
http://<service-host>:<port>/swagger-ui.html
```

For example:
- Item Service: http://localhost:8080/swagger-ui.html
- Image Service: http://localhost:8081/swagger-ui.html
- Opinion Service: http://localhost:8082/swagger-ui.html

## 🔧 Environment Variables

When using Docker, you can configure the services by modifying the `.env` file with:
- Database credentials
- Service ports
- Other service-specific settings

## 🔍 Monitoring & Logs

### Docker Setup
Monitor logs using Docker commands:
```bash
docker-compose logs                   # All services
docker-compose logs <service-name>    # Specific service
docker-compose logs -f <service-name> # Follow logs
```

### Gradle Setup
When running with Gradle, logs will be available in the console and log files.

## 📦 Service Dependencies

- Docker & Docker Compose (for containerized deployment)
- Java 21 or higher
- Gradle
- PostgreSQL

Built with ❤️ using Spring Boot
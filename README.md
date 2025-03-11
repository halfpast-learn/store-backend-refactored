# 🛍️ Store Backend Microservices

A robust e-commerce backend built with Spring Boot microservices, providing a complete solution for managing products, orders, and user preferences.

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

## 🛠️ Technical Stack

- **Framework**: Spring Boot
- **Database**: PostgreSQL
- **Security**: Spring Security
- **API**: RESTful
- **Build Tool**: Gradle
- **Documentation**: SpringDoc/OpenAPI

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

1. Clone the repository
2. Configure PostgreSQL database for each service
3. Update application.properties/yaml files with appropriate configurations
4. Build the services:
   ```bash
   ./gradlew build
   ```
5. Run each service:
   ```bash
   java -jar <service-name>.jar
   ```

## 📝 API Documentation

Each service exposes its own REST API endpoints. Access the OpenAPI documentation at:
```
http://<service-host>:<port>/swagger-ui.html
```

## 🔧 Configuration

Each service has its own configuration properties in `application.properties/yaml` including:
- Database connections
- Server ports
- Service-specific settings

## 📦 Service Dependencies

- Java 21 or higher
- Gradle
- PostgreSQL

Built with ❤️ using Spring Boot
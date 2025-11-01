# JavaEE Example Project

A comprehensive JavaEE 7 web application demonstrating best practices and common patterns for enterprise Java development.

## Overview

This project showcases a modern JavaEE 7 application with RESTful web services, JPA persistence, custom validation, and comprehensive logging. It's designed as a learning resource and reference implementation for building enterprise Java web applications.

## Features

- **RESTful API**: JAX-RS based REST endpoints for user management
- **JPA/EclipseLink**: Entity persistence with JPA 2.1 and EclipseLink
- **Bean Validation**: Custom validators including cross-field validation
- **CDI**: Dependency injection with Context and Dependency Injection
- **Logging**: Structured logging with Log4j2
- **Lombok**: Reduced boilerplate with Lombok annotations
- **Custom Annotations**: Reusable aspects like @TimeLog and @ErrorLog
- **Access Logging**: HTTP request/response logging filter

## Technologies

- Java 8
- JavaEE 7 (Web Profile)
- Maven 3.6+
- JPA 2.1 (EclipseLink 2.5)
- JAX-RS 2.0
- CDI 1.1
- Bean Validation 1.1
- Log4j2 2.0
- Lombok 1.18.30
- JUnit 4.11

## Project Structure

```
src/main/java/
├── pascal/orz/cn/example/javaee/
    ├── apps/
    │   ├── model/          # JPA entities and DAOs
    │   └── resources/      # REST API endpoints
    └── commons/
        ├── annotations/    # Custom annotations
        ├── filters/        # Servlet filters
        ├── utils/          # Utility classes
        └── validators/     # Custom validators
```

## Getting Started

### Prerequisites

- JDK 8 or higher
- Maven 3.6+
- A JavaEE 7 compatible application server (e.g., GlassFish 4.0+, WildFly 8+, Payara 4+)

### Building the Project

```bash
mvn clean compile
```

### Running Tests

```bash
mvn test
```

### Packaging

```bash
mvn package
```

This creates a WAR file in the `target/` directory that can be deployed to any JavaEE 7 compatible server.

## API Endpoints

### Users API

- `GET /api/users` - List all users
- `POST /api/users` - Create a new user

Example request:
```json
{
  "firstName": "John",
  "lastName": "Doe",
  "age": 30
}
```

## Custom Validators

### @FirstOrLastRequired

A cross-field validator ensuring that either firstName or lastName is provided:

```java
@FirstOrLastRequired
public class Users {
    private String firstName;
    private String lastName;
    // ...
}
```

## Configuration

- `src/main/resources/META-INF/persistence.xml` - JPA configuration
- `src/main/resources/log4j2.xml` - Logging configuration
- `src/main/webapp/WEB-INF/web.xml` - Web application configuration

## Author

koduki

## Contributing

Contributions are welcome! Please feel free to submit a Pull Request.

## License

This project is licensed under the MIT License - see the LICENSE file for details.

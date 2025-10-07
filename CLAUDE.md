Core Development Philosophy
KISS (Keep It Simple, Stupid)

Favor simplicity in Spring Beans, controllers, services, and repositories. Simple code is easier to understand, maintain, and debug.

YAGNI (You Aren't Gonna Need It)

Implement only what is required. Avoid adding configuration, beans, or services speculatively.

Design Principles

Dependency Injection: Use Spring’s @Autowired or Lombok @RequiredArgsConstructor.

Open/Closed: Extend services via inheritance or interfaces, but avoid modifying stable code.

Single Responsibility: Each class or method should do one thing.

Fail Fast: Use Spring validations, exception handling, and preconditions early.

🧱 Project Structure & Modularity
src/main/java/com/project/
Application.java
config/
SecurityConfig.java
DatabaseConfig.java
common/
exceptions/
utils/
features/
user/
controller/UserController.java
service/UserService.java
dto/UserDTO.java
repository/UserRepository.java
payment/
...
src/test/java/com/project/features/user/
UserServiceTest.java
src/main/resources/
application.properties
application-dev.properties
application-prod.properties


Rules:

Classes ≤ 100 lines

Methods ≤ 50 lines

DTOs with Lombok (@Data, @Builder, etc.)

Tests next to code

⚙️ Development Environment
IntelliJ Setup

Java SDK 17+

Lombok plugin installed

Enable Annotation Processing

Maven/Gradle for dependency management

Lombok Usage

DTOs/Entities: @Data, @Builder, @NoArgsConstructor, @AllArgsConstructor

Logging: @Slf4j

Immutable objects: @Value

Constructor injection: @RequiredArgsConstructor

🔧 Application Properties & Spring Profiles
Default application.properties
spring.profiles.active=dev
server.port=8080
server.servlet.context-path=/api/v1

spring.datasource.url=${DB_URL:jdbc:mysql://localhost:3306/mydb}
spring.datasource.username=${DB_USER:root}
spring.datasource.password=${DB_PASS:password}
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=false
spring.jpa.properties.hibernate.format_sql=true

logging.level.root=INFO
logging.level.com.project=DEBUG
logging.file.name=logs/project.log

Profile-specific properties

application-dev.properties → development

application-prod.properties → production

application-test.properties → testing

Use environment variables for secrets: DB_USER, DB_PASS, API_KEYS.

🧩 Spring Boot Best Practices

Controllers are thin → delegate logic to services.

Services handle business logic and call repositories.

DTOs used for all external API communication.

Repositories use Spring Data JPA with entity-specific IDs.

Use @Valid and @NotNull for input validation.

Separate configuration via Spring Profiles.

🧪 Testing Strategy

Use JUnit 5 + Mockito.

@SpringBootTest for integration tests.

@DataJpaTest for repository tests.

DTOs in tests can leverage Lombok @Builder.

🚨 Error Handling & Logging

Use custom exceptions for domain logic.

Use @ControllerAdvice for global error handling.

Use @Slf4j for structured logging.

🔒 Security Guidelines

Passwords: BCryptPasswordEncoder

Validate all inputs via DTOs

Use Spring Security for authentication/authorization

Keep secrets in environment variables

🚀 Performance Considerations

Profile before optimizing.

Use caching for expensive queries.

Use @Async for I/O-bound operations.

Expose metrics with Spring Boot Actuator.

Monitor via Micrometer + Prometheus/Grafana.

🏗️ Git Workflow

Branches: main ← develop ← feature/*

Commit messages:

feat(user): add Lombok DTOs and UserService
fix(payment): correct transaction rollback


Always run tests before merging.

📚 Documentation Standards

Public classes and methods must have JavaDoc.

Complex logic should have inline comments with // Reason: ...

Maintain README.md and CHANGELOG.md.

🔍 Debugging & Tooling

Debug in IntelliJ with breakpoints (Shift+F9)

Use Lombok-generated getters/setters directly

Spring Boot DevTools for hot reload

Memory/CPU profiling via VisualVM

✅ Ready-to-use Template

This guide assumes the following pattern:

Application.java → main entry

Controller → Service → Repository pattern

Lombok DTOs & Entities

Profile-based properties

JUnit 5 tests

Structured logging
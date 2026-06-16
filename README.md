Employee Management System

A Spring Boot RESTful API for managing employees with advanced database relationships, dynamic filtering, pagination, auditing, and clean architecture.

Tech Stack
Java 17+
Spring Boot
Spring Data JPA
Hibernate
MySQL
MapStruct
Lombok
Bean Validation (Jakarta Validation)
Architecture

The project follows Layered Architecture:

Controller Layer
    ↓
Service Layer
    ↓
Repository Layer
    ↓
Database

With additional layers:

DTO Layer
Mapper Layer (MapStruct)
Exception Handling Layer
Specification Layer (Dynamic Query)
Auditing & Soft Delete Layer
Features
Employee Management
Create / Update / Delete employees
Get employee by ID
Search employees dynamically
Relationships
One-to-One → Employee ↔ Profile
One-to-Many → Department → Employees
One-to-Many → Employee → Salary History
Many-to-Many → Employee ↔ Skills
Many-to-Many → Employee ↔ Projects
Advanced Querying
JPQL Queries
Native Queries
Dynamic Filtering (Specifications)
Query Methods
Pagination & Sorting
Pageable support
Sorting by salary, name, etc.
Optimized API responses
Performance Optimization
JOIN FETCH (Solving N+1 Problem)
DTO Projection
Lazy Loading Control
Auditing
createdAt
updatedAt
Automatic timestamp tracking
Soft Delete
Logical deletion instead of physical delete
Data retention for history tracking
DTO & Mapping
Request/Response DTOs
MapStruct for automatic mapping
Clean API response structure
Global Exception Handling
Centralized error handling
Custom exceptions
Validation error handling
 PI Response Format
{
  "success": true,
  "message": "Operation successful",
  "data": {}
}
API Features
RESTful endpoints
Clean request validation
Structured responses
Search with multiple filters
Pagination + Sorting support
🗂 Project Structure
com.abdullah
│
├── controller
├── service
│   ├── impl
├── repository
├── entity
├── dto
├── mapper
├── specification
├── exception
├── response
└── config
Example API Endpoints
Employees
GET    /api/employees
POST   /api/employees
GET    /api/employees/{id}
DELETE /api/employees/{id}
Search & Filters
POST /api/employees/search
GET  /api/query/dept?dept=IT
GET  /api/query/gender?gender=MALE
GET  /api/query/avg
GET  /api/query/max
Pagination
GET /api/employees/page?page=0&size=5
GET /api/employees/sorted?page=0&size=5
Key Concepts Implemented
Spring Data JPA Advanced Queries
JPQL & Native SQL
Dynamic Query (Specification Pattern)
REST API Best Practices
Clean Code Architecture
Soft Delete Strategy
Audit Logging
DTO Mapping Strategy
Performance Optimization
Sample Request (Search API)
{
  "department": "IT",
  "gender": "MALE",
  "status": "ACTIVE",
  "minSalary": 10000,
  "maxSalary": 30000
}
 How to Run
git clone https://github.com/your-username/employee-management-system.git

cd employee-management-system

mvn clean install

mvn spring-boot:run
 Future Improvements
Spring Security + JWT Authentication
Role-Based Access Control (RBAC)
Redis Caching
Docker Deployment
Microservices Migration
 Author

Abdullah Shams


# 🚀 Employee Management System (RESTful API)

A production-ready **Spring Boot RESTful API** for managing employees, featuring advanced database relationships, dynamic filtering, pagination, auditing, and clean architectural patterns.

---

## 🛠️ Tech Stack

* **Language:** Java 17+
* **Framework:** Spring Boot
* **Persistence:** Spring Data JPA, Hibernate, MySQL
* **Object Mapping:** MapStruct, Lombok
* **Validation:** Jakarta Bean Validation

---

## 📐 Architecture

The project follows a strict Layered Architecture with separated concerns to ensure scalability and maintainability:


Controller Layer ──> Service Layer ──> Repository Layer ──> Database

### Additional Layers & Component Breakdown

* **DTO Layer:** Decouples the API presentation layer from the database entities.
* **Mapper Layer (MapStruct):** Handles type-safe, high-performance object mappings.
* **Exception Handling Layer:** Centralized global error handling.
* **Specification Layer:** Implements the Specification Pattern for dynamic queries.
* **Auditing & Soft Delete:** Intercepts database changes for automated tracking and logical deletion.

---

## ✨ Core Features

### 👥 Employee Management

* Full CRUD operations (Create, Read, Update, Delete).
* Advanced multi-conditional search and dynamic filtering.

### 🔗 Advanced Database Relationships

* **One-to-One:** `Employee` ↔ `Profile`
* **One-to-Many:** `Department` ➔ `Employees`
* **One-to-Many:** `Employee` ➔ `Salary History`
* **Many-to-Many:** `Employee` ↔ `Skills`
* **Many-to-Many:** `Employee` ↔ `Projects`

### 🔍 Advanced Querying & Optimization

* Custom **JPQL** and **Native SQL** queries.
* Dynamic filtering using **JPA Specification Pattern**.
* Performance tuning: Solved the **N+1 Problem** using `JOIN FETCH` and optimized fetch strategies via DTO Projections and Lazy Loading controls.

### 📊 Pagination & Sorting

* Full `Pageable` support across list endpoints.
* Sorting dynamic capabilities (e.g., sort by salary, name, creation date).

### 🛡️ Auditing & Soft Delete

* Automated tracking for `createdAt` and `updatedAt` timestamps.
* **Soft Delete:** Logical deletion instead of physical row removal to retain data history.

---

## 🗂️ Project Structure

```text
com.abdullah
│
├── controller      # REST Controllers (API Endpoints)
├── service         # Business Logic Interfaces
│   └── impl        # Service Implementation Classes
├── repository      # Spring Data JPA Repositories
├── entity          # Database Models / JPA Entities
├── dto             # Data Transfer Objects (Requests/Responses)
├── mapper          # MapStruct Mappers
├── specification   # JPA Criteria API Dynamic Filters
├── exception       # Global Exception Handler & Custom Exceptions
├── response        # Standardized API Response Wrapper
└── config          # Configuration classes (JPA Auditing, Beans, etc.)

```

---

## 🌐 API Endpoints

### 📝 Common Response Format

All API responses follow a uniform, predictable structure:

```json
{
  "success": true,
  "message": "Operation successful",
  "data": {}
}

```

### 🛣️ Endpoints Overview

| Method | Endpoint | Description |
| --- | --- | --- |
| **GET** | `/api/employees` | Fetch all employees |
| **POST** | `/api/employees` | Create a new employee |
| **GET** | `/api/employees/{id}` | Get employee details by ID |
| **DELETE** | `/api/employees/{id}` | Soft delete an employee |
| **POST** | `/api/employees/search` | Search employees with dynamic filters |
| **GET** | `/api/query/dept?dept=IT` | Filter employees by department name |
| **GET** | `/api/query/gender?gender=MALE` | Filter employees by gender |
| **GET** | `/api/query/avg` | Get average salary of employees |
| **GET** | `/api/query/max` | Get maximum salary details |
| **GET** | `/api/employees/page?page=0&size=5` | Paginated employee list |
| **GET** | `/api/employees/sorted?page=0&size=5` | Paginated & Sorted employee list |

### 🔍 Sample Request Body (`POST /api/employees/search`)

```json
{
  "department": "IT",
  "gender": "MALE",
  "status": "ACTIVE",
  "minSalary": 10000,
  "maxSalary": 30000
}

```

---

## 🚀 How to Run

Follow these steps to get the project up and running locally:

1. **Clone the repository:**
```bash
git clone [https://github.com/your-username/employee-management-system.git](https://github.com/your-username/employee-management-system.git)
cd employee-management-system

```


2. **Configure Database:**
Update your MySQL credentials in `src/main/resources/application.properties`.
3. **Build the project:**
```bash
mvn clean install

```


4. **Run the application:**
```bash
mvn spring-boot:run

```



---

## 🔮 Future Improvements

* [ ] Implement **Spring Security + JWT Authentication**
* [ ] Introduce **Role-Based Access Control (RBAC)**
* [ ] Integrate **Redis Caching** for optimized query performance
* [ ] Containerization with **Docker Deployment**
* [ ] Migration towards a **Microservices Architecture**

---

## 👤 Author

* **Abdullah Shams** - *Backend Engineer*

```

```

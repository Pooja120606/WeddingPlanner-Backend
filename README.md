# 💍 Wedding Planner Management System - Backend

A Spring Boot based backend application for managing wedding planning services.

This project provides secure REST APIs for managing users, vendors, wedding packages, bookings, authentication, and administrative operations.

The backend follows the MVC architecture and uses JWT-based authentication for secure access.

## ✨ Features

- User Registration & Login
- JWT Authentication & Authorization
- Role-based Access (Admin & User)
- Vendor Management
- Wedding Package Management
- Booking Management
- Dashboard & Reports
- RESTful APIs
- MySQL Database Integration

## 🛠️ Tech Stack

### Backend
- Java 21
- Spring Boot
- Spring MVC
- Spring Security
- Spring Data JPA
- Hibernate

### Database
- MySQL

### Authentication
- JWT (JSON Web Token)

### Build Tool
- Maven

### Version Control
- Git & GitHub

### IDE
- Visual Studio Code

## 📂 Project Structure

```text
src
├── main
│   ├── java
│   │   └── com
│   │       └── wedding
│   │           └── weddingplanner
│   │               ├── controller
│   │               ├── dto
│   │               ├── enums
│   │               ├── model
│   │               ├── repository
│   │               ├── security
│   │               ├── service
│   │               └── WeddingplannerApplication.java
│   └── resources
│       ├── static
│       ├── templates
│       └── application.properties
└── test
```

## 🏗️ System Architecture

```text
                    React Frontend
                          │
                          │ REST API (HTTP)
                          ▼
               Spring Boot Controllers
                          │
                          ▼
                   Service Layer
                          │
                          ▼
                 Repository Layer
                          │
                          ▼
                    MySQL Database
```

### Architecture Flow

1. The user interacts with the React frontend.
2. The frontend sends HTTP requests to the Spring Boot REST APIs.
3. Controllers receive and validate requests.
4. The Service layer contains the business logic.
5. The Repository layer communicates with the MySQL database using Spring Data JPA.
6. JWT Authentication secures protected API endpoints.

## 📡 REST API Modules

| Module | Description |
|--------|-------------|
| Authentication | User registration and login using JWT |
| Users | Manage user information |
| Vendors | Add, update, delete, and view vendors |
| Wedding Packages | Manage wedding packages |
| Bookings | Create, view, confirm, and cancel bookings |
| Dashboard | View dashboard statistics |
| Reports | Generate application reports |

### HTTP Methods Used

- GET – Retrieve data
- POST – Create new records
- PUT – Update existing records
- DELETE – Remove records

## 🔐 Security Features

- JWT (JSON Web Token) based authentication
- Role-Based Authorization (Admin, Vendor, User)
- Protected REST API endpoints using Spring Security
- Password encryption for secure user authentication
- Secure API access using Authorization Bearer Token

## ⚙ Local Development Setup

## Prerequisites
 - Java 21
 - Maven
 - MySQL
 - IntelliJ IDEA
 - Postman

## Clone

git clone https://github.com/Pooja120606/WeddingPlanner-Backend.git

## Database

CREATE DATABASE weddingplanner;

## Configure

application.properties

spring.datasource.url=
spring.datasource.username=
spring.datasource.password=

jwt.secret=

## Run

mvn spring-boot:run

Runs on

http://localhost:8080

## 🗄️ Database Design

The application uses **MySQL** as the relational database.

### Main Tables

| Table | Purpose |
|--------|---------|
| User | Stores user information and roles |
| Vendor | Stores vendor details and services |
| WeddingPackage | Stores wedding package information |
| Booking | Stores booking details and booking status |

The backend uses **Spring Data JPA** and **Hibernate** for database operations.

## 🚀 Future Enhancements

- 💳 Online Payment Gateway Integration
- 📧 Email Notifications
- 📱 SMS Notifications
- ⭐ Vendor Ratings & Reviews
- 🤖 AI-based Wedding Package Recommendations
- 💬 Live Chat Support
- 📅 Calendar & Event Scheduling
- ☁️ Cloud Deployment (AWS/Azure)

## 👩‍💻 Author

**Pooja Enugandula**

- 🎓 B.Sc. Information Technology
- 💼 Aspiring Java Backend Developer
- 🔗 LinkedIn: https://www.linkedin.com/in/pooja-enugandula/
- 💻 GitHub: https://github.com/Pooja120606

---

⭐ If you like this project, consider giving it a star!

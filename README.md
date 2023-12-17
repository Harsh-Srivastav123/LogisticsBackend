# Liveasy Logistics Backend

## Project Overview

The Liveasy Logistics Backend is a Spring Boot application built using Java, Spring MVC, JPA Hibernate, and PostgreSQL. The primary focus of this backend application is to facilitate CRUD operations on Loads, allowing users to manage and filter loads based on loading point, unloading point, product type, and total weight. Additionally, the application provides user profile management, enabling users to track their previous loads, filter by total weight, and save profile pictures to Cloudinary database.

### Features

1. **Load Management:** Perform CRUD operations on loads and filter them by loading point, unloading point, and product type.
2. **Topic Filtering:** Efficiently filter loads based on various criteria, including loading point, unloading point, and total weight.
3. **User Profile Management:** Create and manage user profiles, track previous loads, and filter by total weight. Allow users to save profile pictures to Cloudinary database.

## Technology Used

- Java
- Spring Boot
- Spring MVC
- JPA Hibernate
- PostgreSQL (Database)
- SQL Queries
- Swagger API Docs
- Thymeleaf (for user interface)
- Cloudinary API (for profile image management)

## Getting Started

### Prerequisites

Before you begin, make sure you have the following installed:

1. **Java Development Kit (JDK):** [Download JDK](https://www.oracle.com/java/technologies/javase-downloads.html)
2. **PostgreSQL Database:** [Download MySQL](https://www.postgresql.org/download/)
3. **Apache Maven:** [Download Apache Maven](https://maven.apache.org/download.cgi)
4. **Cloudinary API Key and Secret:** Obtain API Key and Secret from [Cloudinary](https://cloudinary.com/)

### Installations

1. **Clone the Repository:**
   ```bash
   https://github.com/Harsh-Srivastav123/LogisticsBackend.git

2. **Configure Database & Application properties **
   ```bash
   spring.datasource.url=#url
   spring.datasource.username=#username
   spring.datasource.password=#password
   spring.jpa.hibernate.ddl-auto=update
   spring.jpa.generate-ddl=true
   spring.main.allow-circular-references=true
   spring.jpa.show.sql=true
   spring.jpa.format.sql=true
   spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
   spring.servlet.multipart.max-file-size=10MB
   spring.servlet.multipart.max-request-size=10MB
3. Configure Cloudinary Configuration
   ```shell
     config.put("cloud_name","");
     config.put("api_key","");
     config.put("api_secret","");
     config.put("sceure",true);

### Swagger API Documentation
QuizApp provides Swagger for easy API documentation and testing. You can access the Swagger UI to interact with the APIs as follows:
 ```shell
   http://localhost:8080/swagger-ui.html


Feel free to explore the API documentation for detailed information on available endpoints and operations.

Now you're ready to run and explore the Liveasy Logistics Backend!

Copy code

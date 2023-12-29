# Liveasy Logistics Backend

## Project Overview

The Liveasy Logistics Backend is a robust Spring Boot application developed using Java, Spring MVC, JPA Hibernate, and PostgreSQL. It serves as the backbone for managing loads, user profiles, and related functionalities. The application is deployed on AWS (Elastic Beanstalk) with a PostgreSQL database, ensuring scalability and reliability.

### Features

1. **Load Management:** Execute CRUD operations on loads, enabling users to efficiently handle and organize their logistics data. Filter loads based on loading point, unloading point, and product type.

2. **Topic Filtering:** Employ advanced filtering options to streamline load searches. Users can filter loads based on loading point, unloading point, and total weight, enhancing the precision of search results.

3. **User Profile Management:** Seamlessly create and manage user profiles, allowing users to track previous loads and apply filters based on total weight. Additionally, users can save profile pictures to Cloudinary for a personalized experience.

4. **Deployment on AWS:** The application is deployed on AWS Elastic Beanstalk, ensuring high availability and reliability. The PostgreSQL database is also hosted on AWS to provide a complete and scalable solution.

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
- AWS (Elastic Beanstalk)

## Getting Started

### Prerequisites

Before getting started, ensure you have the following installed:

1. **Java Development Kit (JDK):** [Download JDK](https://www.oracle.com/java/technologies/javase-downloads.html)
2. **PostgreSQL Database:** [Download PostgreSQL](https://www.postgresql.org/download/)
3. **Apache Maven:** [Download Apache Maven](https://maven.apache.org/download.cgi)
4. **Cloudinary API Key and Secret:** Obtain API Key and Secret from [Cloudinary](https://cloudinary.com/)


### AWS Deployment
The application is deployed on AWS Elastic Beanstalk. Access the deployed application and Swagger API documentation:
1. **Application Home Page:** [Homepage](http://springboot-env.eba-m2q7mnwr.eu-north-1.elasticbeanstalk.com/)
2. **Swagger API on AWS:** [Swagger Docs](http://springboot-env.eba-m2q7mnwr.eu-north-1.elasticbeanstalk.com/swagger-ui/index.html)


### Installations

1. **Clone the Repository:**
   ```bash
   git clone https://github.com/Harsh-Srivastav123/LogisticsBackend.git

2. **Configure Database & Application Properties:**   
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

3. **Configure Cloudinary Configuration:**
   ```bash
   config.put("cloud_name", "");
   config.put("api_key", "");
   config.put("api_secret", "");
   config.put("secure", true);

### Swagger API Documentation
Access the Swagger UI for easy API documentation and testing:
```bash
   http://localhost:8080/swagger-ui/index.html





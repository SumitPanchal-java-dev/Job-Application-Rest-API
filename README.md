# JobApplication
FirstJobApp

FirstJobApp is a job application management system that allows users to manage companies, job listings, and reviews. Built using Spring Boot and JPA, this application provides a robust backend for job-related data operations.

Project Structure

com.embarkx.firstjobapp.company: Contains classes related to managing companies, including entity, repository, service, and controller layers.
com.embarkx.firstjobapp.job: Contains classes related to job postings, including entity, repository, service, and controller layers.
com.embarkx.firstjobapp.review: Contains classes related to company reviews, including entity, repository, service, and controller layers.

Technologies Used

Java 17
Spring Boot 3.3.3
Spring Data JPA
H2 Database (in-memory)
Maven

Entities

Company
id: Unique identifier for the company.
name: Name of the company.
description: Description of the company.
jobs: List of job postings associated with the company.
reviews: List of reviews associated with the company.

Job
id: Unique identifier for the job.
title: Title of the job.
description: Description of the job.
minsalary: Minimum salary for the job.
maxsalary: Maximum salary for the job.
location: Location of the job.
company: Company associated with the job.

Review
id: Unique identifier for the review.
title: Title of the review.
description: Description of the review.
rating: Rating given in the review.
company: Company associated with the review.

Endpoints

Company Endpoints
GET /companies: Retrieve all companies.
GET /companies/{id}: Retrieve a specific company by ID.
POST /companies: Create a new company.
PUT /companies/{id}: Update an existing company by ID.
DELETE /companies/{id}: Delete a company by ID.

Job Endpoints
GET /jobs: Retrieve all jobs.
GET /jobs/{id}: Retrieve a specific job by ID.
POST /jobs: Create a new job.
PUT /jobs/{id}: Update an existing job by ID.
DELETE /jobs/{id}: Delete a job by ID.

Review Endpoints
GET /companies/{compnayid}/reviews: Retrieve all reviews for a specific company.
GET /companies/{compnayid}/reviews/{reviewid}: Retrieve a specific review by ID for a specific company.
POST /companies/{compnayid}/reviews: Create a new review for a specific company.
PUT /companies/{compnayid}/reviews/{reviewid}: Update a specific review by ID for a specific company.
DELETE /companies/{compnayid}/reviews/{reviewid}: Delete a specific review by ID for a specific company.

Configuration
The application uses an in-memory H2 database for testing and development. Configuration details are provided in the application.properties file:

properties

spring.application.name=firstjobapp
server.port=8080
spring.h2.console.enabled=true
spring.datasource.url=jdbc:h2:mem:test
spring.jpa.show-sql=true
spring.jpa.hibernate.ddl-auto=update

Setup
Clone the repository:
bash
Copy code
git clone <repository-url>

Navigate to the project directory:
bash
Copy code
cd firstjobapp

Build the project using Maven:
bash
Copy code
mvn clean install

Run the application:
bash
Copy code
mvn spring-boot:run
Testing

You can test the endpoints using tools like Postman or cURL. Ensure the application is running on http://localhost:8080.


Contributing
Feel free to fork the repository and submit pull requests. For major changes, please open an issue first to discuss what you would like to change.

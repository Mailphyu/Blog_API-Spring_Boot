# Spring Boot Blog API

## Overview

This project is a Blog management API built using Spring Boot. It allows you to create, read, and update blog posts. Each blog post has a title, description, and category. The project is designed to demonstrate RESTful API design, CRUD operations, and integration with an in-memory H2 database. Additionally, it includes a Java utility to find a pair of integers in an array that sum to a specific target.

## Features

* Create a new blog post with title, description, and category.
* Retrieve all blogs.
* Retrieve a single blog by its ID.
* Update existing blog information.
* Demonstrates proper RESTful API conventions.
* Includes a Pair Sum utility to find integer pairs with a target sum.

## Technologies Used

* Java 17
* Spring Boot 3.x
* Spring Data JPA
* H2 Database (in-memory)
* Gradle (build tool)
* Postman (for API testing)

## Project Structure

* `src/main/java/com/example/blog` - Main Spring Boot application.
* `controller/BlogController.java` - REST API endpoints.
* `model/Blog.java` - Blog entity.
* `repository/BlogRepository.java` - JPA repository for Blog entity.
* `service/BlogService.java` - Business logic for blogs.
* `util/PairSum.java` - Utility class for finding integer pairs.
* `resources/application.properties` - Configuration file for H2 database.

## Setup Instructions

1. Clone the repository:

```
git clone https://github.com/Mailphyu/Blog_API-Spring_Boot
cd Blog_API-Spring_Boot
```

2. Build the project:

```
./gradlew build
```

3. Run the application:

```
./gradlew bootRun
```

The API runs on `http://localhost:8080`.

### H2 Database Console

* URL: `http://localhost:8080/h2-console`
* JDBC URL: `jdbc:h2:mem:blogdb`
* Username: `sa`
* Password: *Empty*
* This allows you to view the in-memory database tables and data during runtime.

## How to Use the API

* **POST /blogs**: Create a new blog post. Include JSON body with title, description, and category.
* **GET /blogs**: Retrieve all blogs.
* **GET /blogs/{id}**: Retrieve a specific blog by ID.
* **PUT /blogs/{id}**: Update a blog post by ID.
* Use Postman to test the endpoints. The repository includes a Postman collection and environment file.
* Ensure you run the **Create Blog** request first to generate a `blogId` for subsequent GET by ID or PUT requests.

## Pair Sum Utility

* This utility helps find a pair of integers in an array that add up to a given target.
* Example usage:

```java
int[] nums = {8, 7, 2, 5, 3, 1};
int target = 10;
PairSum.findPair(nums, target); // Output: Pair found (8, 2)
```

* The code is located at `src/main/java/com/example/blog/util/PairSum.java`.
* It demonstrates handling arrays and basic algorithmic problem solving.

## Testing

* Postman collection (`BlogAPI.postman_collection.json`) and environment (`Blog API - Local.postman_environment.json`) are included.
* Steps:

  1. Import the collection and environment into Postman.
  2. Run **Create Blog** to generate a `blogId`.
  3. Test other endpoints (GET all, GET by ID, PUT).
* Verify responses match expected JSON format and HTTP status codes.
* For Pair Sum, run the `main` method in `PairSum.java` or write a small test program.

## Notes

* The H2 database is in-memory; all data is lost when the application stops.
* This project can be easily adapted to use a persistent database such as MySQL.
* Follows clean code principles and separates layers (Controller, Service, Repository).
* Demonstrates practical backend development skills suitable for an internship.

## Author

Sanij Shrestha

## Contact

subba.shrestha031@gmail.com

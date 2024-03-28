# Task Management System - Spring Boot Project

## Overview

A simple Spring Boot project designed for beginners to build a basic Task Management System. Users can perform CRUD (Create, Read, Update, Delete) operations on tasks, providing a fundamental understanding of building a Spring Boot application with a web interface.

## Entities

1. **Task:**
    - Attributes: `id`, `title`, `description`, `dueDate`, `status` (Pending, In Progress, Completed)

## Functionality

1. **List Tasks:**
    - Display a list of tasks with their details.
    - Option to filter tasks by status.

2. **Create Task:**
    - Add a new task with a title, description, due date, and status.

3. **Update Task:**
    - Edit existing tasks, modify details, and update the status.

4. **Delete Task:**
    - Remove tasks from the list.

## Docker Usage

1. Navigate to the directory containing `docker-compose.yml`.
2. Run the following command to start the MySQL database container:

```bash
docker-compose up -d
```

## Technologies

- **Spring Boot:** Backend framework for building the application.
- **Thymeleaf:** Template engine for creating dynamic HTML pages.
- **Spring Data JPA:** Simplifies database access using Java Persistence API.
- **H2 Database:** Lightweight in-memory database for simplicity.

## Project Structure

- `src/main/java/com.example.taskmanagement`: Java source code.
    - `TaskManagementApplication.java`: Main application class.
    - `controller/TaskController.java`: Controller for handling HTTP requests.
    - `model/Task.java`: Entity class representing a task.
    - `repository/TaskRepository.java`: Interface for CRUD operations on tasks.
    - `service/TaskService.java`: Service layer for business logic.
- `src/main/resources`: Configuration files and static content.
    - `application.properties`: Configuration settings, including database configuration.
    - `templates/`: HTML templates.

## Dependencies

```xml
<!-- Spring Boot Starter Web for web applications -->
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-web</artifactId>
</dependency>

<!-- Lombok for reducing boilerplate code -->
<dependency>
    <groupId>org.projectlombok</groupId>
    <artifactId>lombok</artifactId>
    <version>1.18.22</version> <!-- Use the latest version available -->
    <scope>provided</scope>
</dependency>

<!-- Spring Data JPA for data access -->
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-data-jpa</artifactId>
</dependency>

<!-- MySQL Driver for MySQL database connectivity -->
<dependency>
    <groupId>mysql</groupId>
    <artifactId>mysql-connector-java</artifactId>
    <version>8.0.23</version> <!-- Use the latest version available -->
</dependency>

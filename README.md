
# Department Management System

## Overview
Spring Boot REST API for managing departments with full CRUD operations.

## Features
- Create, Read, Update, Delete departments
- One-to-Many relationship with employees

## Technologies
- Java 17+
- Spring Boot 3.x
- Spring Data JPA
- Hibernate
- Maven

## API Endpoints
Base URL: `http://localhost:8080/dept`

| Method | Endpoint    | Description                |
|--------|-------------|----------------------------|
| GET    | /           | Get all departments        |
| GET    | /{id}       | Get department by ID       |
| POST   | /           | Create new department      |
| PUT    | /{id}       | Update department          |
| DELETE | /{id}       | Delete department          |




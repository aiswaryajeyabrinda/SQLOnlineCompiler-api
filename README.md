SQL Runner is a web application used for executing SQL queries against a SQLite database. It allows users to explore database structure, execute read-only queries, and view results in a tabular format!

## System Architecture Diagram

```text
┌─────────────────┐    HTTP/REST    ┌──────────────────┐
│   React         │ ◄─────────────► │   Spring Boot    │
│   Frontend      │                 │   Backend        │
│   (Port: 5173)  │                 │   (Port: 8080)   │
└─────────────────┘                 └─────────┬────────┘
                                              │
                                              │ JDBC
                                              ▼
                                      ┌──────────────────┐
                                      │   SQLite         │
                                      │   Database       │
                                      │   (File-based)   │
                                      └──────────────────┘


```

## Prerequisites
- Java 21
- Spring Boot 3.5.7
- Gradle

### Dependencies needed while creating spring boot project!
- Spring Web
- Spring JDBC
- SQLite Database (implementation 'org.xerial:sqlite-jdbc:3.45.2.0')

## API Endpoints
- `POST /api/execute` - Execute SQL query
- `GET /api/tables` - Get database tables

## Setup
1. Application starts on http://localhost:8080

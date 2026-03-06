# Todo List Backend

A robust backend API for managing Todo lists and Users, built with Java and Spring Boot.

## 🚀 Key Features

*   **User Management**: Create users with secure password hashing (BCrypt).
*   **Task Management**: Secure endpoints for managing tasks.
*   **Authentication**: Custom Basic Authentication filter for task operations.
*   **Documentation**: Integrated OpenAPI (Swagger UI) documentation.
*   **Database**: In-memory H2 database for easy development and testing.

## 🛠 Technologies Used

*   **Java 17**
*   **Spring Boot 3**
*   **Spring Data JPA**
*   **H2 Database**
*   **Lombok** (Boilerplate reduction)
*   **BCrypt** (Password security)
*   **SpringDoc OpenAPI** (API Documentation)
*   **Maven** (Build tool)

## 📋 Prerequisites

*   Java 17 or higher
*   Maven (optional, wrapper included)
*   Docker (optional, for containerization)

## 🏃 How to Run Locally

1.  **Clone the repository:**
    ```bash
    git clone https://github.com/d86554300/todo-list.git
    cd todo-list
    ```

2.  **Run the application:**
    You can use the included Maven wrapper to run the app without installing Maven globally.
    ```bash
    ./mvnw spring-boot:run
    ```
    *On Windows CMD:*
    ```cmd
    mvnw spring-boot:run
    ```

3.  **Access the API:**
    The server will start on `http://localhost:8080`.

## 📚 API Documentation

Once the application is running, you can access the interactive API documentation (Swagger UI) at:

*   **URL**: `http://localhost:8080/swagger-ui/index.html`

## 🗄 Database Access

The project uses an in-memory H2 database. You can access the console to view data directly.

*   **Console URL**: `http://localhost:8080/h2-console`
*   **JDBC URL**: `jdbc:h2:mem:todolist`
*   **User**: `admin`
*   **Password**: `admin`

## 🧪 How to Test

To run the unit and integration tests:

```bash
./mvnw test
```

## 🐳 How to Run Using Docker

1.  **Build the JAR file:**
    ```bash
    ./mvnw clean package -DskipTests
    ```

2.  **Build the Docker image:**
    ```bash
    docker build -t todo-list-app .
    ```

3.  **Run the container:**
    ```bash
    docker run -p 8080:8080 todo-list-app
    ```

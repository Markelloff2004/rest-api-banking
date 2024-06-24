# Simple CRUD REST API for Banking

This project is a simple CRUD (Create, Read, Update, Delete) REST API for managing bank accounts. It is built using Spring Boot and demonstrates basic CRUD operations via a RESTful web service. The application is intended for educational purposes to help understand how to create RESTful APIs with Spring Boot.

## Features

- Create new bank accounts
- View details of all bank accounts
- View details of a single bank account
- Update existing bank account information
- Delete bank accounts

## Technologies Used

- Java
- Spring Boot
- Spring Data JPA
- H2 Database
- Maven

## Getting Started

### Prerequisites

- JDK 11 or later
- Maven 3.6.0 or later

### Installation

1. Clone the repository:
    ```bash
    git clone https://github.com/Markelloff2004/simple-crud-rest-api-banking.git
    cd simple-crud-rest-api-banking
    ```

2. Build the project using Maven:
    ```bash
    mvn clean install
    ```

3. Run the application:
    ```bash
    mvn spring-boot:run
    ```

The application will start on `http://localhost:8080`.

### Configuration

The application uses the H2 in-memory database by default. You can access the H2 database console at `http://localhost:8080/h2-console` with the following settings:

- JDBC URL: `jdbc:h2:mem:testdb`
- Username: `sa`
- Password: `password`

## API Endpoints

- `GET /api/accounts`: Get a list of all bank accounts
- `GET /api/accounts/{id}`: Get details of a single bank account
- `POST /api/accounts`: Create a new bank account
- `PUT /api/accounts/{id}`: Update an existing bank account
- `DELETE /api/accounts/{id}`: Delete a bank account

### Example Requests

- **Get all accounts:**
    ```bash
    curl -X GET http://localhost:8080/api/accounts
    ```

- **Get account by ID:**
    ```bash
    curl -X GET http://localhost:8080/api/accounts/{id}
    ```

- **Create a new account:**
    ```bash
    curl -X POST -H "Content-Type: application/json" -d '{"accountName": "John Doe", "accountType": "Savings", "balance": 1000.0}' http://localhost:8080/api/accounts
    ```

- **Update an account:**
    ```bash
    curl -X PUT -H "Content-Type: application/json" -d '{"accountName": "John Doe", "accountType": "Checking", "balance": 2000.0}' http://localhost:8080/api/accounts/{id}
    ```

- **Delete an account:**
    ```bash
    curl -X DELETE http://localhost:8080/api/accounts/{id}
    ```

## Project Structure

- `src/main/java`: Contains the Java source files
    - `com.example.demo`: Main package containing the Spring Boot application
    - `com.example.demo.controller`: Contains REST controllers
    - `com.example.demo.model`: Contains the data model
    - `com.example.demo.repository`: Contains the repository interfaces
    - `com.example.demo.service`: Contains the service layer
- `src/main/resources`: Contains the application resources
    - `application.properties`: Spring Boot configuration file

## Contributing

Contributions are welcome! Please fork the repository and create a pull request with your changes. Ensure that your code adheres to the existing style and conventions and includes appropriate tests.

1. Fork the repository
2. Create a new feature branch:
    ```bash
    git checkout -b feature/your-feature-name
    ```
3. Commit your changes:
    ```bash
    git commit -m 'Add some feature'
    ```
4. Push to the branch:
    ```bash
    git push origin feature/your-feature-name
    ```
5. Open a pull request

## License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for more details.

## Acknowledgements

- [Spring Boot](https://spring.io/projects/spring-boot)
- [H2 Database](http://www.h2database.com/html/main.html)


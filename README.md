# Migrated Kitchensink Application

This is the migrated version of the "kitchensink" JBoss EAP Quickstart application, now running on Spring Boot with Java 21.

## Build and Run Instructions

**Prerequisites:**

*   Java 21 JDK
*   Maven

**Steps:**

1.  **Clone the repository:**

    ```bash
    git clone [invalid URL removed]
    ```

2.  **Navigate to the project directory:**

    ```bash
    cd kitchensink-spring-boot
    ```

3.  **Build the application:**

    ```bash
    mvn clean install
    ```

4.  **Run the application:**

    ```bash
    mvn spring-boot:run
    ```

**Access the application:**

*   Open your web browser and go to `http://localhost:8080/` to access the application.

**Additional notes:**

*   This application uses an embedded H2 database.
*   The application includes a basic form for registering members and a list of registered members.
*   You can access the REST API endpoints at `/api/members`.
*   Refer to the original "kitchensink" application's documentation for more details about the application's functionality.

**Optional stretch goal:**

*   The application can be modified to use MongoDB instead of the relational database. To do this, update the `application.properties` file to configure the MongoDB connection and update the `Member` entity and `MemberRepository` to use Spring Data MongoDB annotations and methods.

**Migration notes:**

*   The original JSF-based application was migrated to Spring Boot using Spring MVC and Thymeleaf.
*   The `persistence.xml` file was removed as the JPA properties are configured in `application.properties`.
*   The `import.sql` file is used to populate the database with initial data.
*   The `webapp` folder's contents were reorganized to fit the Spring Boot project structure.
*   The `index.xhtml` file was converted to a Thymeleaf template (`index.html`) and placed in the `static` folder to be served directly as the welcome page.
*   The `default.xhtml` file was converted to a Thymeleaf layout template (`default.html`) and placed in the `templates

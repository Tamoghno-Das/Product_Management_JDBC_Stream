# Product Management System

## Executive Summary
The Product Management System is a Java console application that manages product records stored in an Oracle Database. It provides CRUD workflows alongside Stream API demonstrations for filtering, aggregation, grouping, and statistics on product data.

## Objectives
- Centralize product CRUD operations in a simple console interface.
- Demonstrate Java Stream API operations on real product data.
- Provide a DAO-based structure suitable for extension.

## Scope
- In-scope: console-based product management, database access via JDBC, Stream API demos.
- Out-of-scope: web UI, authentication/authorization, multi-tenant data separation.

## Key Capabilities
- Add, view, update, and delete products in the database.
- Search products by category and price range.
- Stream API demos including filtering, mapping, sorting, grouping, partitioning, and statistics.
- Menu-driven console interface.
- Custom exception handling with `ProductException`.

## Architecture Overview
- Presentation: console menu in `ProductDashBoard`.
- Data access: DAO pattern via `ProductDAO` and `ProductDAOImpl`.
- Service: Stream API utilities in `ProductStreamService`.
- Infrastructure: JDBC connection in `DBUtil`.

## Technology Stack
- Java (configured for Java 25 in `pom.xml`)
- Maven
- Oracle Database 11g (JDBC)
- Lombok 1.18.46
- Oracle JDBC driver 23.4.0

## Directory Structure
- `src/main/java/com/example/main/ProductDashBoard.java`: Main console UI and menu.
- `src/main/java/com/example/model/Product.java`: Product model (POJO) using Lombok.
- `src/main/java/com/example/dao/ProductDAO.java`: DAO interface.
- `src/main/java/com/example/dao/ProductDAOImpl.java`: DAO implementation with SQL.
- `src/main/java/com/example/service/ProductStreamService.java`: Stream API demos.
- `src/main/java/com/example/util/DBUtil.java`: Database connection utility.

## Environment Prerequisites
- Java and Maven installed locally.
- Oracle Database instance accessible from the application host.

## Database Provisioning
1. Ensure Oracle Database is running and accessible.
2. Create the `products` table:

```sql
CREATE TABLE products (
    product_id NUMBER PRIMARY KEY,
    product_name VARCHAR2(100),
    category VARCHAR2(50),
    price NUMBER(10,2),
    quantity NUMBER
);
```

3. Update credentials if needed in `src/main/java/com/example/util/DBUtil.java`:
- URL: `jdbc:oracle:thin:@localhost:1521:xe`
- User: `c##scott`
- Password: `tiger`

## Build
From the project root:

```bash
mvn clean compile
```

## Run
This project does not include a Maven exec plugin. Run `ProductDashBoard.main()` from your IDE.

## Usage
The console menu provides options to:
- Add product
- View product by ID
- View all products
- Update product
- Delete product
- View by category
- View within price range
- Stream API demos
- Exit

## Stream API Demonstrations
`ProductStreamService` contains examples such as:
- Filtering by category and price
- Sorting by price
- Grouping and partitioning
- Summaries and statistics
- Parallel stream usage

## Error Handling
Database and application errors are wrapped in `ProductException` for consistent handling.

## Future Enhancements
- Add Maven exec plugin for CLI-based execution.
- Introduce unit tests for DAO and service layers.
- Add logging with configurable levels (e.g., SLF4J + Logback).
- Support pagination and advanced search filters.
- Provide export options (CSV/Excel) for reporting.

## Author
- Name: TAMOGHNO DAS
- Contact: tammoghnowork05@gmail.com

## Notes
- Ensure the Oracle JDBC driver resolves properly via Maven.
- Adjust database URL and credentials to match your environment.

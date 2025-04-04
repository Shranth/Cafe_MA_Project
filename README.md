**Cafe Management System - Microservices Architecture**
Welcome to the Cafe Management System, a backend-driven project designed using Spring Boot Microservices. This system mimics the operations of a real-world cafe by breaking down its functionalities into independent, loosely coupled microservices. Each service is responsible for a specific domain (User, Order, Product, and Payment), ensuring scalability, maintainability, and resilience.
This project showcases the power of distributed systems using Spring Cloud components like Eureka for service discovery, OpenFeign for inter-service communication, and Spring Cloud Config for centralized configuration management. With a secure and validated payment process, dynamic configuration updates, and clean architectural practices, this system serves as a solid foundation for building scalable microservices-based enterprise applications.

**Microservices Overview**
 1. User Service
•	Registers and manages users.
•	Stores user data in the database.
•	Exposes REST APIs to fetch user details.

 2. Order Service
•	Handles order placement by users.
•	Maintains orders with fields:
o	orderId
o	userId
o	totalAmount
o	paymentStatus (INCOMPLETE/COMPLETE)
•	REST endpoints to:
o	Place an order
o	Get order by ID
o	Update payment status

3. Product Service
•	Manages menu items (products) offered by the cafe.
•	APIs to:
o	Add a product
o	List all products
o	Update product details

4. Payment Service
•	Validates payment requests.
•	Ensures that only the user who placed an order can pay for it.
•	Interacts with Order Service using OpenFeign.
•	Logic:
o	Takes userId and orderId as input.
o	Fetches the order details.
o	Verifies userId matches.
o	If valid, updates payment status to COMPLETE.

**Supporting Services**
Eureka Server (Service Discovery)
•	Registers all microservices.
•	Enables load balancing and dynamic discovery

API Gateway
•	Acts as a single entry point.
•	Routes requests to appropriate microservices.
•	Enables cross-cutting concerns like security and rate limiting.

Config Server
•	Centralized management of application.properties files for all services.
•	Loads config from a GitHub repository.
•	Supports dynamic refresh using Spring Actuator (/actuator/refresh).

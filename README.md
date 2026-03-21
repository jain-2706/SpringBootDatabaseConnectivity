# SpringBoot Database Connectivity

## Overview
This repository contains a **Spring Boot backend** for a full-stack application.

It provides a REST API connected to a **MySQL database** using **Spring Data JPA**, allowing dynamic CRUD operations.

---

## Features
- **Database Connectivity:** Connected to MySQL using **Spring Data JPA**.
- **Entity Mapping:** Java classes map directly to database tables using JPA annotations.
- **CRUD Operations:** Create, read, update, and delete functionality via JPA repositories.
- **REST APIs:** Exposes endpoints for frontend consumption.
- **Auto-Configuration:** Spring Boot handles DataSource, EntityManager, and TransactionManager automatically.

---

## Project Snapshot

<p align="center">
  <img src="images/95d8c931-6be4-46f2-a546-a5ebeeba0b02.png" width="600" />
</p>

---

## Database Configuration

Example `application.properties` for MySQL:

```properties
spring.application.name=demo
server.port=1234
server.address=0.0.0.0
spring.jpa.show-sql=true
spring.jpa.generate-ddl=true
spring.jpa.hibernate.ddl-auto=update
spring.jpa.properties.dialect=org.hibernate.dialect.MySQLDialect
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.datasource.url=jdbc:mysql://127.0.0.1:2567/fullStack
spring.datasource.username=root



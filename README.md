# ExpenseTrackerApplication – Java JDBC Project

A console-based personal expense tracking system developed using Java, JDBC, and MySQL.
The application allows users to add expenses, view summaries, filter expenses by category, and enforce budget rules using a layered architecture.

# Project Overview

This project helps users track daily expenses through a menu-driven console interface.
All expense data is stored in a MySQL database, and business rules are applied before saving expenses to control spending.

# Technologies Used

Java

JDBC

MySQL

DAO Design Pattern

Console-based UI

# Architecture

The project follows a layered architecture, ensuring clean separation of concerns:

UI Layer        → MenuUI
Service Layer   → ExpenseTracker
Rule Layer      → ExpenseRuleEngine
DAO Layer       → ExpenseDAO
DB Utility      → DBConnection
Model Layer     → Expense
Database        → MySQL

 # Package Structure

            expense_analyser
            │
            ├── model
            │   └── Expense.java
            │
            ├── db
            │   └── DBConnection.java
            │
            ├── dao
            │   └── ExpenseDAO.java
            │
            ├── rule
            │   └── ExpenseRuleEngine.java
            │
            ├── services
            │   └── ExpenseTracker.java
            │
            └── ui
                └── MenuUI.java

# Class Responsibilities
🔹 Expense (Model Layer)

Represents a single expense record and maps directly to a row in the database.
Used to transfer data between UI, service, and DAO layers.

🔹 DBConnection (Database Utility)

Handles the creation and management of MySQL database connections using JDBC.
Provides a reusable method to obtain database connections.

🔹 ExpenseDAO (Data Access Layer)

Responsible for all database operations such as inserting and retrieving expense data.
Uses prepared statements to ensure secure and efficient database interaction.

🔹 ExpenseRuleEngine (Business Rules Layer)

Applies business rules such as:

Monthly spending limit

Category-specific expense limits

Ensures expense validation before saving data.

🔹 ExpenseTracker (Service Layer)

Acts as the core business logic layer.
Coordinates between UI, DAO, and rule engine to manage expense operations.

🔹 MenuUI (User Interface Layer)

Provides a console-based, menu-driven interface for user interaction.
Handles user input and displays expense summaries and totals.

# Database Schema
CREATE TABLE expenses (
    id INT AUTO_INCREMENT PRIMARY KEY,
    category VARCHAR(50),
    amount DOUBLE,
    description VARCHAR(255)
);

▶️ How to Run the Application

Clone the repository

Create the database and table in MySQL

Update database credentials in DBConnection.java

Compile and run MenuUI.java

Use the console menu to manage expenses

# Key Learning Outcomes

Practical use of JDBC with MySQL

Understanding DAO and layered architecture

Secure database operations using PreparedStatement

Separation of business logic and data access

Budget validation using rule-based design

# Future Enhancements

Custom exception handling

Logging support

Monthly reports

Export expenses to CSV

Migration to Spring Boot REST API

# Project Summary
A Java console-based expense tracking application using JDBC and MySQL, designed with a layered architecture to efficiently manage and validate personal expenses.

# Author
Shyam Sundar K
Computer Science Engineering Student
Aspiring Full Stack Java Developer

# JavaProjects
Folder for java Projects


1.Number_Guessing_Game:
  A Java program in which a user will get K trials to guess a randomly generated number. Below are the rules of the game:

If the guessed number is bigger than the actual number, the program will respond with the message that the guessed number is higher than the actual number.
If the guessed number is smaller than the actual number, the program will respond with the message that the guessed number is lower than the actual number.
If the guessed number is equal to the actual number or if the K trials are exhausted, the program will end with a suitable message.


2.Automobile Management System
Project Overview
The Automobile Management System is a Java-based application that enables users to efficiently manage vehicle records using JDBC (Java Database Connectivity). The system allows users to add, update, remove, and display vehicles stored in a relational database.

Workflow
User Login

Secure authentication system to validate user credentials.
Only authorized users can access vehicle management features.
Dashboard with Options
After a successful login, users can perform the following operations:

Add a Vehicle → Insert new vehicle details into the database.
Remove a Vehicle → Delete an existing vehicle record.
Update a Vehicle → Modify any vehicle detail, including type, brand, model, color, cost, and engine type.
Display All Vehicles → Retrieve and view the list of all vehicles stored in the database.
Vehicle Parameters Used
Each vehicle record in the system consists of the following attributes:

String vehicleType → Type of vehicle (Car, Bike, Truck, etc.)
String vehicleBrand → Brand name of the vehicle (Toyota, Honda, BMW, etc.)
String vehicleModel → Specific model of the vehicle (Camry, Civic, X5, etc.)
String vehicleColor → Color of the vehicle
String vehicleCost → Price of the vehicle
String engineType → Type of engine (Petrol, Diesel, Electric, Hybrid)
Implementation Details
Developed using Core Java with JDBC for database interaction.
Uses Prepared Statements to prevent SQL injection and ensure data security.
Update Functionality → Users can update any parameter of a vehicle record.
Database: MySQL / PostgreSQL for storing vehicle records.
Console-Based Interface or Basic GUI for user interaction.
Technologies Used
Programming Language: Java
Database: MySQL / PostgreSQL
Backend Connectivity: JDBC
Authentication: User credential validation via database
Benefits
✅ Efficient Vehicle Management – Perform CRUD operations (Create, Read, Update, Delete) easily.
✅ Full Update Functionality – Modify any vehicle attribute.
✅ Database Integration – Ensures persistent storage of vehicle records.
✅ Secure & Optimized Queries – Uses JDBC with Prepared Statements for data integrity.
✅ User-Friendly System – Simplifies vehicle record management for dealerships and service centers.

This project provides a complete JDBC-based automobile management system, making it a great learning experience for database-driven applications.


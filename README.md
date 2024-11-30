Property Management System
Overview
This Property Management System is a Java-based application that allows users to manage properties, rental agreements, tenants, and payments. It is built with Maven for dependency management and features a console-based user interface.

Key Features
Console-Based User Interface: Navigate the system using a menu-driven interface.
Property Management: View and search properties by ID or address.
Rental Agreement Management: Perform CRUD operations, search by criteria (e.g., ID, status), and sort by attributes like start date or tenant ID.
Tenant, Owner, and Host Management: View and search records by ID, name, or contact details.
Payment Tracking: View and search payment records.
File-Based Storage: Persistent data storage via text files.
Project Structure
model: Core classes for entities (e.g., Property, Tenant, RentalAgreement).
viewer: Console-based UI implementation (ConsoleUI).
util: Utility classes for supporting application logic.
Getting Started
Prerequisites
Java 8 or higher
Maven 3.6 or higher
Installation
Clone the repository:
git clone https://github.com/phg02/property-management-system.git
cd property-management-system
Build the project using Maven:
mvn clean install
Running the Application
Run the application with the following command:

mvn exec:java -Dexec.mainClass="src"
License
This project is licensed under the MIT License. See the LICENSE file for details.

Author
Nguyen Minh Phuong - s4063236

# Property Management System

## Overview

This project is a Property Management System that allows users to manage properties, rental agreements, tenants, and payments. The system is implemented in Java and uses Maven for dependency management.

## Features

- Manage commercial and residential properties
- Handle rental agreements
- Track tenants and their payments
- Manage property owners and hosts

## Project Structure

The project is organized into the following packages:

- `model`: Contains the core classes representing the entities in the system.
- `viewer`: Contains the classes for the console user interface.

## Classes

### Model Package

- `CommercialProperty`: Represents a commercial property.
- `ResidentialProperty`: Represents a residential property.
- `RentalAgreement`: Represents a rental agreement.
- `Tenant`: Represents a tenant.
- `Person`: Represents a person (base class for `Host` and `Tenant`).
- `Property`: Represents a property (base class for `CommercialProperty` and `ResidentialProperty`).
- `Owner`: Represents a property owner.
- `Host`: Represents a host who manages properties and rental agreements.
- `Payment`: Represents a payment made by a tenant.

### Viewer Package

- `ConsoleUI`: Provides a console-based user interface for interacting with the system.

## Getting Started

### Prerequisites

- Java 8 or higher
- Maven 3.6 or higher

### Installation

1. Clone the repository:
   ```sh
   git clone https://github.com/phg02/property-management-system.git
   cd property-management-system
   ```

2. Build the project using Maven:
   ```sh
   mvn clean install
   ```

### Running the Application

To run the application, execute the following command:
```sh
mvn exec:java -Dexec.mainClass="src"
```

## Usage

The application provides a console-based user interface. Follow the on-screen instructions to manage properties, rental agreements, tenants, and payments.

## Contributing

Contributions are welcome! Please fork the repository and submit a pull request.

## License

This project is licensed under the MIT License. See the `LICENSE` file for details.

## Author

Nguyen Minh Phuong - s4063236

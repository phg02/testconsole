package viewer;
/*
  @author <Nguyen Minh Phuong - s4063236>
 */

import controller.impl.*;
import util.FileHandler;

import java.util.Scanner;

/**
 * Console-based User Interface for the Rental Management System.
 * Provides a menu-driven interface for managing tenants, owners, hosts, properties, rental agreements, and payments.
 */
public class ConsoleUI {
    private Scanner scanner;

    /**
     * Main method to run the console UI.
     * Initializes the necessary managers and starts the main menu loop.
     */
    public void run() {
        // Initialize the file handler for data persistence
        FileHandler fileHandler = new FileHandler();

        // Initialize the various managers with the file handler
        TenantManagerImpl tenantManager = new TenantManagerImpl(fileHandler);
        OwnerManagerImpl ownerManager = new OwnerManagerImpl(fileHandler);
        HostManagerImpl hostManager = new HostManagerImpl(fileHandler);
        CommercialPropertyManagerImpl commercialPropertyManager = new CommercialPropertyManagerImpl(fileHandler);
        ResidentialPropertyManagerImpl residentialPropertyManager = new ResidentialPropertyManagerImpl(fileHandler);
        PropertyManagerImpl propertyManager = new PropertyManagerImpl(commercialPropertyManager, residentialPropertyManager);
        RentalManagerImpl rentalManager = new RentalManagerImpl(fileHandler);
        PaymentManagerImpl paymentManager = new PaymentManagerImpl(fileHandler);

        // Flag to control the main menu loop
        boolean exit = false;

        // Initialize the scanner for user input
        scanner = new Scanner(System.in);

        // Print the welcome banner
        System.out.println("====================================================================================================");
        System.out.println("\n" +
                "  ___         _        _   __  __                                       _     ___         _             \n" +
                " | _ \\___ _ _| |_ __ _| | |  \\/  |__ _ _ _  __ _ __ _ ___ _ __  ___ _ _| |_  / __|_  _ __| |_ ___ _ __  \n" +
                " |   / -_| ' |  _/ _` | | | |\\/| / _` | ' \\/ _` / _` / -_| '  \\/ -_| ' |  _| \\__ | || (_-|  _/ -_| '  \\ \n" +
                " |_|_\\___|_||_\\__\\__,_|_| |_|  |_\\__,_|_||_\\__,_\\__, \\___|_|_|_\\___|_||_\\__| |___/\\_, /__/\\__\\___|_|_|_|\n" +
                "                                                |___/                             |__/                  \n");
        System.out.println("====================================================================================================");
        System.out.println("Welcome to the Rental Management System");

        // Main menu loop
        while (!exit) {
            // Print the main menu options
            printMainMenu();
            try {
                // Read the user's choice
                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume the newline character
                switch (choice) {
                    case 1 -> {
                        System.out.println("You have chosen to check the tenant dashboard.");
                        TenantManagementViewer tenantManagementViewer = new TenantManagementViewer(tenantManager);
                        tenantManagementViewer.tenantViewerManager();
                    }
                    case 2 -> {
                        System.out.println("You have chosen to check the owner dashboard.");
                        OwnerManagementViewer ownerManagementViewer = new OwnerManagementViewer(ownerManager);
                        ownerManagementViewer.ownerViewerManager();
                    }
                    case 3 -> {
                        System.out.println("You have chosen to check the host dashboard.");
                        HostManagementViewer hostManagementViewer = new HostManagementViewer(hostManager);
                        hostManagementViewer.hostViewerManager();
                    }
                    case 4 -> {
                        System.out.println("You have chosen to check the property dashboard.");
                        PropertyManagementViewer propertyManagementViewer = new PropertyManagementViewer(commercialPropertyManager, residentialPropertyManager, propertyManager);
                        propertyManagementViewer.propertyViewerManager();
                    }
                    case 5 -> {
                        System.out.println("You have chosen to check the rental agreement dashboard.");
                        RentalAgreementManagementViewer rentalAgreementManagementViewer = new RentalAgreementManagementViewer(rentalManager, propertyManager, tenantManager, ownerManager, hostManager);
                        rentalAgreementManagementViewer.rentalAgreementViewerManager();
                    }
                    case 6 -> {
                        System.out.println("You have chosen to check the payment dashboard.");
                        PaymentManagementViewer paymentManagementViewer = new PaymentManagementViewer(paymentManager);
                        paymentManagementViewer.paymentViewerManager();
                    }
                    case 7 -> {
                        exit = true;
                        System.out.println("Exiting the system...");
                    }
                    default -> System.out.println("Invalid choice. Please try again.");
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
                System.out.println("Invalid input! Please enter an integer.");
                run(); // Restart the run method in case of invalid input
            }
        }
    }

    /**
     * Prints the main menu options to the console.
     */
    private static void printMainMenu() {
        System.out.println("==========================================");
        System.out.println("|               Main Menu                |");
        System.out.println("==========================================");
        System.out.println("|  1. Tenant Management                  |");
        System.out.println("|  2. Owner Management                   |");
        System.out.println("|  3. Host Management                    |");
        System.out.println("|  4. Property Management                |");
        System.out.println("|  5. Rental Agreement Management        |");
        System.out.println("|  6. Payment Management                 |");
        System.out.println("|  7. Exit                               |");
        System.out.println("==========================================");
        System.out.println("Enter your choice: ");
    }
}
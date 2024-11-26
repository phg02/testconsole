package viewer;

import controller.impl.*;
import model.Property;
import util.FileHandler;

import java.util.Scanner;

public class ConsoleUI {
    private Scanner scanner;
    public void run(){
        FileHandler fileHandler = new FileHandler();

        TenantManagerImpl tenantManager = new TenantManagerImpl(fileHandler);

        OwnerManagerImpl ownerManager = new OwnerManagerImpl(fileHandler);

        HostManagerImpl hostManager = new HostManagerImpl(fileHandler);

        CommercialPropertyManagerImpl commercialPropertyManager = new CommercialPropertyManagerImpl(fileHandler);

        ResidentialPropertyManagerImpl residentialPropertyManager = new ResidentialPropertyManagerImpl(fileHandler);

        RentalManagerImpl rentalManager = new RentalManagerImpl(fileHandler);

        PaymentManagerImpl paymentManager = new PaymentManagerImpl(fileHandler);

        boolean exit = false;

        scanner = new Scanner(System.in);

        System.out.println("====================================================================================================");
        System.out.println("\n" +
                "  ___         _        _   __  __                                       _     ___         _             \n" +
                " | _ \\___ _ _| |_ __ _| | |  \\/  |__ _ _ _  __ _ __ _ ___ _ __  ___ _ _| |_  / __|_  _ __| |_ ___ _ __  \n" +
                " |   / -_| ' |  _/ _` | | | |\\/| / _` | ' \\/ _` / _` / -_| '  \\/ -_| ' |  _| \\__ | || (_-|  _/ -_| '  \\ \n" +
                " |_|_\\___|_||_\\__\\__,_|_| |_|  |_\\__,_|_||_\\__,_\\__, \\___|_|_|_\\___|_||_\\__| |___/\\_, /__/\\__\\___|_|_|_|\n" +
                "                                                |___/                             |__/                  \n");
        System.out.println("====================================================================================================");
        System.out.println("Welcome to the Rental Management System");

        while (!exit){
            printMainMenu();
            try {
                int choice = scanner.nextInt();
                scanner.nextLine();
                switch (choice) {
                    case 1 -> {
                        System.out.println("You have chosen to check the tenant dashboard.");
                        TenantManagementViewer tenantManagementViewer = new TenantManagementViewer(tenantManager);
                        tenantManagementViewer.tenantViewerManager();
                    }
                    case 2 -> {
                        System.out.println("Owner Management");
                        OwnerManagementViewer ownerManagementViewer = new OwnerManagementViewer(ownerManager);
                        ownerManagementViewer.ownerViewerManager();
                    }
                    case 3 -> {
                        System.out.println("Host Management");
                        HostManagementViewer hostManagementViewer = new HostManagementViewer(hostManager);
                        hostManagementViewer.hostViewerManager();
                    }
                    case 4 -> {
                        System.out.println("Property Management");
                        PropertyManagementViewer propertyManagementViewer = new PropertyManagementViewer(commercialPropertyManager, residentialPropertyManager);
                        propertyManagementViewer.propertyViewerManager();
                    }
                    case 5 -> {
                        System.out.println("Rental Agreement Management");
                        RentalAgreementManagementViewer rentalAgreementManagementViewer = new RentalAgreementManagementViewer(rentalManager);
                        rentalAgreementManagementViewer.rentalAgreementViewerManager();
                    }
                    case 6 -> {
                        System.out.println("Payment Management");
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
                run();
            }
        }
    }

    private static void printMainMenu(){
        System.out.println("==========================================");
        System.out.println("|               Main Menu                |");
        System.out.println("==========================================");
        System.out.println("|  1. Tenant Management                  |");
        System.out.println("|  2. Owner Management                   |");
        System.out.println("|  3. Host Management                    |");
        System.out.println("|  4. Property Management                |");
        System.out.println("|  5. Rental Management                  |");
        System.out.println("|  6. Payment Management                 |");
        System.out.println("|  7. Exit                               |");
        System.out.println("==========================================");
        System.out.println("Enter your choice: ");
    }


}

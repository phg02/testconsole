package viewer;
/*
  @author <Nguyen Minh Phuong - s4063236>
 */

import controller.impl.*;
import model.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

/**
 * Viewer class for managing rental agreements.
 * Provides methods to display and interact with rental agreement data.
 */
public class RentalAgreementManagementViewer {
    private final RentalManagerImpl rentalAgreement;
    private final PropertyManagerImpl propertyManager;
    private final TenantManagerImpl tenantManager;
    private final OwnerManagerImpl ownerManager;
    private final HostManagerImpl hostManager;

    private final Scanner scanner = new Scanner(System.in);
    private final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    /**
     * Constructor to initialize the rental agreement manager and other managers.
     *
     * @param rentalAgreement The rental agreement manager implementation.
     * @param propertyManager The property manager implementation.
     * @param tenantManager The tenant manager implementation.
     * @param ownerManager The owner manager implementation.
     * @param hostManager The host manager implementation.
     */
    public RentalAgreementManagementViewer(RentalManagerImpl rentalAgreement, PropertyManagerImpl propertyManager, TenantManagerImpl tenantManager, OwnerManagerImpl ownerManager, HostManagerImpl hostManager) {
        this.rentalAgreement = rentalAgreement;
        this.propertyManager = propertyManager;
        this.tenantManager = tenantManager;
        this.ownerManager = ownerManager;
        this.hostManager = hostManager;
    }

    /**
     * Prints the rental agreement management menu options to the console.
     */
    public void printRentalAgreementManagementMenu() {
        System.out.println("==============================================");
        System.out.println("|         Rental Agreement Management        |");
        System.out.println("==============================================");
        System.out.println("|  1. Add Rental Agreement                   |");
        System.out.println("|  2. Update Rental Agreement                |");
        System.out.println("|  3. Delete Rental Agreement                |");
        System.out.println("|  4. View All Rental Agreements             |");
        System.out.println("|  5. Search Rental Agreement                |");
        System.out.println("|  6. Exit                                   |");
        System.out.println("==============================================");
        System.out.print("Enter your choice: ");
    }

    /**
     * Manages the rental agreement viewer operations based on user input.
     */
    public void rentalAgreementViewerManager() {
        System.out.println("Rental Agreement Management");
        boolean exitRentalAgreement = false;
        try {
            while (!exitRentalAgreement) {
                printRentalAgreementManagementMenu();
                int choiceRental = scanner.nextInt();
                scanner.nextLine();
                switch (choiceRental) {
                    case 1:
                        System.out.println("Add Rental Agreement");
                        addRentalAgreement();
                        System.out.println("Press Enter to continue...");
                        scanner.nextLine();
                        break;
                    case 2:
                        System.out.println("Update Rental Agreement");
                        updateRentalAgreement();
                        System.out.println("Press Enter to continue...");
                        scanner.nextLine();
                        break;
                    case 3:
                        System.out.println("Delete Rental Agreement");
                        deleteRentalAgreement();
                        System.out.println("Press Enter to continue...");
                        scanner.nextLine();
                        break;
                    case 4:
                        System.out.println("View All Rental Agreements");
                        printRentalAgreements();
                        break;
                    case 5:
                        System.out.println("Search Rental Agreement");
                        displaySearchMenu();
                        break;
                    case 6:
                        System.out.println("Exiting Rental Agreement Management");
                        exitRentalAgreement = true;
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                        break;
                }
            }
        } catch (Exception e) {
            System.out.println("Invalid input. Please try again.");
            rentalAgreementViewerManager();
        }
    }

    /**
     * Prints all rental agreements with sorting options.
     */
    public void printRentalAgreements() {
        boolean exitSort = false;

        while (!exitSort) {
            // Print the sorting menu
            System.out.println("=========================================");
            System.out.println("|          Sort Rental Agreements       |");
            System.out.println("=========================================");
            System.out.println("| 1. Sort by Rental Agreement ID        |");
            System.out.println("| 2. Sort by Host ID                    |");
            System.out.println("| 3. Sort by Tenant ID                  |");
            System.out.println("| 4. Sort by Owner ID                   |");
            System.out.println("| 5. Sort by Property ID                |");
            System.out.println("| 6. Sort by Start Date                 |");
            System.out.println("| 7. Sort by End Date                   |");
            System.out.println("| 8. Exit Sorting                       |");
            System.out.println("=========================================");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    System.out.println("Sorted by Rental Agreement ID:");
                    printTableList(rentalAgreement.getAllRentalAgreementsSortByID());
                    System.out.println("Press Enter to continue...");
                    scanner.nextLine();
                    break;
                case 2:
                    System.out.println("Sorted by Host ID:");
                    printTableList(rentalAgreement.getAllRentalAgreementsSortByHost());
                    System.out.println("Press Enter to continue...");
                    scanner.nextLine();
                    break;
                case 3:
                    System.out.println("Sorted by Tenant ID:");
                    printTableList(rentalAgreement.getAllRentalAgreementsSortByTenant());
                    System.out.println("Press Enter to continue...");
                    scanner.nextLine();
                    break;
                case 4:
                    System.out.println("Sorted by Owner ID:");
                    printTableList(rentalAgreement.getAllRentalAgreementsSortByOwner());
                    System.out.println("Press Enter to continue...");
                    scanner.nextLine();
                    break;
                case 5:
                    System.out.println("Sorted by Property ID:");
                    printTableList(rentalAgreement.getAllRentalAgreementsSortByProperty());
                    System.out.println("Press Enter to continue...");
                    scanner.nextLine();
                    break;
                case 6:
                    System.out.println("Sorted by Start Date:");
                    printTableList(rentalAgreement.getAllRentalAgreementsSortByStartDate());
                    System.out.println("Press Enter to continue...");
                    scanner.nextLine();
                    break;
                case 7:
                    System.out.println("Sorted by End Date:");
                    printTableList(rentalAgreement.getAllRentalAgreementsSortByEndDate());
                    System.out.println("Press Enter to continue...");
                    scanner.nextLine();
                    break;
                case 8:
                    System.out.println("Exiting Sorting...");
                    exitSort = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

    }

    /**
     * Prints a table of rental agreements with their details.
     *
     * @param rentalAgreements The set of rental agreements to be printed.
     */
    public void printTable(HashSet<RentalAgreement> rentalAgreements) {
        // Print the table header
        System.out.println("======================================================================================================================================================================================");
        System.out.printf("| %-12s | %-25s | %-25s | %-25s | %-12s | %-8s | %-12s | %-12s | %-10s | %-10s |\n",
                "AgreementID", "OwnerID", "HostID", "Tenants", "PropertyID", "Period", "Start Date", "End Date", "Fee", "Status");
        System.out.println("======================================================================================================================================================================================");

// Loop through and print each rental agreement
        for (RentalAgreement agreement : rentalAgreements) {
            // Print the main rental agreement row
            System.out.printf("| %-12s | %-25s | %-25s | %-25s | %-12s | %-8s | %-12s | %-12s | %-10.2f | %-10s |\n",
                    agreement.getId(),
                    agreement.getOwner().getId() + " " + agreement.getOwner().getFullName(),
                    agreement.getHost().getId() + " " + agreement.getHost().getFullName(),
                    "Main: " + agreement.getMainTenant().getId() + " " + agreement.getMainTenant().getFullName(),
                    agreement.getProperty().getId(),
                    agreement.getPeriod().name(),
                    dtf.format(agreement.getStartDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime()),
                    dtf.format(agreement.getEndDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime()),
                    agreement.getRentingFee(),
                    agreement.getStatus().name());

            // Print sub-tenants, if any
            if (!agreement.getSubTenant().isEmpty()) {
                for (Tenant subTenant : agreement.getSubTenant()) {
                    System.out.printf("| %-12s | %-25s | %-25s | %-25s | %-12s | %-8s | %-12s | %-12s | %-10s | %-10s |\n",
                            "", // No AgreementID for sub-tenants
                            "", // No OwnerID for sub-tenants
                            "", // No HostID for sub-tenants
                            "Sub: " + subTenant.getId() + " " + subTenant.getFullName(),
                            "", // No PropertyID for sub-tenants
                            "", // No Period for sub-tenants
                            "", // No Start Date for sub-tenants
                            "", // No End Date for sub-tenants
                            "", // No Fee for sub-tenants
                            ""); // No Status for sub-tenants
                }
            }

            // Print a dividing line between agreements
            System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        }

// Print the footer
        System.out.println("======================================================================================================================================================================================");
    }

    /**
     * Prints a list of rental agreements in a tabular format.
     *
     * @param rentalAgreements The list of rental agreements to be printed.
     */
    public void printTableList(List<RentalAgreement> rentalAgreements) {
        // Print the table header
        System.out.println("======================================================================================================================================================================================");
        System.out.printf("| %-12s | %-25s | %-25s | %-25s | %-12s | %-8s | %-12s | %-12s | %-10s | %-10s |\n",
                "AgreementID", "OwnerID", "HostID", "Tenants", "PropertyID", "Period", "Start Date", "End Date", "Fee", "Status");
        System.out.println("======================================================================================================================================================================================");

// Loop through and print each rental agreement
        for (RentalAgreement agreement : rentalAgreements) {
            // Print the main rental agreement row
            System.out.printf("| %-12s | %-25s | %-25s | %-25s | %-12s | %-8s | %-12s | %-12s | %-10.2f | %-10s |\n",
                    agreement.getId(),
                    agreement.getOwner().getId() + " " + agreement.getOwner().getFullName(),
                    agreement.getHost().getId() + " " + agreement.getHost().getFullName(),
                    "Main: " + agreement.getMainTenant().getId() + " " + agreement.getMainTenant().getFullName(),
                    agreement.getProperty().getId(),
                    agreement.getPeriod().name(),
                    dtf.format(agreement.getStartDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime()),
                    dtf.format(agreement.getEndDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime()),
                    agreement.getRentingFee(),
                    agreement.getStatus().name());

            // Print sub-tenants, if any
            if (!agreement.getSubTenant().isEmpty()) {
                for (Tenant subTenant : agreement.getSubTenant()) {
                    System.out.printf("| %-12s | %-25s | %-25s | %-25s | %-12s | %-8s | %-12s | %-12s | %-10s | %-10s |\n",
                            "", // No AgreementID for sub-tenants
                            "", // No OwnerID for sub-tenants
                            "", // No HostID for sub-tenants
                            "Sub: " + subTenant.getId() + " " + subTenant.getFullName(),
                            "", // No PropertyID for sub-tenants
                            "", // No Period for sub-tenants
                            "", // No Start Date for sub-tenants
                            "", // No End Date for sub-tenants
                            "", // No Fee for sub-tenants
                            ""); // No Status for sub-tenants
                }
            }

            // Print a dividing line between agreements
            System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        }

        // Print the footer
        System.out.println("======================================================================================================================================================================================");

    }

    /**
     * Displays the search menu for rental agreements.
     */
    public void displaySearchMenu() {
        boolean exitSearch = false;

        while (!exitSearch) {
            // Print the search menu
            System.out.println("=========================================");
            System.out.println("|          Search Rental Agreement      |");
            System.out.println("=========================================");
            System.out.println("| 1. Search Rental Agreement by ID      |");
            System.out.println("| 2. Search Rental Agreement by HostID  |");
            System.out.println("| 3. Search Rental Agreement by TenantID|");
            System.out.println("| 4. Search Rental Agreement by OwnerID |");
            System.out.println("| 5. Search Agreement by PropertyID     |");
            System.out.println("| 6. Search Agreement by Status         |");
            System.out.println("| 7. Exit Search                        |");
            System.out.println("=========================================");
            System.out.println("Enter your choice: ");
            try {
                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                switch (choice) {
                    case 1:
                        System.out.println("Enter Rental Agreement ID: ");
                        String agreementID = scanner.nextLine();
                        searchByAgreementID(agreementID);
                        System.out.println("Press Enter to continue...");
                        scanner.nextLine();
                        break;
                    case 2:
                        System.out.println("Enter Host ID: ");
                        String hostID = scanner.nextLine();
                        searchByHostID(hostID);
                        System.out.println("Press Enter to continue...");
                        scanner.nextLine();
                        break;
                    case 3:
                        System.out.println("Enter Tenant ID: ");
                        String tenantID = scanner.nextLine();
                        searchByTenantID(tenantID);
                        System.out.println("Press Enter to continue...");
                        scanner.nextLine();
                        break;
                    case 4:
                        System.out.println("Enter Owner ID: ");
                        String ownerID = scanner.nextLine();
                        searchByOwnerID(ownerID);
                        System.out.println("Press Enter to continue...");
                        scanner.nextLine();
                        break;
                    case 5:
                        System.out.println("Enter Property ID: ");
                        String propertyID = scanner.nextLine();
                        searchByPropertyID(propertyID);
                        System.out.println("Press Enter to continue...");
                        scanner.nextLine();
                        break;
                    case 6:
                        System.out.println("Enter Status. Please enter 'NEW' or 'ACTIVE' or 'COMPLETED': ");
                        String status = scanner.nextLine();
                        searchByStatus(status);
                        System.out.println("Press Enter to continue...");
                        scanner.nextLine();
                        break;
                    case 7:
                        System.out.println("Exiting Search...");
                        exitSearch = true;
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    /**
     * Searches for rental agreements by property ID.
     *
     * @param propertyID The property ID to search for.
     */
    private void searchByPropertyID(String propertyID) {
        HashSet<RentalAgreement> agreement = rentalAgreement.getRentalAgreementByProperty(propertyID);
        if (agreement != null) {
            printTable(agreement);
        } else {
            System.out.println("Rental Agreement not found.");
        }
    }

    /**
     * Searches for a rental agreement by its ID.
     *
     * @param id The rental agreement ID to search for.
     */
    public void searchByAgreementID(String id) {
        RentalAgreement agreement = rentalAgreement.getRentalAgreementByID(id);
        if (agreement != null) {
            HashSet<RentalAgreement> rentalAgreements = new HashSet<>();
            rentalAgreements.add(agreement);
            printTable(rentalAgreements);
        } else {
            System.out.println("Rental Agreement not found.");
        }
    }

    /**
     * Searches for rental agreements by host ID.
     *
     * @param id The host ID to search for.
     */
    public void searchByHostID(String id) {
        HashSet<RentalAgreement> agreement = rentalAgreement.getRentalAgreementByHost(id);
        if (agreement != null) {
            printTable(agreement);
        } else {
            System.out.println("Rental Agreement not found.");
        }
    }

    /**
     * Searches for rental agreements by tenant ID.
     *
     * @param tenantID The tenant ID to search for.
     */
    private void searchByTenantID(String tenantID) {
        HashSet<RentalAgreement> agreement = rentalAgreement.getRentalAgreementByTenant(tenantID);
        if (agreement != null) {
            printTable(agreement);
        } else {
            System.out.println("Rental Agreement not found.");
        }
    }

    /**
     * Searches for rental agreements by owner ID.
     *
     * @param ownerID The owner ID to search for.
     */
    private void searchByOwnerID(String ownerID) {
        HashSet<RentalAgreement> agreement = rentalAgreement.getRentalAgreementByOwner(ownerID);
        if (agreement != null) {
            printTable(agreement);
        } else {
            System.out.println("Rental Agreement not found.");
        }
    }

    /**
     * Searches for rental agreements by status.
     *
     * @param status The status to search for.
     */
    private void searchByStatus(String status) {
        // Convert the status to uppercase
        status = status.toUpperCase();

        // Check if the status is valid
        if (status.equals("ACTIVE") || status.equals("COMPLETED") || status.equals("NEW")) {
            // Filter the rental agreements by status
            HashSet<RentalAgreement> agreement = rentalAgreement.getRentalAgreementByStatus(status);
            // Print the rental agreements
            printTable(agreement);
        } else {
            System.out.println("Invalid status. Please enter 'NEW' or 'ACTIVE' or 'COMPLETED'.");
        }
    }

    /**
     * Adds a new rental agreement.
     */
    private void addRentalAgreement() {
        try {
            System.out.println("Enter the Rental Agreement ID: ");
            String id = scanner.nextLine();
            if (id.isEmpty()) {
                throw new RuntimeException("Invalid Rental Agreement ID.");
            }
            if (!id.startsWith("RA")) {
                throw new RuntimeException("Rental Agreement ID should start with 'RA'.");
            }
            if (rentalAgreement.getRentalAgreementByID(id) != null) {
                throw new RuntimeException("Rental Agreement ID already exists.");
            }
            System.out.println("Enter the Owner ID: ");
            String ownerID = scanner.nextLine();
            Owner owner = ownerManager.getOwnerByID(ownerID);
            if (owner == null) {
                throw new RuntimeException("Owner not found.");
            }
            System.out.println("Enter the Host ID: ");
            String hostID = scanner.nextLine();
            Host host = hostManager.getHostByID(hostID);
            if (host == null) {
                throw new RuntimeException("Host not found.");
            }
            System.out.println("Enter the Main Tenant ID: ");
            String mainTenantID = scanner.nextLine();
            Tenant mainTenant = tenantManager.getTenantByID(mainTenantID);
            if (mainTenant == null) {
                throw new RuntimeException("Main Tenant not found.");
            }
            System.out.println("Add sub-tenants? (Y/N): ");
            String choice = scanner.nextLine();
            HashSet<Tenant> subTenants = new HashSet<>();
            while (choice.equalsIgnoreCase("Y")) {
                System.out.println("Enter the Sub-Tenant ID: ");
                String subTenantID = scanner.nextLine();
                Tenant subTenant = tenantManager.getTenantByID(subTenantID);
                if (subTenant == null) {
                    throw new RuntimeException("Sub-Tenant not found.");
                }
                subTenants.add(subTenant);
                System.out.println("Add another sub-tenant? (Y/N): ");
                choice = scanner.nextLine();
            }
            System.out.println("Enter the Property ID: ");
            String propertyID = scanner.nextLine();
            Property property = propertyManager.getPropertyByID(propertyID);
            if (property == null) {
                throw new RuntimeException("Property not found.");
            }
            if (property.getOwner() != owner) {
                throw new RuntimeException("Owner does not own the property.");
            }
            if(!property.getHostList().contains(host)){
                throw new RuntimeException("Host does not manage the property.");
            }
            if (property.getStatus().equals(Property.Status.RENTED)) {
                throw new RuntimeException("Property is rented.");
            }
            if (property.getStatus().equals(Property.Status.MAINTENANCE)) {
                throw new RuntimeException("Property is under maintenance.");
            }
            System.out.print("Enter the Period (DAILY, WEEKLY, MONTHLY, YEARLY): ");
            String periodInput = scanner.nextLine();
            RentalAgreement.Period period = RentalAgreement.Period.valueOf(periodInput.toUpperCase());
            System.out.print("Enter the Status (NEW, ACTIVE, COMPLETED): ");
            String statusInput = scanner.nextLine();
            RentalAgreement.Status status = RentalAgreement.Status.valueOf(statusInput.toUpperCase());
            System.out.println("Enter the Start Date (dd/MM/yyyy): ");
            String startDateInput = scanner.nextLine();
            System.out.println("Enter the End Date (dd/MM/yyyy): ");
            String endDateInput = scanner.nextLine();

            Date startDate = null;
            Date endDate = null;
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            try {
                startDate = formatter.parse(startDateInput);
                endDate = formatter.parse(endDateInput);
                // Now you can use startDate and endDate as Date objects
            } catch (ParseException e) {
                throw new RuntimeException("Invalid date format. Please enter the date in the format dd/MM/yyyy.");
            }
            System.out.println("Enter the Renting Fee: ");
            double rentingFee = scanner.nextDouble();
            scanner.nextLine(); // Consume the newline
            RentalAgreement newRentalAgreement = new RentalAgreement(id, owner, host, mainTenant, property, period, startDate, endDate, rentingFee, status);
            if (!subTenants.isEmpty()) {
                for (Tenant subTenant : subTenants) {
                    newRentalAgreement.addSubTenant(subTenant);
                }
            }
            if (rentalAgreement.addRentalAgreement(newRentalAgreement)) {
                System.out.println("Rental Agreement added successfully.");
            } else {
                System.out.println("Failed to add Rental Agreement.");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Invalid input. Please try again.");
        }
    }

    /**
     * Deletes a rental agreement based on user input.
     * Prompts the user for the rental agreement ID and confirms the deletion.
     * If the rental agreement ID is valid and the user confirms, the rental agreement is deleted.
     * Otherwise, an appropriate message is displayed.
     */
    private void deleteRentalAgreement() {
        try {
            System.out.println("Enter the Rental Agreement ID: ");
            String id = scanner.nextLine();
            if (rentalAgreement.getRentalAgreementByID(id) == null) {
                throw new RuntimeException("Invalid Rental Agreement ID.");
            }
            System.out.println("Are you sure you want to delete the Rental Agreement? (Y/N): ");
            String choice = scanner.nextLine();
            if (!choice.equalsIgnoreCase("Y")) {
                System.out.println("Rental Agreement not deleted.");
                return;
            }
            if (rentalAgreement.deleteRentalAgreement(id)) {
                System.out.println("Rental Agreement deleted successfully.");
            } else {
                System.out.println("Failed to delete Rental Agreement.");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Invalid input. Please try again.");
        }

    }

    /**
     * Updates a rental agreement based on user input.
     * Prompts the user for the rental agreement ID and allows updating various fields.
     * If the rental agreement ID is valid, the user can update the owner, host, main tenant, sub-tenants, property, period, status, start date, end date, and renting fee.
     * Otherwise, an appropriate message is displayed.
     */
    private void updateRentalAgreement() {
        try {
            System.out.println("Enter the Rental Agreement ID: ");
            String id = scanner.nextLine();
            RentalAgreement agreement = rentalAgreement.getRentalAgreementByID(id);
            if (agreement == null) {
                throw new RuntimeException("Invalid Rental Agreement ID.");
            }

            Owner owner;
            Host host;
            Tenant mainTenant;
            HashSet<Tenant> subTenants;
            Property property;
            RentalAgreement.Period period;
            RentalAgreement.Status status;
            Date startDate;
            Date endDate;
            double rentingFee;


            System.out.println("Update owner? (Y/N): ");
            String choice = scanner.nextLine();
            if (choice.equalsIgnoreCase("Y")) {
                System.out.println("Enter the Owner ID: ");
                String ownerID = scanner.nextLine();
                owner = ownerManager.getOwnerByID(ownerID);
                if (owner == null) {
                    throw new RuntimeException("Owner not found.");
                }
            } else if (choice.equalsIgnoreCase("N")) {
                owner = agreement.getOwner();
            } else {
                throw new RuntimeException("Invalid input.");
            }

            System.out.println("Update host? (Y/N): ");
            choice = scanner.nextLine();
            if (choice.equalsIgnoreCase("Y")) {
                System.out.println("Enter the Host ID: ");
                String hostID = scanner.nextLine();
                host = hostManager.getHostByID(hostID);
                if (host == null) {
                    throw new RuntimeException("Host not found.");
                }
            } else if (choice.equalsIgnoreCase("N")) {
                host = agreement.getHost();
            } else {
                throw new RuntimeException("Invalid input.");
            }

            System.out.println("Update main tenant? (Y/N): ");
            choice = scanner.nextLine();
            if (choice.equalsIgnoreCase("Y")) {
                System.out.println("Enter the Main Tenant ID: ");
                String mainTenantID = scanner.nextLine();
                mainTenant = tenantManager.getTenantByID(mainTenantID);
                if (mainTenant == null) {
                    throw new RuntimeException("Main Tenant not found.");
                }
            } else if (choice.equalsIgnoreCase("N")) {
                mainTenant = agreement.getMainTenant();
            } else {
                throw new RuntimeException("Invalid input.");
            }
            System.out.println("Add more sub-tenants? (Y/N): ");
            choice = scanner.nextLine();
            subTenants = new HashSet<>(agreement.getSubTenant());
            while (choice.equalsIgnoreCase("Y")) {
                System.out.println("Enter the Sub-Tenant ID: ");
                String subTenantID = scanner.nextLine();
                Tenant subTenant = tenantManager.getTenantByID(subTenantID);
                if (subTenant == null) {
                    throw new RuntimeException("Sub-Tenant not found.");
                }
                subTenants.add(subTenant);
                System.out.println("Add another sub-tenant? (Y/N): ");
                choice = scanner.nextLine();
            }

            System.out.println("Delete sub-tenants? (DeleteAll/ByID/N): ");
            choice = scanner.nextLine();
            if (choice.equalsIgnoreCase("DeleteAll")) {
                subTenants.clear();
            } else if (choice.equalsIgnoreCase("ByID")) {
                System.out.println("Enter the Sub-Tenant ID: ");
                String subTenantID = scanner.nextLine();
                Tenant subTenant = tenantManager.getTenantByID(subTenantID);
                if (subTenant == null) {
                    throw new RuntimeException("Sub-Tenant not found.");
                }
                subTenants.remove(subTenant);
            } else if (choice.equalsIgnoreCase("N")) {
                System.out.println("No sub-tenants deleted.");
            } else {
                throw new RuntimeException("Invalid input.");
            }


            System.out.println("Update the Property ID (Y/N): ");
            choice = scanner.nextLine();
            if (choice.equalsIgnoreCase("Y")) {
                System.out.println("Enter the Property ID: ");
                String propertyID = scanner.nextLine();
                property = propertyManager.getPropertyByID(propertyID);
                if (property == null) {
                    throw new RuntimeException("Property not found.");
                }
                if (property.getOwner() != owner) {
                    throw new RuntimeException("Owner does not own the property.");
                }
            } else if (choice.equalsIgnoreCase("N")) {
                if (agreement.getProperty().getOwner() != owner) {
                    throw new RuntimeException("Owner does not own the property.");
                }
                if(!agreement.getProperty().getHostList().contains(host)){
                    throw new RuntimeException("Host does not manage the property.");
                }
                property = agreement.getProperty();
            } else {
                throw new RuntimeException("Invalid input.");
            }

            System.out.println("Update the Period (Y/N): ");
            choice = scanner.nextLine();
            if (choice.equalsIgnoreCase("Y")) {
                System.out.print("Enter the Period (DAILY, WEEKLY, MONTHLY, YEARLY): ");
                String periodInput = scanner.nextLine();
                period = RentalAgreement.Period.valueOf(periodInput.toUpperCase());
            } else if (choice.equalsIgnoreCase("N")) {
                period = agreement.getPeriod();
            } else {
                throw new RuntimeException("Invalid input.");
            }
            System.out.println("Update the Status (Y/N): ");
            choice = scanner.nextLine();
            if (choice.equalsIgnoreCase("Y")) {
                System.out.print("Enter the Status (NEW, ACTIVE, COMPLETED): ");
                String statusInput = scanner.nextLine();
                status = RentalAgreement.Status.valueOf(statusInput.toUpperCase());
            } else if (choice.equalsIgnoreCase("N")) {
                status = agreement.getStatus();
            } else {
                throw new RuntimeException("Invalid input.");
            }
            System.out.println("Update the Start Date (Y/N): ");
            choice = scanner.nextLine();
            if (choice.equalsIgnoreCase("Y")) {
                System.out.println("Enter the Start Date (dd/MM/yyyy): ");
                String startDateInput = scanner.nextLine();
                startDate = null;
                SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
                try {
                    startDate = formatter.parse(startDateInput);
                    // Now you can use startDate and endDate as Date objects
                } catch (ParseException e) {
                    throw new RuntimeException("Invalid date format. Please enter the date in the format dd/MM/yyyy.");
                }
            } else if (choice.equalsIgnoreCase("N")) {
                startDate = agreement.getStartDate();
            } else {
                throw new RuntimeException("Invalid input.");
            }
            System.out.println("Update the End Date (Y/N): ");
            choice = scanner.nextLine();
            if (choice.equalsIgnoreCase("Y")) {
                System.out.println("Enter the End Date (dd/MM/yyyy): ");
                String endDateInput = scanner.nextLine();
                endDate = null;
                SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
                try {
                    endDate = formatter.parse(endDateInput);
                    // Now you can use startDate and endDate as Date objects
                } catch (ParseException e) {
                    System.out.println("Invalid date format. Please enter the date in the format dd/MM/yyyy.");
                    updateRentalAgreement();
                }
            } else if (choice.equalsIgnoreCase("N")) {
                endDate = agreement.getEndDate();
            } else {
                throw new RuntimeException("Invalid input.");
            }
            System.out.println("Update the Renting Fee (Y/N): ");
            choice = scanner.nextLine();
            if (choice.equalsIgnoreCase("Y")) {
                System.out.println("Enter the Renting Fee: ");
                rentingFee = scanner.nextDouble();
                scanner.nextLine(); // Consume the newline
            } else if (choice.equalsIgnoreCase("N")) {
                rentingFee = agreement.getRentingFee();
            } else {
                throw new RuntimeException("Invalid input.");
            }
            RentalAgreement updatedRentalAgreement = new RentalAgreement(id, owner, host, mainTenant, property, period, startDate, endDate, rentingFee, status);
            if (!subTenants.isEmpty()) {
                for (Tenant subTenant : subTenants) {
                    updatedRentalAgreement.addSubTenant(subTenant);
                }
            }
            if (rentalAgreement.updateRentalAgreement(updatedRentalAgreement)) {
                System.out.println("Rental Agreement updated successfully.");
            } else {
                System.out.println("Failed to update Rental Agreement.");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Invalid input. Please try again.");
        }

    }

}
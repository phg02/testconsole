package viewer;

import controller.impl.RentalManagerImpl;
import model.RentalAgreement;
import model.Tenant;

import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class RentalAgreementManagementViewer {
    private final RentalManagerImpl rentalAgreement;
    private final Scanner scanner = new Scanner(System.in);
    private final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    public RentalAgreementManagementViewer(RentalManagerImpl rentalAgreement){
        this.rentalAgreement = rentalAgreement;
    }

    public void printRentalAgreementManagementMenu(){
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

    public void rentalAgreementViewerManager(){
        System.out.println("You have chosen to check the tenant dashboard.");
        boolean exitRentalAgreement = false;
        try{
            while (!exitRentalAgreement) {
                printRentalAgreementManagementMenu();
                int choiceRental = scanner.nextInt();
                scanner.nextLine();
                switch (choiceRental) {
                    case 1:
                        System.out.println("Add Rental Agreement");
                        break;
                    case 2:
                        System.out.println("Update Rental Agreement");
                        break;
                    case 3:
                        System.out.println("Delete Rental Agreement");
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
        }catch (Exception e){
            System.out.println("Invalid input. Please try again.");
        }
    }

    public void printRentalAgreements(){
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
                    break;
                case 2:
                    System.out.println("Sorted by Host ID:");
                    printTableList(rentalAgreement.getAllRentalAgreementsSortByHost());
                    break;
                case 3:
                    System.out.println("Sorted by Tenant ID:");
                    printTableList(rentalAgreement.getAllRentalAgreementsSortByTenant());
                    break;
                case 4:
                    System.out.println("Sorted by Owner ID:");
                    printTableList(rentalAgreement.getAllRentalAgreementsSortByOwner());
                    break;
                case 5:
                    System.out.println("Sorted by Property ID:");
                    printTableList(rentalAgreement.getAllRentalAgreementsSortByProperty());
                    break;
                case 6:
                    System.out.println("Sorted by Start Date:");
                    printTableList(rentalAgreement.getAllRentalAgreementsSortByStartDate());
                    break;
                case 7:
                    System.out.println("Sorted by End Date:");
                    printTableList(rentalAgreement.getAllRentalAgreementsSortByEndDate());
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

    public void printTable(HashSet<RentalAgreement> rentalAgreements){
        // Print the table header
        System.out.println("==================================================================================================================================================================================");
        System.out.printf("| %-12s | %-25s | %-25s | %-25s | %-12s | %-8s | %-12s | %-12s | %-10s | %-10s |\n",
                "AgreementID", "OwnerID", "HostID", "Tenants", "PropertyID", "Period", "Start Date", "End Date", "Fee", "Status");
        System.out.println("==================================================================================================================================================================================");

// Loop through and print each rental agreement
        for (RentalAgreement agreement : rentalAgreements) {
            // Print the main rental agreement row
            System.out.printf("| %-12s | %-25s | %-25s | %-25s | %-12s | %-8s | %-12s | %-12s | %-10.2f | %-10s |\n",
                    agreement.getId(),
                    agreement.getOwner().getId() + " " + agreement.getOwner().getFullName(),
                    agreement.getHost().getId() + " " + agreement.getHost().getFullName(),
                    "Main: "+agreement.getMainTenant().getId() + " " + agreement.getMainTenant().getFullName(),
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
            System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        }

// Print the footer
        System.out.println("==================================================================================================================================================================================");
    }

    public void printTableList(List<RentalAgreement> rentalAgreements){
        // Print the table header
        System.out.println("==================================================================================================================================================================================");
        System.out.printf("| %-12s | %-25s | %-25s | %-25s | %-12s | %-8s | %-12s | %-12s | %-10s | %-10s |\n",
                "AgreementID", "OwnerID", "HostID", "Tenants", "PropertyID", "Period", "Start Date", "End Date", "Fee", "Status");
        System.out.println("==================================================================================================================================================================================");

// Loop through and print each rental agreement
        for (RentalAgreement agreement : rentalAgreements) {
            // Print the main rental agreement row
            System.out.printf("| %-12s | %-25s | %-25s | %-25s | %-12s | %-8s | %-12s | %-12s | %-10.2f | %-10s |\n",
                    agreement.getId(),
                    agreement.getOwner().getId() + " " + agreement.getOwner().getFullName(),
                    agreement.getHost().getId() + " " + agreement.getHost().getFullName(),
                    "Main: "+agreement.getMainTenant().getId() + " " + agreement.getMainTenant().getFullName(),
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
            System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        }

// Print the footer
        System.out.println("==================================================================================================================================================================================");

    }
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
            try{
                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                switch (choice) {
                    case 1:
                        System.out.println("Enter Rental Agreement ID: ");
                        String agreementID = scanner.nextLine();
                        searchByAgreementID(agreementID);
                        break;
                    case 2:
                        System.out.println("Enter Host ID: ");
                        String hostID = scanner.nextLine();
                        searchByHostID(hostID);
                        break;
                    case 3:
                        System.out.println("Enter Tenant ID: ");
                        String tenantID = scanner.nextLine();
                        searchByTenantID(tenantID);
                        break;
                    case 4:
                        System.out.println("Enter Owner ID: ");
                        String ownerID = scanner.nextLine();
                        searchByOwnerID(ownerID);
                        break;
                    case 5:
                        System.out.println("Enter Property ID: ");
                        String propertyID = scanner.nextLine();
                        searchByPropertyID(propertyID);
                        break;
                    case 6:
                        System.out.println("Enter Status. Please enter 'NEW' or 'ACTIVE' or 'COMPLETED': ");
                        String status = scanner.nextLine();
                        searchByStatus(status);
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

    private void searchByPropertyID(String propertyID) {
        HashSet<RentalAgreement> agreement = rentalAgreement.getRentalAgreementByProperty(propertyID);
        if(agreement != null) {
            printTable(agreement);
        }else{
            System.out.println("Rental Agreement not found.");
        }
    }


    public void searchByAgreementID(String id){
        RentalAgreement agreement = rentalAgreement.getRentalAgreementByID(id);
        if(agreement != null){
            HashSet<RentalAgreement> rentalAgreements = new HashSet<>();
            rentalAgreements.add(agreement);
            printTable(rentalAgreements);
        }else{
            System.out.println("Rental Agreement not found.");
        }
    }

    public void searchByHostID(String id){
        HashSet<RentalAgreement> agreement = rentalAgreement.getRentalAgreementByHost(id);
        if(agreement != null) {
            printTable(agreement);
        }else{
            System.out.println("Rental Agreement not found.");
        }
    }

    private void searchByTenantID(String tenantID) {
        HashSet<RentalAgreement> agreement = rentalAgreement.getRentalAgreementByTenant(tenantID);
        if(agreement != null) {
            printTable(agreement);
        }else{
            System.out.println("Rental Agreement not found.");
        }
    }

    private void searchByOwnerID(String ownerID) {
        HashSet<RentalAgreement> agreement = rentalAgreement.getRentalAgreementByOwner(ownerID);
        if(agreement != null) {
            printTable(agreement);
        }else{
            System.out.println("Rental Agreement not found.");
        }
    }


    private void searchByStatus(String status){
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

}
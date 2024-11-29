package viewer;
/*
  @author <Nguyen Minh Phuong - s4063236>
 */

import controller.impl.TenantManagerImpl;
import model.Payment;
import model.RentalAgreement;
import model.Tenant;

import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.time.ZoneId;
import java.util.Scanner;

/**
 * Viewer class for managing tenants.
 * Provides methods to display and interact with tenant data.
 */
public class TenantManagementViewer {
    private TenantManagerImpl tenantManager;
    private final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    /**
     * Constructor to initialize the tenant manager.
     *
     * @param tenantManager The tenant manager implementation.
     */
    public TenantManagementViewer(TenantManagerImpl tenantManager) {
        this.tenantManager = tenantManager;
    }

    /**
     * Prints the tenant management menu options to the console.
     */
    public void printTenantManagementMenu() {
        System.out.println("==========================================");
        System.out.println("|           Tenant Management            |");
        System.out.println("==========================================");
        System.out.println("|  1. Add Tenant                         |");
        System.out.println("|  2. Update Tenant                      |");
        System.out.println("|  3. Delete Tenant                      |");
        System.out.println("|  4. View All Tenants                   |");
        System.out.println("|  5. Search Tenant by ID                |");
        System.out.println("|  6. Search Tenant by Full Name         |");
        System.out.println("|  7. Search Tenant by Contact Info      |");
        System.out.println("|  8. Exit                               |");
        System.out.println("==========================================");
        System.out.println("Enter your choice: ");
    }

    /**
     * Manages the tenant viewer operations based on user input.
     */
    public void tenantViewerManager() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Tenant dashboard.");
        boolean exitTenant = false;
        try {
            while (!exitTenant) {
                printTenantManagementMenu();
                int choiceTenant = scanner.nextInt();
                scanner.nextLine();
                switch (choiceTenant) {
                    case 1:
                        System.out.println("Add Tenant");
                        System.out.println("Functionality not implemented yet due to assignment requirements.");
                        break;
                    case 2:
                        System.out.println("Update Tenant");
                        System.out.println("Functionality not implemented yet due to assignment requirements.");
                        break;
                    case 3:
                        System.out.println("Delete Tenant");
                        System.out.println("Functionality not implemented yet due to assignment requirements.");
                        break;
                    case 4:
                        System.out.println("View All Tenants");
                        printAllTenants();
                        System.out.println("Press Enter to continue...");
                        scanner.nextLine();
                        break;
                    case 5:
                        System.out.println("Search Tenant by ID");
                        String id = scanner.nextLine();
                        printTenantByID(id);
                        System.out.println("Press Enter to continue...");
                        scanner.nextLine();
                        break;
                    case 6:
                        System.out.println("Search Tenant by Full Name");
                        String fullName = scanner.nextLine();
                        printTenantByFullName(fullName);
                        System.out.println("Press Enter to continue...");
                        scanner.nextLine();
                        break;
                    case 7:
                        System.out.println("Search Tenant by Contact Info");
                        String contactInfo = scanner.nextLine();
                        printTenantByContactInformation(contactInfo);
                        System.out.println("Press Enter to continue...");
                        scanner.nextLine();
                        break;
                    case 8:
                        System.out.println("Exiting Tenant Management");
                        exitTenant = true;
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                        break;
                }
            }
        } catch (Exception e) {
            System.out.println("Invalid input. Please try again.");
        }
    }

    /**
     * Prints all tenants in a tabular format.
     */
    public void printAllTenants() {
        printTable(tenantManager.getAllTenants());
    }

    /**
     * Prints a tenant by their contact information.
     *
     * @param contactInformation The contact information of the tenant.
     */
    public void printTenantByContactInformation(String contactInformation) {
        Tenant tenant = tenantManager.getTenantByContactInformation(contactInformation);
        if (tenant != null) {
            HashSet<Tenant> tenants = new HashSet<>();
            tenants.add(tenant);
            printTable(tenants);
        } else {
            System.out.println("Tenant not found");
        }
    }

    /**
     * Prints a tenant by their ID.
     *
     * @param id The ID of the tenant.
     */
    public void printTenantByID(String id) {
        Tenant tenant = tenantManager.getTenantByID(id);
        if (tenant != null) {
            HashSet<Tenant> tenants = new HashSet<>();
            tenants.add(tenant);
            printTable(tenants);
        } else {
            System.out.println("Tenant not found");
        }
    }

    /**
     * Prints tenants by their full name.
     *
     * @param fullName The full name of the tenant.
     */
    public void printTenantByFullName(String fullName) {
        HashSet<Tenant> tenants = tenantManager.getTenantByFullName(fullName);
        if (!tenants.isEmpty()) {
            printTable(tenants);
        } else {
            System.out.println("No tenant with the name " + fullName + " was found");
        }
    }

    /**
     * Prints a table of tenants with their details.
     *
     * @param tenants The set of tenants to be printed.
     */
    public void printTable(HashSet<Tenant> tenants) {
        System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.printf("| %-10s | %-20s | %-15s | %-30s | %-30s | %-30s |\n",
                "Tenant ID", "Full Name", "Date of Birth", "Contact Info", "Rental Agreement IDs", "Payment IDs");
        System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------");
        for (Tenant tenant : tenants) {
            String[] rentalIDs = new String[tenant.getRentalAgreements().size()];
            StringBuilder rentalIdString = new StringBuilder();
            int i = 0;
            for (RentalAgreement rental : tenant.getRentalAgreements()) {
                rentalIDs[i] = rental.getId();
                i++;
            }
            for (i = 0; i < rentalIDs.length - 2; i++) {
                rentalIdString.append(rentalIDs[i]).append(", ");
            }
            rentalIdString.append(rentalIDs[rentalIDs.length - 1]);
            String[] paymentIDs = new String[tenant.getPayments().size()];
            StringBuilder paymentIdString = new StringBuilder();
            int z = 0;
            for (Payment payment : tenant.getPayments()) {
                paymentIDs[z] = payment.getId();
                z++;
            }
            for (z = 0; z < paymentIDs.length - 2; z++) {
                paymentIdString.append(paymentIDs[z]).append(", ");
            }
            paymentIdString.append(paymentIDs[paymentIDs.length - 1]);
            System.out.printf("| %-10s | %-20s | %-15s | %-30s | %-30s | %-30s |\n",
                    tenant.getId(), tenant.getFullName(), dtf.format(tenant.getDateOfBirth().toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime()),
                    tenant.getContactInformation(),
                    rentalIdString,
                    paymentIdString);
        }
        System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------");
    }
}
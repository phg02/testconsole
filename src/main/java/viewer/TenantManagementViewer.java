package viewer;

import controller.impl.TenantManagerImpl;
import model.Payment;
import model.RentalAgreement;
import model.Tenant;

import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.time.ZoneId;
import java.util.Scanner;

public class TenantManagementViewer {
    private TenantManagerImpl tenantManager;
    private final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public TenantManagementViewer(TenantManagerImpl tenantManager){
        this.tenantManager = tenantManager;
    }

    public void printTenantManagementMenu(){
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

    public void tenantViewerManager(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("You have chosen to check the tenant dashboard.");
        boolean exitTenant = false;
        try{
            while (!exitTenant) {
                printTenantManagementMenu();
                int choiceTenant = scanner.nextInt();
                scanner.nextLine();
                switch (choiceTenant) {
                    case 1:
                        System.out.println("Add Tenant");
                        break;
                    case 2:
                        System.out.println("Update Tenant");
                        break;
                    case 3:
                        System.out.println("Delete Tenant");
                        break;
                    case 4:
                        System.out.println("View All Tenants");
                        printAllTenants();
                        break;
                    case 5:
                        System.out.println("Search Tenant by ID");
                        String id = scanner.nextLine();
                        printTenantByID(id);
                        break;
                    case 6:
                        System.out.println("Search Tenant by Full Name");
                        String fullName = scanner.nextLine();
                        printTenantByFullName(fullName);
                        break;
                    case 7:
                        System.out.println("Search Tenant by Contact Info");
                        String contactInfo = scanner.nextLine();
                        printTenantByContactInformation(contactInfo);
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
        }catch (Exception e){
            System.out.println("Invalid input. Please try again.");
        }
    }

    public void printAllTenants(){
        printTable(tenantManager.getAllTenants());
    }

    public void printTenantByContactInformation(String contactInformation){
        Tenant tenant = tenantManager.getTenantByContactInformation(contactInformation);
        if(tenant != null) {
            HashSet<Tenant> tenants = new HashSet<>();
            tenants.add(tenant);
            printTable(tenants);
        }
        else{
            System.out.println("Tenant not found");
        }
    }

    public void printTenantByID(String id){
        Tenant tenant = tenantManager.getTenantByID(id);
        if(tenant != null) {
            HashSet<Tenant> tenants = new HashSet<>();
            tenants.add(tenant);
            printTable(tenants);
        }
        else{
            System.out.println("Tenant not found");
        }
    }

    public void printTenantByFullName(String fullName){
        HashSet<Tenant> tenants = tenantManager.getTenantByFullName(fullName);
        if(!tenants.isEmpty()) {
            printTable(tenants);
        }
        else{
            System.out.println("No tenant with the name "+ fullName + " was found");
        }
    }


    public void printTable(HashSet<Tenant> tenants) {
        System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.printf("| %-10s | %-20s | %-15s | %-30s | %-30s | %-30s |\n",
                "Tenant ID", "Full Name", "Date of Birth", "Contact Info", "Rental Agreement IDs", "Payment IDs");
        System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------");
        for (Tenant tenant : tenants ) {
            String[] rentalIDs = new String[tenant.getRentalAgreements().size()];
            StringBuilder rentalIdString = new StringBuilder();
            int i = 0;
            for (RentalAgreement rental : tenant.getRentalAgreements()){
                rentalIDs[i]= rental.getId();
                i++;
            }
            for(i = 0; i < rentalIDs.length-2; i++){
                rentalIdString.append(rentalIDs[i]).append(", ");
            }
            rentalIdString.append(rentalIDs[rentalIDs.length - 1]);
            String[] paymentIDs = new String[tenant.getPayments().size()];
            StringBuilder paymentIdString = new StringBuilder();
            int z = 0;
            for (Payment payment : tenant.getPayments()){
                paymentIDs[z]= payment.getId();
                z++;
            }
            for(z = 0; z < paymentIDs.length-2; z++){
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
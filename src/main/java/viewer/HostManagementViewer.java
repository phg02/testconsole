package viewer;

import controller.impl.HostManagerImpl;
import model.Host;
import model.Owner;
import model.Property;
import model.RentalAgreement;

import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.time.ZoneId;
import java.util.Scanner;

public class HostManagementViewer {
    private HostManagerImpl hostManager;
    private final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public HostManagementViewer(HostManagerImpl hostManager) {
        this.hostManager = hostManager;
    }

    public void printHostManagementMenu(){
        System.out.println("==========================================");
        System.out.println("|           Host Management              |");
        System.out.println("==========================================");
        System.out.println("|  1. Add Host                           |");
        System.out.println("|  2. Update Host                        |");
        System.out.println("|  3. Delete Host                        |");
        System.out.println("|  4. View All Hosts                     |");
        System.out.println("|  5. Search Host by ID                  |");
        System.out.println("|  6. Search Host by Full Name           |");
        System.out.println("|  7. Search Host by Contact Info        |");
        System.out.println("|  8. Exit                               |");
        System.out.println("==========================================");
        System.out.println("Enter your choice: ");
    }

    public void hostViewerManager(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("You have chosen to check the host dashboard.");
        boolean exitHost = false;
        try{
            while (!exitHost) {
                printHostManagementMenu();
                int choiceHost = scanner.nextInt();
                scanner.nextLine();
                switch (choiceHost) {
                    case 1:
                        System.out.println("Add Host");
                        break;
                    case 2:
                        System.out.println("Update Host");
                        break;
                    case 3:
                        System.out.println("Delete Host");
                        break;
                    case 4:
                        System.out.println("View All Hosts");
                        printAllHosts();
                        break;
                    case 5:
                        System.out.println("Search Host by ID");
                        String id = scanner.nextLine();
                        printHostByID(id);
                        break;
                    case 6:
                        System.out.println("Search Host by Full Name");
                        String fullName = scanner.nextLine();
                        printHostByFullName(fullName);
                        break;
                    case 7:
                        System.out.println("Search Host by Contact Info");
                        String contactInfo = scanner.nextLine();
                        printHostByContactInformation(contactInfo);
                        break;
                    case 8:
                        System.out.println("Exiting Host Management");
                        exitHost = true;
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

    public void printAllHosts(){
        printTable(hostManager.getAllHosts());
    }

    public void printHostByContactInformation(String contactInformation){
        Host host = hostManager.getHostByContactInformation(contactInformation);
        if(host != null) {
            HashSet<Host> hosts = new HashSet<>();
            hosts.add(host);
            printTable(hosts);
        }
        else{
            System.out.println("Host not found");
        }
    }

    public void printHostByID(String id){
        Host host = hostManager.getHostByID(id);
        if(host != null) {
            HashSet<Host> hosts = new HashSet<>();
            hosts.add(host);
            printTable(hosts);
        }
        else{
            System.out.println("Host not found");
        }
    }

    public void printHostByFullName(String fullName){
        HashSet<Host> hosts = hostManager.getHostByFullName(fullName);
        if(!hosts.isEmpty()) {
            printTable(hosts);
        }
        else{
            System.out.println("No host with the name "+ fullName + " was found");
        }
    }

    public void printTable(HashSet<Host> hosts) {
        System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.printf("| %-10s | %-20s | %-15s | %-30s | %-30s | %-30s | %-30s |\n",
                "Host ID", "Full Name", "Date of Birth", "Contact Info", "Rental Agreement IDs", "Property IDs", "Cooperating Owner IDs");
        System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        for (Host host : hosts) {
            String[] rentalIDs = new String[host.getRentalAgreements().size()];
            StringBuilder rentalIdString = new StringBuilder();
            int i = 0;
            for (RentalAgreement rental : host.getRentalAgreements()) {
                rentalIDs[i] = rental.getId();
                i++;
            }
            for (i = 0; i < rentalIDs.length - 1; i++) {
                rentalIdString.append(rentalIDs[i]).append(", ");
            }
            if (rentalIDs.length > 0) {
                rentalIdString.append(rentalIDs[rentalIDs.length - 1]);
            }

            String[] propertyIDs = new String[host.getProperties().size()];
            StringBuilder propertyIdString = new StringBuilder();
            int j = 0;
            for (Property property : host.getProperties()) {
                propertyIDs[j] = property.getId();
                j++;
            }
            for (j = 0; j < propertyIDs.length - 1; j++) {
                propertyIdString.append(propertyIDs[j]).append(", ");
            }
            if (propertyIDs.length > 0) {
                propertyIdString.append(propertyIDs[propertyIDs.length - 1]);
            }

            String[] ownerIDs = new String[host.getCooperatingOwners().size()];
            StringBuilder ownerIdString = new StringBuilder();
            int k = 0;
            for (Owner owner : host.getCooperatingOwners()) {
                ownerIDs[k] = owner.getId();
                k++;
            }
            for (k = 0; k < ownerIDs.length - 1; k++) {
                ownerIdString.append(ownerIDs[k]).append(", ");
            }
            if (ownerIDs.length > 0) {
                ownerIdString.append(ownerIDs[ownerIDs.length - 1]);
            }

            System.out.printf("| %-10s | %-20s | %-15s | %-30s | %-30s | %-30s | %-30s |\n",
                    host.getId(), host.getFullName(), dtf.format(host.getDateOfBirth().toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime()),
                    host.getContactInformation(), rentalIdString, propertyIdString, ownerIdString);
        }
        System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
    }
}
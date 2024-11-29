package viewer;
/*
  @author <Nguyen Minh Phuong - s4063236>
 */

import controller.impl.HostManagerImpl;
import model.Host;
import model.Owner;
import model.Property;
import model.RentalAgreement;

import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.time.ZoneId;
import java.util.Scanner;

/**
 * Viewer class for managing hosts.
 * Provides methods to display and interact with host data.
 */
public class HostManagementViewer {
    private HostManagerImpl hostManager;
    private final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    /**
     * Constructor to initialize the host manager.
     *
     * @param hostManager The host manager implementation.
     */
    public HostManagementViewer(HostManagerImpl hostManager) {
        this.hostManager = hostManager;
    }

    /**
     * Prints the host management menu options to the console.
     */
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

    /**
     * Manages the host viewer operations based on user input.
     */
    public void hostViewerManager(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Host Management");
        boolean exitHost = false;
        try{
            while (!exitHost) {
                printHostManagementMenu();
                int choiceHost = scanner.nextInt();
                scanner.nextLine();
                switch (choiceHost) {
                    case 1:
                        System.out.println("Add Host");
                        System.out.println("Functionality not implemented yet due to assignment requirements.");
                        break;
                    case 2:
                        System.out.println("Update Host");
                        System.out.println("Functionality not implemented yet due to assignment requirements.");
                        break;
                    case 3:
                        System.out.println("Delete Host");
                        System.out.println("Functionality not implemented yet due to assignment requirements.");
                        break;
                    case 4:
                        System.out.println("View All Hosts");
                        printAllHosts();
                        System.out.println("Press Enter to continue...");
                        scanner.nextLine();
                        break;
                    case 5:
                        System.out.println("Search Host by ID");
                        String id = scanner.nextLine();
                        printHostByID(id);
                        System.out.println("Press Enter to continue...");
                        scanner.nextLine();
                        break;
                    case 6:
                        System.out.println("Search Host by Full Name");
                        String fullName = scanner.nextLine();
                        printHostByFullName(fullName);
                        System.out.println("Press Enter to continue...");
                        scanner.nextLine();
                        break;
                    case 7:
                        System.out.println("Search Host by Contact Info");
                        String contactInfo = scanner.nextLine();
                        printHostByContactInformation(contactInfo);
                        System.out.println("Press Enter to continue...");
                        scanner.nextLine();
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

    /**
     * Prints all hosts in a tabular format.
     */
    public void printAllHosts(){
        printTable(hostManager.getAllHosts());
    }

    /**
     * Prints a host by their contact information.
     *
     * @param contactInformation The contact information of the host.
     */
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

    /**
     * Prints a host by their ID.
     *
     * @param id The ID of the host.
     */
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

    /**
     * Prints hosts by their full name.
     *
     * @param fullName The full name of the host.
     */
    public void printHostByFullName(String fullName){
        HashSet<Host> hosts = hostManager.getHostByFullName(fullName);
        if(!hosts.isEmpty()) {
            printTable(hosts);
        }
        else{
            System.out.println("No host with the name "+ fullName + " was found");
        }
    }

    /**
     * Prints a table of hosts with their details.
     *
     * @param hosts The set of hosts to be printed.
     */
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
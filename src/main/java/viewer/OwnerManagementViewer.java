package viewer;

import controller.impl.OwnerManagerImpl;
import model.Host;
import model.Owner;
import model.Property;
import model.RentalAgreement;

import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.time.ZoneId;
import java.util.Scanner;

public class OwnerManagementViewer {
    private OwnerManagerImpl ownerManager;
    private final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public OwnerManagementViewer(OwnerManagerImpl ownerManager) {
        this.ownerManager = ownerManager;
    }public void printOwnerManagementMenu(){
        System.out.println("==========================================");
        System.out.println("|           Owner Management             |");
        System.out.println("==========================================");
        System.out.println("|  1. Add Owner                          |");
        System.out.println("|  2. Update Owner                       |");
        System.out.println("|  3. Delete Owner                       |");
        System.out.println("|  4. View All Owners                    |");
        System.out.println("|  5. Search Owner by ID                 |");
        System.out.println("|  6. Search Owner by Full Name          |");
        System.out.println("|  7. Search Owner by Contact Info       |");
        System.out.println("|  8. Exit                               |");
        System.out.println("==========================================");
        System.out.println("Enter your choice: ");
    }

    public void ownerViewerManager(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("You have chosen to check the owner dashboard.");
        boolean exitOwner = false;
        try{
            while (!exitOwner) {
                printOwnerManagementMenu();
                int choiceOwner = scanner.nextInt();
                scanner.nextLine();
                switch (choiceOwner) {
                    case 1:
                        System.out.println("Add Owner");
                        break;
                    case 2:
                        System.out.println("Update Owner");
                        break;
                    case 3:
                        System.out.println("Delete Owner");
                        break;
                    case 4:
                        System.out.println("View All Owners");
                        printAllOwners();
                        break;
                    case 5:
                        System.out.println("Search Owner by ID");
                        String id = scanner.nextLine();
                        printOwnerByID(id);
                        break;
                    case 6:
                        System.out.println("Search Owner by Full Name");
                        String fullName = scanner.nextLine();
                        printOwnerByFullName(fullName);
                        break;
                    case 7:
                        System.out.println("Search Owner by Contact Info");
                        String contactInfo = scanner.nextLine();
                        printOwnerByContactInformation(contactInfo);
                        break;
                    case 8:
                        System.out.println("Exiting Owner Management");
                        exitOwner = true;
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

    public void printAllOwners(){
        printTable(ownerManager.getAllOwners());
    }

    public void printOwnerByContactInformation(String contactInformation){
        Owner owner = ownerManager.getOwnerByContactInformation(contactInformation);
        if(owner != null) {
            HashSet<Owner> owners = new HashSet<>();
            owners.add(owner);
            printTable(owners);
        }
        else{
            System.out.println("Owner not found");
        }
    }

    public void printOwnerByID(String id){
        Owner owner = ownerManager.getOwnerByID(id);
        if(owner != null) {
            HashSet<Owner> owners = new HashSet<>();
            owners.add(owner);
            printTable(owners);
        }
        else{
            System.out.println("Owner not found");
        }
    }

    public void printOwnerByFullName(String fullName){
        HashSet<Owner> owners = ownerManager.getOwnerByFullName(fullName);
        if(!owners.isEmpty()) {
            printTable(owners);
        }
        else{
            System.out.println("No owner with the name "+ fullName + " was found");
        }
    }

    public void printTable(HashSet<Owner> owners) {
        System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.printf("| %-10s | %-20s | %-15s | %-30s | %-30s | %-30s | %-30s |\n",
                "Owner ID", "Full Name", "Date of Birth", "Contact Info", "Rental Agreement IDs", "Property IDs", "Cooperating Host IDs");
        System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        for (Owner owner : owners) {
            String[] rentalIDs = new String[owner.getRentalAgreements().size()];
            StringBuilder rentalIdString = new StringBuilder();
            int i = 0;
            for (RentalAgreement rental : owner.getRentalAgreements()) {
                rentalIDs[i] = rental.getId();
                i++;
            }
            for (i = 0; i < rentalIDs.length - 1; i++) {
                rentalIdString.append(rentalIDs[i]).append(", ");
            }
            if (rentalIDs.length > 0) {
                rentalIdString.append(rentalIDs[rentalIDs.length - 1]);
            }

            String[] propertyIDs = new String[owner.getProperties().size()];
            StringBuilder propertyIdString = new StringBuilder();
            int j = 0;
            for (Property property : owner.getProperties()) {
                propertyIDs[j] = property.getId();
                j++;
            }
            for (j = 0; j < propertyIDs.length - 1; j++) {
                propertyIdString.append(propertyIDs[j]).append(", ");
            }
            if (propertyIDs.length > 0) {
                propertyIdString.append(propertyIDs[propertyIDs.length - 1]);
            }

            String[] hostIDs = new String[owner.getCooperatingHosts().size()];
            StringBuilder hostIdString = new StringBuilder();
            int k = 0;
            for (Host host : owner.getCooperatingHosts()) {
                hostIDs[k] = host.getId();
                k++;
            }
            for (k = 0; k < hostIDs.length - 1; k++) {
                hostIdString.append(hostIDs[k]).append(", ");
            }
            if (hostIDs.length > 0) {
                hostIdString.append(hostIDs[hostIDs.length - 1]);
            }

            System.out.printf("| %-10s | %-20s | %-15s | %-30s | %-30s | %-30s | %-30s |\n",
                    owner.getId(), owner.getFullName(), dtf.format(owner.getDateOfBirth().toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime()),
                    owner.getContactInformation(), rentalIdString, propertyIdString, hostIdString);
        }
        System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
    }
}
package viewer;

import controller.impl.CommercialPropertyManagerImpl;
import controller.impl.ResidentialPropertyManagerImpl;
import model.*;

import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.time.ZoneId;
import java.util.Scanner;
import java.util.stream.Collectors;

public class PropertyManagementViewer {
    private CommercialPropertyManagerImpl commercialPropertyManager;
    private ResidentialPropertyManagerImpl residentialPropertyManager;
    private HashSet<Property> properties;

    private final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public PropertyManagementViewer(CommercialPropertyManagerImpl commercialPropertyManager,ResidentialPropertyManagerImpl residentialPropertyManager) {
        this.commercialPropertyManager = commercialPropertyManager;
        this.residentialPropertyManager = residentialPropertyManager;
        properties = new HashSet<>();
        properties.addAll(commercialPropertyManager.getAllCommercialProperties());
        properties.addAll(residentialPropertyManager.getAllResidentialProperties());
    }

    public void printPropertyManagementMenu(){
        System.out.println("==========================================");
        System.out.println("|         Property Management            |");
        System.out.println("==========================================");
        System.out.println("|  1. Add Property                       |");
        System.out.println("|  2. Update Property                    |");
        System.out.println("|  3. Delete Property                    |");
        System.out.println("|  4. View All Properties                |");
        System.out.println("|  5. View All Residential Properties    |");
        System.out.println("|  6. View All Commercial Properties     |");
        System.out.println("|  7. Search Property by ID              |");
        System.out.println("|  8. Search Property by Address         |");
        System.out.println("|  9. Exit                               |");
        System.out.println("==========================================");
        System.out.println("Enter your choice: ");
    }

    public void propertyViewerManager(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("You have chosen to check the property dashboard.");
        boolean exitProperty = false;
        try{
            while (!exitProperty) {
                printPropertyManagementMenu();
                int choiceProperty = scanner.nextInt();
                scanner.nextLine();
                switch (choiceProperty) {
                    case 1:
                        System.out.println("Add Property");
                        break;
                    case 2:
                        System.out.println("Update Property");
                        break;
                    case 3:
                        System.out.println("Delete Property");
                        break;
                    case 4:
                        System.out.println("View All Properties");
                        printAllProperties();
                        break;
                    case 5:
                        System.out.println("View All Residential Properties");
                        HashSet<Property> residentialProperties = properties.stream()
                                .filter(p -> p instanceof ResidentialProperty)
                                .collect(Collectors.toCollection(HashSet::new));
                        printResidentialProperties(residentialProperties);
                        break;
                    case 6:
                        System.out.println("View All Commercial Properties");
                        HashSet<Property> commercialProperties = properties.stream()
                                .filter(p -> p instanceof CommercialProperty)
                                .collect(Collectors.toCollection(HashSet::new));
                        printCommercialProperties(commercialProperties);
                        break;
                    case 7:
                        System.out.println("Search Property by ID");
                        String id = scanner.nextLine();
                        printPropertyByID(id);
                        break;
                    case 8:
                        System.out.println("Search Property by Address");
                        String address = scanner.nextLine();
                        printPropertyByAddress(address);
                        break;
                    case 9:
                        System.out.println("Exiting Property Management");
                        exitProperty = true;
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

    public void printAllProperties(){
        printTable(properties);
    }

    public void printPropertyByID(String id){
        Property property = properties.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst()
                .orElse(null);
        if(property != null) {
            HashSet<Property> propertySet = new HashSet<>();
            propertySet.add(property);
            printTable(propertySet);
        } else {
            System.out.println("Property not found");
        }
    }

    public void printPropertyByAddress(String address){
        HashSet<Property> propertySet = properties.stream()
                .filter(p -> p.getAddress().equals(address))
                .collect(Collectors.toCollection(HashSet::new));
        if(!propertySet.isEmpty()) {
            printTable(propertySet);
        } else {
            System.out.println("No property with the address " + address + " was found");
        }
    }

    public void printTable(HashSet<Property> properties) {
        System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.printf("| %-10s | %-50s | %-10s | %-15s | %-10s | %-30s |\n",
                "Property ID", "Address", "Pricing", "Status", "Owner ID", "Host IDs");
        System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------");
        for (Property property : properties) {
            String ownerIdString = property.getOwner().getId();

            String[] hostIDs = new String[property.getHostList().size()];
            StringBuilder hostIdString = new StringBuilder();
            int j = 0;
            for (Host host : property.getHostList()) {
                hostIDs[j] = host.getId();
                j++;
            }
            for (j = 0; j < hostIDs.length - 1; j++) {
                hostIdString.append(hostIDs[j]).append(", ");
            }
            if (hostIDs.length > 0) {
                hostIdString.append(hostIDs[hostIDs.length - 1]);
            }

            System.out.printf("| %-10s | %-50s | %-10.2f | %-15s | %-10s | %-30s |\n",
                    property.getId(), property.getAddress(), property.getPricing(), property.getStatus(), ownerIdString, hostIdString);
        }
        System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------");
    }

    public void printResidentialProperties(HashSet<Property> properties) {
        // Adjusted header/footer width to fully align with the table columns
        String headerFooter = "---------------------------------------------------------------------------------------------------------------------------------------------------------------------";

        // Print the table header
        System.out.println(headerFooter);
        System.out.printf("| %-12s | %-40s | %-10s | %-15s | %-12s | %-20s | %-9s | %-7s | %-12s |\n",
                "Property ID", "Address", "Pricing", "Status", "Owner ID", "Host IDs", "Bedrooms", "Garden", "Pet Friendly");
        System.out.println(headerFooter);

        // Loop through and print each residential property
        for (Property property : properties) {
            if (property instanceof ResidentialProperty) {
                // Get Owner ID
                String ownerIdString = property.getOwner().getId();

                // Get Host IDs as a comma-separated list
                String hostIdString = property.getHostList().stream()
                        .map(Host::getId)
                        .reduce((id1, id2) -> id1 + ", " + id2)
                        .orElse("None");

                // Print property details
                System.out.printf("| %-12s | %-40s | %-10.2f | %-15s | %-12s | %-20s | %-9d | %-7s | %-12s |\n",
                        property.getId(),
                        property.getAddress(),
                        property.getPricing(),
                        property.getStatus(),
                        ownerIdString,
                        hostIdString,
                        ((ResidentialProperty) property).getNumberOfBedrooms(),
                        ((ResidentialProperty) property).getHasGarden() ? "Yes" : "No",
                        ((ResidentialProperty) property).getPetFriendly() ? "Yes" : "No");
            }
        }

        // Print the table footer
        System.out.println(headerFooter);
    }

    public void printCommercialProperties(HashSet<Property> properties) {
        // Adjusted header/footer width to fully align with the table columns
        String headerFooter = "----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------";

        // Print the table header
        System.out.println(headerFooter);
        System.out.printf("| %-12s | %-40s | %-10s | %-15s | %-12s | %-20s | %-20s | %-12s | %-15s |\n",
                "Property ID", "Address", "Pricing", "Status", "Owner ID", "Host IDs", "Business Type", "Parking Slots", "Square Footage");
        System.out.println(headerFooter);

        // Loop through and print each commercial property
        for (Property property : properties) {
            if (property instanceof CommercialProperty) {
                // Get Owner ID
                String ownerIdString = property.getOwner().getId();

                // Get Host IDs as a comma-separated list
                String hostIdString = property.getHostList().stream()
                        .map(Host::getId)
                        .reduce((id1, id2) -> id1 + ", " + id2)
                        .orElse("None");

                // Print property details
                System.out.printf("| %-12s | %-40s | %-10.2f | %-15s | %-12s | %-20s | %-20s | %-12d | %-15.2f |\n",
                        property.getId(),
                        property.getAddress(),
                        property.getPricing(),
                        property.getStatus(),
                        ownerIdString,
                        hostIdString,
                        ((CommercialProperty) property).getBusinessType(),
                        ((CommercialProperty) property).getParkingSlots(),
                        ((CommercialProperty) property).getSquareFootage());
            }
        }

        // Print the table footer
        System.out.println(headerFooter);
    }



}
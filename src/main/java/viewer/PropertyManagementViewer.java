package viewer;
/*
  @author <Nguyen Minh Phuong - s4063236>
 */

import controller.impl.CommercialPropertyManagerImpl;
import controller.impl.PropertyManagerImpl;
import controller.impl.ResidentialPropertyManagerImpl;
import model.*;

import java.util.HashSet;
import java.util.Scanner;

/**
 * Viewer class for managing properties.
 * Provides methods to display and interact with property data.
 */
public class PropertyManagementViewer {
    private final CommercialPropertyManagerImpl commercialPropertyManager;
    private final ResidentialPropertyManagerImpl residentialPropertyManager;
    private final PropertyManagerImpl propertyManager;

    /**
     * Constructor to initialize the property managers.
     *
     * @param commercialPropertyManager The commercial property manager implementation.
     * @param residentialPropertyManager The residential property manager implementation.
     * @param propertyManager The property manager implementation.
     */
    public PropertyManagementViewer(CommercialPropertyManagerImpl commercialPropertyManager, ResidentialPropertyManagerImpl residentialPropertyManager, PropertyManagerImpl propertyManager) {
        this.commercialPropertyManager = commercialPropertyManager;
        this.residentialPropertyManager = residentialPropertyManager;
        this.propertyManager = propertyManager;
    }

    /**
     * Prints the property management menu options to the console.
     */
    public void printPropertyManagementMenu() {
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

    /**
     * Manages the property viewer operations based on user input.
     */
    public void propertyViewerManager() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Property Management");
        boolean exitProperty = false;
        try {
            while (!exitProperty) {
                printPropertyManagementMenu();
                int choiceProperty = scanner.nextInt();
                scanner.nextLine();
                switch (choiceProperty) {
                    case 1:
                        System.out.println("Add Property");
                        System.out.println("Functionality not implemented yet due to assignment requirements.");
                        break;
                    case 2:
                        System.out.println("Update Property");
                        System.out.println("Functionality not implemented yet due to assignment requirements.");
                        break;
                    case 3:
                        System.out.println("Delete Property");
                        System.out.println("Functionality not implemented yet due to assignment requirements.");
                        break;
                    case 4:
                        System.out.println("View All Properties");
                        HashSet<Property> properties = new HashSet<>(propertyManager.getAllProperties());
                        printTable(properties);
                        System.out.println("Press Enter to continue...");
                        scanner.nextLine();
                        break;
                    case 5:
                        System.out.println("View All Residential Properties");
                        HashSet<Property> residentialProperties = new HashSet<>(residentialPropertyManager.getAllResidentialProperties());
                        printResidentialProperties(residentialProperties);
                        System.out.println("Press Enter to continue...");
                        scanner.nextLine();
                        break;
                    case 6:
                        System.out.println("View All Commercial Properties");
                        HashSet<Property> commercialProperties = new HashSet<>(commercialPropertyManager.getAllCommercialProperties());
                        printCommercialProperties(commercialProperties);
                        System.out.println("Press Enter to continue...");
                        scanner.nextLine();
                        break;
                    case 7:
                        System.out.println("Search Property by ID");
                        String id = scanner.nextLine();
                        printPropertyByID(id);
                        System.out.println("Press Enter to continue...");
                        scanner.nextLine();
                        break;
                    case 8:
                        System.out.println("Search Property by Address");
                        String address = scanner.nextLine();
                        printPropertyByAddress(address);
                        System.out.println("Press Enter to continue...");
                        scanner.nextLine();
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
        } catch (Exception e) {
            System.out.println("Invalid input. Please try again.");
        }
    }

    /**
     * Prints a property by its ID.
     *
     * @param id The ID of the property.
     */
    public void printPropertyByID(String id) {
        Property property = propertyManager.getPropertyByID(id);
        if (property != null) {
            HashSet<Property> propertySet = new HashSet<>();
            propertySet.add(property);
            printTable(propertySet);
        } else {
            System.out.println("Property not found");
        }
    }

    /**
     * Prints a property by its address.
     *
     * @param address The address of the property.
     */
    public void printPropertyByAddress(String address) {
        Property property = propertyManager.getPropertyByAddress(address);
        if (property != null) {
            HashSet<Property> propertySet = new HashSet<>();
            propertySet.add(property);
            printTable(propertySet);
        } else {
            System.out.println("No property with the address " + address + " was found");
        }
    }

    /**
     * Prints a table of properties with their details.
     *
     * @param properties The set of properties to be printed.
     */
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

    /**
     * Prints a table of residential properties with their details.
     *
     * @param properties The set of residential properties to be printed.
     */
    public void printResidentialProperties(HashSet<Property> properties) {
        String headerFooter = "---------------------------------------------------------------------------------------------------------------------------------------------------------------------";
        System.out.println(headerFooter);
        System.out.printf("| %-12s | %-40s | %-10s | %-15s | %-12s | %-20s | %-9s | %-7s | %-12s |\n",
                "Property ID", "Address", "Pricing", "Status", "Owner ID", "Host IDs", "Bedrooms", "Garden", "Pet Friendly");
        System.out.println(headerFooter);
        for (Property property : properties) {
            if (property instanceof ResidentialProperty) {
                String ownerIdString = property.getOwner().getId();
                String hostIdString = property.getHostList().stream()
                        .map(Host::getId)
                        .reduce((id1, id2) -> id1 + ", " + id2)
                        .orElse("None");
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
        System.out.println(headerFooter);
    }

    /**
     * Prints a table of commercial properties with their details.
     *
     * @param properties The set of commercial properties to be printed.
     */
    public void printCommercialProperties(HashSet<Property> properties) {
        String headerFooter = "----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------";
        System.out.println(headerFooter);
        System.out.printf("| %-12s | %-40s | %-10s | %-15s | %-12s | %-20s | %-20s | %-12s | %-15s |\n",
                "Property ID", "Address", "Pricing", "Status", "Owner ID", "Host IDs", "Business Type", "Parking Slots", "Square Footage");
        System.out.println(headerFooter);
        for (Property property : properties) {
            if (property instanceof CommercialProperty) {
                String ownerIdString = property.getOwner().getId();
                String hostIdString = property.getHostList().stream()
                        .map(Host::getId)
                        .reduce((id1, id2) -> id1 + ", " + id2)
                        .orElse("None");
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
        System.out.println(headerFooter);
    }
}
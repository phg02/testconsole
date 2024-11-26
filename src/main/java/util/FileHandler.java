package util;

import controller.impl.*;
import model.*;

import java.io.*;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.*;


public class FileHandler {
    private StringToDate stringToDate;
    private HashMap<String,Tenant> tenantsHashMap = new HashMap<>();
    private HashMap<String,Owner> ownersHashMap = new HashMap<>();
    private HashMap<String,Host> hostsHashMap = new HashMap<>();
    private HashMap<String,ResidentialProperty> residentialPropertyHashMap = new HashMap<>();
    private HashMap<String,CommercialProperty> commercialPropertyHashMap = new HashMap<>();

    public FileHandler() {
        stringToDate = new StringToDate();
    }


    public HashSet<Tenant> getTenantData() {
        // File path
        final String filePathToTenant = "src/main/resources/tenant.txt";

        // List to store Tenant objects
        HashSet<Tenant> tenants = new HashSet<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePathToTenant))) {
            String line;

            // Read file line by line
            while ((line = br.readLine()) != null) {
                // Split the line by the "|" delimiter
                String[] parts = line.split("\\|");

                // Ensure correct number of fields
                if (parts.length == 4) {
                    String id = parts[0];
                    String fullName = parts[1];
                    Date dateOfBirth = stringToDate.convertStringToDate(parts[2]);
                    String contactInformation = parts[3];

                    // Create a Tenant object and add it to the list
                    Tenant tenant = new Tenant(id, fullName, dateOfBirth, contactInformation);
                    tenants.add(tenant);
                    tenantsHashMap.put(tenant.getId(), tenant);
                } else {
                    System.out.println("Invalid line: " + line);
                }
            }
            // Print the tenants to verify
//            System.out.println("Tenants loaded from file:");
//            for (Tenant tenant : tenants) {
//                LocalDateTime localDateTime = tenant.getDateOfBirth().toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
//                System.out.println(tenant.getId() + " " + tenant.getFullName() + " " + dtf.format(localDateTime) + " " + tenant.getContactInformation());
//            }
            return tenants;
        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        }
        return tenants;
    }

    public HashSet<Owner> getOwnerData() {
        // File path
        final String filePathToOwner = "src/main/resources/owner.txt";

        // List to store Tenant objects
        HashSet<Owner> owners = new HashSet<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePathToOwner))) {
            String line;

            // Read file line by line
            while ((line = br.readLine()) != null) {
                // Split the line by the "|" delimiter
                String[] parts = line.split("\\|");

                // Ensure correct number of fields
                if (parts.length == 4) {
                    String id = parts[0];
                    String fullName = parts[1];
                    Date dateOfBirth = stringToDate.convertStringToDate(parts[2]);
                    String contactInformation = parts[3];

                    // Create a Tenant object and add it to the list
                    Owner owner = new Owner(id, fullName, dateOfBirth, contactInformation);
                    owners.add(owner);
                    ownersHashMap.put(owner.getId(), owner);
                } else {
                    System.out.println("Invalid line: " + line);
                }
            }
            // Print the tenants to verify
//            System.out.println("Tenants loaded from file:");
//            for (Owner owner : owners) {
//                LocalDateTime localDateTime = owner.getDateOfBirth().toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
//                System.out.println(owner.getId() + " " + owner.getFullName() + " " + dtf.format(localDateTime) + " " + owner.getContactInformation());
//            }
            return owners;
        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        }
        return owners;
    }


    public HashSet<Host> getHostData() {
        // File path
        final String filePathToHost = "src/main/resources/host.txt";

        // List to store Tenant objects
        HashSet<Host> hosts = new HashSet<>();


        try (BufferedReader br = new BufferedReader(new FileReader(filePathToHost))) {
            String line;

            // Read file line by line
            while ((line = br.readLine()) != null) {
                // Split the line by the "|" delimiter
                String[] parts = line.split("\\|");

                // Ensure correct number of fields
                if (parts.length == 4) {
                    String id = parts[0];
                    String fullName = parts[1];
                    Date dateOfBirth = stringToDate.convertStringToDate(parts[2]);
                    String contactInformation = parts[3];

                    // Create a Tenant object and add it to the list
                    Host host = new Host(id, fullName, dateOfBirth, contactInformation);
                    hosts.add(host);
                    hostsHashMap.put(host.getId(), host);
                } else {
                    System.out.println("Invalid line: " + line);
                }
            }
//            // Print the tenants to verify
//            System.out.println("Tenants loaded from file:");
//            for (Host host : hosts) {
//                LocalDateTime localDateTime = host.getDateOfBirth().toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
//                System.out.println(host.getId() + " " + host.getFullName() + " " + dtf.format(localDateTime) + " " + host.getContactInformation());
//            }
            return hosts;
        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        }
        return hosts;
    }

    public HashSet<ResidentialProperty> getResidentialProperty(){
        String fileName = "src/main/resources/residentialProperty.txt";
        HashSet<ResidentialProperty> properties = new HashSet<>();

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split("\\|");

                // Parsing fields from the text file
                String id = parts[0];
                String address = parts[1];
                double pricing = Double.parseDouble(parts[2]);
                Property.Status status = Property.Status.valueOf(parts[3]); // Convert string to enum
                Owner owner = ownersHashMap.get(parts[4]);
                int numberOfBedrooms = Integer.parseInt(parts[5]);
                boolean hasGarden = Boolean.parseBoolean(parts[6]);
                boolean petFriendly = Boolean.parseBoolean(parts[7]);

                // Create a ResidentialProperty object
                ResidentialProperty property = new ResidentialProperty(
                        id, address, pricing, status, owner, numberOfBedrooms, hasGarden, petFriendly);
                properties.add(property);
                owner.addProperties(property);
                residentialPropertyHashMap.put(property.getId(), property);


            }
            return properties;

        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        }
        return properties;
    }


    public HashSet<CommercialProperty> getCommercialProperty(){
        String fileName = "src/main/resources/commercialProperty.txt";
        HashSet<CommercialProperty> commercialProperties = new HashSet<>();

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split("\\|");

                // Parsing fields from the text file
                String id = parts[0];
                String address = parts[1];
                double pricing = Double.parseDouble(parts[2]);
                Property.Status status = Property.Status.valueOf(parts[3]); // Convert string to enum
                Owner owner = ownersHashMap.get(parts[4]);
                String businessType = parts[5];
                int parkingSlots = Integer.parseInt(parts[6]);
                double squareFootage = Double.parseDouble(parts[7]);
                // Create a CommercialProperty object
                CommercialProperty property = new CommercialProperty(
                        id, address, pricing, status, owner, businessType, parkingSlots, squareFootage);
                commercialPropertyHashMap.put(property.getId(), property);
                commercialProperties.add(property);
                owner.addProperties(property);


            }

            return commercialProperties;

        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        }
        return commercialProperties;
    }

    public HashSet<RentalAgreement> getRentalAgreement(){
        String fileName = "src/main/resources/rentalAgreement.txt";
        HashSet<RentalAgreement> rentalAgreements = new HashSet<>();

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            Owner owner;
            Host host;
            Tenant mainTenant;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split("\\|");

                // Parsing fields from the text file
                String id = parts[0];
                owner = ownersHashMap.get(parts[1]);
                host = hostsHashMap.get(parts[2]);
                mainTenant = tenantsHashMap.get(parts[3]);
                String[] subTenantIds = parts[4].split(",");
                Property property;
                if(parts[5].startsWith("RP")){
                    property = residentialPropertyHashMap.get(parts[5]);

                }
                else{
                    property = commercialPropertyHashMap.get(parts[5]);

                }
                RentalAgreement.Period period = RentalAgreement.Period.valueOf(parts[6]);
                Date startDate = stringToDate.convertStringToDate(parts[7]);
                Date endDate = stringToDate.convertStringToDate(parts[8]);
                double rentingFee = Double.parseDouble(parts[9]);
                RentalAgreement.Status status = RentalAgreement.Status.valueOf(parts[10]);

                // Create a RentalAgreement object
                RentalAgreement rentalAgreement = new RentalAgreement(
                        id, owner, host, mainTenant, property, period, startDate, endDate, rentingFee, status);
                rentalAgreements.add(rentalAgreement);
                owner.addRentalAgreement(rentalAgreement);
                owner.getCooperatingHosts().forEach(h -> h.addRentalAgreement(rentalAgreement));
                owner.addCooperatingHost(host);
                property.addHost(host);
                host.addProperty(property);
                host.addRentalAgreement(rentalAgreement);
                host.addCooperatingOwner(owner);
                mainTenant.addRentalAgreement(rentalAgreement);

                for (String subId : subTenantIds) {
                    rentalAgreement.addSubTenant(tenantsHashMap.get(subId));
                }
            }

            return rentalAgreements;

        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        }
        return rentalAgreements;
    }

    public HashSet<Payment> getPaymentData(){
        String fileName = "src/main/resources/payment.txt";
        HashSet<Payment> payments = new HashSet<>();

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split("\\|");

                // Parsing fields from the text file
                String id = parts[0];
//                TenantManagerImpl tenantManager = new TenantManagerImpl();
                Tenant tenant = tenantsHashMap.get(parts[1]);
                double amount = Double.parseDouble(parts[2]);
                Date date = stringToDate.convertStringToDate(parts[3]);
                String paymentMethod = parts[4];

                // Create a Payment object
                Payment payment = new Payment(id, tenant, amount, date, paymentMethod);
                payments.add(payment);
                tenant.addPayment(payment);
            }
            return payments;

        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        }
        return payments;
    }
}
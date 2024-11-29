package util;
/*
  @author <Nguyen Minh Phuong - s4063236>
 */

import model.*;

import java.io.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Handles file operations for reading and writing data related to tenants, owners, hosts, properties, rental agreements, and payments.
 */
public class FileHandler {
    private StringToDate stringToDate;
    private HashMap<String, Tenant> tenantsHashMap = new HashMap<>();
    private HashMap<String, Owner> ownersHashMap = new HashMap<>();
    private HashMap<String, Host> hostsHashMap = new HashMap<>();
    private HashMap<String, ResidentialProperty> residentialPropertyHashMap = new HashMap<>();
    private HashMap<String, CommercialProperty> commercialPropertyHashMap = new HashMap<>();

    /**
     * Default constructor for creating an instance of FileHandler.
     * Initializes the StringToDate utility.
     */
    public FileHandler() {
        stringToDate = new StringToDate();
    }

    /**
     * Reads tenant data from a file and returns a set of Tenant objects.
     *
     * @return A set of Tenant objects.
     */
    public HashSet<Tenant> getTenantData() {
        final String filePathToTenant = "src/main/resources/tenant.txt";
        HashSet<Tenant> tenants = new HashSet<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePathToTenant))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split("\\|");
                if (parts.length == 4) {
                    String id = parts[0];
                    String fullName = parts[1];
                    Date dateOfBirth = stringToDate.convertStringToDate(parts[2]);
                    String contactInformation = parts[3];
                    Tenant tenant = new Tenant(id, fullName, dateOfBirth, contactInformation);
                    tenants.add(tenant);
                    tenantsHashMap.put(tenant.getId(), tenant);
                } else {
                    System.out.println("Invalid line: " + line);
                }
            }
            return tenants;
        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        }
        return tenants;
    }

    /**
     * Reads owner data from a file and returns a set of Owner objects.
     *
     * @return A set of Owner objects.
     */
    public HashSet<Owner> getOwnerData() {
        final String filePathToOwner = "src/main/resources/owner.txt";
        HashSet<Owner> owners = new HashSet<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePathToOwner))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split("\\|");
                if (parts.length == 4) {
                    String id = parts[0];
                    String fullName = parts[1];
                    Date dateOfBirth = stringToDate.convertStringToDate(parts[2]);
                    String contactInformation = parts[3];
                    Owner owner = new Owner(id, fullName, dateOfBirth, contactInformation);
                    owners.add(owner);
                    ownersHashMap.put(owner.getId(), owner);
                } else {
                    System.out.println("Invalid line: " + line);
                }
            }
            return owners;
        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        }
        return owners;
    }

    /**
     * Reads host data from a file and returns a set of Host objects.
     *
     * @return A set of Host objects.
     */
    public HashSet<Host> getHostData() {
        final String filePathToHost = "src/main/resources/host.txt";
        HashSet<Host> hosts = new HashSet<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePathToHost))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split("\\|");
                if (parts.length == 4) {
                    String id = parts[0];
                    String fullName = parts[1];
                    Date dateOfBirth = stringToDate.convertStringToDate(parts[2]);
                    String contactInformation = parts[3];
                    Host host = new Host(id, fullName, dateOfBirth, contactInformation);
                    hosts.add(host);
                    hostsHashMap.put(host.getId(), host);
                } else {
                    System.out.println("Invalid line: " + line);
                }
            }
            return hosts;
        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        }
        return hosts;
    }

    /**
     * Reads residential property data from a file and returns a set of ResidentialProperty objects.
     *
     * @return A set of ResidentialProperty objects.
     */
    public HashSet<ResidentialProperty> getResidentialProperty() {
        String fileName = "src/main/resources/residentialProperty.txt";
        HashSet<ResidentialProperty> properties = new HashSet<>();

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split("\\|");
                String id = parts[0];
                String address = parts[1];
                double pricing = Double.parseDouble(parts[2]);
                Property.Status status = Property.Status.valueOf(parts[3]);
                Owner owner = ownersHashMap.get(parts[4]);
                int numberOfBedrooms = Integer.parseInt(parts[5]);
                boolean hasGarden = Boolean.parseBoolean(parts[6]);
                boolean petFriendly = Boolean.parseBoolean(parts[7]);
                String hostsList = parts[8];
                String[] host = hostsList.split(",");
                ResidentialProperty property = new ResidentialProperty(
                        id, address, pricing, status, owner, numberOfBedrooms, hasGarden, petFriendly);
                properties.add(property);
                for(String hostId : host){
                    owner.addCooperatingHost(hostsHashMap.get(hostId));
                    property.addHost(hostsHashMap.get(hostId));
                    hostsHashMap.get(hostId).addProperty(property);
                    hostsHashMap.get(hostId).addCooperatingOwner(owner);
                }
                owner.addProperties(property);
                residentialPropertyHashMap.put(property.getId(), property);
            }
            return properties;
        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        }
        return properties;
    }

    /**
     * Reads commercial property data from a file and returns a set of CommercialProperty objects.
     *
     * @return A set of CommercialProperty objects.
     */
    public HashSet<CommercialProperty> getCommercialProperty() {
        String fileName = "src/main/resources/commercialProperty.txt";
        HashSet<CommercialProperty> commercialProperties = new HashSet<>();

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split("\\|");
                String id = parts[0];
                String address = parts[1];
                double pricing = Double.parseDouble(parts[2]);
                Property.Status status = Property.Status.valueOf(parts[3]);
                Owner owner = ownersHashMap.get(parts[4]);
                String businessType = parts[5];
                int parkingSlots = Integer.parseInt(parts[6]);
                double squareFootage = Double.parseDouble(parts[7]);
                String hosts = parts[8];
                CommercialProperty property = new CommercialProperty(
                        id, address, pricing, status, owner, businessType, parkingSlots, squareFootage);
                commercialPropertyHashMap.put(property.getId(), property);
                for(String hostId : hosts.split(",")){
                    owner.addCooperatingHost(hostsHashMap.get(hostId));
                    property.addHost(hostsHashMap.get(hostId));
                    hostsHashMap.get(hostId).addProperty(property);
                    hostsHashMap.get(hostId).addCooperatingOwner(owner);
                }
                commercialProperties.add(property);
                owner.addProperties(property);
            }
            return commercialProperties;
        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        }
        return commercialProperties;
    }

    /**
     * Reads rental agreement data from a file and returns a set of RentalAgreement objects.
     *
     * @return A set of RentalAgreement objects.
     */
    public HashSet<RentalAgreement> getRentalAgreement() {
        String fileName = "src/main/resources/rentalAgreement.txt";
        HashSet<RentalAgreement> rentalAgreements = new HashSet<>();

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            Owner owner;
            Host host;
            Tenant mainTenant;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split("\\|");
                String id = parts[0];
                owner = ownersHashMap.get(parts[1]);
                host = hostsHashMap.get(parts[2]);
                mainTenant = tenantsHashMap.get(parts[3]);
                String[] subTenantIds = parts[4].split(",");
                Property property;
                if (parts[5].startsWith("RP")) {
                    property = residentialPropertyHashMap.get(parts[5]);
                } else {
                    property = commercialPropertyHashMap.get(parts[5]);
                }
                RentalAgreement.Period period = RentalAgreement.Period.valueOf(parts[6]);
                Date startDate = stringToDate.convertStringToDate(parts[7]);
                Date endDate = stringToDate.convertStringToDate(parts[8]);
                double rentingFee = Double.parseDouble(parts[9]);
                RentalAgreement.Status status = RentalAgreement.Status.valueOf(parts[10]);
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
                    if (subId != null && !subId.isEmpty()) {
                        rentalAgreement.addSubTenant(tenantsHashMap.get(subId));
                    }
                }
            }
            return rentalAgreements;
        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        }
        return rentalAgreements;
    }

    /**
     * Reads payment data from a file and returns a set of Payment objects.
     *
     * @return A set of Payment objects.
     */
    public HashSet<Payment> getPaymentData() {
        String fileName = "src/main/resources/payment.txt";
        HashSet<Payment> payments = new HashSet<>();

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split("\\|");
                String id = parts[0];
                Tenant tenant = tenantsHashMap.get(parts[1]);
                double amount = Double.parseDouble(parts[2]);
                Date date = stringToDate.convertStringToDate(parts[3]);
                String paymentMethod = parts[4];
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

    /**
     * Saves rental agreement data to a file.
     *
     * @param rentalAgreements The set of RentalAgreement objects to be saved.
     * @return true if the data was successfully saved, false otherwise.
     */
    public boolean saveDataRentalAgreement(HashSet<RentalAgreement> rentalAgreements) {
        String fileName = "src/main/resources/rentalAgreement.txt";
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (RentalAgreement agreement : rentalAgreements) {
                StringBuilder subTenants = new StringBuilder();
                for (Tenant tenant : agreement.getSubTenant()) {
                    if (!subTenants.isEmpty()) {
                        subTenants.append(",");
                    }
                    subTenants.append(tenant.getId());
                }
                String line = String.format("%s|%s|%s|%s|%s|%s|%s|%s|%s|%.1f|%s",
                        agreement.getId(),
                        agreement.getOwner().getId(),
                        agreement.getHost().getId(),
                        agreement.getMainTenant().getId(),
                        subTenants,
                        agreement.getProperty().getId(),
                        agreement.getPeriod().name(),
                        dateFormat.format(agreement.getStartDate()),
                        dateFormat.format(agreement.getEndDate()),
                        agreement.getRentingFee(),
                        agreement.getStatus().name());
                writer.write(line);
                writer.newLine();
            }
            return true;
        } catch (IOException e) {
            System.err.println("Error writing to the file: " + e.getMessage());
            return false;
        }
    }
}
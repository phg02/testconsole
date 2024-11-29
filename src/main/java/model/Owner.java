package model;

import java.util.Date;
import java.util.HashSet;

/**
 * Represents an owner who owns properties and manages rental agreements.
 * This class extends the Person class.
 */
public class Owner extends Person {
    private HashSet<Property> properties;
    private HashSet<Host> cooperatingHosts;
    private HashSet<RentalAgreement> rentalAgreements;

    /**
     * Default constructor for creating an instance of Owner.
     * Initializes the properties, cooperating hosts, and rental agreements sets.
     */
    public Owner() {
        this.properties = new HashSet<Property>();
        this.cooperatingHosts = new HashSet<Host>();
        this.rentalAgreements = new HashSet<RentalAgreement>();
    }

    /**
     * Constructs an Owner with the specified details.
     *
     * @param id The unique identifier of the owner.
     * @param fullName The full name of the owner.
     * @param dateOfBirth The date of birth of the owner.
     * @param contactInformation The contact information of the owner.
     */
    public Owner(String id, String fullName, Date dateOfBirth, String contactInformation) {
        super(id, fullName, dateOfBirth, contactInformation);
        this.properties = new HashSet<Property>();
        this.cooperatingHosts = new HashSet<Host>();
        this.rentalAgreements = new HashSet<RentalAgreement>();
    }

    /**
     * Adds a property to the owner's list of properties.
     *
     * @param property The property to be added.
     */
    public void addProperties(Property property) {
        this.properties.add(property);
    }

    /**
     * Gets the set of properties owned by the owner.
     *
     * @return The set of properties.
     */
    public HashSet<Property> getProperties() {
        return properties;
    }

    /**
     * Adds a host to the owner's list of cooperating hosts.
     *
     * @param host The host to be added.
     */
    public void addCooperatingHost(Host host) {
        this.cooperatingHosts.add(host);
    }

    /**
     * Gets the set of cooperating hosts associated with the owner.
     *
     * @return The set of cooperating hosts.
     */
    public HashSet<Host> getCooperatingHosts() {
        return cooperatingHosts;
    }

    /**
     * Adds a rental agreement to the owner's list of rental agreements.
     *
     * @param rentalAgreement The rental agreement to be added.
     */
    public void addRentalAgreement(RentalAgreement rentalAgreement) {
        this.rentalAgreements.add(rentalAgreement);
    }

    /**
     * Gets the set of rental agreements managed by the owner.
     *
     * @return The set of rental agreements.
     */
    public HashSet<RentalAgreement> getRentalAgreements() {
        return rentalAgreements;
    }

    /**
     * Compares this owner to the specified object. The result is true if and only if the argument is not null and is an Owner object that has the same id as this object.
     *
     * @param obj The object to compare this Owner against.
     * @return true if the given object represents an Owner equivalent to this owner, false otherwise.
     */
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Owner)) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        return super.getId().equals(((Owner) obj).getId());
    }

    /**
     * Returns a hash code value for the owner. This method is supported for the benefit of hash tables such as those provided by HashMap.
     *
     * @return A hash code value for this owner.
     */
    @Override
    public int hashCode() {
        return super.getId().hashCode();
    }
}
package model;

import java.util.Date;
import java.util.HashSet;

/**
 * Represents a host who manages properties and rental agreements.
 * This class extends the Person class.
 */
public class Host extends Person {
    private HashSet<Property> properties;
    private HashSet<RentalAgreement> rentalAgreements;
    private HashSet<Owner> cooperatingOwners;

    /**
     * Default constructor for creating an instance of Host.
     * Initializes the properties, rental agreements, and cooperating owners sets.
     */
    public Host() {
        this.properties = new HashSet<Property>();
        this.rentalAgreements = new HashSet<RentalAgreement>();
        this.cooperatingOwners = new HashSet<Owner>();
    }

    /**
     * Constructs a Host with the specified details.
     *
     * @param id The unique identifier of the host.
     * @param fullName The full name of the host.
     * @param dateOfBirth The date of birth of the host.
     * @param contactInformation The contact information of the host.
     */
    public Host(String id, String fullName, Date dateOfBirth, String contactInformation) {
        super(id, fullName, dateOfBirth, contactInformation);
        this.properties = new HashSet<Property>();
        this.rentalAgreements = new HashSet<RentalAgreement>();
        this.cooperatingOwners = new HashSet<Owner>();
    }

    /**
     * Adds a property to the host's list of properties.
     *
     * @param property The property to be added.
     */
    public void addProperty(Property property) {
        this.properties.add(property);
    }

    /**
     * Gets the set of properties managed by the host.
     *
     * @return The set of properties.
     */
    public HashSet<Property> getProperties() {
        return properties;
    }

    /**
     * Adds a rental agreement to the host's list of rental agreements.
     *
     * @param rentalAgreement The rental agreement to be added.
     */
    public void addRentalAgreement(RentalAgreement rentalAgreement) {
        this.rentalAgreements.add(rentalAgreement);
    }

    /**
     * Gets the set of rental agreements managed by the host.
     *
     * @return The set of rental agreements.
     */
    public HashSet<RentalAgreement> getRentalAgreements() {
        return rentalAgreements;
    }

    /**
     * Adds an owner to the host's list of cooperating owners.
     *
     * @param owner The owner to be added.
     */
    public void addCooperatingOwner(Owner owner) {
        this.cooperatingOwners.add(owner);
    }

    /**
     * Gets the set of cooperating owners associated with the host.
     *
     * @return The set of cooperating owners.
     */
    public HashSet<Owner> getCooperatingOwners() {
        return cooperatingOwners;
    }

    /**
     * Compares this host to the specified object. The result is true if and only if the argument is not null and is a Host object that has the same id as this object.
     *
     * @param obj The object to compare this Host against.
     * @return true if the given object represents a Host equivalent to this host, false otherwise.
     */
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Host)) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        return super.getId().equals(((Host) obj).getId());
    }

    /**
     * Returns a hash code value for the host. This method is supported for the benefit of hash tables such as those provided by HashMap.
     *
     * @return A hash code value for this host.
     */
    @Override
    public int hashCode() {
        return super.getId().hashCode();
    }
}
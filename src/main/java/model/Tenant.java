package model;

import java.util.Date;
import java.util.HashSet;

/**
 * Represents a tenant who rents properties and makes payments.
 * This class extends the Person class.
 */
public class Tenant extends Person {
    private HashSet<RentalAgreement> rentalAgreements;
    private HashSet<Payment> payments;

    /**
     * Default constructor for creating an instance of Tenant.
     * Initializes the rental agreements and payments sets.
     */
    public Tenant() {
        this.rentalAgreements = new HashSet<>();
        this.payments = new HashSet<Payment>();
    }

    /**
     * Constructs a Tenant with the specified details.
     *
     * @param id The unique identifier of the tenant.
     * @param fullName The full name of the tenant.
     * @param dateOfBirth The date of birth of the tenant.
     * @param contactInformation The contact information of the tenant.
     */
    public Tenant(String id, String fullName, Date dateOfBirth, String contactInformation) {
        super(id, fullName, dateOfBirth, contactInformation);
        this.rentalAgreements = new HashSet<RentalAgreement>();
        this.payments = new HashSet<Payment>();
    }

    /**
     * Adds a rental agreement to the tenant's list of rental agreements.
     *
     * @param rentalAgreement The rental agreement to be added.
     */
    public void addRentalAgreement(RentalAgreement rentalAgreement) {
        this.rentalAgreements.add(rentalAgreement);
    }

    /**
     * Gets the set of rental agreements associated with the tenant.
     *
     * @return The set of rental agreements.
     */
    public HashSet<RentalAgreement> getRentalAgreements() {
        return rentalAgreements;
    }

    /**
     * Adds a payment to the tenant's list of payments.
     *
     * @param payment The payment to be added.
     */
    public void addPayment(Payment payment) {
        this.payments.add(payment);
    }

    /**
     * Gets the set of payments made by the tenant.
     *
     * @return The set of payments.
     */
    public HashSet<Payment> getPayments() {
        return payments;
    }

    /**
     * Compares this tenant to the specified object. The result is true if and only if the argument is not null and is a Tenant object that has the same id as this object.
     *
     * @param obj The object to compare this Tenant against.
     * @return true if the given object represents a Tenant equivalent to this tenant, false otherwise.
     */
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Tenant)) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        return super.getId().equals(((Tenant) obj).getId());
    }

    /**
     * Returns a hash code value for the tenant. This method is supported for the benefit of hash tables such as those provided by HashMap.
     *
     * @return A hash code value for this tenant.
     */
    @Override
    public int hashCode() {
        return super.getId().hashCode();
    }
}
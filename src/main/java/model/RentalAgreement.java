package model;

import java.util.Date;
import java.util.HashSet;

/**
 * Represents a rental agreement between an owner, host, and tenant for a property.
 */
public class RentalAgreement {
    /**
     * Enum representing the rental period.
     */
    public enum Period {
        DAILY,
        WEEKLY,
        MONTHLY,
        YEARLY
    }

    /**
     * Enum representing the status of the rental agreement.
     */
    public enum Status {
        NEW,
        ACTIVE,
        COMPLETED
    }

    private String id;
    private Owner owner;
    private Host host;
    private Tenant mainTenant;
    private HashSet<Tenant> subTenant;
    private Property property;
    private Period period;
    private Date startDate;
    private Date endDate;
    private double rentingFee;
    public Status status;

    /**
     * Default constructor for creating an instance of RentalAgreement.
     * Initializes the sub-tenant set.
     */
    public RentalAgreement() {
        this.subTenant = new HashSet<Tenant>();
    }

    /**
     * Constructs a RentalAgreement with the specified details.
     *
     * @param id The unique identifier of the rental agreement.
     * @param owner The owner involved in the rental agreement.
     * @param host The host involved in the rental agreement.
     * @param mainTenant The main tenant involved in the rental agreement.
     * @param property The property being rented.
     * @param period The rental period.
     * @param startDate The start date of the rental agreement.
     * @param endDate The end date of the rental agreement.
     * @param rentingFee The renting fee.
     * @param status The status of the rental agreement.
     */
    public RentalAgreement(String id, Owner owner, Host host, Tenant mainTenant, Property property, Period period, Date startDate, Date endDate, double rentingFee, Status status) {
        this.owner = owner;
        this.host = host;
        this.id = id;
        this.property = property;
        this.period = period;
        this.startDate = startDate;
        this.endDate = endDate;
        this.rentingFee = rentingFee;
        this.status = status;
        this.mainTenant = mainTenant;
        this.subTenant = new HashSet<Tenant>();
    }

    /**
     * Sets the unique identifier of the rental agreement.
     *
     * @param id The unique identifier.
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Gets the unique identifier of the rental agreement.
     *
     * @return The unique identifier.
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the owner involved in the rental agreement.
     *
     * @param owner The owner.
     */
    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    /**
     * Gets the owner involved in the rental agreement.
     *
     * @return The owner.
     */
    public Owner getOwner() {
        return owner;
    }

    /**
     * Sets the host involved in the rental agreement.
     *
     * @param host The host.
     */
    public void setHost(Host host) {
        this.host = host;
    }

    /**
     * Gets the host involved in the rental agreement.
     *
     * @return The host.
     */
    public Host getHost() {
        return host;
    }

    /**
     * Sets the main tenant involved in the rental agreement.
     *
     * @param mainTenant The main tenant.
     */
    public void setMainTenant(Tenant mainTenant) {
        this.mainTenant = mainTenant;
    }

    /**
     * Gets the main tenant involved in the rental agreement.
     *
     * @return The main tenant.
     */
    public Tenant getMainTenant() {
        return mainTenant;
    }

    /**
     * Sets the property being rented.
     *
     * @param property The property.
     */
    public void setProperty(Property property) {
        this.property = property;
    }

    /**
     * Gets the property being rented.
     *
     * @return The property.
     */
    public Property getProperty() {
        return property;
    }

    /**
     * Sets the rental period.
     *
     * @param period The rental period.
     */
    public void setPeriod(Period period) {
        this.period = period;
    }

    /**
     * Gets the rental period.
     *
     * @return The rental period.
     */
    public Period getPeriod() {
        return period;
    }

    /**
     * Sets the start date of the rental agreement.
     *
     * @param startDate The start date.
     */
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    /**
     * Gets the start date of the rental agreement.
     *
     * @return The start date.
     */
    public Date getStartDate() {
        return startDate;
    }

    /**
     * Sets the end date of the rental agreement.
     *
     * @param endDate The end date.
     */
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    /**
     * Gets the end date of the rental agreement.
     *
     * @return The end date.
     */
    public Date getEndDate() {
        return endDate;
    }

    /**
     * Sets the renting fee.
     *
     * @param rentingFee The renting fee.
     */
    public void setRentingFee(double rentingFee) {
        this.rentingFee = rentingFee;
    }

    /**
     * Gets the renting fee.
     *
     * @return The renting fee.
     */
    public double getRentingFee() {
        return rentingFee;
    }

    /**
     * Sets the status of the rental agreement.
     *
     * @param status The status.
     */
    public void setStatus(Status status) {
        this.status = status;
    }

    /**
     * Gets the status of the rental agreement.
     *
     * @return The status.
     */
    public Status getStatus() {
        return status;
    }

    /**
     * Adds a sub-tenant to the rental agreement if not already present.
     *
     * @param tenant The sub-tenant to be added.
     * @return true if the sub-tenant was added, false otherwise.
     */
    public boolean addSubTenant(Tenant tenant) {
        if (!tenant.equals(mainTenant) && !subTenant.contains(tenant)) {
            subTenant.add(tenant);
            return true;
        }
        return false;
    }

    /**
     * Gets the set of sub-tenants involved in the rental agreement.
     *
     * @return The set of sub-tenants.
     */
    public HashSet<Tenant> getSubTenant() {
        return subTenant;
    }

    /**
     * Compares this rental agreement to the specified object. The result is true if and only if the argument is not null and is a RentalAgreement object that has the same id as this object.
     *
     * @param obj The object to compare this RentalAgreement against.
     * @return true if the given object represents a RentalAgreement equivalent to this rental agreement, false otherwise.
     */
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof RentalAgreement)) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        return getId().equals(((RentalAgreement) obj).getId());
    }

    /**
     * Returns a hash code value for the rental agreement. This method is supported for the benefit of hash tables such as those provided by HashMap.
     *
     * @return A hash code value for this rental agreement.
     */
    @Override
    public int hashCode() {
        return getId().hashCode();
    }
}
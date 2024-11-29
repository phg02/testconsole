package model;

import java.util.HashSet;

/**
 * Represents a property that can be rented, maintained, or available.
 * This is an abstract class to be extended by specific types of properties.
 */
public abstract class Property {
    /**
     * Enum representing the status of the property.
     */
    public enum Status {
        AVAILABLE,
        RENTED,
        MAINTENANCE
    }

    private String id;
    private String address;
    private double pricing;
    private Status status;
    private Owner owner;
    private HashSet<Host> hostList;

    /**
     * Default constructor for creating an instance of Property.
     * Initializes the host list.
     */
    public Property() {
        this.hostList = new HashSet<Host>();
    }

    /**
     * Constructs a Property with the specified details.
     *
     * @param id The unique identifier of the property.
     * @param address The address of the property.
     * @param pricing The pricing of the property.
     * @param status The status of the property.
     * @param owner The owner of the property.
     */
    public Property(String id, String address, double pricing, Status status, Owner owner) {
        this.id = id;
        this.address = address;
        this.pricing = pricing;
        this.status = status;
        this.owner = owner;
        this.hostList = new HashSet<Host>();
    }

    /**
     * Sets the unique identifier of the property.
     *
     * @param id The unique identifier.
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Gets the unique identifier of the property.
     *
     * @return The unique identifier.
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the address of the property.
     *
     * @param address The address.
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Gets the address of the property.
     *
     * @return The address.
     */
    public String getAddress() {
        return address;
    }

    /**
     * Sets the pricing of the property.
     *
     * @param pricing The pricing.
     */
    public void setPricing(double pricing) {
        this.pricing = pricing;
    }

    /**
     * Gets the pricing of the property.
     *
     * @return The pricing.
     */
    public double getPricing() {
        return pricing;
    }

    /**
     * Sets the status of the property.
     *
     * @param status The status.
     */
    public void setStatus(Status status) {
        this.status = status;
    }

    /**
     * Gets the status of the property.
     *
     * @return The status.
     */
    public Status getStatus() {
        return status;
    }

    /**
     * Sets the owner of the property.
     *
     * @param owner The owner.
     */
    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    /**
     * Gets the owner of the property.
     *
     * @return The owner.
     */
    public Owner getOwner() {
        return owner;
    }

    /**
     * Adds a host to the property's host list if not already present.
     *
     * @param host The host to be added.
     * @return true if the host was added, false otherwise.
     */
    public boolean addHost(Host host) {
        if (!this.hostList.contains(host)) {
            this.hostList.add(host);
            return true;
        }
        return false;
    }

    /**
     * Gets the list of hosts associated with the property.
     *
     * @return The list of hosts.
     */
    public HashSet<Host> getHostList() {
        return this.hostList;
    }
}
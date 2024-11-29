package model;

/**
 * Represents a commercial property with specific attributes such as business type, parking slots, and square footage.
 * This class extends the Property class.
 * 
 * @author <Your Full Name - Your Student ID>
 */
public class CommercialProperty extends Property {
    /**
     * The type of business that operates in the commercial property.
     */
    private String businessType;

    /**
     * The number of parking slots available at the commercial property.
     */
    private int parkingSlots;

    /**
     * The total square footage of the commercial property.
     */
    private double squareFootage;

    /**
     * Default constructor for creating an instance of CommercialProperty.
     */
    public CommercialProperty() {
    }

    /**
     * Constructs a CommercialProperty with the specified details.
     * 
     * @param id The unique identifier of the property.
     * @param address The address of the property.
     * @param pricing The pricing of the property.
     * @param status The status of the property.
     * @param owner The owner of the property.
     * @param businessType The type of business that operates in the property.
     * @param parkingSlots The number of parking slots available.
     * @param squareFootage The total square footage of the property.
     */
    public CommercialProperty(String id, String address, double pricing, Status status, Owner owner, String businessType, int parkingSlots, double squareFootage) {
        super(id, address, pricing, status, owner);
        this.businessType = businessType;
        this.parkingSlots = parkingSlots;
        this.squareFootage = squareFootage;
    }

    /**
     * Sets the type of business that operates in the commercial property.
     * 
     * @param businessType The type of business.
     */
    public void setBusinessType(String businessType) {
        this.businessType = businessType;
    }

    /**
     * Gets the type of business that operates in the commercial property.
     * 
     * @return The type of business.
     */
    public String getBusinessType() {
        return businessType;
    }

    /**
     * Sets the number of parking slots available at the commercial property.
     * 
     * @param parkingSlots The number of parking slots.
     */
    public void setParkingSlots(int parkingSlots) {
        this.parkingSlots = parkingSlots;
    }

    /**
     * Gets the number of parking slots available at the commercial property.
     * 
     * @return The number of parking slots.
     */
    public int getParkingSlots() {
        return parkingSlots;
    }

    /**
     * Sets the total square footage of the commercial property.
     * 
     * @param squareFootage The total square footage.
     */
    public void setSquareFootage(double squareFootage) {
        this.squareFootage = squareFootage;
    }

    /**
     * Gets the total square footage of the commercial property.
     * 
     * @return The total square footage.
     */
    public double getSquareFootage() {
        return squareFootage;
    }

    /**
     * Compares this commercial property to the specified object. The result is true if and only if the argument is not null and is a CommercialProperty object that has the same id as this object.
     * 
     * @param obj The object to compare this CommercialProperty against.
     * @return true if the given object represents a CommercialProperty equivalent to this commercial property, false otherwise.
     */
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof CommercialProperty)) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        return super.getId().equals(((CommercialProperty) obj).getId());
    }

    /**
     * Returns a hash code value for the commercial property. This method is supported for the benefit of hash tables such as those provided by HashMap.
     * 
     * @return A hash code value for this commercial property.
     */
    @Override
    public int hashCode() {
        return super.getId().hashCode();
    }
}


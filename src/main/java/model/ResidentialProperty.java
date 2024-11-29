package model;

/**
 * Represents a residential property that can be rented, maintained, or available.
 * Extends the Property class to include specific attributes for residential properties.
 */
public class ResidentialProperty extends Property {
    // The number of bedrooms in the residential property
    private int numberOfBedrooms;

    // Indicates whether the residential property has a garden
    private boolean hasGarden;

    // Indicates whether the residential property is pet-friendly
    private boolean petFriendly;

    /**
     * Default constructor for creating an instance of ResidentialProperty.
     */
    public ResidentialProperty() {
    }

    /**
     * Constructs a ResidentialProperty with the specified details.
     *
     * @param id The unique identifier of the property.
     * @param address The address of the property.
     * @param pricing The pricing of the property.
     * @param status The status of the property.
     * @param owner The owner of the property.
     * @param numberOfBedrooms The number of bedrooms in the property.
     * @param hasGarden Indicates whether the property has a garden.
     * @param petFriendly Indicates whether the property is pet-friendly.
     */
    public ResidentialProperty(String id, String address, double pricing, Status status, Owner owner, int numberOfBedrooms, boolean hasGarden, boolean petFriendly) {
        super(id, address, pricing, status, owner);
        this.numberOfBedrooms = numberOfBedrooms;
        this.hasGarden = hasGarden;
        this.petFriendly = petFriendly;
    }

    /**
     * Sets the number of bedrooms in the residential property.
     *
     * @param numberOfBedrooms The number of bedrooms.
     */
    public void setNumberOfBedrooms(int numberOfBedrooms) {
        this.numberOfBedrooms = numberOfBedrooms;
    }

    /**
     * Gets the number of bedrooms in the residential property.
     *
     * @return The number of bedrooms.
     */
    public int getNumberOfBedrooms() {
        return numberOfBedrooms;
    }

    /**
     * Sets whether the residential property has a garden.
     *
     * @param hasGarden Indicates whether the property has a garden.
     */
    public void setHasGarden(boolean hasGarden) {
        this.hasGarden = hasGarden;
    }

    /**
     * Gets whether the residential property has a garden.
     *
     * @return true if the property has a garden, false otherwise.
     */
    public boolean getHasGarden() {
        return hasGarden;
    }

    /**
     * Sets whether the residential property is pet-friendly.
     *
     * @param petFriendly Indicates whether the property is pet-friendly.
     */
    public void setPetFriendly(boolean petFriendly) {
        this.petFriendly = petFriendly;
    }

    /**
     * Gets whether the residential property is pet-friendly.
     *
     * @return true if the property is pet-friendly, false otherwise.
     */
    public boolean getPetFriendly() {
        return petFriendly;
    }

    /**
     * Compares this residential property to the specified object. The result is true if and only if the argument is not null and is a ResidentialProperty object that has the same id as this object.
     *
     * @param obj The object to compare this ResidentialProperty against.
     * @return true if the given object represents a ResidentialProperty equivalent to this residential property, false otherwise.
     */
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof ResidentialProperty)) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        return super.getId().equals(((ResidentialProperty) obj).getId());
    }

    /**
     * Returns a hash code value for the residential property. This method is supported for the benefit of hash tables such as those provided by HashMap.
     *
     * @return A hash code value for this residential property.
     */
    @Override
    public int hashCode() {
        return super.getId().hashCode();
    }
}
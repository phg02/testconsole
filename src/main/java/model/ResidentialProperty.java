package model;

public class ResidentialProperty extends Property {
    private int numberOfBedrooms;
    private boolean hasGarden;
    private boolean petFriendly;

    public ResidentialProperty() {
    }

    public ResidentialProperty(String id, String address, double pricing, Status status, Owner owner, int numberOfBedrooms, boolean hasGarden, boolean petFriendly){
        super(id, address, pricing, status, owner);
        this.numberOfBedrooms = numberOfBedrooms;
        this.hasGarden = hasGarden;
        this.petFriendly = petFriendly;
    }

    public void setNumberOfBedrooms(int numberOfBedrooms) {
        this.numberOfBedrooms = numberOfBedrooms;
    }

    public int getNumberOfBedrooms() {
        return numberOfBedrooms;
    }

    public void setHasGarden(boolean hasGarden) {
        this.hasGarden = hasGarden;
    }

    public boolean getHasGarden() {
        return hasGarden;
    }

    public void setPetFriendly(boolean petFriendly) {
        this.petFriendly = petFriendly;
    }

    public boolean getPetFriendly() {
        return petFriendly;
    }

    @Override
    public boolean equals(Object obj){
        if(!(obj instanceof ResidentialProperty)){
            return false;
        }
        if(obj == this){
            return true;
        }
        return super.getId().equals(((ResidentialProperty) obj).getId());
    }

    @Override
    public int hashCode(){
        return super.getId().hashCode();
    }
}

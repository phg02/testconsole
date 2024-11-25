package model;

public class CommercialProperty extends Property{
    private String businessType;
    private int parkingSlots;
    private double squareFootage;

    public CommercialProperty() {
    }

    public CommercialProperty(String id, String address, double pricing, Status status, Owner owner, String businessType, int parkingSlots, double squareFootage){
        super(id, address, pricing, status, owner);
        this.businessType = businessType;
        this.parkingSlots = parkingSlots;
        this.squareFootage = squareFootage;
    }

    public void setBusinessType(String businessType) {
        this.businessType = businessType;
    }

    public String getBusinessType() {
        return businessType;
    }

    public void setParkingSlots(int parkingSlots) {
        this.parkingSlots = parkingSlots;
    }

    public int getParkingSlots() {
        return parkingSlots;
    }

    public void setSquareFootage(double squareFootage) {
        this.squareFootage = squareFootage;
    }

    public double getSquareFootage() {
        return squareFootage;
    }

    @Override
    public boolean equals(Object obj){
        if(!(obj instanceof CommercialProperty)){
            return false;
        }
        if(obj == this){
            return true;
        }
        return super.getId().equals(((CommercialProperty) obj).getId());
    }

    @Override
    public int hashCode(){
        return super.getId().hashCode();
    }
}

package model;

import java.util.Date;
import java.util.HashSet;

public class Host extends Person{
    private HashSet<Property> properties;
    private HashSet<RentalAgreement> rentalAgreements;
    private HashSet<Owner> cooperatingOwners;

    public Host() {
        this.properties = new HashSet<Property>();
        this.rentalAgreements = new HashSet<RentalAgreement>();
        this.cooperatingOwners = new HashSet<Owner>();
    }

    public Host(String id, String fullName, Date dateOfBirth, String contactInformation){
        super(id, fullName, dateOfBirth, contactInformation);
        this.properties = new HashSet<Property>();
        this.rentalAgreements = new HashSet<RentalAgreement>();
        this.cooperatingOwners = new HashSet<Owner>();
    }

    public void addProperty(Property property) {
        this.properties.add(property);
    }

    public HashSet<Property> getProperties(){
        return properties;
    }

    public void addRentalAgreement(RentalAgreement rentalAgreement){
        this.rentalAgreements.add(rentalAgreement);
    }

    public HashSet<RentalAgreement> getRentalAgreements() {
        return rentalAgreements;
    }

    public void addCooperatingOwner(Owner owner){
        this.cooperatingOwners.add(owner);
    }

    public HashSet<Owner> getCooperatingOwners(){
        return cooperatingOwners;
    }

    @Override
    public boolean equals(Object obj){
        if(!(obj instanceof Host)){
            return false;
        }
        if(obj == this){
            return true;
        }
        return super.getId().equals(((Host) obj).getId());
    }

    @Override
    public int hashCode(){
        return super.getId().hashCode();
    }
}

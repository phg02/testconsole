package model;

import java.util.Date;
import java.util.HashSet;


public class Owner extends Person{
    private HashSet<Property> properties;
    private HashSet <Host> cooperatingHosts;
    private HashSet <RentalAgreement> rentalAgreements;

    public Owner() {
        this.properties = new HashSet<Property>();
        this.cooperatingHosts = new HashSet<Host>();
        this.rentalAgreements = new HashSet<RentalAgreement>();
    }

    public Owner(String id, String fullName, Date dateOfBirth, String contactInformation) {
        super(id, fullName, dateOfBirth, contactInformation);
        this.properties = new HashSet<Property>();
        this.cooperatingHosts = new HashSet<Host>();
        this.rentalAgreements = new HashSet<RentalAgreement>();
    }

    public void addProperties(Property property){
        this.properties.add(property);
    }

    public HashSet <Property> getProperties(){
        return properties;
    }

    public void addCooperatingHost(Host host){
        this.cooperatingHosts.add(host);
    }

    public HashSet <Host> getCooperatingHosts(){
        return cooperatingHosts;
    }

    public void addRentalAgreement(RentalAgreement rentalAgreement){
        this.rentalAgreements.add(rentalAgreement);
    }

    public HashSet <RentalAgreement> getRentalAgreements(){
        return rentalAgreements;
    }

    @Override
    public boolean equals(Object obj){
        if(!(obj instanceof Owner)){
            return false;
        }
        if(obj == this){
            return true;
        }
        return super.getId().equals(((Owner) obj).getId());
    }

    @Override
    public int hashCode(){
        return super.getId().hashCode();
    }
}

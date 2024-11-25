package model;

import java.util.Date;
import java.util.HashSet;

public class Tenant extends Person{
    private HashSet<RentalAgreement> rentalAgreements;
    private HashSet<Payment> payments;

    public Tenant() {
        this.rentalAgreements = new HashSet<>();
        this.payments = new HashSet<Payment>();
    }

    public Tenant(String id, String fullName, Date dateOfBirth, String contactInformation) {
        super(id, fullName, dateOfBirth,contactInformation);
        this.rentalAgreements = new HashSet<RentalAgreement>();
        this.payments = new HashSet<Payment>();
    }

    public void addRentalAgreement(RentalAgreement rentalAgreement){
        this.rentalAgreements.add(rentalAgreement);
    }

    public HashSet<RentalAgreement> getRentalAgreements() {
        return rentalAgreements;
    }

    public void addPayment(Payment payment){
        this.payments.add(payment);
    }

    public HashSet<Payment> getPayments(){
        return payments;
    }

    @Override
    public boolean equals(Object obj){
        if(!(obj instanceof Tenant)){
            return false;
        }
        if(obj == this){
            return true;
        }
        return super.getId().equals(((Tenant) obj).getId());
    }

    @Override
    public int hashCode(){
        return super.getId().hashCode();
    }
}

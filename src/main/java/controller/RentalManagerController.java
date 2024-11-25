package controller;

import model.RentalAgreement;

import java.util.HashSet;

public interface RentalManagerController {
    HashSet<RentalAgreement> getAllRentalAgreements();
    RentalAgreement getRentalAgreementByID(String propertyId);
    HashSet<RentalAgreement> getRentalAgreementByOwnerName(String tenant);
    HashSet<RentalAgreement> getRentalAgreementByProperty(String property);
    boolean addRentalAgreement(RentalAgreement rentalAgreement);
    boolean updateRentalAgreement(RentalAgreement rentalAgreement);
    boolean deleteRentalAgreement(String rentalAgreementId);

}

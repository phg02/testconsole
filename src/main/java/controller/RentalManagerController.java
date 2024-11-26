package controller;

import model.RentalAgreement;

import java.util.HashSet;
import java.util.List;

public interface RentalManagerController {
    List<RentalAgreement> getAllRentalAgreementsSortByID();
    List<RentalAgreement> getAllRentalAgreementsSortByStartDate();
    List<RentalAgreement> getAllRentalAgreementsSortByEndDate();
    List<RentalAgreement> getAllRentalAgreementsSortByHost();
    List<RentalAgreement> getAllRentalAgreementsSortByTenant();
    List<RentalAgreement> getAllRentalAgreementsSortByProperty();
    List<RentalAgreement> getAllRentalAgreementsSortByOwner();
    RentalAgreement getRentalAgreementByID(String propertyId);
    HashSet<RentalAgreement> getRentalAgreementByOwner(String ownerID);
    HashSet<RentalAgreement> getRentalAgreementByHost(String hostID);
    HashSet<RentalAgreement> getRentalAgreementByTenant(String tenantID);
    HashSet<RentalAgreement> getRentalAgreementByProperty(String property);
    HashSet<RentalAgreement> getRentalAgreementByStatus(String startDate);
    boolean addRentalAgreement(RentalAgreement rentalAgreement);
    boolean updateRentalAgreement(RentalAgreement rentalAgreement);
    boolean deleteRentalAgreement(String rentalAgreementId);

}

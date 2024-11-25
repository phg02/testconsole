package controller.impl;
import controller.RentalManagerController;
import model.RentalAgreement;
import util.FileHandler;

import java.util.HashSet;
import java.util.stream.Collectors;

public class RentalManagerImpl implements RentalManagerController {
    private HashSet<RentalAgreement> rentalAgreements;
    private FileHandler fileHandler;

    public RentalManagerImpl(FileHandler fileHandler) {
        this.fileHandler = fileHandler;
        this.rentalAgreements = this.fileHandler.getRentalAgreement();
    }

    @Override
    public HashSet<RentalAgreement> getAllRentalAgreements() {
        return rentalAgreements;
    }

    @Override
    public RentalAgreement getRentalAgreementByID(String propertyId) {
//        for(RentalAgreement agreement : rentalAgreements) {
//            if (agreement.getId().equals(propertyId)) {
//                return agreement;
//            }
//        }
//        return null;
        return rentalAgreements.stream().filter(agreement -> agreement.getId().equals(propertyId)).findFirst().orElse(null);
    }

    @Override
    public HashSet<RentalAgreement> getRentalAgreementByOwnerName(String ownerName) {
        return (HashSet<RentalAgreement>) rentalAgreements.stream().filter(agreement -> agreement.getOwner().getFullName().equals(ownerName)).collect(Collectors.toSet());
    }

    @Override
    public HashSet<RentalAgreement> getRentalAgreementByProperty(String propertyAddress) {
        return (HashSet<RentalAgreement>) rentalAgreements.stream().filter(rentalAgreement -> rentalAgreement.getProperty().getAddress().equals(propertyAddress)).collect(Collectors.toSet());
    }

    @Override
    public boolean addRentalAgreement(RentalAgreement rentalAgreement) {
        try{
            return rentalAgreements.add(rentalAgreement);
        }catch(Exception e){
            System.err.print("ERROR updating rental agreement: " + e.getMessage());
            return false;
        }
    }

    @Override
    public boolean updateRentalAgreement(RentalAgreement rentalAgreement) {
        for(RentalAgreement agreement : rentalAgreements) {
            if (agreement.getId().equals(rentalAgreement.getId())) {
                rentalAgreements.remove(agreement);
                rentalAgreements.add(rentalAgreement);
                return true;
            }
        }
        return false;

    }

    @Override
    public boolean deleteRentalAgreement(String rentalAgreementId){
        for(RentalAgreement agreement : rentalAgreements) {
            if (agreement.getId().equals(rentalAgreementId)) {
                rentalAgreements.remove(agreement);
                return true;
            }
        }
        return false;

    }


}

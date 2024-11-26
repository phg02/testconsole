package controller.impl;
import controller.RentalManagerController;
import model.RentalAgreement;
import util.FileHandler;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class RentalManagerImpl implements RentalManagerController {
    private HashSet<RentalAgreement> rentalAgreements;
    private FileHandler fileHandler;

    public RentalManagerImpl(FileHandler fileHandler) {
        this.fileHandler = fileHandler;
        this.rentalAgreements = this.fileHandler.getRentalAgreement();
    }

    @Override
    public List<RentalAgreement> getAllRentalAgreementsSortByID() {
        List<RentalAgreement> sortedList = new ArrayList<>(rentalAgreements);
        sortedList.sort(Comparator.comparing(RentalAgreement::getId));
        return sortedList;
    }

    @Override
    public List<RentalAgreement> getAllRentalAgreementsSortByStartDate() {
        List<RentalAgreement> sortedList = new ArrayList<>(rentalAgreements);
        sortedList.sort(Comparator.comparing(RentalAgreement::getStartDate));
        return sortedList;
    }

    @Override
    public List<RentalAgreement> getAllRentalAgreementsSortByEndDate() {
        List<RentalAgreement> sortedList = new ArrayList<>(rentalAgreements);
        sortedList.sort(Comparator.comparing(RentalAgreement::getEndDate));
        return sortedList;
    }

    @Override
    public List<RentalAgreement> getAllRentalAgreementsSortByHost() {
        List<RentalAgreement> sortedList = new ArrayList<>(rentalAgreements);
        sortedList.sort(Comparator.comparing(rentalAgreement -> rentalAgreement.getHost().getId()));
        return sortedList;
    }

    @Override
    public List<RentalAgreement> getAllRentalAgreementsSortByTenant() {
        List<RentalAgreement> sortedList = new ArrayList<>(rentalAgreements);
        sortedList.sort(Comparator.comparing(rentalAgreement -> rentalAgreement.getMainTenant().getId()));
        return sortedList;
    }

    @Override
    public List<RentalAgreement> getAllRentalAgreementsSortByProperty() {
        List<RentalAgreement> sortedList = new ArrayList<>(rentalAgreements);
        sortedList.sort(Comparator.comparing(rentalAgreement -> rentalAgreement.getProperty().getId()));
        return sortedList;
    }

    @Override
    public List<RentalAgreement> getAllRentalAgreementsSortByOwner() {
        List<RentalAgreement> sortList = new ArrayList<>(rentalAgreements);
        sortList.sort(Comparator.comparing(rentalAgreement -> rentalAgreement.getOwner().getId()));
        return sortList;
    }

    @Override
    public RentalAgreement getRentalAgreementByID(String Id) {
        return rentalAgreements.stream().filter(agreement -> agreement.getId().equals(Id)).findFirst().orElse(null);
    }

    @Override
    public HashSet<RentalAgreement> getRentalAgreementByOwner(String ownerID) {
        return (HashSet<RentalAgreement>) rentalAgreements.stream().filter(agreement -> agreement.getOwner().getId().equals(ownerID)).collect(Collectors.toSet());
    }

    @Override
    public HashSet<RentalAgreement> getRentalAgreementByHost(String hostID) {
        return (HashSet<RentalAgreement>) rentalAgreements.stream().filter(rentalAgreement -> rentalAgreement.getHost().getId().equals(hostID)).collect(Collectors.toSet());
    }

    @Override
    public HashSet<RentalAgreement> getRentalAgreementByTenant(String tenantID) {
        return (HashSet<RentalAgreement>) rentalAgreements.stream().filter(rentalAgreement -> rentalAgreement.getMainTenant().getId().equals(tenantID)).collect(Collectors.toSet());
    }

    @Override
    public HashSet<RentalAgreement> getRentalAgreementByProperty(String propertyID) {
        return (HashSet<RentalAgreement>) rentalAgreements.stream().filter(rentalAgreement -> rentalAgreement.getProperty().getId().equals(propertyID)).collect(Collectors.toSet());
    }

    @Override
    public HashSet<RentalAgreement> getRentalAgreementByStatus(String finalStatus) {
        return getAllRentalAgreementsSortByID().stream()
              .filter(rentalAgreement -> rentalAgreement.getStatus().name().equals(finalStatus))
                .collect(HashSet::new, HashSet::add, HashSet::addAll);
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

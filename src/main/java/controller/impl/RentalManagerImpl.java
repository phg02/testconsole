package controller.impl;
/*
  @author <Nguyen Minh Phuong - s4063236>
 */

import controller.RentalManagerController;
import model.RentalAgreement;
import util.FileHandler;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Implementation of the RentalManagerController interface.
 * Manages rental agreements using a file handler.
 */
public class RentalManagerImpl implements RentalManagerController {
    private HashSet<RentalAgreement> rentalAgreements;
    private FileHandler fileHandler;

    /**
     * Constructor to initialize the file handler and load rental agreements.
     *
     * @param fileHandler The file handler to load and save rental agreements.
     */
    public RentalManagerImpl(FileHandler fileHandler) {
        this.fileHandler = fileHandler;
        this.rentalAgreements = this.fileHandler.getRentalAgreement();
    }

    /**
     * Retrieves all rental agreements sorted by ID.
     *
     * @return A list of all rental agreements sorted by ID.
     */
    @Override
    public List<RentalAgreement> getAllRentalAgreementsSortByID() {
        List<RentalAgreement> sortedList = new ArrayList<>(rentalAgreements);
        sortedList.sort(Comparator.comparing(RentalAgreement::getId));
        return sortedList;
    }

    /**
     * Retrieves all rental agreements sorted by start date.
     *
     * @return A list of all rental agreements sorted by start date.
     */
    @Override
    public List<RentalAgreement> getAllRentalAgreementsSortByStartDate() {
        List<RentalAgreement> sortedList = new ArrayList<>(rentalAgreements);
        sortedList.sort(Comparator.comparing(RentalAgreement::getStartDate));
        return sortedList;
    }

    /**
     * Retrieves all rental agreements sorted by end date.
     *
     * @return A list of all rental agreements sorted by end date.
     */
    @Override
    public List<RentalAgreement> getAllRentalAgreementsSortByEndDate() {
        List<RentalAgreement> sortedList = new ArrayList<>(rentalAgreements);
        sortedList.sort(Comparator.comparing(RentalAgreement::getEndDate));
        return sortedList;
    }

    /**
     * Retrieves all rental agreements sorted by host.
     *
     * @return A list of all rental agreements sorted by host.
     */
    @Override
    public List<RentalAgreement> getAllRentalAgreementsSortByHost() {
        List<RentalAgreement> sortedList = new ArrayList<>(rentalAgreements);
        sortedList.sort(Comparator.comparing(rentalAgreement -> rentalAgreement.getHost().getId()));
        return sortedList;
    }

    /**
     * Retrieves all rental agreements sorted by tenant.
     *
     * @return A list of all rental agreements sorted by tenant.
     */
    @Override
    public List<RentalAgreement> getAllRentalAgreementsSortByTenant() {
        List<RentalAgreement> sortedList = new ArrayList<>(rentalAgreements);
        sortedList.sort(Comparator.comparing(rentalAgreement -> rentalAgreement.getMainTenant().getId()));
        return sortedList;
    }

    /**
     * Retrieves all rental agreements sorted by property.
     *
     * @return A list of all rental agreements sorted by property.
     */
    @Override
    public List<RentalAgreement> getAllRentalAgreementsSortByProperty() {
        List<RentalAgreement> sortedList = new ArrayList<>(rentalAgreements);
        sortedList.sort(Comparator.comparing(rentalAgreement -> rentalAgreement.getProperty().getId()));
        return sortedList;
    }

    /**
     * Retrieves all rental agreements sorted by owner.
     *
     * @return A list of all rental agreements sorted by owner.
     */
    @Override
    public List<RentalAgreement> getAllRentalAgreementsSortByOwner() {
        List<RentalAgreement> sortList = new ArrayList<>(rentalAgreements);
        sortList.sort(Comparator.comparing(rentalAgreement -> rentalAgreement.getOwner().getId()));
        return sortList;
    }

    /**
     * Retrieves a rental agreement by its unique identifier.
     *
     * @param Id The unique identifier of the rental agreement.
     * @return The rental agreement with the specified ID, or null if not found.
     */
    @Override
    public RentalAgreement getRentalAgreementByID(String Id) {
        return rentalAgreements.stream().filter(agreement -> agreement.getId().equals(Id)).findFirst().orElse(null);
    }

    /**
     * Retrieves rental agreements by owner ID.
     *
     * @param ownerID The unique identifier of the owner.
     * @return A set of rental agreements associated with the specified owner ID.
     */
    @Override
    public HashSet<RentalAgreement> getRentalAgreementByOwner(String ownerID) {
        return (HashSet<RentalAgreement>) rentalAgreements.stream().filter(agreement -> agreement.getOwner().getId().equals(ownerID)).collect(Collectors.toSet());
    }

    /**
     * Retrieves rental agreements by host ID.
     *
     * @param hostID The unique identifier of the host.
     * @return A set of rental agreements associated with the specified host ID.
     */
    @Override
    public HashSet<RentalAgreement> getRentalAgreementByHost(String hostID) {
        return (HashSet<RentalAgreement>) rentalAgreements.stream().filter(rentalAgreement -> rentalAgreement.getHost().getId().equals(hostID)).collect(Collectors.toSet());
    }

    /**
     * Retrieves rental agreements by tenant ID.
     *
     * @param tenantID The unique identifier of the tenant.
     * @return A set of rental agreements associated with the specified tenant ID.
     */
    @Override
    public HashSet<RentalAgreement> getRentalAgreementByTenant(String tenantID) {
        return (HashSet<RentalAgreement>) rentalAgreements.stream().filter(rentalAgreement -> rentalAgreement.getMainTenant().getId().equals(tenantID)).collect(Collectors.toSet());
    }

    /**
     * Retrieves rental agreements by property ID.
     *
     * @param propertyID The unique identifier of the property.
     * @return A set of rental agreements associated with the specified property ID.
     */
    @Override
    public HashSet<RentalAgreement> getRentalAgreementByProperty(String propertyID) {
        return (HashSet<RentalAgreement>) rentalAgreements.stream().filter(rentalAgreement -> rentalAgreement.getProperty().getId().equals(propertyID)).collect(Collectors.toSet());
    }

    /**
     * Retrieves rental agreements by status.
     *
     * @param finalStatus The status of the rental agreement.
     * @return A set of rental agreements with the specified status.
     */
    @Override
    public HashSet<RentalAgreement> getRentalAgreementByStatus(String finalStatus) {
        return getAllRentalAgreementsSortByID().stream()
                .filter(rentalAgreement -> rentalAgreement.getStatus().name().equals(finalStatus))
                .collect(HashSet::new, HashSet::add, HashSet::addAll);
    }

    /**
     * Adds a new rental agreement.
     *
     * @param rentalAgreement The rental agreement to be added.
     * @return true if the rental agreement was added successfully, false otherwise.
     */
    @Override
    public boolean addRentalAgreement(RentalAgreement rentalAgreement) {
        try {
            if (!rentalAgreements.add(rentalAgreement)) {
                return false;
            }
            fileHandler.saveDataRentalAgreement(rentalAgreements);
            return true;

        } catch (Exception e) {
            System.err.print("ERROR updating rental agreement: " + e.getMessage());
            return false;
        }
    }

    /**
     * Updates an existing rental agreement.
     *
     * @param rentalAgreement The rental agreement with updated details.
     * @return true if the rental agreement was updated successfully, false otherwise.
     */
    @Override
    public boolean updateRentalAgreement(RentalAgreement rentalAgreement) {
        for (RentalAgreement agreement : rentalAgreements) {
            if (agreement.getId().equals(rentalAgreement.getId())) {
                rentalAgreements.remove(agreement);
                rentalAgreements.add(rentalAgreement);
                return true;
            }
        }
        return false;
    }

    /**
     * Deletes a rental agreement by its unique identifier.
     *
     * @param rentalAgreementId The unique identifier of the rental agreement to be deleted.
     * @return true if the rental agreement was deleted successfully, false otherwise.
     */
    @Override
    public boolean deleteRentalAgreement(String rentalAgreementId) {
        for (RentalAgreement agreement : rentalAgreements) {
            if (agreement.getId().equals(rentalAgreementId)) {
                rentalAgreements.remove(agreement);
                fileHandler.saveDataRentalAgreement(rentalAgreements);
                return true;
            }
        }
        return false;
    }
}
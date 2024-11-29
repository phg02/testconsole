package controller;
/*
  @author <Nguyen Minh Phuong - s4063236>
 */

import model.RentalAgreement;

import java.util.HashSet;
import java.util.List;

/**
 * Interface for managing rental agreements.
 */
public interface RentalManagerController {
    /**
     * Retrieves all rental agreements sorted by their unique identifier.
     *
     * @return A list of all rental agreements sorted by ID.
     */
    List<RentalAgreement> getAllRentalAgreementsSortByID();

    /**
     * Retrieves all rental agreements sorted by their start date.
     *
     * @return A list of all rental agreements sorted by start date.
     */
    List<RentalAgreement> getAllRentalAgreementsSortByStartDate();

    /**
     * Retrieves all rental agreements sorted by their end date.
     *
     * @return A list of all rental agreements sorted by end date.
     */
    List<RentalAgreement> getAllRentalAgreementsSortByEndDate();

    /**
     * Retrieves all rental agreements sorted by their host.
     *
     * @return A list of all rental agreements sorted by host.
     */
    List<RentalAgreement> getAllRentalAgreementsSortByHost();

    /**
     * Retrieves all rental agreements sorted by their tenant.
     *
     * @return A list of all rental agreements sorted by tenant.
     */
    List<RentalAgreement> getAllRentalAgreementsSortByTenant();

    /**
     * Retrieves all rental agreements sorted by their property.
     *
     * @return A list of all rental agreements sorted by property.
     */
    List<RentalAgreement> getAllRentalAgreementsSortByProperty();

    /**
     * Retrieves all rental agreements sorted by their owner.
     *
     * @return A list of all rental agreements sorted by owner.
     */
    List<RentalAgreement> getAllRentalAgreementsSortByOwner();

    /**
     * Retrieves a rental agreement by its unique identifier.
     *
     * @param propertyId The unique identifier of the rental agreement.
     * @return The rental agreement with the specified ID, or null if not found.
     */
    RentalAgreement getRentalAgreementByID(String propertyId);

    /**
     * Retrieves rental agreements by the owner's unique identifier.
     *
     * @param ownerID The unique identifier of the owner.
     * @return A set of rental agreements associated with the specified owner ID.
     */
    HashSet<RentalAgreement> getRentalAgreementByOwner(String ownerID);

    /**
     * Retrieves rental agreements by the host's unique identifier.
     *
     * @param hostID The unique identifier of the host.
     * @return A set of rental agreements associated with the specified host ID.
     */
    HashSet<RentalAgreement> getRentalAgreementByHost(String hostID);

    /**
     * Retrieves rental agreements by the tenant's unique identifier.
     *
     * @param tenantID The unique identifier of the tenant.
     * @return A set of rental agreements associated with the specified tenant ID.
     */
    HashSet<RentalAgreement> getRentalAgreementByTenant(String tenantID);

    /**
     * Retrieves rental agreements by the property's unique identifier.
     *
     * @param property The unique identifier of the property.
     * @return A set of rental agreements associated with the specified property.
     */
    HashSet<RentalAgreement> getRentalAgreementByProperty(String property);

    /**
     * Retrieves rental agreements by their status.
     *
     * @param startDate The start date of the rental agreement.
     * @return A set of rental agreements with the specified status.
     */
    HashSet<RentalAgreement> getRentalAgreementByStatus(String startDate);

    /**
     * Adds a new rental agreement.
     *
     * @param rentalAgreement The rental agreement to be added.
     * @return true if the rental agreement was added successfully, false otherwise.
     */
    boolean addRentalAgreement(RentalAgreement rentalAgreement);

    /**
     * Updates an existing rental agreement.
     *
     * @param rentalAgreement The rental agreement with updated details.
     * @return true if the rental agreement was updated successfully, false otherwise.
     */
    boolean updateRentalAgreement(RentalAgreement rentalAgreement);

    /**
     * Deletes a rental agreement by its unique identifier.
     *
     * @param rentalAgreementId The unique identifier of the rental agreement to be deleted.
     * @return true if the rental agreement was deleted successfully, false otherwise.
     */
    boolean deleteRentalAgreement(String rentalAgreementId);
}
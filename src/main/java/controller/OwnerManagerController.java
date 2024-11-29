package controller;
/*
  @author <Nguyen Minh Phuong - s4063236>
 */

import model.Owner;

import java.util.HashSet;

/**
 * Interface for managing owners.
 */
public interface OwnerManagerController {
    /**
     * Retrieves all owners.
     *
     * @return A set of all owners.
     */
    HashSet<Owner> getAllOwners();

    /**
     * Retrieves an owner by their unique identifier.
     *
     * @param ownerId The unique identifier of the owner.
     * @return The owner with the specified ID, or null if not found.
     */
    Owner getOwnerByID(String ownerId);

    /**
     * Retrieves owners by their full name.
     *
     * @param fullName The full name of the owner.
     * @return A set of owners with the specified full name.
     */
    HashSet<Owner> getOwnerByFullName(String fullName);

    /**
     * Retrieves an owner by their contact information.
     *
     * @param contactInformation The contact information of the owner.
     * @return The owner with the specified contact information, or null if not found.
     */
    Owner getOwnerByContactInformation(String contactInformation);

    /**
     * Adds a new owner.
     *
     * @param owner The owner to be added.
     * @return true if the owner was added successfully, false otherwise.
     */
    boolean addOwner(Owner owner);

    /**
     * Updates an existing owner.
     *
     * @param owner The owner with updated details.
     * @return true if the owner was updated successfully, false otherwise.
     */
    boolean updateOwner(Owner owner);

    /**
     * Deletes an owner by their unique identifier.
     *
     * @param ownerId The unique identifier of the owner to be deleted.
     * @return true if the owner was deleted successfully, false otherwise.
     */
    boolean deleteOwner(String ownerId);
}
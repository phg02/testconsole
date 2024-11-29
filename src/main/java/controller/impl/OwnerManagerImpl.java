package controller.impl;
/*
  @author <Nguyen Minh Phuong - s4063236>
 */

import controller.OwnerManagerController;
import model.Owner;

import java.util.HashSet;
import java.util.stream.Collectors;

import util.FileHandler;

/**
 * Implementation of the OwnerManagerController interface.
 * Manages owners using a file handler.
 */
public class OwnerManagerImpl implements OwnerManagerController {
    private HashSet<Owner> owners;
    private FileHandler fileHandler;

    /**
     * Constructor to initialize the file handler and load owners.
     *
     * @param fileHandler The file handler to load and save owners.
     */
    public OwnerManagerImpl(FileHandler fileHandler) {
        this.fileHandler = fileHandler;
        owners = this.fileHandler.getOwnerData();
    }

    /**
     * Retrieves all owners.
     *
     * @return A set of all owners.
     */
    @Override
    public HashSet<Owner> getAllOwners() {
        return owners;
    }

    /**
     * Retrieves an owner by its unique identifier.
     *
     * @param ownerId The unique identifier of the owner.
     * @return The owner with the specified ID, or null if not found.
     */
    @Override
    public Owner getOwnerByID(String ownerId) {
        return owners.stream().filter(owner -> owner.getId().equals(ownerId)).findFirst().orElse(null);
    }

    /**
     * Retrieves owners by their full name.
     *
     * @param fullName The full name of the owner.
     * @return A set of owners with the specified full name.
     */
    @Override
    public HashSet<Owner> getOwnerByFullName(String fullName) {
        return (HashSet<Owner>) owners.stream().filter(owner -> owner.getFullName().equals(fullName)).collect(Collectors.toSet());
    }

    /**
     * Retrieves an owner by its contact information.
     *
     * @param contactInformation The contact information of the owner.
     * @return The owner with the specified contact information, or null if not found.
     */
    @Override
    public Owner getOwnerByContactInformation(String contactInformation) {
        return owners.stream().filter(owner -> owner.getContactInformation().equals(contactInformation)).findFirst().orElse(null);
    }

    /**
     * Adds a new owner.
     *
     * @param owner The owner to be added.
     * @return true if the owner was added successfully, false otherwise.
     */
    @Override
    public boolean addOwner(Owner owner) {
        return false;
    }

    /**
     * Updates an existing owner.
     *
     * @param owner The owner with updated details.
     * @return true if the owner was updated successfully, false otherwise.
     */
    @Override
    public boolean updateOwner(Owner owner) {
        return false;
    }

    /**
     * Deletes an owner by its unique identifier.
     *
     * @param ownerId The unique identifier of the owner to be deleted.
     * @return true if the owner was deleted successfully, false otherwise.
     */
    @Override
    public boolean deleteOwner(String ownerId) {
        return false;
    }
}
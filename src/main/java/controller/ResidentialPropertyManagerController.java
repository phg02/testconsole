package controller;
/*
  @author <Nguyen Minh Phuong - s4063236>
 */

import model.ResidentialProperty;

import java.util.HashSet;

/**
 * Interface for managing residential properties.
 */
public interface ResidentialPropertyManagerController {
    /**
     * Retrieves all residential properties.
     *
     * @return A set of all residential properties.
     */
    HashSet<ResidentialProperty> getAllResidentialProperties();

    /**
     * Retrieves a residential property by its unique identifier.
     *
     * @param residentialPropertyId The unique identifier of the residential property.
     * @return The residential property with the specified ID, or null if not found.
     */
    ResidentialProperty getResidentialPropertyByID(String residentialPropertyId);

    /**
     * Retrieves a residential property by its address.
     *
     * @param address The address of the residential property.
     * @return The residential property with the specified address, or null if not found.
     */
    ResidentialProperty getResidentialPropertyByAddress(String address);

    /**
     * Adds a new residential property.
     *
     * @param residentialProperty The residential property to be added.
     * @return true if the residential property was added successfully, false otherwise.
     */
    boolean addResidentialProperty(ResidentialProperty residentialProperty);

    /**
     * Updates an existing residential property.
     *
     * @param residentialProperty The residential property with updated details.
     * @return true if the residential property was updated successfully, false otherwise.
     */
    boolean updateResidentialProperty(ResidentialProperty residentialProperty);

    /**
     * Deletes a residential property by its unique identifier.
     *
     * @param residentialPropertyId The unique identifier of the residential property to be deleted.
     * @return true if the residential property was deleted successfully, false otherwise.
     */
    boolean deleteResidentialProperty(String residentialPropertyId);
}
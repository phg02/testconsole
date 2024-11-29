package controller.impl;
/*
  @author <Nguyen Minh Phuong - s4063236>
 */

import controller.ResidentialPropertyManagerController;
import model.ResidentialProperty;
import util.FileHandler;

import java.util.HashSet;

/**
 * Implementation of the ResidentialPropertyManagerController interface.
 * Manages residential properties using a file handler.
 */
public class ResidentialPropertyManagerImpl implements ResidentialPropertyManagerController {
    private HashSet<ResidentialProperty> residentialProperties;
    private FileHandler fileHandler;

    /**
     * Constructor to initialize the file handler and load residential properties.
     *
     * @param fileHandler The file handler to load and save residential properties.
     */
    public ResidentialPropertyManagerImpl(FileHandler fileHandler) {
        this.fileHandler = fileHandler;
        residentialProperties = this.fileHandler.getResidentialProperty();
    }

    /**
     * Retrieves all residential properties.
     *
     * @return A set of all residential properties.
     */
    @Override
    public HashSet<ResidentialProperty> getAllResidentialProperties() {
        return residentialProperties;
    }

    /**
     * Retrieves a residential property by its unique identifier.
     *
     * @param residentialPropertyId The unique identifier of the residential property.
     * @return The residential property with the specified ID, or null if not found.
     */
    @Override
    public ResidentialProperty getResidentialPropertyByID(String residentialPropertyId) {
        for (ResidentialProperty residentialProperty : residentialProperties) {
            if (residentialProperty.getId().equals(residentialPropertyId)) {
                return residentialProperty;
            }
        }
        return null;
    }

    /**
     * Retrieves a residential property by its address.
     *
     * @param address The address of the residential property.
     * @return The residential property with the specified address, or null if not found.
     */
    @Override
    public ResidentialProperty getResidentialPropertyByAddress(String address) {
        return residentialProperties.stream().filter(residentialProperty -> residentialProperty.getAddress().equals(address)).findFirst().orElse(null);
    }

    /**
     * Adds a new residential property.
     *
     * @param residentialProperty The residential property to be added.
     * @return true if the residential property was added successfully, false otherwise.
     */
    @Override
    public boolean addResidentialProperty(ResidentialProperty residentialProperty) {
        return false;
    }

    /**
     * Updates an existing residential property.
     *
     * @param residentialProperty The residential property with updated details.
     * @return true if the residential property was updated successfully, false otherwise.
     */
    @Override
    public boolean updateResidentialProperty(ResidentialProperty residentialProperty) {
        return false;
    }

    /**
     * Deletes a residential property by its unique identifier.
     *
     * @param residentialPropertyId The unique identifier of the residential property to be deleted.
     * @return true if the residential property was deleted successfully, false otherwise.
     */
    @Override
    public boolean deleteResidentialProperty(String residentialPropertyId) {
        return false;
    }
}
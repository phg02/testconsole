package controller.impl;
/*
  @author <Nguyen Minh Phuong - s4063236>
 */

import controller.CommercialPropertyManagerController;
import model.CommercialProperty;
import util.FileHandler;

import java.util.HashSet;
import java.util.stream.Collectors;

/**
 * Implementation of the CommercialPropertyManagerController interface.
 * Manages commercial properties using a file handler.
 */
public class CommercialPropertyManagerImpl implements CommercialPropertyManagerController {
    private HashSet<CommercialProperty> commercialProperties;
    private FileHandler fileHandler;

    /**
     * Constructor to initialize the file handler and load commercial properties.
     *
     * @param fileHandler The file handler to load and save commercial properties.
     */
    public CommercialPropertyManagerImpl(FileHandler fileHandler) {
        this.fileHandler = fileHandler;
        commercialProperties = this.fileHandler.getCommercialProperty();
    }

    /**
     * Retrieves all commercial properties.
     *
     * @return A set of all commercial properties.
     */
    @Override
    public HashSet<CommercialProperty> getAllCommercialProperties() {
        return commercialProperties;
    }

    /**
     * Retrieves a commercial property by its unique identifier.
     *
     * @param commercialPropertyId The unique identifier of the commercial property.
     * @return The commercial property with the specified ID, or null if not found.
     */
    @Override
    public CommercialProperty getCommercialPropertyByID(String commercialPropertyId) {
        return commercialProperties.stream().filter(commercialProperty -> commercialProperty.getId().equals(commercialPropertyId)).findFirst().orElse(null);
    }

    /**
     * Retrieves a commercial property by its address.
     *
     * @param address The address of the commercial property.
     * @return The commercial property with the specified address, or null if not found.
     */
    @Override
    public CommercialProperty getCommercialPropertyByAddress(String address) {
        return commercialProperties.stream().filter(commercialProperty -> commercialProperty.getAddress().equals(address)).findFirst().orElse(null);
    }

    /**
     * Adds a new commercial property.
     *
     * @param commercialProperty The commercial property to be added.
     * @return true if the commercial property was added successfully, false otherwise.
     */
    @Override
    public boolean addCommercialProperty(CommercialProperty commercialProperty) {
        return false;
    }

    /**
     * Updates an existing commercial property.
     *
     * @param commercialProperty The commercial property with updated details.
     * @return true if the commercial property was updated successfully, false otherwise.
     */
    @Override
    public boolean updateCommercialProperty(CommercialProperty commercialProperty) {
        return false;
    }

    /**
     * Deletes a commercial property by its unique identifier.
     *
     * @param commercialPropertyId The unique identifier of the commercial property to be deleted.
     * @return true if the commercial property was deleted successfully, false otherwise.
     */
    @Override
    public boolean deleteCommercialProperty(String commercialPropertyId) {
        return false;
    }
}
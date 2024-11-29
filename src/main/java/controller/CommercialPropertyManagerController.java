package controller;
/*
  @author <Nguyen Minh Phuong - s4063236>
 */
import model.CommercialProperty;

import java.util.HashSet;

/**
 * Interface for managing commercial properties.
 */
public interface CommercialPropertyManagerController {
    /**
     * Retrieves all commercial properties.
     *
     * @return A set of all commercial properties.
     */
    HashSet<CommercialProperty> getAllCommercialProperties();

    /**
     * Retrieves a commercial property by its unique identifier.
     *
     * @param commercialPropertyId The unique identifier of the commercial property.
     * @return The commercial property with the specified ID, or null if not found.
     */
    CommercialProperty getCommercialPropertyByID(String commercialPropertyId);

    /**
     * Retrieves a commercial property by its address.
     *
     * @param address The address of the commercial property.
     * @return The commercial property with the specified address, or null if not found.
     */
    CommercialProperty getCommercialPropertyByAddress(String address);

    /**
     * Adds a new commercial property.
     *
     * @param commercialProperty The commercial property to be added.
     * @return true if the property was added successfully, false otherwise.
     */
    boolean addCommercialProperty(CommercialProperty commercialProperty);

    /**
     * Updates an existing commercial property.
     *
     * @param commercialProperty The commercial property with updated details.
     * @return true if the property was updated successfully, false otherwise.
     */
    boolean updateCommercialProperty(CommercialProperty commercialProperty);

    /**
     * Deletes a commercial property by its unique identifier.
     *
     * @param commercialPropertyId The unique identifier of the commercial property to be deleted.
     * @return true if the property was deleted successfully, false otherwise.
     */
    boolean deleteCommercialProperty(String commercialPropertyId);
}
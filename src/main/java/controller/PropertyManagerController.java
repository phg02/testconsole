package controller;
/*
  @author <Nguyen Minh Phuong - s4063236>
 */

import model.Property;

import java.util.HashSet;

/**
 * Interface for managing properties.
 */
public interface PropertyManagerController {
    /**
     * Retrieves all properties.
     *
     * @return A set of all properties.
     */
    HashSet<Property> getAllProperties();

    /**
     * Retrieves a property by its unique identifier.
     *
     * @param id The unique identifier of the property.
     * @return The property with the specified ID, or null if not found.
     */
    Property getPropertyByID(String id);

    /**
     * Retrieves a property by its address.
     *
     * @param address The address of the property.
     * @return The property with the specified address, or null if not found.
     */
    Property getPropertyByAddress(String address);
}
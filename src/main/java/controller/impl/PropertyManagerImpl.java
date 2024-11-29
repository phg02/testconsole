package controller.impl;
/*
  @author <Nguyen Minh Phuong - s4063236>
 */

import controller.PropertyManagerController;
import model.Property;

import java.util.HashSet;

/**
 * Implementation of the PropertyManagerController interface.
 * Manages properties by combining commercial and residential properties.
 */
public class PropertyManagerImpl implements PropertyManagerController {
    private HashSet<Property> properties;

    /**
     * Constructor to initialize the property manager with commercial and residential properties.
     *
     * @param commercialPropertyManager The manager for commercial properties.
     * @param residentialPropertyManager The manager for residential properties.
     */
    public PropertyManagerImpl(CommercialPropertyManagerImpl commercialPropertyManager, ResidentialPropertyManagerImpl residentialPropertyManager) {
        properties = new HashSet<>();
        properties.addAll(commercialPropertyManager.getAllCommercialProperties());
        properties.addAll(residentialPropertyManager.getAllResidentialProperties());
    }

    /**
     * Retrieves all properties.
     *
     * @return A set of all properties.
     */
    @Override
    public HashSet<Property> getAllProperties() {
        return properties;
    }

    /**
     * Retrieves a property by its unique identifier.
     *
     * @param id The unique identifier of the property.
     * @return The property with the specified ID, or null if not found.
     */
    @Override
    public Property getPropertyByID(String id) {
        return properties.stream().filter(property -> property.getId().equals(id)).findFirst().orElse(null);
    }

    /**
     * Retrieves a property by its address.
     *
     * @param address The address of the property.
     * @return The property with the specified address, or null if not found.
     */
    @Override
    public Property getPropertyByAddress(String address) {
        return properties.stream().filter(property -> property.getAddress().equals(address)).findFirst().orElse(null);
    }
}
package controller.impl;
/*
  @author <Nguyen Minh Phuong - s4063236>
 */

import controller.TenantManagerController;
import model.Tenant;
import util.FileHandler;

import java.util.HashSet;
import java.util.stream.Collectors;

/**
 * Implementation of the TenantManagerController interface.
 * Manages tenants using a file handler.
 */
public class TenantManagerImpl implements TenantManagerController {
    private HashSet<Tenant> tenants;
    private FileHandler fileHandler;

    /**
     * Constructor to initialize the file handler and load tenants.
     *
     * @param fileHandler The file handler to load and save tenants.
     */
    public TenantManagerImpl(FileHandler fileHandler) {
        this.fileHandler = fileHandler;
        tenants = this.fileHandler.getTenantData();
    }

    /**
     * Retrieves all tenants.
     *
     * @return A set of all tenants.
     */
    @Override
    public HashSet<Tenant> getAllTenants() {
        return tenants;
    }

    /**
     * Retrieves a tenant by its unique identifier.
     *
     * @param tenantId The unique identifier of the tenant.
     * @return The tenant with the specified ID, or null if not found.
     */
    @Override
    public Tenant getTenantByID(String tenantId) {
        return tenants.stream().filter(tenant -> tenant.getId().equals(tenantId)).findFirst().orElse(null);
    }

    /**
     * Retrieves tenants by their full name.
     *
     * @param fullName The full name of the tenant.
     * @return A set of tenants with the specified full name.
     */
    @Override
    public HashSet<Tenant> getTenantByFullName(String fullName) {
        return (HashSet<Tenant>) tenants.stream().filter(tenant -> tenant.getFullName().equals(fullName)).collect(Collectors.toSet());
    }

    /**
     * Retrieves a tenant by their contact information.
     *
     * @param contactInformation The contact information of the tenant.
     * @return The tenant with the specified contact information, or null if not found.
     */
    @Override
    public Tenant getTenantByContactInformation(String contactInformation) {
        return tenants.stream().filter(tenant -> tenant.getContactInformation().equals(contactInformation)).findFirst().orElse(null);
    }

    /**
     * Adds a new tenant.
     *
     * @param tenant The tenant to be added.
     * @return true if the tenant was added successfully, false otherwise.
     */
    @Override
    public boolean addTenant(Tenant tenant) {
        return false;
    }

    /**
     * Updates an existing tenant.
     *
     * @param tenant The tenant with updated details.
     * @return true if the tenant was updated successfully, false otherwise.
     */
    @Override
    public boolean updateTenant(Tenant tenant) {
        return false;
    }

    /**
     * Deletes a tenant by its unique identifier.
     *
     * @param tenantId The unique identifier of the tenant to be deleted.
     * @return true if the tenant was deleted successfully, false otherwise.
     */
    @Override
    public boolean deleteTenant(String tenantId) {
        return false;
    }
}
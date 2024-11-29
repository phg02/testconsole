package controller;
/*
  @author <Nguyen Minh Phuong - s4063236>
 */

import java.util.HashSet;

import model.Tenant;

/**
 * Interface for managing tenants.
 */
public interface TenantManagerController {
    /**
     * Retrieves all tenants.
     *
     * @return A set of all tenants.
     */
    HashSet<Tenant> getAllTenants();

    /**
     * Retrieves a tenant by their unique identifier.
     *
     * @param tenantId The unique identifier of the tenant.
     * @return The tenant with the specified ID, or null if not found.
     */
    Tenant getTenantByID(String tenantId);

    /**
     * Retrieves tenants by their full name.
     *
     * @param fullName The full name of the tenant.
     * @return A set of tenants with the specified full name.
     */
    HashSet<Tenant> getTenantByFullName(String fullName);

    /**
     * Retrieves a tenant by their contact information.
     *
     * @param contactInformation The contact information of the tenant.
     * @return The tenant with the specified contact information, or null if not found.
     */
    Tenant getTenantByContactInformation(String contactInformation);

    /**
     * Adds a new tenant.
     *
     * @param tenant The tenant to be added.
     * @return true if the tenant was added successfully, false otherwise.
     */
    boolean addTenant(Tenant tenant);

    /**
     * Updates an existing tenant.
     *
     * @param tenant The tenant with updated details.
     * @return true if the tenant was updated successfully, false otherwise.
     */
    boolean updateTenant(Tenant tenant);

    /**
     * Deletes a tenant by their unique identifier.
     *
     * @param tenantId The unique identifier of the tenant to be deleted.
     * @return true if the tenant was deleted successfully, false otherwise.
     */
    boolean deleteTenant(String tenantId);
}
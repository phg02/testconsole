package controller;

import java.util.HashSet;
import model.Tenant;

public interface TenantManagerController {
    HashSet<Tenant> getAllTenants();
    Tenant getTenantByID(String tenantId);
    HashSet<Tenant> getTenantByFullName(String fullName);
    Tenant getTenantByContactInformation(String contactInformation);
    boolean addTenant(Tenant tenant);
    boolean updateTenant(Tenant tenant);
    boolean deleteTenant(String tenantId);
}

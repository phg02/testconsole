package controller.impl;

import controller.TenantManagerController;
import model.Tenant;
import util.FileHandler;

import java.util.HashSet;
import java.util.stream.Collectors;

public class TenantManagerImpl implements TenantManagerController {
    private HashSet<Tenant> tenants;
    private FileHandler fileHandler;

    public TenantManagerImpl(FileHandler fileHandler) {
        this.fileHandler = fileHandler;
        tenants = this.fileHandler.getTenantData();
    }

    @Override
    public HashSet<Tenant> getAllTenants() {
        return tenants;
    }

    @Override
    public Tenant getTenantByID(String tenantId) {
        return tenants.stream().filter(tenant -> tenant.getId().equals(tenantId)).findFirst().orElse(null);
    }

    @Override
    public HashSet<Tenant> getTenantByFullName(String fullName) {
        return (HashSet<Tenant>) tenants.stream().filter(tenant -> tenant.getFullName().equals(fullName)).collect(Collectors.toSet());
    }

    @Override
    public Tenant getTenantByContactInformation(String contactInformation) {
        return tenants.stream().filter(tenant -> tenant.getContactInformation().equals(contactInformation)).findFirst().orElse(null);
    }

    @Override
    public boolean addTenant(Tenant tenant) {
        return false;
    }

    @Override
    public boolean updateTenant(Tenant tenant) {
        return false;
    }

    @Override
    public boolean deleteTenant(String tenantId) {
        return false;
    }
}

package controller.impl;

import controller.OwnerManagerController;
import model.Owner;

import java.util.HashSet;
import java.util.stream.Collectors;
import util.FileHandler;

public class OwnerManagerImpl implements OwnerManagerController {
    private HashSet<Owner> owners;
    private FileHandler fileHandler;

    public OwnerManagerImpl(FileHandler fileHandler) {
        this.fileHandler = fileHandler;
        owners = this.fileHandler.getOwnerData();
    }
    @Override
    public HashSet<Owner> getAllOwners() {
        return owners;
    }

    @Override
    public Owner getOwnerByID(String ownerId) {
        return owners.stream().filter(owner -> owner.getId().equals(ownerId)).findFirst().orElse(null);
    }

    @Override
    public HashSet<Owner> getOwnerByFullName(String fullName) {
        return (HashSet<Owner>) owners.stream().filter(owner -> owner.getFullName().equals(fullName)).collect(Collectors.toSet());
    }

    @Override
    public Owner getOwnerByContactInformation(String contactInformation) {
        return owners.stream().filter(owner -> owner.getContactInformation().equals(contactInformation)).findFirst().orElse(null);
    }

    @Override
    public boolean addOwner(Owner owner) {
        return false;
    }

    @Override
    public boolean updateOwner(Owner owner) {
        return false;
    }

    @Override
    public boolean deleteOwner(String ownerId) {
        return false;
    }
}

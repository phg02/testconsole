package controller;

import model.Owner;

import java.util.HashSet;

public interface OwnerManagerController {
    HashSet<Owner> getAllOwners();
    Owner getOwnerByID(String ownerId);
    HashSet<Owner> getOwnerByFullName(String fullName);
    Owner getOwnerByContactInformation(String contactInformation);
    boolean addOwner(Owner owner);
    boolean updateOwner(Owner owner);
    boolean deleteOwner(String ownerId);
}

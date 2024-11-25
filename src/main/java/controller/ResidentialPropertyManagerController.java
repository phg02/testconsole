package controller;

import model.ResidentialProperty;

import java.util.HashSet;

public interface ResidentialPropertyManagerController {
    HashSet<ResidentialProperty> getAllResidentialProperties();
    ResidentialProperty getResidentialPropertyByID(String residentialPropertyId);
    ResidentialProperty getResidentialPropertyByAddress(String address);
    boolean addResidentialProperty(ResidentialProperty residentialProperty);
    boolean updateResidentialProperty(ResidentialProperty residentialProperty);
    boolean deleteResidentialProperty(String residentialPropertyId);
}

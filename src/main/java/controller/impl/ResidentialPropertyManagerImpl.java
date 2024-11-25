package controller.impl;

import controller.ResidentialPropertyManagerController;
import model.ResidentialProperty;
import util.FileHandler;

import java.util.HashSet;


public class ResidentialPropertyManagerImpl implements ResidentialPropertyManagerController {
    private HashSet<ResidentialProperty> residentialProperties;
    private FileHandler fileHandler;

    public ResidentialPropertyManagerImpl(FileHandler fileHandler) {
        this.fileHandler = fileHandler;
        residentialProperties = this.fileHandler.getResidentialProperty();
    }

    @Override
    public HashSet<ResidentialProperty> getAllResidentialProperties() {
        return residentialProperties;
    }

    @Override
    public ResidentialProperty getResidentialPropertyByID(String residentialPropertyId) {
//        return residentialProperties.stream().filter(residentialProperty -> residentialProperty.getId().equals(residentialPropertyId)).findFirst().orElse(null);
        for(ResidentialProperty residentialProperty : residentialProperties) {
            if (residentialProperty.getId().equals(residentialPropertyId)) {
                return residentialProperty;
            }
        }
        return null;
    }

    @Override
    public ResidentialProperty getResidentialPropertyByAddress(String address) {
        return residentialProperties.stream().filter(residentialProperty -> residentialProperty.getAddress().equals(address)).findFirst().orElse(null);
    }

    @Override
    public boolean addResidentialProperty(ResidentialProperty residentialProperty) {
        return false;
    }

    @Override
    public boolean updateResidentialProperty(ResidentialProperty residentialProperty) {
        return false;
    }

    @Override
    public boolean deleteResidentialProperty(String residentialPropertyId) {
        return false;
    }
}

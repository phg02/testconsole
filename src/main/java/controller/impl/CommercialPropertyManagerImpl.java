package controller.impl;

import controller.CommercialPropertyManagerController;
import model.CommercialProperty;
import util.FileHandler;

import java.util.HashSet;
import java.util.stream.Collectors;

public class CommercialPropertyManagerImpl implements CommercialPropertyManagerController {
    private HashSet<CommercialProperty> commercialProperties;
    private FileHandler fileHandler;

    public CommercialPropertyManagerImpl(FileHandler fileHandler) {
        this.fileHandler = fileHandler;
        commercialProperties = this.fileHandler.getCommercialProperty();
    }

    @Override
    public HashSet<CommercialProperty> getAllCommercialProperties() {
        return commercialProperties;
    }

    @Override
    public CommercialProperty getCommercialPropertyByID(String commercialPropertyId) {
        return commercialProperties.stream().filter(commercialProperty -> commercialProperty.getId().equals(commercialPropertyId)).findFirst().orElse(null);
    }

    @Override
    public CommercialProperty getCommercialPropertyByAddress(String address) {
        return commercialProperties.stream().filter(commercialProperty -> commercialProperty.getAddress().equals(address)).findFirst().orElse(null);
    }

    @Override
    public boolean addCommercialProperty(CommercialProperty commercialProperty) {
        return false;
    }

    @Override
    public boolean updateCommercialProperty(CommercialProperty commercialProperty) {
        return false;
    }

    @Override
    public boolean deleteCommercialProperty(String commercialPropertyId) {
        return false;
    }
}

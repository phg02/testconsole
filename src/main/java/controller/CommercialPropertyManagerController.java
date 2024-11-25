package controller;

import model.CommercialProperty;

import java.util.HashSet;

public interface CommercialPropertyManagerController {
    HashSet<CommercialProperty> getAllCommercialProperties();
    CommercialProperty getCommercialPropertyByID(String commercialPropertyId);
    CommercialProperty getCommercialPropertyByAddress(String address);
    boolean addCommercialProperty(CommercialProperty commercialProperty);
    boolean updateCommercialProperty(CommercialProperty commercialProperty);
    boolean deleteCommercialProperty(String commercialPropertyId);
}

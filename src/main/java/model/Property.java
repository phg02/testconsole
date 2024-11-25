package model;

import java.util.HashSet;


public abstract class Property {
    public enum  Status{
        AVAILABLE,
        RENTED,
        MAINTENANCE
    }
    private String id;
    private String address;
    private double pricing;
    private Status status;
    private Owner owner;
    private HashSet<Host> hostList;


    public Property() {
        this.hostList = new HashSet<Host>();
    }

    public Property(String id, String address, double pricing, Status status, Owner owner) {
        this.id = id;
        this.address = address;
        this.pricing = pricing;
        this.status = status;
        this.owner = owner;
        this.hostList = new HashSet<Host>();
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public void setPricing(double pricing) {
        this.pricing = pricing;
    }

    public double getPricing() {
        return pricing;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Status getStatus() {
        return status;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public Owner getOwner() {
        return owner;
    }

    public boolean addHost(Host host) {
        if (!this.hostList.contains(host)) {
            this.hostList.add(host);
            return true;
        }
        return false;
    }

    public HashSet<Host> getHostList () {
        return this.hostList;
    }
}

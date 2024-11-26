package model;

import java.util.Date;
import java.util.HashSet;

public class RentalAgreement {
    public enum Period{
        DAILY,
        WEEKLY,
        MONTHLY,
        YEARLY
    }
    public enum Status{
        NEW,
        ACTIVE,
        COMPLETED
    }
    private String id;
    private Owner owner;
    private Host host;
    private Tenant mainTenant;
    private HashSet<Tenant> subTenant;
    private Property property;
    private Period period;
    private Date startDate;
    private Date endDate;
    private double rentingFee;
    public Status status;

    public RentalAgreement() {
        this.subTenant = new HashSet<Tenant>();
    }
    public RentalAgreement(String id,  Owner owner, Host host, Tenant mainTenant, Property property, Period period, Date startDate, Date endDate, double rentingFee, Status status) {
        this.owner = owner;
        this.host = host;
        this.id = id;
        this.property = property;
        this.period = period;
        this.startDate = startDate;
        this.endDate = endDate;
        this.rentingFee = rentingFee;
        this.status = status;
        this.mainTenant = mainTenant;
        this.subTenant = new HashSet<Tenant>();
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setHost(Host host) {
        this.host = host;
    }

    public Host getHost() {
        return host;
    }
    public void setMainTenant(Tenant mainTenant) {
        this.mainTenant = mainTenant;
    }

    public Tenant getMainTenant() {
        return mainTenant;
    }

    public void setProperty(Property property) {
        this.property = property;
    }

    public Property getProperty() {
        return property;
    }

    public void setPeriod(Period period) {
        this.period = period;
    }

    public Period getPeriod() {
        return period;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setRentingFee(double rentingFee) {
        this.rentingFee = rentingFee;
    }

    public double getRentingFee() {
        return rentingFee;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Status getStatus() {
        return status;
    }

    public boolean addSubTenant(Tenant tenant) {
        if(!tenant.equals(mainTenant) && !subTenant.contains(tenant)){
            subTenant.add(tenant);
            return true;
        }
        return false;
    }


    public HashSet<Tenant> getSubTenant() {
        return subTenant;
    }

    @Override
    public boolean equals(Object obj){
        if(!(obj instanceof RentalAgreement)){
            return false;
        }
        if(obj == this){
            return true;
        }
        return getId().equals(((RentalAgreement) obj).getId());
    }

    @Override
    public int hashCode(){
        return getId().hashCode();
    }

}

package model;

import java.util.Date;

public class Payment {
    private String id;
    private Tenant tenant;
    private Double amount;
    private Date date;
    private String paymentMethod;

    public Payment() {
    }

    public Payment(String id,Tenant tenant, Double amount, Date date, String paymentMethod) {
        this.id = id;
        this.tenant = tenant;
        this.amount = amount;
        this.date = date;
        this.paymentMethod = paymentMethod;
    }

    public void setId(String id){
        this.id = id;
    }

    public String getId(){
        return id;
    }

    public void setTenant(Tenant tenant) {
        this.tenant = tenant;
    }

    public Tenant getTenant(){
        return tenant;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Double getAmount() {
        return amount;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getDate() {
        return date;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    @Override
    public boolean equals(Object obj){
        if(!(obj instanceof Payment)){
            return false;
        }
        if(obj == this){
            return true;
        }
        return getId().equals(((Payment) obj).getId());
    }

    @Override
    public int hashCode(){
        return getId().hashCode();
    }

}

package model;

import java.util.Date;

/**
 * Represents a payment made by a tenant.
 */
public class Payment {
    private String id;
    private Tenant tenant;
    private Double amount;
    private Date date;
    private String paymentMethod;

    /**
     * Default constructor for creating an instance of Payment.
     */
    public Payment() {
    }

    /**
     * Constructs a Payment with the specified details.
     *
     * @param id The unique identifier of the payment.
     * @param tenant The tenant who made the payment.
     * @param amount The amount of the payment.
     * @param date The date of the payment.
     * @param paymentMethod The method of the payment.
     */
    public Payment(String id, Tenant tenant, Double amount, Date date, String paymentMethod) {
        this.id = id;
        this.tenant = tenant;
        this.amount = amount;
        this.date = date;
        this.paymentMethod = paymentMethod;
    }

    /**
     * Sets the unique identifier of the payment.
     *
     * @param id The unique identifier.
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Gets the unique identifier of the payment.
     *
     * @return The unique identifier.
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the tenant who made the payment.
     *
     * @param tenant The tenant.
     */
    public void setTenant(Tenant tenant) {
        this.tenant = tenant;
    }

    /**
     * Gets the tenant who made the payment.
     *
     * @return The tenant.
     */
    public Tenant getTenant() {
        return tenant;
    }

    /**
     * Sets the amount of the payment.
     *
     * @param amount The amount.
     */
    public void setAmount(Double amount) {
        this.amount = amount;
    }

    /**
     * Gets the amount of the payment.
     *
     * @return The amount.
     */
    public Double getAmount() {
        return amount;
    }

    /**
     * Sets the date of the payment.
     *
     * @param date The date.
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * Gets the date of the payment.
     *
     * @return The date.
     */
    public Date getDate() {
        return date;
    }

    /**
     * Sets the method of the payment.
     *
     * @param paymentMethod The method.
     */
    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    /**
     * Gets the method of the payment.
     *
     * @return The method.
     */
    public String getPaymentMethod() {
        return paymentMethod;
    }

    /**
     * Compares this payment to the specified object. The result is true if and only if the argument is not null and is a Payment object that has the same id as this object.
     *
     * @param obj The object to compare this Payment against.
     * @return true if the given object represents a Payment equivalent to this payment, false otherwise.
     */
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Payment)) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        return getId().equals(((Payment) obj).getId());
    }

    /**
     * Returns a hash code value for the payment. This method is supported for the benefit of hash tables such as those provided by HashMap.
     *
     * @return A hash code value for this payment.
     */
    @Override
    public int hashCode() {
        return getId().hashCode();
    }
}
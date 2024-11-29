package controller;
/*
  @author <Nguyen Minh Phuong - s4063236>
 */

import model.Payment;

import java.util.HashSet;

/**
 * Interface for managing payments.
 */
public interface PaymentManagerController {
    /**
     * Retrieves all payments.
     *
     * @return A set of all payments.
     */
    HashSet<Payment> getAllPayments();

    /**
     * Retrieves payments by the tenant's unique identifier.
     *
     * @param tenantId The unique identifier of the tenant.
     * @return A set of payments associated with the specified tenant ID.
     */
    HashSet<Payment> getPaymentByTenantID(String tenantId);

    /**
     * Retrieves a payment by its unique identifier.
     *
     * @param id The unique identifier of the payment.
     * @return The payment with the specified ID, or null if not found.
     */
    Payment getPaymentByID(String id);

    /**
     * Makes a payment for a tenant for a specific residential property.
     *
     * @param tenantId The unique identifier of the tenant.
     * @param residentialPropertyId The unique identifier of the residential property.
     * @param amount The amount to be paid.
     * @return true if the payment was made successfully, false otherwise.
     */
    boolean makePayment(String tenantId, String residentialPropertyId, double amount);

    /**
     * Updates an existing payment for a tenant for a specific residential property.
     *
     * @param tenantId The unique identifier of the tenant.
     * @param residentialPropertyId The unique identifier of the residential property.
     * @param amount The updated amount to be paid.
     * @return true if the payment was updated successfully, false otherwise.
     */
    boolean updatePayment(String tenantId, String residentialPropertyId, double amount);

    /**
     * Deletes a payment for a tenant for a specific residential property.
     *
     * @param tenantId The unique identifier of the tenant.
     * @param residentialPropertyId The unique identifier of the residential property.
     * @return true if the payment was deleted successfully, false otherwise.
     */
    boolean deletePayment(String tenantId, String residentialPropertyId);
}
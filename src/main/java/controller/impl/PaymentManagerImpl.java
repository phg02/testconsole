package controller.impl;
/*
  @author <Nguyen Minh Phuong - s4063236>
 */

import controller.PaymentManagerController;
import model.Payment;
import util.FileHandler;

import java.util.HashSet;
import java.util.stream.Collectors;

/**
 * Implementation of the PaymentManagerController interface.
 * Manages payments using a file handler.
 */
public class PaymentManagerImpl implements PaymentManagerController {
    private HashSet<Payment> payments;
    private FileHandler fileHandler;

    /**
     * Constructor to initialize the file handler and load payments.
     *
     * @param fileHandler The file handler to load and save payments.
     */
    public PaymentManagerImpl(FileHandler fileHandler) {
        this.fileHandler = fileHandler;
        payments = this.fileHandler.getPaymentData();
    }

    /**
     * Retrieves all payments.
     *
     * @return A set of all payments.
     */
    @Override
    public HashSet<Payment> getAllPayments() {
        return payments;
    }

    /**
     * Retrieves payments by tenant ID.
     *
     * @param tenantId The unique identifier of the tenant.
     * @return A set of payments associated with the specified tenant ID.
     */
    @Override
    public HashSet<Payment> getPaymentByTenantID(String tenantId) {
        return (HashSet<Payment>) payments.stream().filter(payment -> payment.getId().equals(tenantId)).collect(Collectors.toSet());
    }

    /**
     * Retrieves a payment by its unique identifier.
     *
     * @param id The unique identifier of the payment.
     * @return The payment with the specified ID, or null if not found.
     */
    @Override
    public Payment getPaymentByID(String id) {
        return payments.stream().filter(payment -> payment.getId().equals(id)).findFirst().orElse(null);
    }

    /**
     * Makes a payment.
     *
     * @param tenantId The unique identifier of the tenant.
     * @param residentialPropertyId The unique identifier of the residential property.
     * @param amount The amount to be paid.
     * @return true if the payment was made successfully, false otherwise.
     */
    @Override
    public boolean makePayment(String tenantId, String residentialPropertyId, double amount) {
        return false;
    }

    /**
     * Updates an existing payment.
     *
     * @param tenantId The unique identifier of the tenant.
     * @param residentialPropertyId The unique identifier of the residential property.
     * @param amount The updated amount.
     * @return true if the payment was updated successfully, false otherwise.
     */
    @Override
    public boolean updatePayment(String tenantId, String residentialPropertyId, double amount) {
        return false;
    }

    /**
     * Deletes a payment by tenant ID and residential property ID.
     *
     * @param tenantId The unique identifier of the tenant.
     * @param residentialPropertyId The unique identifier of the residential property.
     * @return true if the payment was deleted successfully, false otherwise.
     */
    @Override
    public boolean deletePayment(String tenantId, String residentialPropertyId) {
        return false;
    }
}
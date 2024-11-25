package controller;

import model.Payment;

import java.util.HashSet;

public interface PaymentManagerController {
    HashSet<Payment> getAllPayments();
    HashSet<Payment> getPaymentByTenantID(String tenantId);
    boolean makePayment(String tenantId, String residentialPropertyId, double amount);
    boolean updatePayment(String tenantId, String residentialPropertyId, double amount);
    boolean deletePayment(String tenantId, String residentialPropertyId);
}

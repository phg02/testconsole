package controller.impl;

import controller.PaymentManagerController;
import model.Payment;
import util.FileHandler;

import java.util.HashSet;
import java.util.stream.Collectors;

public class PaymentManagerImpl implements PaymentManagerController {
    private HashSet<Payment> payments;
    private FileHandler fileHandler;

    public PaymentManagerImpl(FileHandler fileHandler) {
        this.fileHandler = fileHandler;
        payments = this.fileHandler.getPaymentData();
    }

    @Override
    public HashSet<Payment> getAllPayments() {
        return payments;
    }

    @Override
    public HashSet<Payment> getPaymentByTenantID(String tenantId) {
        return (HashSet<Payment>) payments.stream().filter(payment -> payment.getId().equals(tenantId)).collect(Collectors.toSet());
    }

    @Override
    public boolean makePayment(String tenantId, String residentialPropertyId, double amount) {
        return false;
    }

    @Override
    public boolean updatePayment(String tenantId, String residentialPropertyId, double amount) {
        return false;
    }

    @Override
    public boolean deletePayment(String tenantId, String residentialPropertyId) {
        return false;
    }
}

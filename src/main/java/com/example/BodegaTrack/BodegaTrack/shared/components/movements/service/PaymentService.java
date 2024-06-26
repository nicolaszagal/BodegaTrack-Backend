package com.example.BodegaTrack.BodegaTrack.shared.components.movements.service;

import com.example.BodegaTrack.BodegaTrack.shared.components.movements.model.Payment;

import java.util.List;

public interface PaymentService {
    Payment createPayment(Payment payment);
    Payment getPaymentById(Long id);
    List<Payment> getAllPayments();
    Payment updatePayment(Long id, Payment paymentDetails);
    void deletePayment(Long id);
}

package com.example.BodegaTrack.BodegaTrack.shared.components.movements.service.impl;

import com.example.BodegaTrack.BodegaTrack.grocer.model.GrocerCustomer;
import com.example.BodegaTrack.BodegaTrack.grocer.repository.GrocerCustomerRepository;
import com.example.BodegaTrack.BodegaTrack.shared.components.movements.model.Payment;
import com.example.BodegaTrack.BodegaTrack.shared.components.movements.repository.PaymentRepository;
import com.example.BodegaTrack.BodegaTrack.shared.components.movements.service.PaymentService;
import com.example.BodegaTrack.BodegaTrack.shared.project.exception.ResourceNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;
    @Autowired
    private GrocerCustomerRepository grocerCustomerRepository;

    @Override
    public Payment createPayment(Payment payment) {
        /*if (payment.getPaymentDate().isAfter(payment.getGrocerCustomer().getNextDueDate())) {
            double lateFee = payment.getAmount() * payment.getGrocerCustomer().getDefaultRate() / 100;
            payment.setLateFee(lateFee);
        } else {
            payment.setLateFee(0.0);
        }*/

        GrocerCustomer grocerCustomer = payment.getGrocerCustomer();
        grocerCustomer.setUsedCredit(grocerCustomer.getUsedCredit() - payment.getAmount());
        grocerCustomer.setAvailableCredit(grocerCustomer.getCredit() - grocerCustomer.getUsedCredit());

        grocerCustomer.updateCreditValues();
        grocerCustomerRepository.save(grocerCustomer);

        return paymentRepository.save(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No se encontró ningún pago con el id:" + id));
    }

    @Override
    public List<Payment> getAllPayments() {
        return paymentRepository.findAll();
    }

    @Override
    public Payment updatePayment(Long id, Payment paymentDetails) {
        Payment payment = getPaymentById(id);
        payment.setAmount(paymentDetails.getAmount());
        payment.setPaymentDate(paymentDetails.getPaymentDate());

        /*if (payment.getPaymentDate().isAfter(payment.getGrocerCustomer().getNextDueDate())) {
            double lateFee = payment.getAmount() * payment.getGrocerCustomer().getDefaultRate() / 100;
            payment.setLateFee(lateFee);
        } else {
            payment.setLateFee(0.0);
        }*/

        return paymentRepository.save(payment);
    }

    @Transactional
    @Override
    public void deletePayment(Long id) {
        Payment payment = getPaymentById(id);
        if (payment != null) {
            paymentRepository.deleteById(id);
        } else {
            throw new ResourceNotFoundException("Payment not found with id " + id);
        }
    }
}

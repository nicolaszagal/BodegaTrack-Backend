package com.example.BodegaTrack.BodegaTrack.shared.components.movements.controller;
import com.example.BodegaTrack.BodegaTrack.grocer.repository.GrocerCustomerRepository;
import com.example.BodegaTrack.BodegaTrack.shared.components.movements.model.Payment;
import com.example.BodegaTrack.BodegaTrack.shared.components.movements.service.PaymentService;
import com.example.BodegaTrack.BodegaTrack.shared.project.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/payments")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;
    @Autowired
    private GrocerCustomerRepository grocerCustomerRepository;

    @PostMapping
    public ResponseEntity<Payment> createPayment(@RequestBody Payment payment) {
        Payment createdPayment = paymentService.createPayment(payment);
        return ResponseEntity.ok(createdPayment);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Payment> getPaymentById(@PathVariable Long id) {
        Payment payment = paymentService.getPaymentById(id);
        return ResponseEntity.ok(payment);
    }

    @GetMapping
    public ResponseEntity<List<Payment>> getAllPayments() {
        List<Payment> payments = paymentService.getAllPayments();
        return ResponseEntity.ok(payments);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Payment> updatePayment(@PathVariable Long id, @RequestBody Payment paymentDetails) {
        Payment updatedPayment = paymentService.updatePayment(id, paymentDetails);
        return ResponseEntity.ok(updatedPayment);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePayment(@PathVariable Long id) {
        paymentService.deletePayment(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{id}/pay")
    public ResponseEntity<Payment> payInstallment(@PathVariable Long id, @RequestBody Payment paymentDetails) {
        paymentDetails.setGrocerCustomer(grocerCustomerRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Customer not found")));
        Payment paidPayment = paymentService.createPayment(paymentDetails);
        return ResponseEntity.ok(paidPayment);
    }
}

package com.example.BodegaTrack.BodegaTrack.shared.components.movements.repository;

import com.example.BodegaTrack.BodegaTrack.shared.components.movements.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
}
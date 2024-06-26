package com.example.BodegaTrack.BodegaTrack.shared.components.movements.model;

import com.example.BodegaTrack.BodegaTrack.grocer.model.GrocerCustomer;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "payment")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "grocer_customer_id")
    @JsonBackReference
    private GrocerCustomer grocerCustomer;

    @Column(name = "amount", nullable = false)
    private Double amount;

    @Column(name = "payment_date", nullable = false)
    private LocalDate paymentDate;

    @Column(name = "late_fee", nullable = false)
    private Double lateFee;
}

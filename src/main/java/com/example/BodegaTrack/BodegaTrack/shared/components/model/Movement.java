package com.example.BodegaTrack.BodegaTrack.shared.components.model;

import com.example.BodegaTrack.BodegaTrack.customer.model.Customer;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="movement")
public class Movement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "cost", nullable = false)
    private Double cost;

    @Column(name="type", nullable = false)
    private String type;

    @Column(name = "interest", nullable = false)
    private Double interest;

    @Column(name = "local_date", nullable = false)
    private LocalDate movementDate;
}

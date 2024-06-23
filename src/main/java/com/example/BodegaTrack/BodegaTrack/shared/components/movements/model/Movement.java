package com.example.BodegaTrack.BodegaTrack.shared.components.movements.model;

import com.example.BodegaTrack.BodegaTrack.customer.model.Customer;
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
@Table(name = "movement")
public class Movement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "grocer_customer_id")
    @JsonBackReference
    private GrocerCustomer grocerCustomer;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "cost", nullable = false)
    private Double cost;

    @Column(name="type", nullable = false)
    private String type;

    @Column(name = "interest", nullable = false)
    private Double interest;

    @Column(name = "movement_date", nullable = false)
    private LocalDate movementDate;

    @PrePersist
    public void prePersist(){
        this.movementDate = LocalDate.now();
    }
}

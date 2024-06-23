package com.example.BodegaTrack.BodegaTrack.grocer.model;
import com.example.BodegaTrack.BodegaTrack.customer.model.Customer;
import com.example.BodegaTrack.BodegaTrack.shared.components.movements.model.Movement;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "grocer_customer")
public class GrocerCustomer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "grocer_id")
    @JsonBackReference
    private Grocer grocer;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @Column(name = "rate_type", nullable = false)
    private String rateType;

    @Column(name = "rate", nullable = false)
    private Double rate;

    @Column(name = "config_default", nullable = false)
    private Boolean configDefault;

    @Column(name = "default_rate", nullable = false)
    private Double defaultRate;

    @Column(name = "pay_day", nullable = false)
    private Integer payDay;

    @Column(name = "grace_days", nullable = false)
    private Integer graceDays;

    @OneToMany(mappedBy = "grocerCustomer", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Movement> movements = new ArrayList<>();
}

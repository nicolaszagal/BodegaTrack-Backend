package com.example.BodegaTrack.BodegaTrack.grocer.model;
import com.example.BodegaTrack.BodegaTrack.customer.model.Customer;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="grocer_customer")
public class GrocerCustomer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "grocer_id")
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
}

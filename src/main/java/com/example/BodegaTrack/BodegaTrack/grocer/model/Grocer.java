package com.example.BodegaTrack.BodegaTrack.grocer.model;

import com.example.BodegaTrack.BodegaTrack.customer.model.Customer;
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
@Table(name="grocer")
public class Grocer {
    @Id
    @Column(name = "id", nullable = false, unique = true, length = 6)
    private String id;

    @Column(name="name", nullable = false)
    private String name;

    @Column(name="lastname", nullable = false)
    private String lastname;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "phone", nullable = false)
    private String phone;

    @Column(name = "password", nullable = false)
    private String password;

    @OneToMany(mappedBy = "grocer", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<GrocerCustomer> customers = new ArrayList<>();

}

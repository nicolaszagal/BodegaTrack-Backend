package com.example.BodegaTrack.BodegaTrack.grocer.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="grocer")
public class Grocer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;;

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

}

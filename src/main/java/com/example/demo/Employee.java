package com.example.demo;

import jakarta.persistence.*;
import lombok.Data;
@Data
@Entity
@Table(name="employees")

public class Employee {
 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private Long ID;

 @Column(name="first_name",nullable = false)
    private String firstName;
    @Column(name="last_name")
    private String lastName;
    @Column(name="email")
    private String email;
}


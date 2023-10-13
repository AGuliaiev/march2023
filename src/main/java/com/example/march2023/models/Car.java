package com.example.march2023.models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "Cars")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int id;
    private String model;
    private int power;
    private String producer;


}

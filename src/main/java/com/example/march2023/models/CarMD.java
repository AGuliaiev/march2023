package com.example.march2023.models;

import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
@NoArgsConstructor
public class CarMD {
    @Id
    private String id;
    private String model;
    private String producer;
    private int power;

}

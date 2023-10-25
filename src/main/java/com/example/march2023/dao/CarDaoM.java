package com.example.march2023.dao;

import com.example.march2023.models.CarMD;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CarDaoM extends MongoRepository<CarMD, String> {
}

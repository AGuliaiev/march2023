package com.example.march2023.repositories;

import com.example.march2023.models.Car;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarRepository extends JpaRepository<Car, Integer> {

    List<Car> findAllByProducer(String producer);
    List<Car> findAllByPower(int power);
}

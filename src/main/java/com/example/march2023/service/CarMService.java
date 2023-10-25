package com.example.march2023.service;

import com.example.march2023.models.CarMD;

import java.util.List;

public interface CarMService {
    List<CarMD>getCars();
    CarMD getCar(String id);
    void saveCar(CarMD carMD);
    void deleteCar(String id);

}

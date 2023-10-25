package com.example.march2023.service.implemetation;

import com.example.march2023.dao.CarDaoM;
import com.example.march2023.models.CarMD;
import com.example.march2023.service.CarMService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@AllArgsConstructor
@Service
public class CarServiceImpM implements CarMService {
    private CarDaoM carDaoM;
    @Override
    public List<CarMD> getCars() {
        return carDaoM.findAll();
    }

    @Override
    public CarMD getCar(String id) {
        return carDaoM.findById(id).get();
    }

    @Override
    public void saveCar(CarMD carMD) {
        carDaoM.save(carMD);
    }

    @Override
    public void deleteCar(String id) {
        carDaoM.delete(carDaoM.findById(id).get());
    }
}

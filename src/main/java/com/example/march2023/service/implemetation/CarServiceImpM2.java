package com.example.march2023.service.implemetation;

import com.example.march2023.dao.CarDaoM;
import com.example.march2023.models.CarMD;
import com.example.march2023.service.CarMService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@AllArgsConstructor
@Service
public class CarServiceImpM2 implements CarMService {
    private CarDaoM carDaoM;
    @Override
    public List<CarMD> getCars() {
        return carDaoM.findAll();
    }

    @Override
    public CarMD getCar(String id) {
        if(id.isEmpty() || id==null){
            throw new RuntimeException("id is bad");
        }
        return carDaoM.findById(id).orElseGet(CarMD::new);
    }

    @Override
    public void saveCar(CarMD carMD) {
        if (carMD==null) {
            throw new RuntimeException("car cannot be null");
        }
        carDaoM.save(carMD);

    }

    @Override
    public void deleteCar(String id) {
        carDaoM.deleteById(id);
    }
}

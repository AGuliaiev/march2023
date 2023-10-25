package com.example.march2023.controllers;

import com.example.march2023.models.CarMD;
import com.example.march2023.service.CarMService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/carsM")

@RestController
public class CarMDController {
    //?????
    private CarMService carMService;

    public CarMDController( @Qualifier("carServiceImpM2")CarMService carMService){
        this.carMService = carMService;
    }

    @GetMapping()
    public ResponseEntity<List<CarMD>> getCars(){
        return new ResponseEntity<>(carMService.getCars(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CarMD> getCars(@PathVariable String id) {
        return new ResponseEntity<>(carMService.getCar(id), HttpStatus.OK);
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.OK)
    public void saveCar (@RequestBody CarMD carMD) {
        carMService.saveCar(carMD);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteCar (@PathVariable String id) {
        carMService.deleteCar(id);

    }
}

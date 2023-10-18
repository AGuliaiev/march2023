package com.example.march2023.controllers;

import com.example.march2023.dto.CarDto;
import com.example.march2023.models.Car;
import com.example.march2023.service.CarService;
import com.example.march2023.view.View;
import com.fasterxml.jackson.annotation.JsonView;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/cars")
public class CarController {

    private final CarService carService;

    @JsonView(View.Level3.class)
    @GetMapping
    public ResponseEntity<List<CarDto>> getAll() {
        return ResponseEntity.ok(this.carService.getAll());
    }

    @PostMapping
    public ResponseEntity<CarDto> create(@RequestBody @Valid CarDto car){
        return ResponseEntity.status(HttpStatus.CREATED).body(carService.create(car));
    }

    @JsonView(View.Level1.class)
    @GetMapping("/{id}")
    public ResponseEntity<CarDto> getById(@PathVariable int id){
        return ResponseEntity.of(carService.getById(id));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable int id){
         carService.deleteById(id);
    }

    @JsonView(View.Level2.class)
    @GetMapping("/power/{value}")
    public ResponseEntity<List<CarDto>> getByPower(@PathVariable int value){
       return ResponseEntity.ok(this.carService.getByPower(value));

    }

    @JsonView(View.Level2.class)
    @GetMapping("/producer/{value}")
    public ResponseEntity<List<CarDto>> getByProducer(@PathVariable String value){
        return ResponseEntity.ok(this.carService.getByProducer(value));
    }

}

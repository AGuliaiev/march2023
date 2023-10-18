package com.example.march2023.service;

import com.example.march2023.dto.CarDto;
import com.example.march2023.mapper.CarMapper;
import com.example.march2023.models.Car;
import com.example.march2023.repositories.CarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CarService {
    private final CarRepository carRepository;
    private final CarMapper carMapper;

    public List<CarDto> getAll() {
        return this.carRepository.findAll().stream().map(carMapper::toDto).toList();
    }

    public Optional<CarDto> getById(int id) {
        return this.carRepository.findById(id).stream().map(carMapper::toDto).findFirst();

    }

    public CarDto create(CarDto carDto) {
        return carMapper.toDto(this.carRepository.save(carMapper.toEntity(carDto)));
    }

    public void deleteById(int id) {
        this.carRepository.deleteById(id);
    }

    public List<CarDto> getByPower(int power){
        return this.carRepository.findAllByPower(power).stream().map(carMapper::toDto).toList();
    }
    public List<CarDto> getByProducer(String producer){
        return this.carRepository.findAllByProducer(producer).stream().map(carMapper::toDto).toList();
    }
}

package com.autodrenaline.autodrenalineapp.service;

import com.autodrenaline.autodrenalineapp.entity.Car;
import com.autodrenaline.autodrenalineapp.repository.CarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CarManagementService {

    private final CarRepository carRepository;

    @Transactional(readOnly = true)
    public List<Car> getAll() {
        return carRepository.findAll();
    }

    @Transactional
    public Car save(Car car) {
        return carRepository.saveAndFlush(car);
    }

}

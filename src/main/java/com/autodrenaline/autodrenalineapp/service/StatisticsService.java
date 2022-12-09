package com.autodrenaline.autodrenalineapp.service;

import com.autodrenaline.autodrenalineapp.repository.CarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StatisticsService {

    private final CarRepository carRepository;

    public long getTotalCarsAmount() {
        return carRepository.count();
    }

}

package com.autodrenaline.autodrenalineapp.service;

import com.autodrenaline.autodrenalineapp.repository.CarRepository;
import com.autodrenaline.autodrenalineapp.repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StatisticsService {
    private final CarRepository carRepository;
    private final ClientRepository clientRepository;

    public long getTotalCarsAmount() {
        return carRepository.count();
    }

    public long getTotalClientsAmount() {
        return clientRepository.count();
    }
}

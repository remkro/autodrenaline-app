package com.autodrenaline.autodrenalineapp.service;

import com.autodrenaline.autodrenalineapp.entity.Car;
import com.autodrenaline.autodrenalineapp.entity.Client;
import com.autodrenaline.autodrenalineapp.entity.RentEvent;
import com.autodrenaline.autodrenalineapp.repository.CarRepository;
import com.autodrenaline.autodrenalineapp.repository.ClientRepository;
import com.autodrenaline.autodrenalineapp.repository.RentEventRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class RentService {
    private final ClientRepository clientRepository;
    private final CarRepository carRepository;
    private final RentEventRepository rentEventRepository;

    @Transactional
    public void rent(long clientId, long carId) {
        Client client = clientRepository.findById(clientId).orElseThrow(() -> new IllegalArgumentException("Client not found"));
        Car car = carRepository.findById(carId).orElseThrow(() -> new IllegalArgumentException("Car not found"));
        RentEvent event = new RentEvent();
        event.setClient(client);
        event.setCar(car);
        event.setCreatedAt(LocalDateTime.now());
        event.setStartDate(LocalDate.now());
        event.setDuration(5);
        event.setIncome(BigDecimal.valueOf(5000));
        rentEventRepository.saveAndFlush(event);
    }
}

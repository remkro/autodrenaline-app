package com.autodrenaline.autodrenalineapp.service;

import com.autodrenaline.autodrenalineapp.dto.CreateRentEventDto;
import com.autodrenaline.autodrenalineapp.entity.Car;
import com.autodrenaline.autodrenalineapp.entity.Client;
import com.autodrenaline.autodrenalineapp.entity.RentEvent;
import com.autodrenaline.autodrenalineapp.exceptions.EntityNotFoundException;
import com.autodrenaline.autodrenalineapp.repository.CarRepository;
import com.autodrenaline.autodrenalineapp.repository.ClientRepository;
import com.autodrenaline.autodrenalineapp.repository.RentEventRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class RentService {
    private final ClientRepository clientRepository;
    private final CarRepository carRepository;
    private final RentEventRepository rentEventRepository;
    private final DiscountManagementService discountManagementService;

    @Transactional
    public void rent(CreateRentEventDto createRentEventDto, String clientUsername) {
        Client client = clientRepository.findByUsername(clientUsername).orElseThrow(
                () -> new EntityNotFoundException("Client not found")
        );
        Car car = carRepository.findById(
                createRentEventDto.getCarId()).orElseThrow(() -> new EntityNotFoundException("Car not found")
        );
        RentEvent event = new RentEvent();
        event.setClient(client);
        event.setCar(car);
        event.setCreatedAt(LocalDateTime.now());
        event.setStartDate(createRentEventDto.getStartDate());
        event.setDuration(createRentEventDto.getDuration());
        BigDecimal rentalCost = discountManagementService.calculateRentalCostIncludingDiscount(
                client.getId(), createRentEventDto.getDuration(), car.getRate()
        );
        event.setIncome(rentalCost);
        rentEventRepository.saveAndFlush(event);
        discountManagementService.updateDiscountRate(client.getId());
    }
}

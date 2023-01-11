package com.autodrenaline.autodrenalineapp.service;

import com.autodrenaline.autodrenalineapp.entity.Client;
import com.autodrenaline.autodrenalineapp.exceptions.EntityNotFoundException;
import com.autodrenaline.autodrenalineapp.repository.ClientRepository;
import com.autodrenaline.autodrenalineapp.repository.RentEventRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

@Service
@RequiredArgsConstructor
public class DiscountManagementService {
    private final RentEventRepository rentEventRepository;
    private final ClientRepository clientRepository;
    @Value("#{${discountsThresholds}}")
    private Map<Integer, Integer> discountsThresholds = new TreeMap<>();

    public BigDecimal calculateRentalCostIncludingDiscount(long clientId, int duration, BigDecimal rate) {
        Client client = clientRepository.findById(clientId).orElseThrow(
                () -> new EntityNotFoundException("Client not found")
        );
        int discountRate = client.getDiscountRate();
        BigDecimal percentage = BigDecimal.ONE.subtract(BigDecimal.valueOf(discountRate).divide(BigDecimal.valueOf(100)));
        return rate.multiply(BigDecimal.valueOf(duration)).multiply(percentage);
    }

    @Transactional
    public void updateDiscountRate(long clientId) {
        Client client = clientRepository.findById(clientId).orElseThrow(
                () -> new EntityNotFoundException("Client not found")
        );
        int discountRate = 0;
        int totalRentDuration = rentEventRepository.countTotalRentDurationCompletedByCustomer(clientId);
        Set<Map.Entry<Integer, Integer>> entries = discountsThresholds.entrySet();
        for (Map.Entry<Integer, Integer> entry : entries) {
            if(totalRentDuration >= entry.getValue())
                discountRate = entry.getValue();
        }
        client.setDiscountRate(discountRate);
        clientRepository.saveAndFlush(client);
    }
}

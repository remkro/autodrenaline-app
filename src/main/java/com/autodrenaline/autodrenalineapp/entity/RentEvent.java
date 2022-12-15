package com.autodrenaline.autodrenalineapp.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class RentEvent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToOne
    private Car car;

    @OneToOne
    private Client client;

    private LocalDateTime createdAt;
    private LocalDate startDate;
    private int duration;
    private BigDecimal income;

    public RentEvent() {
    }
}

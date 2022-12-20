package com.autodrenaline.autodrenalineapp.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CreateRentEventDto {
    private long carId;
    private int duration;
    private LocalDate startDate;
}

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
public class RecentRentalDto {
    private String tenant;
    private String car;
    private LocalDate startDate;
    private int duration;
    private int discount;
    private double income;
}

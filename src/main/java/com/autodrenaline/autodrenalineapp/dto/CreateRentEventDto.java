package com.autodrenaline.autodrenalineapp.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CreateRentEventDto {
    private long carId;
    private int duration;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate startDate;
}

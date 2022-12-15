package com.autodrenaline.autodrenalineapp.dto;

import com.autodrenaline.autodrenalineapp.entity.Car;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CreateRentEventDto {
    private long carId;
    private int duration;
}

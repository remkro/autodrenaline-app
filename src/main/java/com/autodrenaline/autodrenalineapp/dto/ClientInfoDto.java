package com.autodrenaline.autodrenalineapp.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ClientInfoDto {
    private String firstName;
    private String lastName;
    private String email;
    private int age;
    private int rentals;
    private int discountRate;
    double income;
}

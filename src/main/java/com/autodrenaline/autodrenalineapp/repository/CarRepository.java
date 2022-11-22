package com.autodrenaline.autodrenalineapp.repository;

import com.autodrenaline.autodrenalineapp.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car, Long> {
}

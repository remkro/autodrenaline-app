package com.autodrenaline.autodrenalineapp.repository;

import com.autodrenaline.autodrenalineapp.entity.RentEvent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RentEventRepository extends JpaRepository<RentEvent, Long> {
}

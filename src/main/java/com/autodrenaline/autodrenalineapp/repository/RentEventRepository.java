package com.autodrenaline.autodrenalineapp.repository;

import com.autodrenaline.autodrenalineapp.entity.RentEvent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface RentEventRepository extends JpaRepository<RentEvent, Long> {
    @Query("SELECT SUM(r.duration) FROM RentEvent r WHERE r.client.id = ?1")
    int sumTotalRentDurationCompletedByCustomer(long id);
    int countAllByClient_Id(long id);
    @Query("SELECT SUM(r.income) FROM RentEvent r WHERE r.client.id = ?1")
    Double sumTotalRentIncomeGeneratedByCustomer(long id);
}

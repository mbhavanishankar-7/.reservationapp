package com.reservationapp.Repository;

import com.reservationapp.entity.Driver;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DriverRepository extends JpaRepository<Driver,Long> {
}

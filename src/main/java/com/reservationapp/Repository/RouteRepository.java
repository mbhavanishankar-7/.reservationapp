package com.reservationapp.Repository;

import com.reservationapp.entity.Route;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RouteRepository extends JpaRepository<Route,Long> {
}

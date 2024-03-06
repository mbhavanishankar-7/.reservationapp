package com.reservationapp.Service;

import com.reservationapp.Repository.BusRepository;
import com.reservationapp.Repository.DriverRepository;
import com.reservationapp.Repository.RouteRepository;
import com.reservationapp.Repository.SubRouteRepository;
import com.reservationapp.entity.Bus;
import com.reservationapp.entity.Route;
import com.reservationapp.entity.SubRoute;
import com.reservationapp.payload.BusDto;
import com.reservationapp.payload.SubRouteDto;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BusService {
    @Autowired
    private BusRepository busRepository;
    @Autowired
    private RouteRepository routeRepository;

    @Autowired
    private SubRouteRepository subRouteRepository;
    @Autowired
    private DriverRepository driverRepository;

    @Transactional
    public void addBus(BusDto busDto) {

        //cretae Route entity
        Route route = new Route();
        route.setFromLocation(busDto.getRoute().getFromLocation());
        route.setToLocation(busDto.getRoute().getToLocation());
        route.setFromDate(busDto.getRoute().getFromDate());
        route.setToDate(busDto.getRoute().getToDate());
        route.setTotalDuration(busDto.getRoute().getTotalDuration());
        route.setFromTime(busDto.getRoute().getFromTime());
        route.setToTime(busDto.getRoute().getToTime());

        Route savedRoute = routeRepository.save(route);

        Bus bus = new Bus();
        bus.setBusNumber(busDto.getBusNumber());
        bus.setBusType(busDto.getBusType());
        bus.setPrice(busDto.getPrice());
        bus.setTotalSeats(busDto.getTotalSeats());
        bus.setAvailableSeats(busDto.getAvailableSeats());

        bus.setRoute(route);

        Bus savedBus = busRepository.save(bus);

        Route routeUpdate = routeRepository.findById(savedRoute.getId()).get();
        routeUpdate.setBus(savedBus);
        routeRepository.save(routeUpdate);

        if (busDto.getSubRoute() != null && !busDto.getSubRoute().isEmpty()) {
            for (SubRouteDto subRouteDto : busDto.getSubRoute()) {
                SubRoute subRoute = new SubRoute();
                subRoute.setFromLocation(subRouteDto.getFromLocation());
                subRoute.setToLocation(subRouteDto.getToLocation());
                subRoute.setFromDate(subRouteDto.getFromDate());
                subRoute.setToDate(subRouteDto.getToDate());
                subRoute.setTotalDuration(subRouteDto.getTotalDuration());
                subRoute.setFromTime(subRouteDto.getToTime());
                subRoute.setToTime(subRouteDto.getToTime());

                subRoute.setRoute(route);

                subRouteRepository.save(subRoute);
            }
        }
    }
}
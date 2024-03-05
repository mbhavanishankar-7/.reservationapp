package com.reservationapp.controller;

import com.reservationapp.Repository.BusRepository;
import com.reservationapp.Service.BusService;
import com.reservationapp.entity.Bus;
import com.reservationapp.payload.BusDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
@RequestMapping("/api/v1/bus")
public class BusController {
    @Autowired
    private BusRepository busRepository;
    @Autowired
    private BusService busService;

    //http:localhost:8080/api/v1/bus/add
    @PostMapping("/add")
    public ResponseEntity<BusDto> addBus(
           @RequestBody BusDto busDto
            ) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("dd MM yyyy");
        Date fromDate = formatter.parse(busDto.getFromDate());
        Date toDate = formatter.parse(busDto.getToDate());

        BusDto dto = busService.addBus(busDto);
        return new ResponseEntity<>(dto,HttpStatus.CREATED);
    }
}

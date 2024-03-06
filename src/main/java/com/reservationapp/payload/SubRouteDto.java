package com.reservationapp.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SubRouteDto {
    private Long subRouteId;
    private String fromLocation;
    private String toLocation;
    private String fromDate;
    private String toDate;
    private int totalDuration;
    private String fromTime;
    private String toTime;
    private RouteDto route; // Reference to the parent Route
    // Getters and setters
}


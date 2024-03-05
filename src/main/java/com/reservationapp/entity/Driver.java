package com.reservationapp.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Driver {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String driverName;
    private String driverLicenseNumber;
    private String aadharNumber;
    private String contactNumber;
    private String alternateContactNumber;
    private String emailId;

    // Constructor, getters, setters
}


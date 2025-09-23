package org.example.frotavivapostgreapi.controller;

import org.example.frotavivapostgreapi.model.DriverFirebase;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

public interface DriverFirebaseController {
    @GetMapping("/driver-firebase")
    ResponseEntity<List<DriverFirebase>> getAllDrivers(@Param("enterprise_code") String enterpriseCode);
}

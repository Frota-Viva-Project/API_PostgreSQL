package org.example.frotavivapostgreapi.controller.impl;

import org.example.frotavivapostgreapi.controller.DriverFirebaseController;
import org.example.frotavivapostgreapi.model.DriverFirebase;
import org.example.frotavivapostgreapi.service.DriverFirebaseService;
import org.example.frotavivapostgreapi.service.impl.DriverFirebaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("v1/api")
public class DriverFirebaseControllerImpl implements DriverFirebaseController {



    public ResponseEntity<List<DriverFirebase>> getAllDrivers(@Param("enterprise_code") String enterpriseCode) {
        try {
            DriverFirebaseService driverFirebaseService = new DriverFirebaseServiceImpl();
            List<DriverFirebase> drivers = driverFirebaseService.getAllDrivers(enterpriseCode);
            return new ResponseEntity<>(drivers, HttpStatus.OK);
        } catch (InterruptedException | ExecutionException e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

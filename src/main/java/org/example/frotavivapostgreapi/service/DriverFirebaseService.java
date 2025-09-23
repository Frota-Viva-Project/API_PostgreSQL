package org.example.frotavivapostgreapi.service;

import org.example.frotavivapostgreapi.model.DriverFirebase;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.concurrent.ExecutionException;

public interface DriverFirebaseService {
    List<DriverFirebase> getAllDrivers(@Param("enterprise_code") String enterpriseCode) throws InterruptedException, ExecutionException;
}

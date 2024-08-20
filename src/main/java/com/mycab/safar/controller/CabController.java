package com.mycab.safar.controller;

import com.mycab.safar.domain.Driver;
import com.mycab.safar.domain.Location;
import com.mycab.safar.domain.request.LocationRequest;
import com.mycab.safar.service.CabService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RestController
public class CabController {
    @Autowired
    private CabService cabService;
    @GetMapping(value = "/cabs/{customerId}")
    public List<String> findRides(@PathVariable Long customerId, @RequestBody LocationRequest tripLocation) {
        Location source = tripLocation.getSource();
        Location destination = tripLocation.getDestination();
        List<Driver> driverList = cabService.findRides(customerId, source, destination);
        List<String> driverNames = new ArrayList<>();
        for (Driver driver: driverList) {
            driverNames.add(driver.getName());
        }
        return driverNames.isEmpty()? Collections.singletonList("No ride found."): driverNames;
    }
}

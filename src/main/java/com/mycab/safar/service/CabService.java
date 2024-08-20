package com.mycab.safar.service;

import com.mycab.safar.domain.Driver;
import com.mycab.safar.domain.Location;
import com.mycab.safar.repository.CustomerRepository;
import com.mycab.safar.repository.DriverRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class CabService {
    private int maxDistance = 5;
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private DriverRepository driverRepository;
    public List<Driver> findRides(Long customerId, Location customerLocation, Location destination) {
        List<Driver> drivers = driverRepository.findAll();
        List<Driver> availableDriverList = new ArrayList<>();
        for (Driver driver: drivers) {
            Location driverLocation = driver.getLocation();
            if (driver.isAvailable() && calculateDistance(customerLocation, driverLocation) <= maxDistance) {
                availableDriverList.add(driver);
            }
        }
        return availableDriverList;
    }

    private int calculateDistance(Location a, Location b) {
        return (int) Math.sqrt(Math.pow(a.getX().doubleValue() - b.getX().doubleValue(), 2) + Math.pow(a.getY().doubleValue() - b.getY().doubleValue(), 2));
    }
}

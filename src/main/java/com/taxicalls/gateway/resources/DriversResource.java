package com.taxicalls.gateway.resources;

import com.taxicalls.gateway.model.Driver;
import com.taxicalls.gateway.model.Trip;
import com.taxicalls.gateway.services.DriverService;
import com.taxicalls.protocol.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/drivers")
public class DriversResource {

    @Autowired
    private DriverService driverService;

    @RequestMapping(method = RequestMethod.POST, value = "/authenticate")
    public Response authenticateDriver(@RequestBody Driver driver) {
        return driverService.authenticateDriver(driver);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/trips")
    public Response acceptTrip(@RequestBody Trip trip) {
        return driverService.acceptTrip(trip);
    }
}

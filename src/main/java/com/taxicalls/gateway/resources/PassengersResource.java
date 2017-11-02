package com.taxicalls.gateway.resources;

import com.taxicalls.gateway.model.Driver;
import com.taxicalls.gateway.model.Passenger;
import com.taxicalls.gateway.services.PassengerService;
import com.taxicalls.protocol.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/passengers")
public class PassengersResource {

    @Autowired
    private PassengerService passengerService;

    @RequestMapping(method = RequestMethod.POST, value = "/authenticate")
    public Response authenticatePassenger(@RequestBody Passenger passenger) {
        return passengerService.authenticatePassenger(passenger);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/trips/drivers/available")
    public Response getAvailableDrivers() {
        return passengerService.getAvailableDrivers();
    }

    @RequestMapping(method = RequestMethod.POST, value = "/trips/drivers/choose")
    public Response chooseDriver(@RequestBody Driver driver) {
        return passengerService.chooseDriver(driver);
    }

}

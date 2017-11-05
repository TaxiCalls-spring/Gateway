package com.taxicalls.gateway.services;

import com.taxicalls.gateway.model.Driver;
import com.taxicalls.gateway.model.Trip;
import com.taxicalls.gateway.resources.AvailableDriversRequest;
import com.taxicalls.protocol.Response;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author romulo
 */
@FeignClient(name = "trip")
public interface TripService {

    @RequestMapping(method = RequestMethod.POST, value = "/drivers/available")
    public Response getAvailableDrivers(AvailableDriversRequest availableDriversRequest);

    @RequestMapping(method = RequestMethod.POST, value = "/drivers/update")
    public Response updateDriver(Driver driver);

    @RequestMapping(method = RequestMethod.POST, value = "/trips/update")
    public Response updateTrip(Trip trip);

}

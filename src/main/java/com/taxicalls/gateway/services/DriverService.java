package com.taxicalls.gateway.services;

import com.taxicalls.gateway.model.Driver;
import com.taxicalls.gateway.model.Trip;
import com.taxicalls.protocol.Response;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author romulo
 */
@FeignClient(name = "driver")
public interface DriverService {

    @RequestMapping(method = RequestMethod.POST, value = "/authenticate")
    public Response authenticateDriver(Driver driver);

    @RequestMapping(method = RequestMethod.POST, value = "/trips")
    public Response acceptTrip(Trip trip);

}

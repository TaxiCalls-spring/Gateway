package com.taxicalls.gateway.services;

import com.taxicalls.gateway.model.Passenger;
import com.taxicalls.gateway.resources.ChooseDriverRequest;
import com.taxicalls.protocol.Response;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author romulo
 */
@FeignClient(name = "passenger")
public interface PassengerService {

    @RequestMapping(method = RequestMethod.POST, value = "/authenticate")
    public Response authenticatePassenger(Passenger passenger);

    @RequestMapping(method = RequestMethod.POST, value = "/trips/drivers/available")
    public Response getAvailableDrivers();

    @RequestMapping(method = RequestMethod.POST, value = "/trips/drivers/choose")
    public Response chooseDriver(ChooseDriverRequest chooseDriverRequest);

}

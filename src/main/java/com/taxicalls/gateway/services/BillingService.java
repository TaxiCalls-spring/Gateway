package com.taxicalls.gateway.services;

import com.taxicalls.gateway.model.Driver;
import com.taxicalls.protocol.Response;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author romulo
 */
@FeignClient(name = "billing")
public interface BillingService {

   @RequestMapping(method = RequestMethod.POST, value = "/billings")
    public Response chooseDriver(Driver diver);

}

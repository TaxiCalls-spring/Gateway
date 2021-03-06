package com.taxicalls.gateway.services;

import com.taxicalls.gateway.model.Driver;
import com.taxicalls.gateway.resources.CheckNotificationsRequest;
import com.taxicalls.protocol.Response;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author romulo
 */
@FeignClient(name = "notification")
public interface NotificationService {

    @RequestMapping(method = RequestMethod.POST, value = "/notifications")
    public Response chooseDriver(Driver diver);
    
    @RequestMapping(method = RequestMethod.POST, value = "/checks")
    public Response checkNotifications(CheckNotificationsRequest checkNotificationsRequest);

}

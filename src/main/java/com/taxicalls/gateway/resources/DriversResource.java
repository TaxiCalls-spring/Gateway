package com.taxicalls.gateway.resources;

import com.taxicalls.gateway.model.Driver;
import com.taxicalls.gateway.model.Trip;
import com.taxicalls.gateway.services.DriverService;
import com.taxicalls.gateway.services.NotificationService;
import com.taxicalls.gateway.services.TripService;
import com.taxicalls.protocol.Response;
import com.taxicalls.protocol.Status;
import java.util.logging.Level;
import java.util.logging.Logger;

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

    @Autowired
    private TripService tripService;

    @Autowired
    private NotificationService notificationService;

    private static final Logger LOGGER = Logger.getLogger(DriversResource.class.getName());

    @RequestMapping(method = RequestMethod.POST, value = "/authenticate")
    public Response authenticateDriver(@RequestBody Driver driver) {
        Response response = driverService.authenticateDriver(driver);
        if (response.getStatus().equals(Status.NOT_FOUND)) {
            return driverService.createDriver(driver);
        }
        return response;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/trips/accept")
    public Response acceptTrip(@RequestBody Trip trip) {
        return driverService.acceptTrip(trip);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/trips/update")
    public Response updateTrip(@RequestBody Trip trip) {
        return tripService.updateTrip(trip);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/update")
    public Response updateDriver(@RequestBody Driver driver) {
        return tripService.updateDriver(driver);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/notifications/check")
    public Response checkNotifications(@RequestBody Driver driver) {
        CheckNotificationsRequest checkNotificationsRequest = new CheckNotificationsRequest();
        checkNotificationsRequest.setEntity(driver.getClass().getSimpleName());
        checkNotificationsRequest.setId(driver.getId());
        return notificationService.checkNotifications(checkNotificationsRequest);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/billings/account/update")
    public Response updateAccount(@RequestBody Driver driver) {
        LOGGER.log(Level.INFO, "updateAccount() invoked");
        return Response.successful();
    }

}

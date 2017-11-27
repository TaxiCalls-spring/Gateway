package com.taxicalls.gateway.resources;

import com.taxicalls.gateway.model.Passenger;
import com.taxicalls.gateway.model.Trip;
import com.taxicalls.gateway.services.NotificationService;
import com.taxicalls.gateway.services.PassengerService;
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
@RequestMapping("/passengers")
public class PassengersResource {

    @Autowired
    private PassengerService passengerService;

    @Autowired
    private NotificationService notificationService;

    @Autowired
    private TripService tripService;

    private static final Logger LOGGER = Logger.getLogger(PassengersResource.class.getName());

    @RequestMapping(method = RequestMethod.POST, value = "/authenticate")
    public Response authenticatePassenger(@RequestBody Passenger passenger) {
        Response response = passengerService.authenticatePassenger(passenger);
        if (response.getStatus().equals(Status.NOT_FOUND)) {
            return passengerService.createPassenger(passenger);
        }
        return response;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/trips/drivers/available")
    public Response getAvailableDrivers(@RequestBody Trip trip) {
        AvailableDriversRequest availableDriversRequest = new AvailableDriversRequest();
        availableDriversRequest.setCoordinate(trip.getAddressFrom().getCoordinate());
        availableDriversRequest.setRatio(5);
        return tripService.getAvailableDrivers(availableDriversRequest);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/trips/request")
    public Response requestTrip(@RequestBody Trip trip) {
        return tripService.requestTrip(trip);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/trips/drivers/choose")
    public Response chooseDriver(@RequestBody ChooseDriverRequest chooseDriverRequest) {
        return passengerService.chooseDriver(chooseDriverRequest);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/notifications/check")
    public Response checkNotifications(@RequestBody Passenger passenger) {
        CheckNotificationsRequest checkNotificationsRequest = new CheckNotificationsRequest();
        checkNotificationsRequest.setEntity(passenger.getClass().getSimpleName());
        checkNotificationsRequest.setId(passenger.getId());
        return notificationService.checkNotifications(checkNotificationsRequest);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/billings/card/update")
    public Response updateCard(@RequestBody Passenger passenger) {
        LOGGER.log(Level.INFO, "updateCard() invoked");
        return Response.successful();
    }

}

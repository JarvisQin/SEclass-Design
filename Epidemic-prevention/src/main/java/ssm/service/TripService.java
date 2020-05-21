package ssm.service;

import ssm.domain.Trip;

import java.util.List;

public interface TripService {
    void addTrip(Trip trip);
    List<Trip> getTripList();
    List<Trip> getTripListbyUserId(int userId);


}

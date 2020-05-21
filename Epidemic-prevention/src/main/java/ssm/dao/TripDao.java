package ssm.dao;

import ssm.domain.Trip;

import java.util.List;

public interface TripDao {
    void addTrip(Trip trip);
    List<Trip> getTripList();
    List<Trip> getTripListbyUserId(int userId);

}

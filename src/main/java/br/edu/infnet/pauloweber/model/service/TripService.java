package br.edu.infnet.pauloweber.model.service;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.pauloweber.model.domain.Trip;
import br.edu.infnet.pauloweber.model.repository.TripRepository;

@Service
public class TripService {
  @Autowired
  private TripRepository tripRepository;

  public Trip add(Trip trip) {
    return tripRepository.save(trip);
  }

  public void remove(Integer id) {
    tripRepository.deleteById(id);
  }

  public Long count() {
    return tripRepository.count();
  }

  public Collection<Trip> getAll(String sort) {
    List<Trip> trips = (List<Trip>) tripRepository.findAll();
    if (trips.isEmpty() || sort == null) {
        return trips;
    }

    switch (sort.toLowerCase()) {
        case "distance":
            trips.sort(Comparator.comparing(Trip::getDistance));
            break;
        case "starttime":
            trips.sort(Comparator.comparing(Trip::getStartTime));
            break;
        case "endtime":
            trips.sort(Comparator.comparing(Trip::getEndTime));
            break;
        case "averagespeed":
            trips.sort(Comparator.comparing(Trip::getAverageSpeed));
            break;
        case "averageconsumption":
            trips.sort(Comparator.comparing(Trip::getAverageConsumption));
            break;
        default:
            trips.sort(Comparator.comparing(Trip::getId));
    }
    return trips;
}


  public Trip getById(Integer id) {
    return tripRepository.findById(id).orElse(null);
  }

  public Collection<Trip> getAllByDriverId(Integer driverId) {
    return tripRepository.findByDriverId(driverId);
  }

  public Collection<Trip> searchAllFields(String query) {
    try {
        Float numericValue = Float.parseFloat(query);
        return tripRepository.findByDistanceOrAverageSpeedOrAverageConsumptionOrStartingOdometerOrEndingOdometerOrStartingFuelLevelOrEndingFuelLevel(
            numericValue, numericValue, numericValue,
            numericValue, numericValue,
            numericValue, numericValue
        );
    } catch (NumberFormatException e) {
        return List.of(); // Return empty list if query isn't numeric
    }
}


}

package br.edu.infnet.pauloweber.model.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;

import br.edu.infnet.pauloweber.model.domain.Trip;
import br.edu.infnet.pauloweber.model.repository.TripRepository;

public class TripService {
  @Autowired
  private TripRepository tripRepository;

  public Trip add(Trip trip) {
    return tripRepository.save(trip);
  }

  public void remove(Integer id) {
    tripRepository.deleteById(id);
  }

  public Collection<Trip> getAll() {
    return (Collection<Trip>) tripRepository.findAll();
  }

  public Collection<Trip> getAllByDriverId(Integer driverId) {
    return tripRepository.findByDriverId(driverId);
  }

}

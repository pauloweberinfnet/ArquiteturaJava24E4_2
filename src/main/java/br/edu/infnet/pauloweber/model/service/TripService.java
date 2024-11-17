package br.edu.infnet.pauloweber.model.service;

import java.util.Collection;

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

  public Collection<Trip> getAll() {
    return (Collection<Trip>) tripRepository.findAll();
  }

  public Trip getById(Integer id) {
    return tripRepository.findById(id).orElse(null);
  }

  public Collection<Trip> getAllByDriverId(Integer driverId) {
    return tripRepository.findByDriverId(driverId);
  }

}

package br.edu.infnet.pauloweber.model.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.edu.infnet.pauloweber.model.domain.Trip;

public interface TripRepository extends CrudRepository<Trip, Integer> {

  List<Trip> findByDriverId(Integer driverId);

  List<Trip> findByVehicleId(Integer vehicleId);


}

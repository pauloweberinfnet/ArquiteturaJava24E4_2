package br.edu.infnet.pauloweber.model.service;

import java.util.Collection;
import  java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.pauloweber.model.domain.Vehicle;
import br.edu.infnet.pauloweber.model.repository.VehicleRepository;

@Service
public class VehicleService {
  @Autowired
  private VehicleRepository vehicleRepository;

  public Vehicle getById(Integer id) {
    return vehicleRepository.findById(id).orElse(null);
  }

  private static final Random random = new Random();

  public Collection<Vehicle> getAll() {
    return (Collection<Vehicle>) vehicleRepository.findAll();
  }

  public Collection<Vehicle> getByLicensePlate(String licensePlate) {
    return vehicleRepository.findByLicensePlate(licensePlate);
  }

  public Vehicle add(Vehicle vehicle) {
    return vehicleRepository.save(vehicle);
  }

  public long count() {
    return vehicleRepository.count();
  }

  public void remove(Vehicle vehicle) {
    vehicleRepository.delete(vehicle);
  }

  public Vehicle getRandomVehicle() {
    Collection<Vehicle> vehicles = getAll();
    int randomIndex = random.nextInt(vehicles.size());
    return vehicles.toArray(new Vehicle[0])[randomIndex];
  }


}

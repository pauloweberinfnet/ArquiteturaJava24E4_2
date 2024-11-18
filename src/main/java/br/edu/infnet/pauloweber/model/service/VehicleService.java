package br.edu.infnet.pauloweber.model.service;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
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

  public Collection<Vehicle> getAll(String sort) {
    List<Vehicle> vehicles = (List<Vehicle>) vehicleRepository.findAll();

    if (vehicles.isEmpty() || sort == null) {
      return vehicles;
    }

    switch (sort.toLowerCase()) {
        case "licensePlate":
            vehicles.sort(Comparator.comparing(Vehicle::getLicensePlate));
            break;
        case "brand":
            vehicles.sort(Comparator.comparing(Vehicle::getBrand));
            break;
        case "model":
            vehicles.sort(Comparator.comparing(Vehicle::getModel));
            break;
        case "modelYear":
            vehicles.sort(Comparator.comparing(Vehicle::getModelYear));
            break;
        case "odometer":
            vehicles.sort(Comparator.comparing(Vehicle::getOdometer));
            break;
        default:
            vehicles.sort(Comparator.comparing(Vehicle::getId));
    }

    return vehicles;
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
    Collection<Vehicle> vehicles = getAll("id");
    int randomIndex = random.nextInt(vehicles.size());
    return vehicles.toArray(new Vehicle[0])[randomIndex];
  }


}

package br.edu.infnet.pauloweber.model.service;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.pauloweber.model.domain.Combustion;
import br.edu.infnet.pauloweber.model.domain.Vehicle;
import br.edu.infnet.pauloweber.model.repository.CombustionRepository;

@Service
public class CombustionService {
  @Autowired
  private CombustionRepository combustionRepository;

  public Combustion add(Combustion combustion) {
    return combustionRepository.save(combustion);
  }

  public long count() {
    return combustionRepository.count();
  }
  public Collection<Combustion> getAll(String sort) {

    List<Combustion> vehicles = (List<Combustion>) combustionRepository.findAll();
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
}

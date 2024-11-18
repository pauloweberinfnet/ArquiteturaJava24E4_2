package br.edu.infnet.pauloweber.model.service;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.pauloweber.model.domain.Eletric;
import br.edu.infnet.pauloweber.model.domain.Vehicle;
import br.edu.infnet.pauloweber.model.repository.EletricRepository;

@Service
public class EletricService {
  @Autowired
  private EletricRepository eletricRepository;

  public Eletric add(Eletric eletric) {
    return eletricRepository.save(eletric);
  }

  public long count() {
    return eletricRepository.count();
  }

  public Collection<Eletric> getAll(String sort) {

    List<Eletric> vehicles = (List<Eletric>) eletricRepository.findAll();
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

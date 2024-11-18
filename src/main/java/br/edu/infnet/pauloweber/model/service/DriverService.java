package br.edu.infnet.pauloweber.model.service;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.pauloweber.model.domain.Driver;
import br.edu.infnet.pauloweber.model.repository.DriverRepository;

@Service
public class DriverService {

  private final DriverRepository driverRepository;
  @Autowired
  public DriverService(DriverRepository driverRepository) {
    this.driverRepository = driverRepository;
  }

  private static final Random random = new Random();

  public Driver add(Driver driver) {
    return driverRepository.save(driver);
  }

  public void remove(Integer id) {
    driverRepository.deleteById(id);
  }

  /* public Collection<Driver> getAll() {
    return (Collection<Driver>) driverRepository.findAll();
  } */

  public Collection<Driver> getAll(String sort) {
    List<Driver> drivers = (List<Driver>) driverRepository.findAll();
    if (drivers.isEmpty()) {
        return drivers;
    }
    if (sort == null) {
        return drivers;
    }
    switch (sort.toLowerCase()) {
        case "name":
            drivers.sort(Comparator.comparing(Driver::getName));
            break;
        case "licenseid":
            drivers.sort(Comparator.comparing(Driver::getLicenseId));
            break;
        default:
            drivers.sort(Comparator.comparing(Driver::getId));
    }
    return drivers;
}

  public List<Driver> getByNameContaining(String name) {
    return driverRepository.findByNameContaining(name);
  }

  public List<Driver> getByLicenseId(String licenseId) {
    return driverRepository.findByLicenseId(licenseId);
  }

  public long count() {
    return driverRepository.count();
  }

  public Driver getById(Integer id) {
    return driverRepository.findById(id).orElse(null);
  }

  public Driver getRandomDriver() {
    Collection<Driver> drivers = getAll("id");
    int randomIndex = random.nextInt(drivers.size());
    return drivers.toArray(new Driver[0])[randomIndex];
  }

}

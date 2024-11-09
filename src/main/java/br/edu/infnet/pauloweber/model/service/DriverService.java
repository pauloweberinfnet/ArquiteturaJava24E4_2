package br.edu.infnet.pauloweber.model.service;

import java.util.Collection;
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

  public Collection<Driver> getAll() {
    return (Collection<Driver>) driverRepository.findAll();
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
    Collection<Driver> drivers = getAll();
    int randomIndex = random.nextInt(drivers.size());
    return drivers.toArray(new Driver[0])[randomIndex];
  }

}

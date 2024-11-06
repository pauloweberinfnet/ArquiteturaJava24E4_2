package br.edu.infnet.pauloweber.model.service;

import java.util.Collection;
import java.util.List;

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

  public Driver add(Driver driver) {
    return driverRepository.save(driver);
  }

  public void remove(Integer id) {
    driverRepository.deleteById(id);
  }

  public Collection<Driver> getAll() {
    return (Collection<Driver>) driverRepository.findAll();
  }

  public List<Driver> getByName(String name) {
    return driverRepository.findByNameContaining(name);
  }

  public long count() {
    return driverRepository.count();
  }

  public Driver getById(Integer id) {
    return driverRepository.findById(id).orElse(null);
  }

}

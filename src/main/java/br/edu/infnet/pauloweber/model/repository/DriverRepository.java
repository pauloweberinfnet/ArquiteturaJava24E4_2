package br.edu.infnet.pauloweber.model.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.pauloweber.model.domain.Driver;

@Repository
public interface DriverRepository extends CrudRepository<Driver, Integer> {

  List<Driver> findByNameContaining(String name);

  List<Driver> findByLicenseId(String licenseId);

}

package br.edu.infnet.pauloweber.model.repository;

import java.util.Collection;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.pauloweber.model.domain.Vehicle;

@Repository
public interface VehicleRepository extends CrudRepository<Vehicle, Integer> {

  Collection<Vehicle> findByLicensePlate(String licensePlate);

  Collection<Vehicle> findByLicensePlateContainingOrBrandContainingOrModelContainingOrModelYearOrOdometerOrArchived(
      String licensePlate,
      String brand,
      String model,
      Integer modelYear,
      Float odometer,
      Boolean archived
  );
}

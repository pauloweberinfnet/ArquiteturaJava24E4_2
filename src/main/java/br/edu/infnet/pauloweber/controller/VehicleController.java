package br.edu.infnet.pauloweber.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.infnet.pauloweber.model.domain.Vehicle;
import br.edu.infnet.pauloweber.model.service.VehicleService;

@RestController
@RequestMapping("/api/vehicles")
public class VehicleController {

    @Autowired
    private VehicleService vehicleService;

    @GetMapping
    public Collection<Vehicle> getAll() {
        return vehicleService.getAll();
    }

    @GetMapping("/{id}")
    public Vehicle getById(@PathVariable Integer id) {
        return vehicleService.getById(id);
    }

    @GetMapping("/license/{licensePlate}")
    public Collection<Vehicle> getByLicensePlate(@PathVariable String licensePlate) {
        return vehicleService.getByLicensePlate(licensePlate);
    }

    @GetMapping("/random")
    public Vehicle getRandomVehicle() {
        return vehicleService.getRandomVehicle();
    }

    @GetMapping("/count")
    public long getCount() {
        return vehicleService.count();
    }

    @PostMapping
    public Vehicle add(@RequestBody Vehicle vehicle) {
        return vehicleService.add(vehicle);
    }

    @DeleteMapping("/{id}")
    public void remove(@PathVariable Integer id) {
        Vehicle vehicle = vehicleService.getById(id);
        if (vehicle != null) {
            vehicleService.remove(vehicle);
        }
    }
}

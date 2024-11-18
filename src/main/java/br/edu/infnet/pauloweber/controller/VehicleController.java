package br.edu.infnet.pauloweber.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import br.edu.infnet.pauloweber.model.domain.Vehicle;
import br.edu.infnet.pauloweber.model.service.VehicleService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/vehicles")
public class VehicleController {

    @Autowired
    private VehicleService vehicleService;

    @Operation(summary = "Get all vehicles")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Vehicles found"),
            @ApiResponse(responseCode = "404", description = "Vehicles not found")
    })
    @GetMapping
    public ResponseEntity<Collection<Vehicle>> getAll(String sort) {
        Collection<Vehicle> vehicles = vehicleService.getAll(sort);
        if (vehicles.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No vehicles found");
        }
        return ResponseEntity.ok(vehicles);
    }

    @Operation(summary = "Get a vehicle by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Vehicle found"),
            @ApiResponse(responseCode = "404", description = "Vehicle not found")
    })
    @GetMapping("/{id}")
    public ResponseEntity<Vehicle> getById(@PathVariable Integer id) {
        Vehicle existingVehicle = vehicleService.getById(id);
        if (existingVehicle == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(existingVehicle);
    }

    @GetMapping("/license/{licensePlate}")
    public Collection<Vehicle> getByLicensePlate(@PathVariable String licensePlate) {
        return vehicleService.getByLicensePlate(licensePlate);
    }

    @Operation(summary = "Search vehicles by querying all fields")
    @GetMapping("/search")
    public Collection<Vehicle> search(@RequestParam String query) {
        return vehicleService.searchAllFields(query);
    }

    @Operation(summary = "Get a random vehicle")
    @GetMapping("/random")
    public Vehicle getRandomVehicle() {
        return vehicleService.getRandomVehicle();
    }

    @Operation(summary = "Get the count of vehicles")
    @GetMapping("/count")
    public long getCount() {
        return vehicleService.count();
    }

    @Operation(summary = "Add a new vehicle")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Vehicle created successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid input data")
    })
    @PostMapping
    public Vehicle add(@Valid @RequestBody Vehicle vehicle) {
        return vehicleService.add(vehicle);
    }

    @Operation(summary = "Delete a vehicle by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Vehicle deleted successfully"),
            @ApiResponse(responseCode = "404", description = "Vehicle not found")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Vehicle> remove(@PathVariable Integer id) {
        Vehicle existingVehicle = vehicleService.getById(id);

        if (existingVehicle == null) {
            return ResponseEntity.notFound().build();
        }

        try {
            vehicleService.remove(existingVehicle);
        } catch (DataIntegrityViolationException e) {
            return ResponseEntity
                .status(HttpStatus.CONFLICT)
                .body(existingVehicle);
        }

        return ResponseEntity.noContent().build();
    }
}

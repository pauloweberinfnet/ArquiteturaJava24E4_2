package br.edu.infnet.pauloweber.controller;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.edu.infnet.pauloweber.model.domain.Driver;
import br.edu.infnet.pauloweber.model.service.DriverService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/drivers")
public class DriverController {

    @Autowired
    private DriverService driverService;

    @Operation(summary = "Get all drivers")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Drivers found", content = @Content(schema = @Schema(implementation = Driver.class))),
            @ApiResponse(responseCode = "404", description = "Drivers not found", content = @Content(schema = @Schema(implementation = ErrorResponse.class)))
    })
    @GetMapping
    public ResponseEntity<Collection<Driver>> getAllDrivers(@RequestParam(required = false, defaultValue = "id") String sort) {
        return ResponseEntity.ok(driverService.getAll(sort));
    }
    @Operation(summary = "Get a driver by ID")
    @GetMapping("/{id}")
    public ResponseEntity<Driver> getDriverById(@PathVariable Integer id) {
        Driver driver = driverService.getById(id);
        return driver != null ? ResponseEntity.ok(driver) : ResponseEntity.notFound().build();
    }

    @Operation(summary = "Search drivers across all fields")
    @GetMapping("/search")
    public ResponseEntity<List<Driver>> searchDrivers(@RequestParam String query) {
        return ResponseEntity.ok(driverService.searchAllFields(query));
    }

    @GetMapping("/search/name")
    public ResponseEntity<List<Driver>> getDriversByName(@RequestParam String name) {
        return ResponseEntity.ok(driverService.getByNameContaining(name));
    }

    @GetMapping("/search/license")
    public ResponseEntity<List<Driver>> getDriversByLicense(@RequestParam String licenseId) {
        return ResponseEntity.ok(driverService.getByLicenseId(licenseId));
    }

    @Operation(summary = "Get a random driver")
    @GetMapping("/random")
    public ResponseEntity<Driver> getRandomDriver() {
        return ResponseEntity.ok(driverService.getRandomDriver());
    }

    @Operation(summary = "Create a new driver")
    @PostMapping
    public ResponseEntity<Driver> createDriver(@Valid @RequestBody Driver driver) {
        return new ResponseEntity<>(driverService.add(driver), HttpStatus.CREATED);
    }

    @Operation(summary = "Update a driver")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Driver updated", content = @Content(schema = @Schema(implementation = Driver.class))),
            @ApiResponse(responseCode = "404", description = "Driver not found", content = @Content(schema = @Schema(implementation = ErrorResponse.class)))
    })
    @PutMapping("/{id}")
    public ResponseEntity<Driver> updateDriver(@PathVariable Integer id, @Valid @RequestBody Driver driver) {
        Driver existingDriver = driverService.getById(id);
        if (existingDriver == null) {
            return ResponseEntity.notFound().build();
        }
        driver.setId(id);
        return ResponseEntity.ok(driverService.add(driver));
    }

    @Operation(summary = "Delete a driver")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Driver deleted"),
            @ApiResponse(responseCode = "404", description = "Driver not found", content = @Content(schema = @Schema(implementation = ErrorResponse.class)))
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Driver> deleteDriver(@PathVariable Integer id) {
        Driver existingDriver = driverService.getById(id);
        if (existingDriver == null) {
            return ResponseEntity.notFound().build();
        }
            try {
                driverService.remove(id);
            } catch (DataIntegrityViolationException e) {
                return ResponseEntity
                .status(HttpStatus.CONFLICT)
                .body(existingDriver);
            }
            return ResponseEntity.noContent().build();
    }

    @GetMapping("/count")
    public ResponseEntity<Long> getDriverCount() {
        return ResponseEntity.ok(driverService.count());
    }
}

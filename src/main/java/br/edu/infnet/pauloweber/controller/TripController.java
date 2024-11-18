package br.edu.infnet.pauloweber.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
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

import br.edu.infnet.pauloweber.model.domain.Trip;
import br.edu.infnet.pauloweber.model.service.TripService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/trips")
public class TripController {

    @Autowired
    private TripService tripService;

    @Operation(summary = "Get all trips with optional sorting")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Retrieved all trips successfully"),
            @ApiResponse(responseCode = "404", description = "No trips found")
    })
    @GetMapping
    public ResponseEntity<Collection<Trip>> getTrips(@RequestParam(required = false, defaultValue = "id") String sort) {
        Collection<Trip> trips = tripService.getAll(sort);
        if (trips.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No trips found");
        }
        return ResponseEntity.ok(trips);
    }

    @Operation(summary = "Get a trip by its ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Trip found successfully"),
            @ApiResponse(responseCode = "404", description = "Trip not found")
    })
    @GetMapping("/{id}")
    public ResponseEntity<Trip> getTripById(@PathVariable Integer id) {
        Trip trip = tripService.getById(id);
        if (trip == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(trip);
    }

    @GetMapping("/count")
    public ResponseEntity<Long> getTripCount() {
        return ResponseEntity.ok(tripService.count());
    }

    @GetMapping("/driver/{driverId}")
    public ResponseEntity<Collection<Trip>> getTripsByDriver(@PathVariable Integer driverId) {
        Collection<Trip> trips = tripService.getAllByDriverId(driverId);
        if (trips.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(trips);
    }

    @Operation(summary = "Search trips by querying all fields")
    @GetMapping("/search")
    public ResponseEntity<Collection<Trip>> searchTrips(@RequestParam String query) {
        Collection<Trip> trips = tripService.searchAllFields(query);
        if (trips.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(trips);
    }

    @Operation(summary = "Create a new trip.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Trip created successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid input data")
    })
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Trip> createTrip(@Valid @RequestBody Trip trip) {
        Trip createdTrip = tripService.add(trip);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdTrip);
    }

    @Operation(summary = "Delete a trip by ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Trip deleted successfully"),
            @ApiResponse(responseCode = "404", description = "Trip not found")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Trip> deleteTrip(@PathVariable Integer id) {
        Trip existingTrip = tripService.getById(id);
        if (existingTrip == null) {
            return ResponseEntity.notFound().build();
        }
        tripService.remove(id);
        return ResponseEntity.noContent().build();
    }
}
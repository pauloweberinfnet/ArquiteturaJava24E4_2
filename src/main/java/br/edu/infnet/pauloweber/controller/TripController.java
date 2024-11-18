package br.edu.infnet.pauloweber.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.edu.infnet.pauloweber.model.domain.Trip;
import br.edu.infnet.pauloweber.model.service.TripService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/trips")
public class TripController {

    @Autowired
    private TripService tripService;

    @GetMapping
    public Collection<Trip> getTrips(@RequestParam(required = false, defaultValue = "id") String sort) {
    return tripService.getAll(sort);
}

    @GetMapping("/{id}")
    public Trip getTripById(@PathVariable Integer id) {
        return tripService.getById(id);
    }

    @GetMapping("/count")
    public Long getTripCount() {
        return tripService.count();
    }

    @GetMapping("/driver/{driverId}")
    public Collection<Trip> getTripsByDriver(@PathVariable Integer driverId) {
        return tripService.getAllByDriverId(driverId);
    }

    @Operation(summary = "Create a new trip.")
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public Trip createTrip(@Valid @RequestBody Trip trip) {
        return tripService.add(trip);
    }
    @DeleteMapping("/{id}")
    public void deleteTrip(@PathVariable Integer id) {
        tripService.remove(id);
    }
}

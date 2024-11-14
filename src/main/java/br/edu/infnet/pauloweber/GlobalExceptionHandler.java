package br.edu.infnet.pauloweber;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import br.edu.infnet.pauloweber.exceptions.DriverNotFound;
import br.edu.infnet.pauloweber.exceptions.TripNotFound;
import br.edu.infnet.pauloweber.exceptions.VehicleNotFound;

@ControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler(VehicleNotFound.class)
  public ResponseEntity<String> handleVehicleNotFound(VehicleNotFound ex) {
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
  }

  @ExceptionHandler(DriverNotFound.class)
  public ResponseEntity<String> handleDriverNotFound(DriverNotFound ex) {
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
  }

  @ExceptionHandler(TripNotFound.class)
  public ResponseEntity<String> handleTripNotFound(TripNotFound ex) {
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
  }
}

package br.edu.infnet.pauloweber.exceptions;

public class VehicleNotFound extends RuntimeException {

  private static final long serialVersionUID = 1L;

  public VehicleNotFound(String message) {
    super(message);
  }
}

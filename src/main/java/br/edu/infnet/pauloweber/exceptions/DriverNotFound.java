package br.edu.infnet.pauloweber.exceptions;

public class DriverNotFound extends RuntimeException {

  private static final long serialVersionUID = 1L;

  public DriverNotFound(String message) {
    super(message);
  }

}

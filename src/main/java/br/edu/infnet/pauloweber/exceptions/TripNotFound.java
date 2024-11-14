package br.edu.infnet.pauloweber.exceptions;

public class TripNotFound extends RuntimeException {

  private static final long serialVersionUID = 1L;

  public TripNotFound(String message) {
    super(message);
  }

}

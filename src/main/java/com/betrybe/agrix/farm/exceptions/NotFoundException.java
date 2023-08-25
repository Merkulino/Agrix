package com.betrybe.agrix.farm.exceptions;

/**
 * Not found exception.
 */
public class NotFoundException extends RuntimeException {

  public NotFoundException() {}

  public NotFoundException(String message) {
    super(message);
  }
  
}

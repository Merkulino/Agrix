package com.betrybe.agrix.farm.controller;

import com.betrybe.agrix.farm.exceptions.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;


/**
 * Controller Advice to run the exceptions.
 */
@RestControllerAdvice
public class ControllerAdvice {
  
  @ExceptionHandler(NotFoundException.class)
  @ResponseStatus(HttpStatus.NOT_FOUND)
  public String handleNotFoundException(NotFoundException exception) {
    return exception.getMessage();
  }

}

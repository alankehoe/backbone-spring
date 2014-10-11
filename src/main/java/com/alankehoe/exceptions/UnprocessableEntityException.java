package com.alankehoe.exceptions;

/**
 * Created by alan on 10/10/2014.
 */
public class UnprocessableEntityException extends Exception {
  public UnprocessableEntityException() {
  }

  public UnprocessableEntityException(String message) {
    super(message);
  }
}

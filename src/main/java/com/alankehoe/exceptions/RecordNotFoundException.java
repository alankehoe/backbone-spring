package com.alankehoe.exceptions;

/**
 * Created by alan on 10/10/2014.
 */
public class RecordNotFoundException extends Exception {
  public RecordNotFoundException() {
  }

  public RecordNotFoundException(String message) {
    super(message);
  }
}

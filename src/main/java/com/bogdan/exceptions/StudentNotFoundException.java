package com.bogdan.exceptions;

public class StudentNotFoundException extends RuntimeException {

  public StudentNotFoundException(final String id) {
    super("Student not found by id: " + id);
  }
}

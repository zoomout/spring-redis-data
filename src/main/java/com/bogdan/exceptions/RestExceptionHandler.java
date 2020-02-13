package com.bogdan.exceptions;

import com.bogdan.dto.ErrorDetails;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class RestExceptionHandler {

  @ExceptionHandler(StudentNotFoundException.class)
  @ResponseBody
  public ResponseEntity handleStudentNotFoundException(
      final HttpServletRequest req,
      final StudentNotFoundException e) {
    return new ResponseEntity<>(
        new ErrorDetails(null, e.getMessage()),
        HttpStatus.NOT_FOUND
    );
  }

}

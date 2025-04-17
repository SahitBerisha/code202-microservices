package com.tenderservice;

import static org.springframework.http.HttpStatus.NOT_FOUND;

import java.time.Instant;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Slf4j
//@RestControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

  //  @ExceptionHandler(TenderNotFoundException.class)
  public ResponseEntity<ErrorResponse> handleNotFound(RuntimeException e) {
    log.error(e.getClass().getName(), e);
    var httpStatus = NOT_FOUND;
    var errorResponse = new ErrorResponse(
        httpStatus.value(),
        httpStatus.getReasonPhrase(),
        Instant.now(),
        e.getLocalizedMessage()
    );
    return ResponseEntity.status(httpStatus).body(errorResponse);
  }

  record ErrorResponse(int code, String status, Instant timestamp, String message) {

  }
}

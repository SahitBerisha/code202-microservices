package com.tenderservice.exception;

import java.util.UUID;

public class TenderNotFoundException extends RuntimeException {

  private TenderNotFoundException(String message) {
    super(message);
  }

  public static TenderNotFoundException withId(UUID id) {
    return new TenderNotFoundException(String.format("Tender with id: '%s' not found", id));
  }
}

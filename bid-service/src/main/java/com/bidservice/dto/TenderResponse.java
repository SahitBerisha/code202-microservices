package com.bidservice.dto;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;

public class TenderResponse {

  UUID id;
  Instant createdAt;
  Instant updatedAt;
  String title;
  String description;
  Status status;
  Instant deadline;
  BigDecimal budget;

  public TenderResponse(UUID id, Instant createdAt, Instant updatedAt, String title,
      String description, Status status, Instant deadline, BigDecimal budget) {
    this.id = id;
    this.createdAt = createdAt;
    this.updatedAt = updatedAt;
    this.title = title;
    this.description = description;
    this.status = status;
    this.deadline = deadline;
    this.budget = budget;
  }

  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public Instant getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(Instant createdAt) {
    this.createdAt = createdAt;
  }

  public Instant getUpdatedAt() {
    return updatedAt;
  }

  public void setUpdatedAt(Instant updatedAt) {
    this.updatedAt = updatedAt;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Status getStatus() {
    return status;
  }

  public void setStatus(Status status) {
    this.status = status;
  }

  public Instant getDeadline() {
    return deadline;
  }

  public void setDeadline(Instant deadline) {
    this.deadline = deadline;
  }

  public BigDecimal getBudget() {
    return budget;
  }

  public void setBudget(BigDecimal budget) {
    this.budget = budget;
  }

  public enum Status {
    OPEN, CLOSED, CANCELLED, AWARDED
  }
}

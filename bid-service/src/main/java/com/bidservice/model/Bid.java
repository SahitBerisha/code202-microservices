package com.bidservice.model;

import java.math.BigDecimal;
import java.util.UUID;

public class Bid {

  private Long id;
  private Long bidderId;
  private UUID tenderId;
  private BigDecimal amount;
  private BidStatus status;

  public enum BidStatus {
    SUBMITTED, WITHDRAWN, DISQUALIFIED, WINNING, LOST
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Long getBidderId() {
    return bidderId;
  }

  public void setBidderId(Long bidderId) {
    this.bidderId = bidderId;
  }

  public UUID getTenderId() {
    return tenderId;
  }

  public void setTenderId(UUID tenderId) {
    this.tenderId = tenderId;
  }

  public BigDecimal getAmount() {
    return amount;
  }

  public void setAmount(BigDecimal amount) {
    this.amount = amount;
  }

  public BidStatus getStatus() {
    return status;
  }

  public void setStatus(BidStatus status) {
    this.status = status;
  }
}

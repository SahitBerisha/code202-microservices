package com.bidservice.dto;

import com.bidservice.model.Bid.BidStatus;
import java.math.BigDecimal;
import java.util.UUID;

public class BidResponse {

  private Long id;
  private Long bidderId;
  private UUID tenderId;
  private BigDecimal amount;
  private BidStatus status;

  private BidResponse(Builder builder) {
    this.id = builder.id;
    this.bidderId = builder.bidderId;
    this.tenderId = builder.tenderId;
    this.amount = builder.amount;
    this.status = builder.status;
  }

  public static class Builder {

    private Long id;
    private Long bidderId;
    private UUID tenderId;
    private BigDecimal amount;
    private BidStatus status;

    public Builder id(Long id){
      this.id = id;
      return this;
    }
    public Builder bidderId(Long bidderId){
      this.bidderId = bidderId;
      return this;
    }
    public Builder tenderId(UUID tenderId){
      this.tenderId = tenderId;
      return this;
    }
    public Builder amount(BigDecimal amount){
      this.amount = amount;
      return this;
    }
    public Builder status(BidStatus status){
      this.status = status;
      return this;
    }
    public BidResponse build() {
      return new BidResponse(this);
    }
  }
}

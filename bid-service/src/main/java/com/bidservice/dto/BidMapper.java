package com.bidservice.dto;

import com.bidservice.model.Bid;
import org.springframework.stereotype.Component;

@Component
public class BidMapper {

  public Bid map(BidRequest request) {
    var bid = new Bid();
    bid.setId(request.id());
    bid.setTenderId(request.tenderId());
    bid.setBidderId(request.bidderId());
    bid.setAmount(request.amount());
    bid.setStatus(request.status());
    return bid;
  }

  public BidResponse map(Bid bid) {
    return new BidResponse.Builder()
        .id(bid.getId())
        .tenderId(bid.getTenderId())
        .bidderId(bid.getBidderId())
        .amount(bid.getAmount())
        .status(bid.getStatus())
        .build();
  }
}

package com.bidservice.dto;

import com.bidservice.model.Bid.BidStatus;
import jakarta.validation.constraints.NotBlank;
import java.math.BigDecimal;
import java.util.UUID;

public record BidRequest(@NotBlank Long id,
                         @NotBlank Long bidderId,
                         @NotBlank UUID tenderId,
                         BigDecimal amount,
                         BidStatus status) {

}

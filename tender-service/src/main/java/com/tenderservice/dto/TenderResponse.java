package com.tenderservice.dto;

import com.tenderservice.model.Tender.Status;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class TenderResponse {

  UUID id;
  Instant createdAt;
  Instant updatedAt;
  String title;
  String description;
  Status status;
  Instant deadline;
  BigDecimal budget;
}

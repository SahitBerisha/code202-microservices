package com.tenderservice.dto;

import com.tenderservice.model.Tender.Status;
import jakarta.validation.constraints.NotBlank;
import java.math.BigDecimal;
import java.time.Instant;

public record TenderRequest(@NotBlank String title,
                            String description,
                            Status status,
                            BigDecimal budget,
                            Instant deadline) {

}
